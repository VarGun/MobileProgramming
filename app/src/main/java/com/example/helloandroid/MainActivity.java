package com.example.helloandroid;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    // 초기화면
    EditText re_id,re_pw; // 회원가입 입력필드

    int version = 1;
    String sql;
    Cursor cursor;
    DBHelper dbHelper;
    SQLiteDatabase db;

    Button btn_login;
    Button btn_regi;
    Button btn_no_id;

    boolean yes_login_check = true;
    boolean no_login_check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login  = (Button) findViewById(R.id.btn_login);
        btn_regi = (Button) findViewById(R.id.go_register);
        btn_no_id = (Button) findViewById(R.id.no_id_btn);

        re_id = (EditText) findViewById(R.id.re_id);
        re_pw = (EditText) findViewById(R.id.re_password);

        dbHelper = new DBHelper(MainActivity.this, DBHelper.tableName, null, version);
        db = dbHelper.getWritableDatabase();

        Check check = (Check)getApplication();

        // 로그인으로 하기
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = re_id.getText().toString();
                String pw = re_pw.getText().toString();
                if(id.length() == 0 || pw.length() == 0) {
                    //아이디와 비밀번호는 필수 입력사항입니다.
                    Toast toast = Toast.makeText(MainActivity.this, "아이디와 비밀번호는 필수 입력사항입니다.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                sql = "SELECT id FROM "+ dbHelper.tableName + " WHERE id = '" + id + "'";
                cursor = db.rawQuery(sql, null);

                if(cursor.getCount() != 1){
                    //아이디가 틀렸습니다.
                    Toast toast = Toast.makeText(MainActivity.this, "존재하지 않는 아이디입니다.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                sql = "SELECT pw FROM "+ dbHelper.tableName + " WHERE id = '" + id + "'";
                cursor = db.rawQuery(sql, null);

                cursor.moveToNext();
                if(!pw.equals(cursor.getString(0))){
                    //비밀번호가 틀렸습니다.
                    Toast toast = Toast.makeText(MainActivity.this, "비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    //로그인성공
                    check.setLogin_check(yes_login_check);
                    check.setState_id(id);
                    check.setState_pwd(pw);
                    Toast toast = Toast.makeText(MainActivity.this, "로그인성공", Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }
                cursor.close();
            }
        });
        // 회원가입 화면으로 이동
        btn_regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        // 비회원으로 이용하기
        btn_no_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check.setLogin_check(no_login_check);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}