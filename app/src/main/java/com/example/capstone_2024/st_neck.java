package com.example.capstone_2024;

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
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class st_neck extends AppCompatActivity {
    private TextView txtResult;
    private Button buttonShowDialog;
    private CountdownCircleView circleView;
    private ImageButton back, startbtn;
    private Button[] btn = new Button[6];
    private TextToSpeech tts;
    private CountDownTimer timer;
    private int messageIndex = 0;
    private String[] messages = {
            "목을 지긋이 올리고 내려주세요",
            "고개를 지긋이 좌우로 돌려주세요",
            "고개를 지긋이 좌우로 내려주세요",
            "다음은 손으로 목을 위 아래로 당겨주세요",
            "목을 손으로 왼쪽으로 당겨주세요",
            "목을 손으로 오른쪽으로 당겨주세요"

            // 추가 메시지를 여기에 입력할 수 있습니다.
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.streching_list_neck);

        buttonShowDialog = findViewById(R.id.button2);
        back = findViewById(R.id.back);
        startbtn = findViewById(R.id._button1);
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
                stopTimerAndTTS();
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

        startbtn.setOnClickListener(new View.OnClickListener() {
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
                        Intent intent = new Intent(getApplicationContext(), st_neck.class);
                        startActivity(intent);
                        stopTimerAndTTS();
                    }
                });
            }
        });
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
                } else {
                    Toast.makeText(getApplicationContext(), "메시지", Toast.LENGTH_SHORT).show();
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
        AlertDialog.Builder builder = new AlertDialog.Builder(st_neck.this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.st_popup, null);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();
        dialog.show();

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

    public void btn_popup_set() {
        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("1. 똑바로 서거나 앉아서 몸을 편안하게 합니다.\n" +
                        "2. 천천히 머리를 뒤로 젖혀서 천장을 바라봅니다. 이 자세를 10-15초 동안 유지하면서 깊게 호흡합니다.\n" +
                        "3. 천천히 머리를 앞으로 숙여 턱이 가슴에 닿도록 합니다. 이 자세를 10-15초 동안 유지하면서 깊게 호흡합니다.\n" +
                        "4. 천천히 머리를 원래 위치로 되돌립니다.\n");

            }
        });
        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("1. 똑바로 서거나 앉아서 몸을 편안하게 합니다.\n" +
                        "2. 천천히 머리를 오른쪽으로 돌려서 턱이 오른쪽 어깨에 가깝게 갑니다. 이 자세를 10-15초 동안 유지합니다.\n" +
                        "3. 천천히 머리를 왼쪽으로 돌려서 턱이 왼쪽 어깨에 가깝게 갑니다. 이 자세를 10-15초 동안 유지합니다.\n" +
                        "4. 천천히 머리를 원래 위치로 되돌립니다.\n");

            }
        });
        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("1. 똑바로 서거나 앉아서 몸을 편안하게 합니다.\n" +
                        "2. 머리를 부드럽게 오른쪽 어깨 쪽으로 기울입니다. 목 왼쪽에 스트레칭을 느끼면서 15-30초 동안 유지합니다.\n" +
                        "3. 머리를 부드럽게 왼쪽 어깨 쪽으로 기울입니다. 목 오른쪽에 스트레칭을 느끼면서 15-30초 동안 유지합니다.\n" +
                        "4. 천천히 머리를 원래 위치로 되돌립니다.\n");


            }
        });
        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("1. 똑바로 서거나 앉아서 몸을 편안하게 합니다.\n" +
                        "2. 양손을 머리 뒤에 깍지 끼고 놓습니다.\n" +
                        "3. 손으로 머리를 부드럽게 앞으로 당겨서 턱이 가슴에 닿도록 합니다. 목 뒤쪽과 어깨 윗부분에 스트레칭을 느끼면서 15-30초 동안 유지합니다.\n" +
                        "4. 천천히 머리를 원래 위치로 되돌립니다.\n");

            }
        });
        btn[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("1. 똑바로 서거나 앉아서 몸을 편안하게 합니다.\n" +
                        "2. 왼손을 머리 위로 가져가 오른쪽 귀 가까이에 놓습니다.\n" +
                        "3. 왼손으로 머리를 부드럽게 당겨 왼쪽 어깨 쪽으로 기울입니다. 목 오른쪽에 스트레칭을 느끼면서 15-30초 동안 유지합니다.\n" +
                        "4. 이때, 오른쪽 어깨는 이완된 상태로 아래쪽으로 내려가게 합니다. 천천히 머리를 원래 위치로 되돌립니다.\n");

            }
        });
        btn[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("1. 똑바로 서거나 앉아서 몸을 편안하게 합니다.\n" +
                        "2. 오른손을 머리 위로 가져가 왼쪽 귀 가까이에 놓습니다.\n" +
                        "3. 오른손으로 머리를 부드럽게 당겨 오른쪽 어깨 쪽으로 기울입니다. 목 왼쪽에 스트레칭을 느끼면서 15-30초 동안 유지합니다.\n" +
                        "4. 이때, 왼쪽 어깨는 이완된 상태로 아래쪽으로 내려가게 합니다. 천천히 머리를 원래 위치로 되돌립니다.\n");

            }
        });
    }
}
