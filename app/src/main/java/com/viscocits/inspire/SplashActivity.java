package com.viscocits.inspire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.viscocits.redeem.utils.Constants;
import com.viscocits.redeem.utils.Utility;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        boolean isLogin = Utility.getPreferences(this, Constants.KEY_LOGIN_CHECK, false);

        if (isLogin)
            startActivity(new Intent(this, Main2Activity.class));
        else
            startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
