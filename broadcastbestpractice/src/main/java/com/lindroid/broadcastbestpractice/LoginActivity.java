package com.lindroid.broadcastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity implements View.OnClickListener{
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        accountEdit = (EditText)findViewById( R.id.account );
        passwordEdit = (EditText)findViewById( R.id.password );
        login = (Button)findViewById( R.id.login );

        login.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        if ( v == login ) {
            String account = accountEdit.getText().toString();
            String password = passwordEdit.getText().toString();
            if (account.equals("Lin") && password.equals("123456")){
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();
            }else {
                Toast.makeText(this, "账号或者密码无效", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
