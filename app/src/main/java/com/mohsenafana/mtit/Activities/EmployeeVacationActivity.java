package com.mohsenafana.mtit.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.mohsenafana.mtit.R;

public class EmployeeVacationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_vacation);
        Toast.makeText(this, "EmployeeVacationActivity", Toast.LENGTH_SHORT).show();
        ((TextView) findViewById(R.id.title_toolbar)).setText("EmployeeVacationActivity");
        findViewById(R.id.ic_back).setOnClickListener(view -> onBackPressed());

    }
}
