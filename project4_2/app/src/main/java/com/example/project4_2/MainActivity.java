package com.example.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView1,textView2;
    CheckBox checkBox;
    RadioGroup radioGroup;
    RadioButton rdoDog, rdoCat, rdoHorse,rdoFox;
    Button button;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        textView1 = (TextView) findViewById(R.id.text1);
        checkBox = (CheckBox)findViewById(R.id.checkbox1);
        textView2 = (TextView) findViewById(R.id.text2);
        radioGroup = (RadioGroup)findViewById(R.id.radio1);
        rdoDog =(RadioButton) findViewById(R.id.rdodog);
        rdoCat =(RadioButton) findViewById(R.id.rdocat);
        rdoHorse=(RadioButton) findViewById(R.id.rdohorse);
        rdoFox=(RadioButton) findViewById(R.id.rdofox);
        button = (Button)findViewById(R.id.BtnOK);
        imageView = (ImageView) findViewById(R.id.ImgPet);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBox.isChecked() == true){
                    textView2.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.VISIBLE);
                    button.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.VISIBLE);
                }else{
                    textView2.setVisibility(View.INVISIBLE);
                    radioGroup.setVisibility(View.INVISIBLE);
                    button.setVisibility(View.INVISIBLE);
                    imageView.setVisibility(View.INVISIBLE);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                int checkedRadio = radioGroup.getCheckedRadioButtonId();
                if(checkedRadio == R.id.rdodog){
                    imageView.setImageResource(R.drawable.dog);
                }
                else if (checkedRadio == R.id.rdocat) {
                    imageView.setImageResource(R.drawable.cat);
                }
                else if (checkedRadio == R.id.rdofox) {
                    imageView.setImageResource(R.drawable.fox);
                }
                else if (checkedRadio == R.id.rdohorse) {
                    imageView.setImageResource(R.drawable.horse);
                }else {
                    Toast.makeText(getApplicationContext(), "동물을 먼저 선택하세요",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}