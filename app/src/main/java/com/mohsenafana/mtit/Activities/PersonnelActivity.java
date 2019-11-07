package com.mohsenafana.mtit.Activities;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mohsenafana.mtit.R;

public class PersonnelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_personnel);
        ((TextView)findViewById(R.id.title_toolbar)).setText("Personnel");
        findViewById(R.id.ic_back).setOnClickListener(view -> onBackPressed());
    }
}
