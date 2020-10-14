package com.dip.dipay.login;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistationActivity extends AppCompatActivity {

    EditText mobile,username,password,coinfrm_pass,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation2);
        mobile=findViewById(R.id.edt_Rmobile);
        username=findViewById(R.id.edt_userName);
        password=findViewById(R.id.edt_Rpassword);
        coinfrm_pass=findViewById(R.id.edt_RRepassword);
        email=findViewById(R.id.edt_email);

        // Set onclickListener
        Button btn_register=findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=username.getText().toString().trim();
                String pass=password.getText().toString().trim();
                String c_pass=coinfrm_pass.getText().toString().trim();
                String mail=email.getText().toString().trim();
                String mob=mobile.getText().toString().trim();

                if (uname.length() == 0 & pass.length() == 0
                        & coinfrm_pass.length() == 0 & mobile.length() == 0) {
                    Toast.makeText(registation.this,
                            "All fields are mandatory to fill", Toast.LENGTH_LONG)
                            .show();
                } else if (uname.length() == 0) {
                    Toast.makeText(registation.this, "Please enter your Name",
                            Toast.LENGTH_LONG).show();
                } else if (pass.length() == 0) {
                    Toast.makeText(registation.this,
                            "Please enter your Password", Toast.LENGTH_LONG).show();
                } else if (coinfrm_pass.length() == 0) {
                    Toast.makeText(registation.this,
                            "Please Re-enter your Password", Toast.LENGTH_LONG).show();
                }

                else if (email.length() == 0) {
                    Toast.makeText(registation.this,
                            "Please enter your Email Id", Toast.LENGTH_LONG).show();
                }

                else if (pass.contains(c_pass) != c_pass
                        .contains(pass)) {
                    Toast.makeText(registation.this,
                            "Confirm Password does not match", Toast.LENGTH_LONG)
                            .show();
                } else if (mob.length() == 0) {

                    Toast.makeText(registation.this,
                            "Please enter your mobile number", Toast.LENGTH_LONG)
                            .show();

                }
                else
                {

                    Register.editor.putString("user",uname);
                    Register.editor.putString("password",c_pass);
                    Register.editor.putString("email",mail);
                    Register.editor.putString("mobile",mob);
                    Register.editor.commit();
                    Toast.makeText(registation.this,
                            "You have successfully registered", Toast.LENGTH_LONG)
                            .show();
                    startActivity(new Intent(registation.this,register.class));

                }
            }

        });
    }
}
