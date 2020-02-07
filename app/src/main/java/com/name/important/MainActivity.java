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

        //startActivity(new Intent(this, SplashActivity.class));

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
                    nameTheme("simple");
                    break;

                case R.id.main_card_sports:
                    nameTheme("sports");
                    break;

                case R.id.main_card_singer:
                    nameTheme("singer");
                    break;

                case R.id.main_card_random:
                    nameTheme("random");
                    break;
            }
        }
    };

    private void nameTheme(String theme) {
        Intent i = new Intent(MainActivity.this, SearchOptionsActivity.class);
        i.putExtra("NameTheme", theme);
        startActivity(i);
    }
}