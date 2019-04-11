package com.richkidz.mizrahihelper;

import android.os.Bundle;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        ArrayList<BankObject> bankObjects = new ArrayList<>();
        bankObjects.add(new BankObject("https://www.facebook.com/",
                "https://images.pexels.com/photos/104827/cat-pet-animal-domestic-104827.jpeg",
                "Facebook is Google"));

        bankObjects.add(new BankObject("https://www.facebook.com/",
                "https://images.pexels.com/photos/104827/cat-pet-animal-domestic-104827.jpeg",
                "Facebook is Google"));

        bankObjects.add(new BankObject("https://www.facebook.com/",
                "https://images.pexels.com/photos/104827/cat-pet-animal-domestic-104827.jpeg",
                "Facebook is Google"));
        mAdapter = new MyAdapter(bankObjects);
        recyclerView.setAdapter(mAdapter);
    }
}
