package com.example.capstone_2024;

import static android.widget.Toast.makeText;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
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

public class st_waish extends AppCompatActivity {
    TextView txtResult;
    Button[] btn = new Button[5];
    public android.widget.Button buttonShowDialog;
    ImageButton back;
    public TextToSpeech tts;
    private ImageButton start;
    private CountDownTimer timer;
    private int messageIndex = 0;
    private CountdownCircleView circleView;
    private String[] messages = {
            "어깨를 돌려주세요",
            "벽을 잡고 지긋이 눌러 날개뼈 사이를 늘려주세요",
            "등 뒤에 힘을 주어 날개뼈를 모으고 풀기를 반복해주세요"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.streching_list_waish);
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

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.timierview);
                circleView = findViewById(R.id.circleView);
                ImageButton home = findViewById(R.id.home);

                tts.speak(messages[messageIndex], TextToSpeech.QUEUE_FLUSH, null, null); // 타이머 시작 시 메시지 읽기
                startTimer();
                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), st_waish.class);
                        startActivity(intent);
                        stopTimerAndTTS();
                    }
                });
            }
        });
        btn_popup_set();


    }
    private void startTimer() {
        timer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (circleView != null) {
                    int percentage = (int) ((millisUntilFinished / 20000.0) * 100);
                    int secondsRemaining = (int) (millisUntilFinished / 1000);
                    circleView.updateCircleRadius(percentage);
                    circleView.setRemainingTime(secondsRemaining);
                }
            }

            @Override
            public void onFinish() {
                if (circleView != null) {
                    circleView.setCircleVisible(false);
                    circleView.setRemainingTime(0); // 타이머 텍스트를 0으로 설정
                }
                if (messageIndex < messages.length - 1) {
                    messageIndex++; // 다음 메시지 인덱스로 이동
                    tts.speak(messages[messageIndex], TextToSpeech.QUEUE_FLUSH, null, null);
                    new CountDownTimer(2000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            // 2초 동안 대기
                        }

                        @Override
                        public void onFinish() {
                            // 2초가 지나면 타이머를 다시 시작
                            if (circleView != null) {
                                circleView.setCircleVisible(true);
                            }
                            startTimer();
                        }
                    }.start();
                }
            }
        };
        timer.start();
    }

    private void stopTimerAndTTS() {
        if (timer != null) {
            timer.cancel();
        }
        if (tts != null) {
            tts.stop();
        }
    }

    @Override
    public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
    public void showDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(st_waish.this);
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
                showDialog("waish  1");
                System.out.println("1. 바닥에 무릎을 꿇고, 손바닥을 바닥에 내려놓습니다. 무릎은 고양이가 앉는 자세와 비슷한 위치에 있어야 합니다.\n" +
                        "2. 천천히 등을 아치 모양으로 올려줍니다. 이때 허리를 아래로 드러냄으로써 아치 모양을 만듭니다.\n" +
                        "3. 머리를 천천히 아래로 내려 턱을 가슴 쪽으로 끌어당깁니다. 이때 어깨는 자연스럽게 아래로 늘어지도록 합니다.\n" +
                        "4. 고양이 자세를 유지하며 깊게 숨을 들이마시고, 숨을 내쉬며 천천히 허리를 아래로 드러냅니다.\n" +
                        "5. 최대한의 스트레칭을 느끼면서, 약 10-15초 동안 이 자세를 유지합니다.");
            }
        });
        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("waish  2");
                System.out.println("1. 양발은 어깨너비 정도로 벌려지도록 서 있습니다.\n" +
                        "2. 하나의 팔을 머리 위로 올리고 팔꿈치를 귀 쪽으로 향하도록 합니다. 손은 머리 위에서 굳게 붙잡습니다.\n" +
                        "3. 반대쪽 팔은 옆구리에 대고 편안하게 놓습니다. 손은 고정된 자세를 유지합니다.\n" +
                        "4. 상체를 편안하게 유지하되 곧게 선 상태를 유지합니다. 어깨는 양쪽으로 내리고 등은 약간 편평하게 유지합니다.\n" +
                        "5. 팔을 머리 위로 올린 쪽으로 몸을 천천히 기울입니다. 이때 몸의 중심은 곧게 유지하되 허리를 측면으로 기울입니다.\n" +
                        "6. 천천히 원래 자세로 돌아갑니다.\n" +
                        "7. 몇 초간의 휴식을 취한 후, 다른 쪽으로 팔을 올리고 같은 스트레칭을 수행합니다.");
            }
        });
        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("waish 3");
                System.out.println("1. 안전하고 평평한 바닥에 누워 등을 곧게 펴고 두 다리를 펴서 눕니다. \n" +
                        "2. 양 다리를 뻗은 채로 오른쪽으로 몸을 돌리고, 왼쪽 팔을 천천히 몸 위로 이동하여 팔을 바닥에 놓습니다. 이때, 왼쪽 어깨가 바닥에 붙을 때까지 이동합니다.\n" +
                        "3. 왼쪽 팔이 바닥에 닿지 않는다면, 스트레칭에 약간의 압력을 가하지 않고 왼쪽 어깨를 바닥에 가깝게 가져갑니다.\n" +
                        "4. 몸을 오른쪽으로 돌리면서 왼쪽 팔을 바닥에 고정한 상태로 몸을 유지합니다. 이때, 허리를 바닥에서 최대한 멀리하면서 허리와 골반 근육의 스트레칭을 느끼도록 합니다.\n" +
                        "5. 최대한의 스트레칭을 느끼면, 약 15-30초 동안 이 자세를 유지합니다.\n" +
                        "6. 천천히 몸을 원래의 자세로 되돌립니다. 오른쪽으로 돌아올 때 왼쪽 팔을 바닥에서 떼고 몸을 펴줍니다.\n" +
                        "7. 다리를 반대쪽으로 뻗고, 오른쪽 팔을 몸 위로 이동하여 바닥에 놓고, 왼쪽으로 몸을 돌려 반대 방향으로 스트레칭을 수행합니다.");
            }
        });
        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("waish  4");
                System.out.println("1. 안전하고 평평한 바닥에 서거나 앉아 편안한 자세를 취합니다.\n" +
                        "2. 먼저 오른쪽 손을 들어 머리 뒤쪽에 위치시킵니다. 오른쪽 팔꿈치는 천장을 향하도록 합니다.\n" +
                        "3. 왼쪽 손은 허리 부분에 놓거나 손가락을 서로 맞닿게 합니다.\n" +
                        "4. 오른쪽 팔을 머리 뒤로 잡은 채로 상체를 왼쪽으로 천천히 기울입니다. 이때, 왼쪽 어깨가 오른쪽 방향으로 기울어지는 것을 느끼면 됩니다.\n" +
                        "5. 몸을 기울일 때, 너무 과도한 힘을 주지 않고 천천히 움직입니다. 특히 허리 부분에 과도한 압력을 가하지 않도록 주의해야 합니다.\n" +
                        "6. 최대한의 스트레칭 상태를 유지한 후, 약 15-30초 동안 이 자세를 유지합니다. 이때 호흡은 깊게 하고 편안하게 유지합니다.\n" +
                        "7. 천천히 원래 자세로 돌아갑니다. \n" +
                        "8. 반대쪽으로 팔을 올리고 같은 스트레칭을 수행합니다.");
            }
        });
        btn[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("waish 5");
                System.out.println("1. 바닥에 네 다리를 굽힌 자세로 무릎을 깔고 앉습니다. 손목을 어깨 아래에 두고 팔꿈치를 바닥과 수직으로 유지합니다.\n" +
                        "2. 호흡을 내쉬며 엉덩이를 천천히 위로 들어올려요. 이때 양팔과 어깨는 바닥에 고정돼 있어야 합니다.\n" +
                        "3. 엉덩이를 위로 들면서 등을 아치 모양으로 폅니다. 어깨와 팔이 바닥으로부터 멀어지지 않도록 주의해야 합니다.\n" +
                        "4. 엉덩이를 들어올린 상태에서 머리를 양쪽 무릎 사이로 천천히 내려가요. 몸이 V자 모양을 형성하도록 합니다.\n" +
                        "5. 머리를 아래로 내려가는 동안 등과 다리 근육을 스트레칭합니다. \n" +
                        "6. 최대한의 스트레칭 상태를 유지하며, 15-30초 동안 이 자세를 유지합니다.\n" +
                        "7. 천천히 머리를 들어 올리고 엉덩이를 바닥으로 내려놓아요. 몸을 원래의 자세로 되돌립니다.");
            }
        });



    }


}
