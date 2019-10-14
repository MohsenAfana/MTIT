package com.mohsenafana.mtit.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mohsenafana.mtit.R;

public class EmployeeServicesFragment extends Fragment {
    ImageView EmployeeVacationsIV;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      /*  EmployeeVacationsIV=container.findViewById(R.id.EmployeeVacationsIV);
        EmployeeVacationsIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), EmployeeVacationFragment.class);
                startActivity(intent);
            }
        });*/
        return inflater.inflate(R.layout.fragment_employee_services,container,false);
    }
}
