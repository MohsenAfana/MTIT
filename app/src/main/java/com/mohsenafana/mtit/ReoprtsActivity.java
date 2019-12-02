package com.mohsenafana.mtit;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReoprtsActivity extends AppCompatActivity {

    @BindView(R.id.Attendance_and_Leave)
    LinearLayout AttendanceAndLeave;
    @BindView(R.id.permissions)
    LinearLayout permissions;
    @BindView(R.id.vacations)
    LinearLayout vacations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reoprts);
        ButterKnife.bind(this);
        ((TextView) findViewById(R.id.title_toolbar)).setText("Employee Reports");
        findViewById(R.id.ic_back).setOnClickListener(view -> onBackPressed());
    }

    @OnClick(R.id.Attendance_and_Leave)
    public void onAttendanceAndLeaveClicked() {
        Intent intent = new Intent(this, AttendanceReportActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.permissions)
    public void onPermissionsClicked() {
        Intent intent = new Intent(this, PermissionReportActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.vacations)
    public void onVacationsClicked() {
        Intent intent = new Intent(this, VacationsReportActivity.class);
        startActivity(intent);
    }
}
