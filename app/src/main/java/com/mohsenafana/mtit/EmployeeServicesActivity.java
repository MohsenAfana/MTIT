package com.mohsenafana.mtit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mohsenafana.mtit.Activities.EmployeeVacationActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class EmployeeServicesActivity extends AppCompatActivity {

    @BindView(R.id.EmployeeVacationsIV)
    ImageView EmployeeVacationsIV;
    @BindView(R.id.portfolioManagementIv)
    ImageView portfolioManagementIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_services_layout);
        ButterKnife.bind(this);
        ((TextView) findViewById(R.id.title_toolbar)).setText("Employee Services");
        findViewById(R.id.ic_back).setOnClickListener(view -> onBackPressed());
    }

    @OnClick(R.id.EmployeeVacationsIV)
    public void onEmployeeVacationsIVClicked() {
        Intent intent = new Intent(this, EmployeeVacationActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.portfolioManagementIv)
    public void onPortfolioManagementIvClicked() {
        Intent intent = new Intent(this,ReoprtsActivity.class);
        startActivity(intent);
    }



}
