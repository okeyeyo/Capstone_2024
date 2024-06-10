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

public class st_knee extends AppCompatActivity {
    TextView txtResult;
    Button[] btn = new Button[5];
    public android.widget.Button buttonShowDialog;
    ImageButton back;
    public TextToSpeech tts;

    private CountdownCircleView circleView;
    private String[] messages = {
            "대퇴 사두근에 20초 동안 힘을 주세요",
            "다리를 들어 20초 동안 자세를 유지해 주세요",
            "대퇴 사두근을 늘려주세요",
            "앉아서 윗몸을 앞으로 굽혀주세요",
            "누워서 무릎을 당겨주세요"};

    private CountDownTimer timer;
    private ImageButton start;
    private int messageIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.streching_list_knee);
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
                        Intent intent = new Intent(getApplicationContext(), st_knee.class);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(st_knee.this);
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
                showDialog("knee 1");
                System.out.println("1. 평평한 바닥에 누워 등을 곧게 펴고 양쪽 다리를 펴서 바닥에 놓습니다.\n" +
                        "2. 오른쪽 다리를 손으로 잡아 무릎을 구부립니다. 무릎을 가슴 쪽으로 당겨 다리를 몸 쪽으로 당깁니다. 이때, 왼쪽 다리는 바닥에 놓여 있어야 합니다.\n" +
                        "3. 오른쪽 다리를 가슴 쪽으로 당긴 채로 15-30초 동안 유지합니다. \n" +
                        "4. 천천히 오른쪽 다리를 원래의 자세로 돌려놓습니다.\n" +
                        "5. 동일한 방법으로 왼쪽 다리도 스트레칭합니다.");
            }
        });
        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("knee 2");
                System.out.println("1. 평평한 바닥에 누워 등을 곧게 펴고 양쪽 다리를 펴서 바닥에 놓습니다.\n" +
                        "2. 오른쪽 다리를 천천히 들어올려 천장 쪽으로 향하도록 합니다. 다리는 무릎을 조금 구부리고, 발은 바닥을 향하도록 유지합니다. -\n" +
                        "3. 다리를 들어올린 채로 15-30초간 유지합니다. 이때, 대퇴사두근과 다리 뒷부분의 스트레칭을 느끼도록 합니다. 특히 다리 뒷부분의 근육을 힘주지 않고 최대한 편안하게 느끼도록 합니다.\n" +
                        "4. 천천히 오른쪽 다리를 바닥으로 내려놓습니다.\n" +
                        "5. 같은 방법으로 왼쪽 다리도 들어올려서 스트레칭합니다.");
            }
        });
        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("knee 3");
                System.out.println("1. 평평한 바닥에 서서 양손을 허리에 놓습니다. 등은 곧게 펴고, 어깨는 뒤로 넣어줍니다.\n" +
                        "2. 오른쪽 다리를 앞으로 내밀어서 왼쪽 다리의 뒤쪽으로 한 발을 놓습니다. 앞으로 내밀 때는 곧게 편 상태로 유지하며 무릎을 향해 발을 이끌어 나갑니다. 이때, 발끝을 향해 멀리 내미는 것이 아니라 허리 부분에서 약간의 텐션이 느껴지도록 하세요.\n" +
                        "3. 앞으로 내밀어 놓은 다리의 무릎이 직각이 되도록 조절한 후, 상체를 약간 뒤로 기울여 줍니다. 이때, 대퇴사두근의 느낌을 느끼며 스트레칭을 유지합니다. 이 자세에서 15-30초간 정적으로 유지합니다.");
            }
        });
        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("knee 4");
                System.out.println("1. 평평한 바닥에 앉아서 다리를 뻗고 앞으로 편 상태로 자세를 취합니다. 등은 곧게 펴고 어깨는 내려놓은 상태로 유지합니다.\n" +
                        "2. 호흡을 내쉬며 상체를 앞으로 굽히고, 양손을 발에 가까이 가져갑니다. 이때, 등은 곧게 유지하고 너무 과도한 힘을 주지 않도록 합니다. 발끝을 향해 점진적으로 몸을 내려가면서 다리 뒷부분의 스트레칭을 느끼도록 합니다.\n" +
                        "3. 최대한 내려가면서 대퇴사두근과 다리 뒷부분의 스트레칭을 느끼며 15-30초 동안 유지합니다. \n" +
                        "4. 천천히 상체를 원래 자세로 돌아옵니다.");
            }
        });
        btn[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("knee 5");
                System.out.println("1. 평평한 바닥에 등을 대고 누워서 자세를 취합니다. 양 다리를 펴고 발을 바닥에 딱 붙여놓습니다.\n" +
                        "2. 오른쪽 다리의 무릎을 가슴 쪽으로 천천히 당겨옵니다. 이때, 양 손을 무릎 뒤에 감거나 다리 뒤쪽에 얹어서 무릎을 당기는 데 도움을 줍니다.\n" +
                        "3. 가능한 최대한의 스트레칭을 느끼며 편안한 자세에서 유지합니다.\n" +
                        "4. 무릎을 가슴 쪽당긴 채로 15-30초간 유지합니다. \n" +
                        "5. 천천히 오른쪽 다리를 원래의 자세로 돌려놓습니다. \n" +
                        "6. 동일한 방법으로 왼쪽 다리도 당겨서 스트레칭합니다.");
            }
        });


    }
}
