package com.sliit.madlab11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Student extends AppCompatActivity {

    TextView txt_studentName;
    String studentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        txt_studentName = findViewById(R.id.txt_student);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null){
            studentName = (String) bundle.get("username");
            txt_studentName.setText(studentName);
        }
    }
}