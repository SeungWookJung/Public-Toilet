package com.dsappcenter.jun.mytoilet2;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.dsappcenter.jun.mytoilet2.R;


public class introActivity extends Activity {
    Handler handler = new Handler();
    Runnable r = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(getApplicationContext(), MapActivity.class);
            startActivity(intent);
            finish();

            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_intro);
        }
    @Override
    protected void onResume() {
        super.onResume();
        // 다시 화면에 들어어왔을 때 예약 걸어주기
        handler.postDelayed(r, 3000);  // 4초 뒤에 Runnable 객체 수행
        }

        @Override
        protected void onPause() {
            super.onPause();
            // 화면을 벗어나면, handler 에 예약해놓은 작업을 취소하자
            handler.removeCallbacks(r); // 예약 취소
        }
}




