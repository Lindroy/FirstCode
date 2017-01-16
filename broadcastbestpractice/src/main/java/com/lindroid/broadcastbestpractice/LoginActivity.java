package com.lindroid.broadcastbestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity implements View.OnClickListener{
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    private CheckBox rememberPass;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit = (EditText)findViewById( R.id.account );
        passwordEdit = (EditText)findViewById( R.id.password );
        rememberPass = (CheckBox) findViewById(R.id.remember_pass);
        login = (Button)findViewById( R.id.login );
        boolean isRemember = preferences.getBoolean("remember_password",false);
        login.setOnClickListener(this);

        if (isRemember){
            String account = preferences.getString("account","");
            String password = preferences.getString("password","");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
    }


    @Override
    public void onClick(View v) {
        if ( v == login ) {
            String account = accountEdit.getText().toString();
            String password = passwordEdit.getText().toString();
            if (account.equals("Lin") && password.equals("123456")){
                editor = preferences.edit();
                if (rememberPass.isChecked()){
                    editor.putBoolean("remember_password",true);
                    editor.putString("account",account);
                    editor.putString("password",password);
                }else {
                    editor.clear();
                }
                editor.apply();
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();
            }else {
                Toast.makeText(this, "账号或者密码无效", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
