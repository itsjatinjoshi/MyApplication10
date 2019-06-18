package com.example.jatin.myapplication10;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etPass;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName= findViewById(R.id.etName);
        etPass= findViewById(R.id.etPass);
        btnSubmit= findViewById(R.id.btnSubmit);

        final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);

    btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter the Name", Toast.LENGTH_LONG).show();
                } else if (etPass.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter the Password", Toast.LENGTH_LONG).show();
                } else {
                 alertBuilder.setMessage("Are you want to go to IntentActivity");
                 alertBuilder.setTitle("Exit");
                 alertBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override

                  public void onClick(DialogInterface dialog, int which) {

                        String userName = etName.getText().toString().trim();
                        String userPass = etPass.getText().toString().trim();
                        Intent intent = new Intent(MainActivity.this, intentActivity.class);

                        intent.putExtra("uname", userName);
                        intent.putExtra("upass", userPass);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "Thank You !", Toast.LENGTH_LONG).show();


                        }
                    });
                    alertBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "Don't want to leave window",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                    alertBuilder.show();

                    Snackbar snackbar = Snackbar.make(findViewById(R.id.LinLayout), "Practise again", Snackbar.LENGTH_LONG).
                            setAction("Undo", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(MainActivity.this, "Reset", Toast.LENGTH_LONG).show();
                                    etName.setText(" ");
                                    etPass.setText(" ");
                                }
                            });
                    snackbar.show();
                }
            }
        });



    }
}
