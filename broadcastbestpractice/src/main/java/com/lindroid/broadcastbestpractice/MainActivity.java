package com.lindroid.broadcastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void forceOffline(View v){
        Intent intent = new Intent("com.lindroid.broadcastbestpractice.FORCE_OFFLINE");
        sendBroadcast(intent);
    }
}
