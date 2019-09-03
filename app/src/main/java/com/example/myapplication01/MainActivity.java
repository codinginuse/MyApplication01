package com.example.myapplication01;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//추가추가
    MediaPlayer soundf;
    Button stalkerbtn;
    Button stalkerstop;
    int tom;
//추가추가끝
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "버튼이 눌러졌습니다.", Toast.LENGTH_SHORT).show();
            }
        });

//        사이트 이동 버튼 3개
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.daum.net"));
                startActivity(myIntent);
            }
        });

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
                startActivity(myIntent);
            }
        });

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(myIntent);
            }
        });

//            아래 버튼 2개 작동
        Button buttonONE = (Button) findViewById(R.id.buttonONE);
        buttonONE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OneActivity.class);
                startActivity(intent);
            }
        });
        Button buttonTWO = (Button) findViewById(R.id.buttonTWO);
        buttonTWO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(intent);
            }
        });

//       MediaPlayer 이용한 스토커 노래 재생
        stalkerbtn = (Button) findViewById(R.id.stalkerbtn);
        stalkerstop = (Button) findViewById(R.id.stalkerstop);

        stalkerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundf = MediaPlayer.create(MainActivity.this, R.raw.stalker);
                soundf.start();
            }
        });

        stalkerstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 정지버튼
                soundf.stop();
                // 초기화
                soundf.reset();
            }
        });
    }
        // MediaPlayer는 시스템 리소스를 잡아먹는다.
        // MediaPlayer는 필요이상으로 사용하지 않도록 주의해야 한다.
        @Override
        protected void onDestroy() {
            super.onDestroy();
            // MediaPlayer 해지
            if (soundf != null) {
                soundf.release();
                soundf = null;

            }
        }

    }

