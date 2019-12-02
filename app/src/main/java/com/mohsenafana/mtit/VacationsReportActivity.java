package com.mohsenafana.mtit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class VacationsReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacations_report);
        ((TextView) findViewById(R.id.title_toolbar)).setText("Vacation Report");
        findViewById(R.id.ic_back).setOnClickListener(view -> onBackPressed());
        draw_chart();
    }
    private void draw_chart() {
        BarChart chart = findViewById(R.id.barchart);

        ArrayList NoOfEmpVac = new ArrayList();

        NoOfEmpVac.add(new BarEntry(4, 0));
        NoOfEmpVac.add(new BarEntry(6, 1));


        ArrayList year = new ArrayList();

        year.add("Normal Vacations");
        year.add("Emergency Vacations");
       BarDataSet bardataset = new BarDataSet(NoOfEmpVac, "No Of Vacations");
        chart.animateY(1000);
        BarData data = new BarData(year, bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(data);
    }

}
