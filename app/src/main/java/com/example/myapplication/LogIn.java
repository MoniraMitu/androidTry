package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.dao.Database;

public class LogIn extends AppCompatActivity {
    EditText edUserName;
    EditText edPassword;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        edUserName=findViewById(R.id.name);
        edPassword=findViewById(R.id.password);
        btn=findViewById(R.id.logIn);
        tv=findViewById(R.id.newUser);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LogIn.this,MainActivity.class);
                startActivity(intent);
            }});

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                String name= edUserName.getText().toString();
                String  password=edPassword.getText().toString();
                Database database = new Database(getApplicationContext(),"healthcare",null,1);

//                Toast.makeText(getApplicationContext(),"Name: "+name+ "Password: "+password,Toast.LENGTH_SHORT).show();
                if(edUserName.length()==0 || edPassword.length()==1){
                    Toast.makeText(getApplicationContext(),"Please fill the following Fields",Toast.LENGTH_SHORT).show();
                }else {
                    if(database.logIn(name,password)==1){
                        Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_SHORT).show();
                        SharedPreferences preferences=getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.apply();
                        editor.commit();
                        startActivity(new Intent(LogIn.this, Home.class));
                    }
                }
            }
        });
    }
    public void logIn(){}
}