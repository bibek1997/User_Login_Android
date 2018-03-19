package com.example.bibek.userlogin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by bibek on 6/23/17.
 */

class LoginActivity extends AppCompatActivity {
    TextView getname,getphone,getage,getemail,getusername;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output);

        getname = (TextView)findViewById(R.id.showname);
        getphone = (TextView)findViewById(R.id.shownumber);
        getage = (TextView)findViewById(R.id.showage);
        getemail = (TextView)findViewById(R.id.showemail);
        getusername = (TextView)findViewById(R.id.showusername);

        sharedPreferences = getSharedPreferences("prefName",MODE_APPEND);

        String userName = sharedPreferences.getString("username",null);
        String name = sharedPreferences.getString("name",null);
        String phone = sharedPreferences.getString("number",null);
        String age = sharedPreferences.getString("age",null);
        String email = sharedPreferences.getString("email",null);

        getusername.setText(userName);
        getname.setText(name);
        getphone.setText(phone);
        getage.setText(age);
        getemail.setText(email);

    }
}
