package com.example.project10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        Button btnfinish = (Button)findViewById(R.id.btnfinish);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.toSecond);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.toThird);


        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (radioButton2.isChecked() == true){
                    Intent intent =
                            new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                } else if (radioButton3.isChecked() == true) {
                    Intent intent =
                            new Intent(MainActivity.this, ThirdActivity.class);
                    startActivity(intent);
                }


            }
        });

        btnfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}