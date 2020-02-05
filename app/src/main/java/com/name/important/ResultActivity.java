package com.name.important;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ResultActivity extends AppCompatActivity {
    String selectedGender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        selectedGender = getIntent().getStringExtra("GENDER");

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
}
