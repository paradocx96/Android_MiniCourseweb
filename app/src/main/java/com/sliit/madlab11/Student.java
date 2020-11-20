package com.sliit.madlab11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.sliit.madlab11.database.DBHandler;

import java.util.ArrayList;
import java.util.List;

public class Student extends AppCompatActivity {

    TextView txt_studentName;
    String studentName;
    RecyclerView recyclerView;
    ArrayList<String> users, subjects, messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        txt_studentName = findViewById(R.id.txt_student);
        recyclerView = findViewById(R.id.recyclerView);

        users = new ArrayList<>();
        subjects = new ArrayList<>();
        messages = new ArrayList<>();

        saveMessageData();

        CustomAdapter customAdapter = new CustomAdapter(users,subjects,messages,Student.this);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Student.this));

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null){
            studentName = (String) bundle.get("username");
            txt_studentName.setText("Welcome " + studentName);
        }
    }

    void saveMessageData() {
        DBHandler dbHandler = new DBHandler(getApplicationContext());

        users = (ArrayList<String>) dbHandler.readAllMessage("User");
        subjects = (ArrayList<String>) dbHandler.readAllMessage("Subject");
        messages = (ArrayList<String>) dbHandler.readAllMessage("Message");
    }
}