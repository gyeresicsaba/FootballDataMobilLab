package com.example.gyere.footballdata.ui.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gyere.footballdata.FootballDataApplication;
import com.example.gyere.footballdata.R;
import com.example.gyere.footballdata.model.Team;

import javax.inject.Inject;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen {

    @Inject
    DetailsPresenter detailsPresenter;

    int teamId;

    TextView teamName;
    TextView shortNameValue;
    TextView marketValueValue;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        FootballDataApplication.injector.inject(this);

        teamName = (TextView) findViewById(R.id.teamName);
        shortNameValue = (TextView) findViewById(R.id.shortNameValue);
        marketValueValue = (TextView) findViewById(R.id.marketValueVAlue);
        imageView = (ImageView) findViewById(R.id.imageView);

        String data = getIntent().getExtras().getString("Key_id");
        teamId = Integer.parseInt(data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        detailsPresenter.attachScreen(this);
        detailsPresenter.showDetails(teamId);
    }

    @Override
    protected void onStop() {
        super.onStop();
        detailsPresenter.detachScreen();
    }

    @Override
    public void showDetails(Team team) {
        System.out.println(team);
        Glide.with(this).load("https://bristolsport.azureedge.net/media/22386/manchester-united.jpg?width=1240&height=808&mode=crop").into(imageView);
        teamName.setText(team.getName());
        shortNameValue.setText(team.getShortName());
        marketValueValue.setText("32 000 000 $");
    }
}
