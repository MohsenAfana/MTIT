package com.mohsenafana.mtit.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.mohsenafana.mtit.Fingerprint.FingerprintActivity;
import com.mohsenafana.mtit.R;

import java.text.DateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class FingerprintFragment extends Fragment {
    TextView TimeNowTv;
    @BindView(R.id.AttendanceRegistrationIv)
    ImageView AttendanceRegistrationIv;
    @BindView(R.id.AttendanceDepartureIv)
    ImageView AttendanceDepartureIv;
    Context context;


    private String mydate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

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

    @OnClick(R.id.AttendanceRegistrationIv)
    public void onAttendanceRegistrationIvClicked() {
        Intent AttendanceRegistrationIntent=new Intent(context, FingerprintActivity.class);
        startActivity(AttendanceRegistrationIntent);
    }

    @OnClick(R.id.AttendanceDepartureIv)
    public void onAttendanceDepartureIvClicked() {
        Intent AttendanceDepartureIntent=new Intent(context, FingerprintActivity.class);
        startActivity(AttendanceDepartureIntent);
    }
}
