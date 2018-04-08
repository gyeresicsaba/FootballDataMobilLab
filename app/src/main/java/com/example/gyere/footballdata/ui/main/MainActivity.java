package com.example.gyere.footballdata.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gyere.footballdata.R;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    public void showTeams() {

    }
}
