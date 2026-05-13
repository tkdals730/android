package com.example.project10_3;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // [현대적 방법 1] ActivityResultLauncher를 멤버 변수로 등록
    // 기존 onActivityResult() 오버라이드 방식을 대체합니다.
    // registerForActivityResult()는 Activity의 STARTED 상태 이전(필드 초기화 시점)에 호출되어야 합니다.
    private ActivityResultLauncher<Intent> sumLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        // 결과 처리 콜백 - 옛 onActivityResult()의 내용이 이곳으로 이동
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            int hap = result.getData().getIntExtra("Hap", 0);
                            Toast.makeText(getApplicationContext(),
                                    "합계 :" + hap, Toast.LENGTH_SHORT).show();
                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("매인 엑티비티");

        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editNum1 = (EditText) findViewById(R.id.edtNum1);
                EditText editNum2 = (EditText) findViewById(R.id.edtNum2);
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Num1", Integer.parseInt(editNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(editNum2.getText().toString()));

                // [현대적 방법 2] startActivityForResult(intent, 0) 대신 launcher.launch(intent) 사용
                // requestCode 정수를 더 이상 관리할 필요가 없습니다.
                //startActivityForResult(intent, 0);
                sumLauncher.launch(intent);
            }
        });
    }

    // [현대적 방법 3] onActivityResult() 오버라이드 메서드는 더 이상 필요 없습니다.
    // 결과 처리 로직이 위쪽 sumLauncher의 콜백 람다로 이동했습니다.
    // (참고: 옛 방식인 startActivityForResult / onActivityResult는 API 30부터 deprecated)
}