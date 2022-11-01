package com.example.helloandroid;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String tableName = "Users";

    public DBHelper(Context context,String name, SQLiteDatabase.CursorFactory factory ,int version){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void createTable(SQLiteDatabase db){
        String sql = "CREATE TABLE " + tableName + "(id text, pw text)";
        try{
            db.execSQL(sql);
        }
        catch (SQLException e) {
        }
    }
    public void insertUser(SQLiteDatabase db, String id, String pw){
        db.beginTransaction();
        try{
            String sql = "INSERT INTO " + tableName + "(id,pw)" + "values('" + id + "', '"+ pw + "')";
            db.execSQL(sql);
            db.setTransactionSuccessful();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            db.endTransaction();
        }
    }
}
