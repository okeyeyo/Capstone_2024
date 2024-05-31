package com.example.capstone_2024;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //일정 시간 지연 후 실행하기 위한 코드
        Handler hd = new Handler();
        hd.postDelayed(new splashHandler(), 3000); //posetDelayed를 통해 2초 뒤에 작동하도록 설정
    }

    private class splashHandler implements Runnable {
        public void run() {
            startActivity(new Intent(getApplication(), MainActivity.class));
            SplashActivity.this.finish();
        }
    }
}