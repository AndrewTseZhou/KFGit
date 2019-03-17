package com.andrewtse.kfgit;

import android.os.Bundle;
import android.os.Handler;

import com.andrewtse.kfgit.common.utils.ActivityUtils;
import com.andrewtse.kfgit.data.pref.UserPref;
import com.andrewtse.kfgit.ui.module.main.MainActivity;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        new Handler(msg -> {
            if (UserPref.checkLogin(WelcomeActivity.this)) {
                ActivityUtils.startActivity(this, MainActivity.class);
                finish();
            }
            return false;
        }).sendEmptyMessageDelayed(0, 2500);

    }
}
