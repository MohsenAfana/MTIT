package com.mohsenafana.mtit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PermissionReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_report);
        ((TextView) findViewById(R.id.title_toolbar)).setText("Permission Report");
        findViewById(R.id.ic_back).setOnClickListener(view -> onBackPressed());
        draw_chart();
    }
    private void draw_chart() {
        PieChart pieChart = findViewById(R.id.piechart);
        ArrayList permission_data = new ArrayList();

        permission_data.add(new Entry(945f, 0));
        permission_data.add(new Entry(1040f, 1));
        permission_data.add(new Entry(1133f, 2));
        permission_data.add(new Entry(1240f, 3));
        permission_data.add(new Entry(1369f, 4));

        PieDataSet dataSet = new PieDataSet(permission_data, "Employee worktime report");

        ArrayList employee_data = new ArrayList();

        employee_data.add("Special permission");
        employee_data.add("Morning delay");
        employee_data.add("Job Assignment");
        employee_data.add("Workdays");
        employee_data.add("Without Permission");

        PieData data = new PieData(employee_data, dataSet);
        pieChart.setData(data);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setValueTextSize(12);
        pieChart.animateXY(1000, 1500);

    }

}
