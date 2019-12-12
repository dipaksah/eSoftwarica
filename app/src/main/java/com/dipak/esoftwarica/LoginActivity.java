package com.dipak.esoftwarica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnLogin;
    private EditText etUsername,etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);

        btnLogin=findViewById(R.id.btnlogin);
        etUsername=findViewById(R.id.etusername);
        etPassword=findViewById(R.id.etpassword);

        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (TextUtils.isEmpty(etUsername.getText().toString())){
            etUsername.setError("Please Insert Username");
            etUsername.requestFocus();
            return;
        }else if (TextUtils.isEmpty(etPassword.getText().toString())){
            etPassword.setError("Please Insert password");
            etPassword.requestFocus();
            return;
        }else {

            String name = etUsername.getText().toString();
            String pass = etPassword.getText().toString();

            LoginOperation loginOperation = new LoginOperation(name, pass);
            Boolean log = loginOperation.operation();

            if (log == true) {
                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(intent);
            } else if (log == false) {
                Toast.makeText(LoginActivity.this, "Incorrect Username or Password", Toast.LENGTH_LONG).show();
            }
        }
    }
}
