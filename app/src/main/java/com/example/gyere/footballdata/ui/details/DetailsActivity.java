package com.example.gyere.footballdata.ui.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gyere.footballdata.R;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void showDetails() {

    }
}
