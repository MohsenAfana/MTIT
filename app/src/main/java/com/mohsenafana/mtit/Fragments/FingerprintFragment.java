package com.mohsenafana.mtit.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mohsenafana.mtit.R;

import org.w3c.dom.Text;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class FingerprintFragment extends Fragment {
    TextView TimeNowTv;


    private String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

    public FingerprintFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fingerprint, container, false);
        TextView TimeNowTv = view.findViewById(R.id.TimeNowTv);
        TimeNowTv.setText(String.valueOf(mydate));
        return view;


    }

}
