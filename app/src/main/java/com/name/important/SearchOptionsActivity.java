package com.name.important;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SearchOptionsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_options);

        setAlphabetSpinner();
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
