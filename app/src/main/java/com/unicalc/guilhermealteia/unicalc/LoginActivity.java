package com.unicalc.guilhermealteia.unicalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = (EditText) findViewById(R.id.et_email);
        etEmail.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                etPassword = (EditText) findViewById(R.id.et_password);
                etEmail = (EditText) view;
                if(etEmail.getText().toString().contains( "\n")){
                    etEmail.setText(etEmail.getText().toString().replace("\n", ""));
                    etPassword.requestFocus();
                }
                return false;
            }
        });

        btLogin = (Button) findViewById(R.id.bt_login);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //MOCK
                if ("alteia@live.com".equals(etEmail.getText().toString())){
                    Intent myIntent = new Intent(LoginActivity.this, CalcActivity.class);
                    myIntent.putExtra("email", etEmail.getText().toString()); //Optional parameters
                    LoginActivity.this.startActivity(myIntent);
                }
            }
        });
    }
}
