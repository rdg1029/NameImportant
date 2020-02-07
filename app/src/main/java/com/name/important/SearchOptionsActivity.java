package com.name.important;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SearchOptionsActivity extends AppCompatActivity {
    String selectedGender = "";

    FloatingActionButton btnNext;
    CheckBox checkAllGender;
    RadioButton radioFemale;
    RadioButton radioMale;
    RadioGroup radioGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_options);

        btnNext = findViewById(R.id.main_btn_next);
        checkAllGender = findViewById(R.id.main_check_allgender);
        radioGender = findViewById(R.id.main_radio_gender);
        radioFemale = findViewById(R.id.main_radio_female);
        radioMale = findViewById(R.id.main_radio_male);

        setNameThemeTitle();
        setAlphabetSpinner();
        updateGenderMenus();

        final Intent i = getIntent();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("GENDER", selectedGender);
                intent.putExtra("NameTheme", i.getStringExtra("NameTheme"));
                if(i.getStringExtra("NameTheme").equals("random")) {
                    Toast.makeText(getApplicationContext(), "준비중입니다", Toast.LENGTH_SHORT).show();
                }
                else {
                    startActivity(intent);
                }
            }
        });
    }

    private void updateGenderMenus(){
        radioMale.setChecked(true);
        selectedGender = "MALE";

        checkAllGender.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    radioFemale.setEnabled(false);
                    radioMale.setEnabled(false);
                    radioFemale.setTextColor(Color.parseColor("#bfbfbf"));
                    radioMale.setTextColor(Color.parseColor("#bfbfbf"));

                    selectedGender = "ALL";
                }else{
                    radioFemale.setEnabled(true);
                    radioMale.setEnabled(true);
                    radioFemale.setTextColor(Color.parseColor("#d11141"));
                    radioMale.setTextColor(Color.parseColor("#00aedb"));

                    switch(radioGender.getCheckedRadioButtonId()){
                        case R.id.main_radio_female:
                            selectedGender = "FEMALE";
                            break;
                        case R.id.main_radio_male:
                            selectedGender = "MALE";
                            break;
                    }
                }
            }
        });

        radioGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.main_radio_female:
                        selectedGender = "FEMALE";
                        break;
                    case R.id.main_radio_male:
                        selectedGender = "MALE";
                        break;
                }
            }
        });
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
        Intent i = getIntent();
        if(i.getStringExtra("NameTheme").equals("random")) {
            alphabetArray.add("랜덤");
        }
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
