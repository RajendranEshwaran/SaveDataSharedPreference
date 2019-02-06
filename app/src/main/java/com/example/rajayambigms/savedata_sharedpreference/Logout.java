package com.example.rajayambigms.savedata_sharedpreference;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Logout extends AppCompatActivity {

    TextView usernameTxt;
    TextView msgTxt;
    Button logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        String username= getIntent().getStringExtra("username");

        usernameTxt = (TextView)findViewById(R.id.usernameTxt);
        msgTxt =(TextView)findViewById(R.id.msgTxt);
        logoutBtn = (Button)findViewById(R.id.logoutBtn);


        usernameTxt.setText("UserName:" + username);
        msgTxt.setText("Welcome User!!!!!");

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Logout.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
