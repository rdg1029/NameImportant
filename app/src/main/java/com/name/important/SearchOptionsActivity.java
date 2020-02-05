package com.name.important;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SearchOptionsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_options);

        setNameThemeTitle();
        setAlphabetSpinner();
    }

    private void setNameThemeTitle() {
        TextView nameThemeTitle = findViewById(R.id.search_options_name_theme);
        Intent i = getIntent();

        switch (i.getStringExtra("NameTheme")) {
            case "simple":
                nameThemeTitle.setText("간단한 영어 이름");
                break;

            case "sports":
                nameThemeTitle.setText("스포츠 선수 이름");
                break;

            case "singer":
                nameThemeTitle.setText("유명 가수 이름");
                break;

            case "random":
                nameThemeTitle.setText("랜덤 이름 찾기");
                break;
        }
    }

    private void setAlphabetSpinner() {
        ArrayList<String> alphabetArray = new ArrayList<>();
        alphabetArray.add("A");
        alphabetArray.add("B");
        alphabetArray.add("C");
        alphabetArray.add("D");
        alphabetArray.add("E");
        alphabetArray.add("F");
        alphabetArray.add("G");
        alphabetArray.add("H");
        alphabetArray.add("I");
        alphabetArray.add("J");
        alphabetArray.add("K");
        alphabetArray.add("L");
        alphabetArray.add("M");
        alphabetArray.add("N");
        alphabetArray.add("O");
        alphabetArray.add("P");
        alphabetArray.add("Q");
        alphabetArray.add("R");
        alphabetArray.add("S");
        alphabetArray.add("T");
        alphabetArray.add("U");
        alphabetArray.add("V");
        alphabetArray.add("W");
        alphabetArray.add("X");
        alphabetArray.add("Y");
        alphabetArray.add("Z");

        ArrayAdapter<String> alphabetArrayAdapter = new ArrayAdapter(this, R.layout.item_alphabet_spinner, alphabetArray);
        Spinner alphabetSpinner = findViewById(R.id.search_options_alphabet_spinner);
        alphabetSpinner.setAdapter(alphabetArrayAdapter);
    }
}
