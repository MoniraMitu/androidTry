package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.api.ApiGateWay;
import com.example.myapplication.entity.Students;

import java.util.List;

public class apiActivity extends AppCompatActivity {
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        btn=findViewById(R.id.btnGetAll);
        tv=findViewById(R.id.textView2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiGateWay ap = new ApiGateWay();

                try {
                    List<Students> studentsList
                }
            }
        })
    }
}