package com.example.bibek.userlogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText username1,password1;
    Button login,signup;
    CheckBox remmember;
    boolean check;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("prefName",MODE_APPEND);
        editor = sharedPreferences.edit();

        username1 = (EditText)findViewById(R.id.username);
        password1 = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);
        signup = (Button)findViewById(R.id.signup);
        remmember = (CheckBox)findViewById(R.id.chbox);
        check = sharedPreferences.getBoolean("check",false);
        if(check)
        {
            remmember.setChecked(true);
            Intent i1 = new Intent(this,LoginActivity.class);
            startActivity(i1);
        }

    }

    public void onLogin(View view)
    {
        String userName = username1.getText().toString();
        String passWord = password1.getText().toString();

        String username = sharedPreferences.getString("username",null);
        String password = sharedPreferences.getString("password",null);

        if(remmember.isChecked()) {
            editor.putBoolean("check", true);
            editor.apply();
        }

        if((userName.equals(username))==true && (passWord.equals(password))==true){
            /*editor = sharedPreferences.edit();
            editor.putString("userName",userName);
            editor.putString("passWord",passWord);
            editor.apply();*/

                Intent i = new Intent(this, LoginActivity.class);
                startActivity(i);
        }
        else
            Toast.makeText(this,"Incorrect UserName or Password",Toast.LENGTH_SHORT).show();
    }

    public void onSignUp(View view){

        Intent intent = new Intent(this,SignUpActivity.class);
        startActivity(intent);
    }
}
