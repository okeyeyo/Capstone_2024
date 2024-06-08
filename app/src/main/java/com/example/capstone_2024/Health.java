package com.example.capstone_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    private Button btnAttendance,resetbtn2;
    private List<String> attendanceDays=new ArrayList<>();
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
        resetbtn2 = findViewById(R.id.resetbtn2);

        calendarView = findViewById(R.id.calendarView);
        tvAttendanceDays = findViewById(R.id.tvAttendanceDays);
        btnAttendance = findViewById(R.id.btnAttendance);

        preferences = getSharedPreferences("Attendance", MODE_PRIVATE);
        //attendanceDays = preferences.getStringSet("attendanceDays", new HashSet<String>());
        selectedDate = "";

        // onCreate 메서드에서도 출석일 데이터를 초기화하고 UI를 업데이트
        attendanceDays = updateAttendanceDays("attendanceDays",getApplicationContext());
        updateAttendanceTextView();

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // 선택된 날짜를 문자열로 변환
                selectedDate = year + "-" + (month + 1) + "-" + dayOfMonth;

                // 이미 출석한 날짜인 경우 출석 버튼 비활성화
                if (!selectedDate.isEmpty() && attendanceDays.contains(selectedDate)) {
                    Toast.makeText(Health.this, "이미 출석한 날짜입니다.", Toast.LENGTH_SHORT).show();
                    btnAttendance.setEnabled(false);
                } else {
                    btnAttendance.setEnabled(true);
                }
            }
        });

        resetbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAttendanceDays();
              //Toast.makeText(Health.this, String.valueOf(attendanceDays.size()) + selectedDate, Toast.LENGTH_SHORT).show();
                updateAttendanceTextView();
            }
        });
        btnAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!selectedDate.isEmpty()) {
                    if (!attendanceDays.contains(selectedDate)) {
                        attendanceDays.add(selectedDate);
                        Set<String> set = new HashSet<String>(attendanceDays);
                        attendanceDays = new ArrayList<>(set);


                        saveAttendanceData(attendanceDays,"attendanceDays",getApplicationContext()); // 출석일 데이터를 바로 저장
                        updateAttendanceDays("attendanceDays",getApplicationContext());
                        updateAttendanceTextView();
                        Toast.makeText(Health.this, "출석 완료: " + selectedDate, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Health.this, "이미 출석한 날짜입니다.", Toast.LENGTH_SHORT).show();
                    }
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
    }


    private void resetChronometer() {
        if (chronometer != null) {
            chronometer.stop();
            chronometer.setBase(SystemClock.elapsedRealtime());
            pauseOffset = 0;
        }
    }

    private void clearAttendanceDays() {
        // 출석일 리스트 초기화
        attendanceDays.clear();

        // SharedPreferences에서도 데이터를 초기화
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();

        // UI 업데이트
        updateAttendanceTextView();
        Toast.makeText(this, "출석일 데이터가 초기화되었습니다.", Toast.LENGTH_SHORT).show();
    }


    private void updateAttendanceTextView() {
        int days = attendanceDays.size();
        tvAttendanceDays.setText("출석일수: " + days + "일");
    }
    public static List<String> updateAttendanceDays(String listName, Context mContext){

        SharedPreferences prefs = mContext.getSharedPreferences("attendanceDays",Context.MODE_PRIVATE);
        int size = prefs.getInt(listName+"_size",0);
        List<String> list = new ArrayList<>();

        for(int i = 0; i<size; i++){
            list.add(prefs.getString(listName+"_"+ i, null));
        }
        return list;
    }


    private void updateAttendanceOnButtonClick() {
        btnAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!selectedDate.isEmpty()) {
                    if (!attendanceDays.contains(selectedDate)) {
                        attendanceDays.add(selectedDate);
                        saveAttendanceData(attendanceDays, "attendanceDays", getApplicationContext()); // 출석일 데이터를 저장
                        updateAttendanceDays("attendanceDays", getApplicationContext()); // 출석일 데이터를 UI에 업데이트
                        Toast.makeText(Health.this, "출석 완료: " + selectedDate, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Health.this, "이미 출석한 날짜입니다.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Health.this, "날짜를 선택하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean saveAttendanceData(List<String> list, String listName, Context mContext){
        SharedPreferences prefs = mContext.getSharedPreferences("attendanceDays",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.remove(listName + "_size").apply();
        editor.putInt(listName+"_size",list.size());

        for(int i=0;i<list.size();i++){
            editor.putString(listName +"_"+i, list.get(i));
        }
        return editor.commit();
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

    @Override
    protected void onPause() {
        super.onPause();
        saveAttendanceData(attendanceDays,"attendanceDays",getApplicationContext()); // 앱이 일시정지될 때 출석일 데이터 저장
    }

    @Override
    protected void onResume() {
        super.onResume();
        //attendanceDays = preferences.getStringSet("attendanceDays", new HashSet<String>());
        updateAttendanceDays("attendanceDays",getApplicationContext()); // 앱이 재개될 때 출석일 데이터 불러와서 UI 업데이트
    }
}
