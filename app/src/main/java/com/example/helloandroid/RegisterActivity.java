package com.example.helloandroid;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    //회원가입 화면

    EditText userId;
    EditText userPassword;
    EditText userphone;// 회원가입 입력필드
    Button mBtnRegister; //회원가입 입력버튼
    Button popupbtn;
    RadioButton yes_btn, no_btn;
    RadioGroup radioGroup;
    Boolean state = false;

    DBHelper dbHelper;
    SQLiteDatabase database;
    int version = 1;
    String sql;
    Cursor cursor;


    boolean id_check = false;
    boolean pw_check = false;
    boolean num_check = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userId = (EditText) findViewById(R.id.re_id);
        userPassword = (EditText) findViewById(R.id.re_password);
        userphone = (EditText) findViewById(R.id.re_phone);

        mBtnRegister = (Button) findViewById(R.id.btn_register);
        popupbtn = (Button) findViewById(R.id.popup_btn);

        yes_btn = (RadioButton) findViewById(R.id.yes_btn);
        no_btn = (RadioButton) findViewById(R.id.no_btn);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);

        dbHelper = new DBHelper(RegisterActivity.this, DBHelper.tableName,null,version);
        database = dbHelper.getWritableDatabase();



    // 라디오 버튼 true false 받기
    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            if (checkedId == R.id.yes_btn){
                state = true;
            }
            else if(checkedId == R.id.no_btn){
                state = false;
            }
        }
    });
    // 회원가입 진행 파트
    mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state == true) {
                    // 회원가입 처리 시작
                    String id = userId.getText().toString();
                    String password = userPassword.getText().toString();
                    String phone = userphone.getText().toString();
                    if (id.length() == 0 || password.length() == 0) {
                        Toast.makeText(getApplicationContext(), "아이디와 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    sql = "SELECT id FROM " + dbHelper.tableName + " WHERE id = '" + id + "'";
                    cursor = database.rawQuery(sql,null);


                    if(cursor.getCount() != 0){
                        Toast.makeText(RegisterActivity.this, " 존재하는 아이디입니다.", Toast.LENGTH_LONG).show();
                        id_check = false;

                    }
                    else{
                        id_check = true;
                    }


                    if(!Pattern.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&]).{8,15}.$", password)){
                        Toast.makeText(RegisterActivity.this, "숫자, 문자, 특수문자 모두 포함 (8~15자)를 입력해주세요", Toast.LENGTH_LONG).show();
                        pw_check = false;
                    }
                    else{
                        pw_check = true;
                    }


                    if(!Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$",phone)){
                        Toast.makeText(RegisterActivity.this, "올바른 휴대폰 번호가 아닙니다.", Toast.LENGTH_LONG).show();
                        num_check = false;
                    }
                    else{
                        num_check = true;
                    }


                    if(id_check == true && pw_check == true && num_check ==true){
                        dbHelper.insertUser(database,id,password);
                        Toast.makeText(RegisterActivity.this, "가입이 완료되었습니다.", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
                else if (state == false)
                {
                    Toast.makeText(RegisterActivity.this, "개인정보를 동의하셔야합니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // 개인정보 보호 버튼
        popupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, PopupActivity.class);
                startActivity(intent);
            }
        });
    }
}