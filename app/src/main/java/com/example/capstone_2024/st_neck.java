package com.example.capstone_2024;

import static android.widget.Toast.makeText;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class st_neck extends AppCompatActivity {
    TextView txtResult;
    public android.widget.Button buttonShowDialog,back;
    android.widget.Button[] btn = new Button[6];
    public TextToSpeech tts;
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.streching_list_neck);

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
    /*
    public void showDialog2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(st_neck.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.st_popup, null);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();
        dialog.show();

        // 다이얼로그 크기 조정
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        Button buttonOk = dialogView.findViewById(R.id.button_ok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    */
    public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
    public void showDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(st_neck.this);
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
                showDialog("Text for Button 1");
                System.out.println("1. 똑바로 서거나 앉아서 몸을 편안하게 합니다.\n" +
                        "2. 천천히 머리를 뒤로 젖혀서 천장을 바라봅니다. 이 자세를 10-15초 동안 유지하면서 깊게 호흡합니다.\n" +
                        "3. 천천히 머리를 앞으로 숙여 턱이 가슴에 닿도록 합니다. 이 자세를 10-15초 동안 유지하면서 깊게 호흡합니다.\n" +
                        "4. 천천히 머리를 원래 위치로 되돌립니다.");
            }
        });
        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("Text for Button 2");
                System.out.println("1. 똑바로 서거나 앉아서 몸을 편안하게 합니다.\n" +
                        "2. 천천히 머리를 오른쪽으로 돌려서 턱이 오른쪽 어깨에 가깝게 갑니다. 이 자세를 10-15초 동안 유지합니다.\n" +
                        "3. 천천히 머리를 왼쪽으로 돌려서 턱이 왼쪽 어깨에 가깝게 갑니다. 이 자세를 10-15초 동안 유지합니다.\n" +
                        "4. 천천히 머리를 원래 위치로 되돌립니다.");
            }
        });
        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("Text for Button 3");
                System.out.println("1. 똑바로 서거나 앉아서 몸을 편안하게 합니다.\n" +
                        "2. 머리를 부드럽게 오른쪽 어깨 쪽으로 기울입니다. 목 왼쪽에 스트레칭을 느끼면서 15-30초 동안 유지합니다.\n" +
                        "3. 머리를 부드럽게 왼쪽 어깨 쪽으로 기울입니다. 목 오른쪽에 스트레칭을 느끼면서 15-30초 동안 유지합니다.\n" +
                        "4. 천천히 머리를 원래 위치로 되돌립니다.");

            }
        });
        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("Text for Button 4");
                System.out.println("1. 똑바로 서거나 앉아서 몸을 편안하게 합니다.\n" +
                        "2. 양손을 머리 뒤에 깍지 끼고 놓습니다.\n" +
                        "3. 손으로 머리를 부드럽게 앞으로 당겨서 턱이 가슴에 닿도록 합니다. 목 뒤쪽과 어깨 윗부분에 스트레칭을 느끼면서 15-30초 동안 유지합니다.\n" +
                        "4. 천천히 머리를 원래 위치로 되돌립니다.");
            }
        });
        btn[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("Text for Button 5");
                System.out.println("1. 똑바로 서거나 앉아서 몸을 편안하게 합니다.\n" +
                        "2. 왼손을 머리 위로 가져가 오른쪽 귀 가까이에 놓습니다.\n" +
                        "3. 왼손으로 머리를 부드럽게 당겨 왼쪽 어깨 쪽으로 기울입니다. 목 오른쪽에 스트레칭을 느끼면서 15-30초 동안 유지합니다.\n" +
                        "4. 이때, 오른쪽 어깨는 이완된 상태로 아래쪽으로 내려가게 합니다. 천천히 머리를 원래 위치로 되돌립니다.");
            }
        });
        btn[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("Text for Button 6");
                System.out.println("1. 똑바로 서거나 앉아서 몸을 편안하게 합니다.\n" +
                        "2. 오른손을 머리 위로 가져가 왼쪽 귀 가까이에 놓습니다.\n" +
                        "3. 오른손으로 머리를 부드럽게 당겨 오른쪽 어깨 쪽으로 기울입니다. 목 왼쪽에 스트레칭을 느끼면서 15-30초 동안 유지합니다.\n" +
                        "4. 이때, 왼쪽 어깨는 이완된 상태로 아래쪽으로 내려가게 합니다. 천천히 머리를 원래 위치로 되돌립니다");
            }
        });


    }
}
