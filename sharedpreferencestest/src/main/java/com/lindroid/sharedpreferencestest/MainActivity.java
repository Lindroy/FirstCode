package com.lindroid.sharedpreferencestest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveData(View view){
        SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
        editor.putString("name","Lindroid");
        editor.putInt("age",26);
        editor.putBoolean("married",false);
        editor.apply();
        Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
    }

    public void readData(View view){
        SharedPreferences preferences = getSharedPreferences("data",MODE_PRIVATE);
        String name = preferences.getString("name","");
        int age = preferences.getInt("age",0);
        boolean married = preferences.getBoolean("married",false);
        Log.e("MainActivity","name is "+name);
        Log.e("MainActivity","age is "+age);
        Log.e("MainActivity","married is "+married);
        Toast.makeText(this, "读取成功", Toast.LENGTH_SHORT).show();

    }
}
