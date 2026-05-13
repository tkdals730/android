package com.example.a402p6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        setTitle("투표 결과");

        Intent intent = getIntent();

        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        Integer imageFileId[] = {
                R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
                R.drawable.pic7, R.drawable.pic8, R.drawable.pic9
        };

        ViewFlipper viewFlipper =
                (ViewFlipper) findViewById(R.id.viewFlipper);

        // 순위 저장용 배열
        Integer rank[] = {0,1,2,3,4,5,6,7,8};

        // 득표수 기준 정렬
        for (int i = 0; i < rank.length - 1; i++) {
            for (int j = i + 1; j < rank.length; j++) {

                if (voteResult[rank[i]] < voteResult[rank[j]]) {

                    int temp = rank[i];
                    rank[i] = rank[j];
                    rank[j] = temp;
                }
            }
        }

        // ViewFlipper에 추가
        for (int i = 0; i < rank.length; i++) {

            int index = rank[i];

            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.setGravity(Gravity.CENTER);

            TextView tvInfo = new TextView(this);

            tvInfo.setText(
                    (i + 1) + "등 : "
                            + imageName[index]
                            + "\n득표수 : "
                            + voteResult[index]
                            + "표"
            );

            tvInfo.setTextSize(24);
            tvInfo.setGravity(Gravity.CENTER);

            ImageView imageView = new ImageView(this);

            imageView.setImageResource(imageFileId[index]);

            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

            imageView.setAdjustViewBounds(true);

            layout.addView(tvInfo);
            layout.addView(imageView);

            viewFlipper.addView(layout);
        }

        Button btnStart =
                (Button) findViewById(R.id.btnStart);

        Button btnStop =
                (Button) findViewById(R.id.btnStop);

        Button btnReturn =
                (Button) findViewById(R.id.btnReturn);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewFlipper.startFlipping();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewFlipper.stopFlipping();
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }
}