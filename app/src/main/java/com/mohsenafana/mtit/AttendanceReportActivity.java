package com.mohsenafana.mtit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class AttendanceReportActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attendance_report_layout);
        ((TextView) findViewById(R.id.title_toolbar)).setText("Employee Report");
        findViewById(R.id.ic_back).setOnClickListener(view -> onBackPressed());
        draw_chart();
    }

    private void draw_chart() {
        PieChart pieChart = findViewById(R.id.piechart);
        ArrayList<Entry> attendance_data = new ArrayList<>();

        attendance_data.add(new Entry(945f, 0));
        attendance_data.add(new Entry(1040f, 1));
        attendance_data.add(new Entry(1133f, 2));
        attendance_data.add(new Entry(1240f, 3));
        attendance_data.add(new Entry(1369f, 4));

        PieDataSet dataSet = new PieDataSet(attendance_data, "Employee worktime report");


        ArrayList<String> employee_data = new ArrayList<>();

        employee_data.add("Delay Days");
        employee_data.add("Not Entered");
        employee_data.add("Vacations");
        employee_data.add("Workdays");
        employee_data.add("Weekly Holidays");

        PieData data = new PieData(employee_data, dataSet);
        pieChart.setData(data);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setValueTextSize(12);
        pieChart.animateXY(1000, 1500);

    }


}
