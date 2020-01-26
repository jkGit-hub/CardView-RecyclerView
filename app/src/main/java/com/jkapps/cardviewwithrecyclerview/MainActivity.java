package com.jkapps.cardviewwithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView.Adapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;

    ArrayList<Model> data;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);

        data = new ArrayList<>();
        for (int i = 0; i < Data.titleArray.length; i++) {
            data.add(new Model(
                    Data.drawableArray[i],
                    Data.titleArray[i],
                    Data.descriptionArray[i],
                    Data.shopUrlArray[i]
            ));
        }

        adapter = new MyRecyclerViewAdapter(this, data);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}





