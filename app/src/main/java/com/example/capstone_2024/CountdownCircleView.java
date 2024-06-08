/*
package com.example.capstone_2024;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CountdownCircleView extends View {
    private Paint paint;
    private RectF rectF;
    private float startAngle = -90; // 시작 각도: -90도 (12시 방향)
    private float sweepAngle = 0; // 회전 각도: 초기값은 0
    private String timerText = ""; // 타이머 텍스트

    public CountdownCircleView(Context context) {
        super(context);
        init();
    }

    public CountdownCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CountdownCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(50);
        rectF = new RectF();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 원 그리기
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = Math.min(centerX, centerY) - 5;
        rectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius);
        canvas.drawArc(rectF, startAngle, sweepAngle, false, paint); // sweepAngle에 양수를 사용하여 시계 방향으로 그립니다.

        // 타이머 텍스트 그리기
        canvas.drawText(timerText, centerX, centerY, paint);
    }

    public void updateCircleRadius(float percentage) {
        // 타이머에 따라 원의 회전 각도를 조정합니다.
        sweepAngle = -360 * (percentage / 100f);
        // 타이머 텍스트 업데이트
        timerText = String.valueOf((int)(percentage / 100 * 20)); // 예를 들어, 30초를 기준으로 퍼센티지에 따라 텍스트 업데이트
        // 뷰를 다시 그리도록 요청합니다.
        invalidate();
    }


}
*/
package com.example.capstone_2024;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CountdownCircleView extends View {
    private Paint paint;
    private Paint textPaint;
    private RectF circleRect;
    private float sweepAngle;
    private int remainingTime;
    private boolean isCircleVisible = true;

    public CountdownCircleView(Context context) {
        super(context);
        init();
    }

    public CountdownCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        paint.setAntiAlias(true);

        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(100);
        textPaint.setAntiAlias(true);

        circleRect = new RectF();
        sweepAngle = 360;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (isCircleVisible) {
            canvas.drawArc(circleRect, -90, sweepAngle, false, paint);
        }

        if (remainingTime > 0) {
            String text = String.valueOf(remainingTime);
            float textWidth = textPaint.measureText(text);
            float x = getWidth() / 2 - textWidth / 2;
            float y = getHeight() / 2 - (textPaint.descent() + textPaint.ascent()) / 2;
            canvas.drawText(text, x, y, textPaint);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        float padding = 20;
        circleRect.set(padding, padding, w - padding, h - padding);
    }

    public void updateCircleRadius(int percentage) {
        sweepAngle = (-360 * percentage) / 100;
        invalidate();
    }

    public void setRemainingTime(int time) {
        remainingTime = time;
        invalidate();
    }

    public void setCircleVisible(boolean visible) {
        isCircleVisible = visible;
        invalidate();
    }
}
