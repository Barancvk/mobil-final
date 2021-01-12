package com.h5190061.baran_civak_final.activities;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.h5190061.baran_civak_final.utils.AlertDialogUtil;
import com.h5190061.baran_civak_final.utils.NetworkUtil;
import com.h5190061.baran_civak_final.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UcSaniyeBeklemeTimer();
    }
    public void UcSaniyeBeklemeTimer() {
        CountDownTimer countDownTimer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                if(NetworkUtil.internetKontrol(getApplicationContext()))
                {
                    Intent ikinciekranagecis=new Intent(getApplicationContext(),ListeActivity.class);
                    startActivity(ikinciekranagecis);
                    finish();
                }
                else
                {
                    InternetVarmi();
                }

            }
        };
        countDownTimer.start(); }

    public void InternetVarmi(){
        AlertDialogUtil.alertDialoguGoster(MainActivity.this,getResources().getString(R.string.uygulama_internet),
                getResources().getString(R.string.uygulama_internet_bagla),
                getResources().getString(R.string.uygulama_ayarlar_git),getResources().getString(R.string.uygulama_kapat),
                getResources().getString(R.string.mainactivityekrani));
        }
}