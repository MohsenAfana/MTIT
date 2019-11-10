package com.mohsenafana.mtit.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.mohsenafana.mtit.R;

public class MessagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_messages);
        ((TextView)findViewById(R.id.title_toolbar)).setText("Messages");
        findViewById(R.id.ic_back).setOnClickListener(view -> {
            onBackPressed();
        });
    }
}
