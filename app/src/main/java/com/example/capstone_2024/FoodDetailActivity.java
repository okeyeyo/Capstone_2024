package com.example.capstone_2024;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoodDetailActivity extends AppCompatActivity {

    ImageButton homebtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_detail);

        homebtn = findViewById(R.id.home);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeActivity();
            }
        });

        TextView foodNameTextView = findViewById(R.id.foodNameTextView);
        TextView ingredientsTextView = findViewById(R.id.ingredientsTextView);

// TextViews와 ImageViews의 리스트를 만듭니다.
        List<TextView> manualTextViews = new ArrayList<>(Arrays.asList(
                findViewById(R.id.manual1TextView),
                findViewById(R.id.manual2TextView),
                findViewById(R.id.manual3TextView),
                findViewById(R.id.manual4TextView),
                findViewById(R.id.manual5TextView),
                findViewById(R.id.manual6TextView),
                findViewById(R.id.manual7TextView),
                findViewById(R.id.manual8TextView),
                findViewById(R.id.manual9TextView),
                findViewById(R.id.manual10TextView),
                findViewById(R.id.manual11TextView),
                findViewById(R.id.manual12TextView),
                findViewById(R.id.manual13TextView),
                findViewById(R.id.manual14TextView),
                findViewById(R.id.manual15TextView),
                findViewById(R.id.manual16TextView),
                findViewById(R.id.manual17TextView),
                findViewById(R.id.manual18TextView),
                findViewById(R.id.manual19TextView),
                findViewById(R.id.manual20TextView)
        ));

        List<ImageView> manualImageViews = new ArrayList<>(Arrays.asList(
                findViewById(R.id.manual_img1View),
                findViewById(R.id.manual_img2View),
                findViewById(R.id.manual_img3View),
                findViewById(R.id.manual_img4View),
                findViewById(R.id.manual_img5View),
                findViewById(R.id.manual_img6View),
                findViewById(R.id.manual_img7View),
                findViewById(R.id.manual_img8View),
                findViewById(R.id.manual_img9View),
                findViewById(R.id.manual_img10View),
                findViewById(R.id.manual_img11View),
                findViewById(R.id.manual_img12View),
                findViewById(R.id.manual_img13View),
                findViewById(R.id.manual_img14View),
                findViewById(R.id.manual_img15View),
                findViewById(R.id.manual_img16View),
                findViewById(R.id.manual_img17View),
                findViewById(R.id.manual_img18View),
                findViewById(R.id.manual_img19View),
                findViewById(R.id.manual_img20View)
        ));

// Intent로부터 데이터를 가져옵니다.
        Intent intent = getIntent();
        String foodName = intent.getStringExtra("foodName");
        String ingredients = intent.getStringExtra("ingredients");

// 매뉴얼 단계와 이미지 URL을 리스트에 저장합니다.
        List<String> manualTexts = Arrays.asList(
                intent.getStringExtra("manual1"),
                intent.getStringExtra("manual2"),
                intent.getStringExtra("manual3"),
                intent.getStringExtra("manual4"),
                intent.getStringExtra("manual5"),
                intent.getStringExtra("manual6"),
                intent.getStringExtra("manual7"),
                intent.getStringExtra("manual8"),
                intent.getStringExtra("manual9"),
                intent.getStringExtra("manual10"),
                intent.getStringExtra("manual11"),
                intent.getStringExtra("manual12"),
                intent.getStringExtra("manual13"),
                intent.getStringExtra("manual14"),
                intent.getStringExtra("manual15"),
                intent.getStringExtra("manual16"),
                intent.getStringExtra("manual17"),
                intent.getStringExtra("manual18"),
                intent.getStringExtra("manual19"),
                intent.getStringExtra("manual20")
        );

        List<String> manualImages = Arrays.asList(
                intent.getStringExtra("manual_img1"),
                intent.getStringExtra("manual_img2"),
                intent.getStringExtra("manual_img3"),
                intent.getStringExtra("manual_img4"),
                intent.getStringExtra("manual_img5"),
                intent.getStringExtra("manual_img6"),
                intent.getStringExtra("manual_img7"),
                intent.getStringExtra("manual_img8"),
                intent.getStringExtra("manual_img9"),
                intent.getStringExtra("manual_img10"),
                intent.getStringExtra("manual_img11"),
                intent.getStringExtra("manual_img12"),
                intent.getStringExtra("manual_img13"),
                intent.getStringExtra("manual_img14"),
                intent.getStringExtra("manual_img15"),
                intent.getStringExtra("manual_img16"),
                intent.getStringExtra("manual_img17"),
                intent.getStringExtra("manual_img18"),
                intent.getStringExtra("manual_img19"),
                intent.getStringExtra("manual_img20")
        );

// 음식 이름과 재료를 설정합니다.
        foodNameTextView.setText(foodName);
        ingredientsTextView.setText(ingredients);

// 매뉴얼 단계와 이미지를 설정합니다.
        for (int i = 0; i < manualTexts.size(); i++) {
            if (!TextUtils.isEmpty(manualTexts.get(i))) {
                manualTextViews.get(i).setText(manualTexts.get(i));
            } else {
                manualTextViews.get(i).setVisibility(View.GONE); // 비어 있으면 숨김
            }

            if (!TextUtils.isEmpty(manualImages.get(i))) {
                Picasso.get().load(manualImages.get(i)).into(manualImageViews.get(i));
            } else {
                manualImageViews.get(i).setVisibility(View.GONE); // 비어 있으면 숨김
            }
        }

    }

    public void openHomeActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

