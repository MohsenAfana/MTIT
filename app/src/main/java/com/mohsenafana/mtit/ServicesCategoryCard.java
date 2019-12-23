package com.mohsenafana.mtit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.beloo.widget.chipslayoutmanager.SpacingItemDecoration;
import com.google.android.material.snackbar.Snackbar;
import com.mohsenafana.mtit.Data.AdapterGridServicesCategory;
import com.mohsenafana.mtit.Data.DataGenerator;
import com.mohsenafana.mtit.Data.ServicesCategory;
import com.mohsenafana.mtit.Data.Tools;

import java.util.List;

public class ServicesCategoryCard extends AppCompatActivity {
    private View parent_view;
    private RecyclerView recyclerView;
    private AdapterGridServicesCategory mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_category_card);
        parent_view = findViewById(R.id.parent_view);
        initComponent();

    }

    private void initComponent() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.addItemDecoration(new SpacingItemDecoration
                (2, Tools.dpToPx(this, 8)));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);

        List<ServicesCategory> items = DataGenerator.getServiceCategory(this);

        //set data and list adapter
        mAdapter = new AdapterGridServicesCategory(this, items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterGridServicesCategory.OnItemClickListener() {
            @Override
            public void onItemClick(View view, ServicesCategory obj, int position) {
                Snackbar.make(parent_view, "Item " + obj.title + " clicked", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

}
