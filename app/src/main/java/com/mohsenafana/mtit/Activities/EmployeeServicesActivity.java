package com.mohsenafana.mtit.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.mohsenafana.mtit.R;

public class EmployeeServicesActivity extends AppCompatActivity {
    ImageView EmployeeVacationsIV;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_employee_services);
        EmployeeVacationsIV = findViewById(R.id.EmployeeVacationsIV);

    }
}
