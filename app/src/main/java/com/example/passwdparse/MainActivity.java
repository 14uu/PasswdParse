package com.example.passwdparse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText PasswdIn;
    String Passwd = "android";
    TextView Status;
    Button btnRun;
    int numTries = 0;
    int maxTries = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRun = (Button) findViewById(R.id.run);
        Status = (TextView) findViewById(R.id.status);
        Status.setText(getResources().getString(R.string.on_start, maxTries));
        PasswdIn = (EditText) findViewById(R.id.passwd);
    }
    public void Test(View view)
    {
        if(numTries < maxTries)
        {
            if (PasswdIn.getText().toString().equals(Passwd))
            {
                Status.setText(R.string.on_approval);
            }
            else {
                numTries++;
                if (numTries < maxTries)
                {
                    Status.setText(getResources().getString(R.string.on_fail, (maxTries - numTries)));
                }
                else
                {
                    Status.setText(R.string.on_maxTriesReached);
                }
            }
        }
    }
}
