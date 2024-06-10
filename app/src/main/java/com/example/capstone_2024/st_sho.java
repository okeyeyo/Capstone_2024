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

public class st_sho extends AppCompatActivity {
    TextView txtResult;
    Button[] btn = new Button[6];
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
        setContentView(R.layout.streching_list_shoulder);
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
                        Intent intent = new Intent(getApplicationContext(), st_sho.class);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(st_sho.this);
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
       // tts.speak(message, TextToSpeech.QUEUE_FLUSH, null, null);
    }
    public void btn_popup_set(){

        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("어깨 1");
                System.out.println("1. 똑바로 서거나 앉습니다.\n" +
                        "2. 오른팔을 가슴 앞쪽으로 뻗어 왼쪽으로 넘깁니다.\n" +
                        "3. 왼팔로 오른팔의 팔꿈치나 상완 부분을 감싸고, 몸 쪽으로 부드럽게 당깁니다.\n" +
                        "4. 이 자세를 15-30초 동안 유지하면서 깊게 호흡합니다.\n" +
                        "5. 천천히 원래 위치로 돌아갑니다. 반대쪽 팔도 같은 방식으로 스트레칭합니다.");
            }
        });
        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("어깨 2");
                System.out.println("1. 똑바로 서거나 앉습니다.\n" +
                        "2. 한 팔을 등 뒤로 넘겨 손을 가능한 높이 올립니다.\n" +
                        "3. 반대쪽 손으로 등 뒤의 손목이나 팔꿈치를 잡고, 부드럽게 당깁니다.\n" +
                        "4. 20-30초 동안 유지하면서 깊게 호흡합니다.\n" +
                        "5. 천천히 원래 위치로 돌아갑니다. 반대쪽 팔도 같은 방식으로 스트레칭합니다.");
            }
        });
        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("어깨 3");
                System.out.println("1. 똑바로 서서 한 팔을 위로 들어 올립니다.\n" +
                        "2. 반대쪽 손으로 들어 올린 팔의 팔꿈치를 잡고, 부드럽게 머리 뒤쪽으로 당깁니다.\n" +
                        "3. 이 자세를 20-30초 동안 유지하면서 깊게 호흡합니다.\n" +
                        "4. 천천히 원래 위치로 돌아갑니다. 반대쪽 팔도 같은 방식으로 스트레칭합니다.");
            }
        });
        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("어깨 4");
                System.out.println("1. 똑바로 서서 발을 어깨 너비로 벌리고 팔을 몸 옆에 둡니다. 어깨를 편안하게 이완시킵니다.\n" +
                        "2. 천천히 어깨를 뒤로 당기면서 날개뼈를 서로 모읍니다. 이때 가슴이 앞으로 나오고 어깨가 뒤로 젖혀집니다.\n" +
                        "3. 날개뼈를 최대한 모은 상태에서 5-10초 동안 유지합니다.\n" +
                        "4. 천천히 원래 위치로 돌아갑니다.");
            }
        });
        btn[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("어깨 5");
                System.out.println("1. 벽 옆에 서서 팔꿈치를 90도로 굽히고 손바닥을 벽에 댑니다. 팔꿈치가 어깨 높이에 오도록 합니다.\n" +
                        "2. 벽에 댄 손을 고정한 상태에서 천천히 몸을 반대쪽으로 돌립니다. 어깨 앞쪽에 스트레칭을 느끼면서 15-30초 동안 유지합니다.\n" +
                        "3. 천천히 원래 위치로 돌아갑니다.\n" +
                        "4. 반대쪽 어깨도 같은 방법으로 스트레칭합니다");
            }
        });
        btn[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("어깨 6");
                System.out.println("1.똑바로 서거나 앉아서 몸을 편안하게 합니다. 어깨를 이완시키고 등을 곧게 펴세요.\n" +
                        "2. 팔을 옆으로 뻗은 후 천천히 팔을 앞으로 돌리기 시작합니다.\n" +
                        "3. 작은 원을 그리면서 점점 원의 크기를 키웁니다.\n" +
                        "4. 0-15회 회전한 후 반대 방향으로도 10-15회 회전합니다.");
            }
        });


    }
}
