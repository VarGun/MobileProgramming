package com.example.helloandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ImgAddAcitivity extends AppCompatActivity {
    Button button;
    ImageView imageView;
    EditText title;
    EditText grade;
    ArrayList<SampleData> movieDataList;
    private final String TAG = this.getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_add);

        imageView = findViewById(R.id.add_img);
        button = findViewById(R.id.btn_add_img);
        title = (EditText) findViewById(R.id.add_movietitle);
        grade = (EditText) findViewById(R.id.add_moviegrade);
;       Intent intent = new Intent();

        imageView.setOnClickListener(v -> {
            intent.setType("image/*");
            intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            launcher.launch(intent);
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st_title = title.getText().toString();
                String st_grade = grade.getText().toString();
                finish();
            }
        });
    }

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == RESULT_OK)
            {
                Log.e(TAG,"result : " + result);
                Intent intent = result.getData();
                Log.e(TAG, "intent : " + intent);
                Uri uri  = intent.getData();
                Log.e(TAG, " uri" + uri);
                Glide.with(ImgAddAcitivity.this)
                        .load(uri)
                        .into(imageView);
            }
        }
    });
}
