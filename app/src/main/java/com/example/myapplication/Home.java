package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.entity.Employee;

public class Home extends AppCompatActivity {
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences preferences = getSharedPreferences("shared_pref", Context.MODE_PRIVATE);

        String name = preferences.getString("name", "");
        Toast.makeText(getApplicationContext(), "Welcome " + name + "!", Toast.LENGTH_SHORT).show();

        cardView = findViewById(R.id.cardOrderDetails);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "okkk", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Home.this, CreateEmployee.class));
            }
        });
    }
}