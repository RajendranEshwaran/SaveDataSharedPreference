package com.example.rajayambigms.savedata_sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText usernameTxt;
    private EditText passwordTxt;
    private Button singInBtn;
    private Button singUpBtn;

    private final static String SharePreference = "";
    private final static String USERNAME ="username";
    private final static String PASSWORD = "password";
    private String getUsername;
    private String getPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameTxt = (EditText)findViewById(R.id.usernameTxt);
        passwordTxt = (EditText)findViewById(R.id.passwordTxt);
        singInBtn = (Button)findViewById(R.id.signInBtn);
        singUpBtn =(Button)findViewById(R.id.signUpBtn);
        usernameTxt.requestFocus();

        singUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signUpAction();
            }
        });

        singInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInAction();
            }
        });

    }

    public  void signUpAction()
    {
        WriteData();
    }
    public void WriteData()
    {
        // WRITE DATA IN SHARED PREFERENCES

        SharedPreferences sharedPreferences = getSharedPreferences("LoginDetail",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(!usernameTxt.getText().toString().isEmpty() && !passwordTxt.getText().toString().isEmpty())
        {
            editor.putString(USERNAME , usernameTxt.getText().toString());
            editor.putString(PASSWORD,passwordTxt.getText().toString());
            Toast.makeText(this,"SAVED DATA",Toast.LENGTH_LONG).show();
            usernameTxt.getText().clear();
            passwordTxt.getText().clear();
            editor.apply();
        }
        else
        {
            Toast.makeText(this,"Enter all Required Data",Toast.LENGTH_LONG).show();
        }

    }

    public void ReadData()
    {
        // READ DATA FROM THE SHARED PREFERENCES

        SharedPreferences sharedPreferences = getSharedPreferences("LoginDetail",MODE_PRIVATE);
        getUsername = sharedPreferences.getString(USERNAME,"");
        getPassword = sharedPreferences.getString(PASSWORD,"");
    }

    public void signInAction()
    {
        ReadData();

        if(usernameTxt.getText().toString().equals(getUsername) && passwordTxt.getText().toString().equals(getPassword) )
        {
            usernameTxt.getText().clear();
            passwordTxt.getText().clear();

            Toast.makeText(this,"Authentican Success",Toast.LENGTH_LONG).show();

            Intent intent = new Intent(MainActivity.this,Logout.class);
            intent.putExtra(USERNAME,getUsername);
            startActivity(intent);

        }
        else
        {
            Toast.makeText(this,"Sorry!!!Wrong Data",Toast.LENGTH_LONG).show();
        }
    }
}
