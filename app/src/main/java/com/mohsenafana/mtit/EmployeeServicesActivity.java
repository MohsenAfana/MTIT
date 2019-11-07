package com.mohsenafana.mtit;

import android.os.Bundle;
import android.widget.ImageView;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class EmployeeServicesActivity extends AppCompatActivity {

    @BindView(R.id.EmployeeVacationsIV)
    ImageView EmployeeVacationsIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_services_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.EmployeeVacationsIV)
    public void onViewClicked() {
        Toast.makeText(this, "Text", Toast.LENGTH_SHORT).show();
    }
}
