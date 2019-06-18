package com.example.jatin.myapplication10;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class intentActivity extends AppCompatActivity {
    TextView tvName1, tvPass1;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        tvName1= findViewById(R.id.tvName1);
        tvPass1= findViewById(R.id.tvPass1);
        btnBack= findViewById(R.id.btnBack);

        String getUserName= getIntent().getStringExtra("uname");
        String getUserPass= getIntent().getStringExtra("upass");
        tvName1.setText(getUserName);
        tvPass1.setText(getUserPass);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                onBackPressed();

            }
        });
    }
}
