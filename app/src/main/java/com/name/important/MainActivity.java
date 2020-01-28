package com.name.important;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, SplashActivity.class));

        findViewById(R.id.main_card_name).setOnClickListener(cardViewClickListener);
        findViewById(R.id.main_card_random).setOnClickListener(cardViewClickListener);
        findViewById(R.id.main_card_simple).setOnClickListener(cardViewClickListener);
        findViewById(R.id.main_card_sports).setOnClickListener(cardViewClickListener);
        findViewById(R.id.main_card_singer).setOnClickListener(cardViewClickListener);
    }

    private CardView.OnClickListener cardViewClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.main_card_name:
                    Toast.makeText(getApplicationContext(), "준비중입니다", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.main_card_simple:
                    Toast.makeText(getApplicationContext(), "준비중입니다(간단한 이름)", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.main_card_sports:
                    Toast.makeText(getApplicationContext(), "준비중입니다(스포츠 선수 이름)", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.main_card_singer:
                    Toast.makeText(getApplicationContext(), "준비중입니다(유명 가수 이름)", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.main_card_random:
                    Toast.makeText(getApplicationContext(), "준비중입니다(랜덤 이름)", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}