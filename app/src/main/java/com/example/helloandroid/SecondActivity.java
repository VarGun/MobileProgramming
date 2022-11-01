package com.example.helloandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ArrayList<SampleData> movieDataList;
    Button btn_add;
    Button btn_del;
    Button btn_chk;
    boolean state;
    String id;
    String pwd;

    private static final int REQUEST_CODE= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn_add  = (Button) findViewById(R.id.btn_add);
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_chk = (Button) findViewById(R.id.btn_check_regi);

        final ListView listView = (ListView)findViewById(R.id.listView);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        this.InitializeMovieData();
        final MyAdapter myAdapter = new MyAdapter(this,android.R.layout.simple_list_item_single_choice,movieDataList);
        listView.setAdapter(myAdapter);

        Check check = (Check)getApplication();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Toast.makeText(getApplicationContext(),
                        myAdapter.getItem(position).getMovieName(),
                        Toast.LENGTH_LONG).show();
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() { // 기능 미구현
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ImgAddAcitivity.class);
                startActivity(intent);
            }
        });
        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count, checked;
                count = myAdapter.getCount();
                if (count > 0){
                    checked = listView.getCheckedItemPosition();
                    if (checked > -1 && checked < count){
                        movieDataList.remove(checked);
                        listView.clearChoices();
                        myAdapter.notifyDataSetChanged();
                        Toast.makeText(SecondActivity.this, "삭제 완료", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        btn_chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state = check.isLogin_check();

                id = check.is_Id();
                pwd = check.is_Pwd();

                if (state == true){
                    AlertDialog.Builder sd = new AlertDialog.Builder(SecondActivity.this);
                    sd.setIcon(R.mipmap.ic_launcher);
                    sd.setTitle("회원정보화면");
                    sd.setMessage("id: "+id+"\n"+"pw: "+pwd);
                    final EditText et = new EditText(SecondActivity.this);
                    sd.setView(et);
                    sd.show();
                }
                else{
                    AlertDialog.Builder ad = new AlertDialog.Builder(SecondActivity.this);
                    ad.setIcon(R.mipmap.ic_launcher);
                    ad.setTitle("비회원화면상태");
                    ad.setMessage("비회원입니다.회원가입을 하러 가시겠습니까?");

                    final EditText et = new EditText(SecondActivity.this);
                    ad.setView(et);

                    ad.setPositiveButton("동의", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(SecondActivity.this, RegisterActivity.class);
                            startActivity(intent);
                            dialog.dismiss();
                        }
                    });
                    ad.setNegativeButton("비동의", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    ad.show();
                }
            }
        });

    }

    public void InitializeMovieData()
    {
        movieDataList = new ArrayList<SampleData>();

        movieDataList.add(new SampleData(R.drawable.ttaza, "타짜","15세 이상관람가 \n 가격:9000원"));
        movieDataList.add(new SampleData(R.drawable.mogadishu, "모가디슈","19세 이상관람가\n 가격:10000원"));
        movieDataList.add(new SampleData(R.drawable.venom, "베놈","12세 이상관람가\n 가격:11000원"));
        movieDataList.add(new SampleData(R.drawable.inner,"내부자들","19세 이상관람가\n 가격:9000원"));
        movieDataList.add(new SampleData(R.drawable.withgod,"신과함께","12세 이상관람가\n 가격:8000원"));
        movieDataList.add(new SampleData(R.drawable.aqua_man,"아쿠아맨","15세 이상관람가\n 가격:1000원"));
        movieDataList.add(new SampleData(R.drawable.titanic,"타이타닉","15세 이상관람가\n 가격:7000원"));

    }
}