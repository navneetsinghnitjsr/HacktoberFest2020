package com.dip.dipay.login;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Logout1 extends AppCompatActivity {

    TextView prof;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        Button btn_logout=findViewById(R.id.logout);
        prof=findViewById(R.id.txt_profile);
        //fetching informations from main activity

        String uname=Register.shared.getString("user",null);
        String password=Register.shared.getString("password",null);
        String Email=Register.shared.getString("email",null);
        String mob=Register.shared.getString("mobile",null);

        prof.setText("Name : " + uname + "\n" + "\n" + "Password : "
                + password + "\n" + "\n" + "Email : " + Email
                + "\n" + "\n" + "Mobile : " + mob);

        // removing log in credentials
        Register.editor.remove("loginTest");
        Register.editor.commit();

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Logout1.this, "You have successfully logout",
                        Toast.LENGTH_LONG).show();
                startActivity(new Intent(Logout1.this,Login.class));
            }
        });
    }
}
