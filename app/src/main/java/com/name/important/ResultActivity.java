package com.name.important;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    String selectedGender = "";

    ListView resultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        selectedGender = getIntent().getStringExtra("GENDER");

        resultList = findViewById(R.id.result_list);

        setNameThemeTitle();
        setResultList();

        FirebaseApp.initializeApp(getApplicationContext());

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Names").child("Simple");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot messageData : dataSnapshot.getChildren()) {
                    String dataKey = messageData.getKey();
                    String dataValue = messageData.getValue().toString();

                    if(selectedGender.equals("ALL")){
                        Log.d("DB_READ", dataKey + ":" + dataValue);
                    }else if(selectedGender.equals("FEMALE") && dataValue.equals("F")){
                        Log.d("DB_READ", dataKey + ":" + dataValue);
                    }else if(selectedGender.equals("MALE") && dataValue.equals("M")){
                        Log.d("DB_READ", dataKey + ":" + dataValue);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("DB", "Failed to read value.", error.toException());
            }
        });
    }

    private void setNameThemeTitle() {
        TextView nameThemeTitle = findViewById(R.id.result_nametheme);
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

    private void setResultList() {
        ArrayList<String> nameArray = new ArrayList<>();
        nameArray.add("A");
        nameArray.add("B");
        nameArray.add("C");
        nameArray.add("D");
        nameArray.add("E");
        nameArray.add("F");
        nameArray.add("G");
        nameArray.add("H");
        nameArray.add("I");
        nameArray.add("J");
        nameArray.add("K");
        nameArray.add("L");
        nameArray.add("M");
        nameArray.add("N");
        nameArray.add("O");
        nameArray.add("P");
        nameArray.add("Q");
        nameArray.add("R");
        nameArray.add("S");
        nameArray.add("T");
        nameArray.add("U");
        nameArray.add("V");
        nameArray.add("W");
        nameArray.add("X");
        nameArray.add("Y");
        nameArray.add("Z");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nameArray);
        resultList.setAdapter(adapter);
    }
}
