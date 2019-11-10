package com.mohsenafana.mtit.Fingerprint;

import android.os.Bundle;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.mohsenafana.mtit.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        Toast.makeText(this, "Successfully Sign In ", Toast.LENGTH_SHORT).show();


    }

}
