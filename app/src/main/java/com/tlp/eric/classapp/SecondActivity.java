package com.tlp.eric.classapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.view.View.OnClickListener;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] spinnerNamesEnglish={"Student","Faculty","Other"};
    String[] spinnerNamesSpanish={"Hola","Nombre","Casa"};
    private String emailAddress;

    private RadioGroup radioGroup;
    private RadioButton english, spanish;
    private Button submitButton;
    private EditText emailEditText;
    private Intent emailIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        english = (RadioButton) findViewById(R.id.englishID);
        spanish = (RadioButton) findViewById(R.id.spanishID);
        radioGroup = (RadioGroup) findViewById(R.id.myRadioGroup);
        submitButton = (Button) findViewById(R.id.sendEmailID);
        emailEditText = (EditText) findViewById(R.id.emailEditTextID);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                emailAddress = emailEditText.getText().toString();
                emailIntent = new Intent(Intent.ACTION_SEND);

                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ emailAddress });
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "CISP 362 ClassApp Email Intent by Eric Duncan");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Final App: https://play.google.com/store/apps/details?id=com.tlp.eric.spider");
                emailIntent.setType("plain/text");
                startActivity(Intent.createChooser(emailIntent, "Choose an Email client: "));
            }
        });


        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.spinnerID);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerNamesEnglish);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if (checkedId == R.id.englishID) {
                    Toast.makeText(getApplicationContext(), "choice: English",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "choice: Spanish",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btn = (Button)findViewById(R.id.DateAndTimeID);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, DateAndTimeActivity.class));
            }
        });

        Button profile = (Button)findViewById(R.id.profileID);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, ProfileActivity.class));
            }
        });
    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        Toast.makeText(getApplicationContext(), spinnerNamesEnglish[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub

    }
}
