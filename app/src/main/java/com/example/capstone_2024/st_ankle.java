/*
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

public class st_ankle extends AppCompatActivity {   //발목
    TextView txtResult;
    public android.widget.Button buttonShowDialog;
    ImageButton back;
    Button[] btn = new Button[3];
    public TextToSpeech tts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.streching_list_ankle);

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
        AlertDialog.Builder builder = new AlertDialog.Builder(st_ankle.this);
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
                showDialog("발목 1");
            }
        });
        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("발목 2");
            }
        });
        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("발목 3");
            }
        });



    }
}
*/
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

public class st_ankle extends AppCompatActivity {   //발목
    private TextView txtResult;
    private Button buttonShowDialog;
    private CountdownCircleView circleView;
    private ImageButton back, startbtn;
    private Button[] btn = new Button[3];
    private TextToSpeech tts;
    private CountDownTimer timer;
    private int messageIndex = 0;
    private String[] messages = {
            "발목을 손으로 당겨주세요",
            "발목을 손으로 내려주세요",
            "발목을 좌우로 돌려주세요"
            // 추가 메시지를 여기에 입력할 수 있습니다.
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.streching_list_ankle);

        buttonShowDialog = findViewById(R.id.button2);
        back = findViewById(R.id.back);
        startbtn = findViewById(R.id._button1);
        int[] buttonIds = {
                R.id.button2,
                R.id.button3,
                R.id.button4
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
                        Intent intent = new Intent(getApplicationContext(), st_ankle.class);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(st_ankle.this);
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
                showDialog("발목 1");
            }
        });
        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("발목 2");
            }
        });
        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("발목 3");
            }
        });
    }
}
