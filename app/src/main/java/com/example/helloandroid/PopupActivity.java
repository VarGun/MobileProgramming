package com.example.helloandroid;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PopupActivity extends AppCompatActivity {

    Button agree_btn;
    TextView textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_popup);
        agree_btn  = (Button) findViewById(R.id.agree_btn);
        textview = (TextView) findViewById(R.id.textview);

        String text = "<개인정보보호 포털> 개인정보 처리방침\n" +
                "개인정보보호위원회가 취급하는 모든 개인정보는 관련 법령에 근거하여 수집 · 보유 및 처리되고 있습니다. 「개인정보보호법」은 이러한 개인정보의 취급에 대한 일반적 규범을 제시하고 있으며, 개인정보보호위원회는 이러한 법령의 규정에 따라 수집 · 보유 및 처리하는 개인정보를 공공업무의 적절한 수행과 이용자의 권익을 보호하기 위해 적법하고 적정하게 취급할 것입니다.\n" +
                "\n" +
                "또한, 개인정보보호위원회는 관련 법령에서 규정한 바에 따라 보유하고 있는 개인정보에 대한 열람, 정정·삭제, 처리정지 요구 등 이용자의 권익을 존중하며, 이용자는 이러한 법령상 권익의 침해 등에 대하여 행정심판법에서 정하는 바에 따라 행정심판을 청구할 수 있습니다.\n" +
                "\n" +
                "개인정보보호위원회는 개인정보보호법 제 30조에 따라 정보주체의 개인정보 보호 및 권익을 보호하고 개인정보와 관련한 이용자의 고충을 원활하게 처리할 수 있도록 다음과 같은 개인정보 처리방침을 수립 · 공개하고 있습니다.\n" +
                "\n" +
                "제1조 (개인정보의 처리 목적)\n" +
                "\n" +
                "① 개인정보보호위원회는 개인정보를 다음의 목적을 위해 처리합니다. 처리한 개인정보는 다음의 목적이외의 용도로는 사용되지 않으며 이용 목적이 변경되는 경우에는 개인정보 보호법 제18조에 따라 별도의 동의를 받는 등 필요한 조치를 이행할 예정입니다.\n" +
                "가. 서비스 제공\n" +
                "교육 콘텐츠 제공, 본인인증, 증명서발급(교육 수료증) 등 서비스 제공에 관련한 목적으로 개인정보를 처리합니다. \n" +
                "협박 사례를 적극 신고하시기 바랍니다.\n" +
                "나. 민원처리\n" +
                "개인정보 열람, 개인정보 정정·삭제, 개인정보 처리정지 요구, 개인정보 유출사고 신고 등 개인정보와 관련된 민원처리를 목적으로 개인정보를 처리합니다.\n" +
                "② 개인정보보호위원회가 개인정보 보호법 제32조에 따라 등록·공개하는 개인정보파일의 처리목적은 다음과 같습니다.";

        textview.setText(text);

        agree_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}



