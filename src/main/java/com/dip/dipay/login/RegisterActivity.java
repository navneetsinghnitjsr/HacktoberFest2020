package com.dip.dipay.login;

// MainActivity

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dip.dipay.login.R;

public class register extends AppCompatActivity {
    public static SharedPreferences shared;
    public static SharedPreferences.Editor editor;
    public static String str_login_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        shared = getSharedPreferences("myPrefer", 0);
        editor = shared.edit();

        // checking for log in

        str_login_test = shared.getString("loginTest", null);

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
            return;
        }

        if (str_login_test != null
                && !str_login_test.toString().trim().equals("")) {
            Intent send = new Intent(register.this, .class);
            startActivity(send);
        }
        /*
         * if user login test is false on oncreate then redirect the
         * user to login & registration page
         */
        else {

            Intent send = new Intent(getApplicationContext(),
                    Register.class);
            startActivity(send);

        }


        Button btn_login=findViewById(R.id.btn_login);
        Button btn_register=findViewById(R.id.btn_register);

        // sending intent
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(.this,MainActivity.class);
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                startActivity(new Intent(register.this,Registration.class));
                                            }
                                        }
        );
    }
}
