package com.example.capstone_2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class st_popup extends AppCompatActivity {
    TextView txtText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);


       // txtText = (TextView) findViewById(R.id.textText);

        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        txtText.setText(data);

    }

    public void mOnClose(View v){
        Intent intent = new Intent();
        intent.putExtra("result","Close Popup");
        setResult(RESULT_OK, intent);

        finish();

    }
    public boolean touchevent(MotionEvent event){
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    public void onBackPresse(){
        return;
    }
}