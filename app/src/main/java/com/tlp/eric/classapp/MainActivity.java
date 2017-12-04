package com.tlp.eric.classapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity{

    public static final String EXTRA_MESSAGE = "com.example.eric.password";

    private TextView textID, usernameTextViewID, credentialID;
    private Button submitID;
    private EditText username, password;
    String editTextUser, editTextPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //textID = (TextView) findViewById(R.id.submitID);
        usernameTextViewID = (TextView) findViewById(R.id.usernameTextViewID);
        credentialID = (TextView) findViewById(R.id.credentialID);
        submitID = (Button) findViewById(R.id.submitID);
        submitID.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editTextUser = username.getText().toString();
                editTextPass = password.getText().toString();
                if (editTextUser.isEmpty() && editTextPass.isEmpty())
                {
                    credentialID.setText("Please enter a username and password");
                }
                else if (editTextPass.isEmpty())
                {
                    credentialID.setText("Please enter a password");
                }
                else if (editTextUser.isEmpty())
                {
                    credentialID.setText("Please enter a username");
                }
                else
                {
                    if (v.getId() == R.id.submitID) //textID.setText("Submitted");
                    {
                        //if (editTextUser.equals("username") && editTextPass.equals("password"))
                        //{
                            credentialID.setText("Correct login");
                            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                            startActivity(intent);
                       //}
                        //else
                        //{
                            //credentialID.setText("Incorrect login");
                        //}
                    }
                }
            }
        });

        username = (EditText) findViewById(R.id.userEditID);
        password = (EditText) findViewById(R.id.passEditID);
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(this, SecondActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
}
