package com.example.capstone_2024;

import static android.widget.Toast.makeText;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class st_back extends AppCompatActivity {
    TextView txtResult;
    android.widget.Button[] btn = new Button[3];
    public android.widget.Button buttonShowDialog,back;
    public ImageButton start;
    public TextToSpeech tts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.streching_list_back);
        start = findViewById(R.id._button1);
        buttonShowDialog = findViewById(R.id.button2);
        back = findViewById(R.id.back);

        int[] buttonIds = {
                R.id.button2,
                R.id.button3,
                R.id.button4,
                R.id.button5,
                R.id.button6,
                R.id.button7,
                R.id.button8
        };

        for (int i = 0; i < btn.length; i++) {
            btn[i] = findViewById(buttonIds[i]);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Streching.class);
                startActivity(intent);

            }
        });
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    tts.setLanguage(Locale.KOREAN);
                }
            }
        });

        btn_popup_set();


    }
    public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
    public void showDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(st_back.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.st_popup, null);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();
        dialog.show();

        // 다이얼로그 크기 조정
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView dialogText = dialogView.findViewById(R.id.text);
        dialogText.setText(message);

        Button buttonOk = dialogView.findViewById(R.id.button_ok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        tts.speak(message, TextToSpeech.QUEUE_FLUSH, null, null);
    }
    public void btn_popup_set(){

        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("등 1");
                System.out.println("1. 똑바로 서거나 앉아서 몸을 편안하게 합니다. 어깨를 이완시키고 등을 곧게 펴세요.\n" +
                        "2. 어깨를 천천히 앞으로 돌리면서 작은 원을 그립니다.\n" +
                        "3. 점차 원의 크기를 키우면서 10-15회 회전합니다.\n" +
                        "4. 어깨를 천천히 뒤로 돌리면서 작은 원을 그립니다.\n" +
                        "5. 점차 원의 크기를 키우면서 10-15회 회전합니다.");

            }
        });
        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("등 2");
                System.out.println("1. 등을 곧게 펴고 어깨를 뒤로 넣습니다.\n" +
                        "2. 양손을 등 뒤로 가져가서 손등을 마주보도록 합니다.\n" +
                        "3. 어깨 너비 이상으로 손을 넓게 벌려서 양쪽 손을 만나도록 합니다.\n" +
                        "4. 양손을 만나는 부분에서 약간의 압력을 가해줍니다.\n" +
                        "5. 가급적 어깨를 뒤로 넣으면서 팔을 더 뒤쪽으로 가져갑니다. 이 자세에서 15-30초 정도 유지합니다.\n" +
                        "6. 숨을 내쉬면서 자연스럽게 풀어줍니다.");
            }
        });
        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("등 3");
                System.out.println("");
            }
        });



    }

}
