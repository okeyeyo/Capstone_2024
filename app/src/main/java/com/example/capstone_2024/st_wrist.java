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

public class st_wrist extends AppCompatActivity {
    TextView txtResult;
    public android.widget.Button buttonShowDialog;
    ImageButton back;
    public TextToSpeech tts;
    Button[] btn = new Button[5];

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
        setContentView(R.layout.streching_list_wrist);
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
                ImageButton backback = findViewById(R.id.backback);
                backback.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), st_wrist.class);
                        startActivity(intent);
                        stopTimerAndTTS();
                    }
                });
                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(st_wrist.this);
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
      //  tts.speak(message, TextToSpeech.QUEUE_FLUSH, null, null);
    }
    public void btn_popup_set(){

        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("손목 1");
                System.out.println("1. 한 손을 내려놓고 손바닥이 위를 향하도록 합니다.\n" +
                        "2. 다른 손으로 손목을 잡고 천천히 시계 방향으로 손목을 돌립니다. 이때 팔은 고정되어 있어야 합니다.\n" +
                        "3. 10-15회 반복한 후, 반대 방향으로 돌려서 스트레칭을 합니다.");
            }
        });
        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("손목 2");
                System.out.println("1. 한 손을 내려놓고 손바닥이 위를 향하도록 합니다.\n" +
                        "2. 다른 손으로 손바닥을 잡고 천천히 아래로 당겨줍니다.\n" +
                        "3. 손바닥을 최대한 아래로 당기고, 팔은 고정되어 있어야 합니다. 손목과 손바닥 근육에 스트레칭을 느낄 수 있을 때까지 유지합니다.\n" +
                        "4. 15-30초 동안 유지한 후, 천천히 원래 자세로 돌아갑니다.");
            }
        });
        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("손목 3");
                System.out.println("1. 한 손을 내려놓고 손바닥이 위를 향하도록 합니다.\n" +
                        "2. 다른 손으로 손바닥을 가볍게 잡고 천천히 아래로 깊게 눌러줍니다.\n" +
                        "3. 손바닥을 최대한 아래로 누르고, 팔은 고정된 상태여야 합니다. 손목과 손바닥 근육에 스트레칭을 느낄 수 있을 때까지 유지합니다.\n" +
                        "4. 15-30초 동안 유지한 후, 천천히 원래 자세로 돌아갑니다.");
            }
        });
        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("손목 4");
                System.out.println("1. 한 손의 손가락을 다른 손으로 잡아 깍지에 끼도록 합니다.\n" +
                        "2. 다른 손으로 끼고 있는 손가락을 천천히 외쪽으로 늘려줍니다.\n" +
                        "3. 손가락을 최대한 늘린 상태에서 10-15초 정도 유지합니다.\n" +
                        "4. 이후 천천히 원래 자세로 돌아갑니다.");
            }
        });
        btn[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("손목 5");
                System.out.println("1. 한 손을 다른 손으로 잡아주고 손바닥을 아래로 향하도록 합니다.\n" +
                        "2. 다른 손으로 손등을 부드럽게 쥐어줍니다. 적당한 압력으로 손바닥 전체에 균등하게 압력을 가해줍니다.\n" +
                        "3. 손등을 가볍게 쥐어주면서 손목에서부터 손가락 끝까지 이동합니다. 이렇게 하면 모든 부분에 마사지를 균등하게 해줄 수 있습니다.\n" +
                        "4. 손등 전체에 대해 약 5-10분 동안 마사지를 진행합니다.\n");
            }
        });



    }
}
