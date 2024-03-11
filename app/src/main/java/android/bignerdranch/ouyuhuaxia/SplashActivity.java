package android.bignerdranch.ouyuhuaxia;

import android.bignerdranch.ouyuhuaxia.BaseClass.BaseAct;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends BaseAct {

    private Handler mHandler=new Handler();
    private Runnable mRunnable=new Runnable() {
        @Override
        public void run() {
            Intent intent=new Intent(SplashActivity.this,MainActivity.class);
            startActivity(intent);
            SplashActivity.this.finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mHandler.postDelayed(mRunnable,2000);//开屏停俩秒
    }

    @Override
    protected void onPause() {
        super.onPause();

        mHandler.removeCallbacks(mRunnable);
    }
}