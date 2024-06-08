package com.example.capstone_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class Health extends AppCompatActivity {

    ImageButton homebtn;
    Button strechbtn;
    Button musclebtn;
    ImageButton startbtn, resetbtn, stopbtn;
    private long pauseOffset;
    Chronometer chronometer;

    private CalendarView calendarView;
    private TextView tvAttendanceDays;
    private Button btnAttendance;
    private Set<String> attendanceDays;
    private String selectedDate;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health);

        startbtn = findViewById(R.id._button1);
        resetbtn = findViewById(R.id._button2);
        stopbtn = findViewById(R.id.stop);
        homebtn = findViewById(R.id.home);
        strechbtn = findViewById(R.id.streching);
        musclebtn = findViewById(R.id.muscle);
        chronometer = findViewById(R.id.timer);

        calendarView = findViewById(R.id.calendarView);
        tvAttendanceDays = findViewById(R.id.tvAttendanceDays);
        btnAttendance = findViewById(R.id.btnAttendance);

        preferences = getSharedPreferences("Attendance", MODE_PRIVATE);
        attendanceDays = preferences.getStringSet("attendanceDays", new HashSet<String>());
        selectedDate = "";

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // 선택된 날짜를 문자열로 변환
                selectedDate = year + "-" + (month + 1) + "-" + dayOfMonth;
            }
        });

        btnAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!selectedDate.isEmpty()) {
                    attendanceDays.add(selectedDate);
                    preferences.edit().putStringSet("attendanceDays", attendanceDays).apply();
                    updateAttendanceDays();
                    Toast.makeText(Health.this, "출석 완료: " + selectedDate, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Health.this, "날짜를 선택하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chronometer != null) {
                    chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                    chronometer.start();
                }
            }
        });

        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chronometer != null) {
                    chronometer.stop();
                    pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                }
            }
        });
        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetChronometer();
            }
        });

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeActivity();
            }
        });

        strechbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStrechingActivity();
            }
        });

        musclebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMuscleActivity();
            }
        });

        updateAttendanceDays();
    }

    private void updateAttendanceDays() {
        int days = attendanceDays.size();
        tvAttendanceDays.setText("출석일수: " + days + "일");
    }

    private void resetChronometer() {
        if (chronometer != null) {
            chronometer.stop();
            chronometer.setBase(SystemClock.elapsedRealtime());
            pauseOffset = 0;
        }
    }

    public void openHomeActivity() {
        Intent intent = new Intent(Health.this, MainActivity.class);
        startActivity(intent);
    }

    public void openStrechingActivity() {
        Intent intent = new Intent(getApplicationContext(), Streching.class);
        startActivity(intent);
    }

    public void openMuscleActivity() {
        Intent intent = new Intent(Health.this, muscle_shoulder.class);
        startActivity(intent);
    }
}
