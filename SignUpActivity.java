package com.example.bibek.userlogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by bibek on 6/23/17.
 */

class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    EditText setname,setnumber,setemail,setusername,setpassword,setage;
    Button save;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        setname = (EditText)findViewById(R.id.setname);
        setnumber = (EditText)findViewById(R.id.setnumber);
        setage = (EditText)findViewById(R.id.setage);
        setemail = (EditText)findViewById(R.id.setemail);
        setusername = (EditText)findViewById(R.id.setUsername);
        setpassword = (EditText)findViewById(R.id.setpassword);
        save = (Button)findViewById(R.id.setsave);

        sharedPreferences = getSharedPreferences("prefName",MODE_APPEND);
        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String name = setname.getText().toString();
        String number = setnumber.getText().toString();
        String age = setage.getText().toString();
        String email = setemail.getText().toString();
        String username = setusername.getText().toString();
        String password = setpassword.getText().toString();

        editor = sharedPreferences.edit();
        editor.putString("name",name);
        editor.putString("number",number);
        editor.putString("age",age);
        editor.putString("email",email);
        editor.putString("username",username);
        editor.putString("password",password);
        editor.apply();

        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
