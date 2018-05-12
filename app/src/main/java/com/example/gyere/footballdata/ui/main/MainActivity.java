package com.example.gyere.footballdata.ui.main;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gyere.footballdata.FootballDataApplication;
import com.example.gyere.footballdata.R;
import com.example.gyere.footballdata.model.Team;
import com.example.gyere.footballdata.model.TeamsResponse;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    TextView textView;

    private TeamsResponse teamsResponse;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TeamsAdapter teamsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FootballDataApplication.injector.inject(this);

        teamsResponse = new TeamsResponse();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        teamsAdapter = new TeamsAdapter(this, teamsResponse);
        recyclerView.setAdapter(teamsAdapter);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayoutList);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mainPresenter.showTeams();
            }
        });
        ;

        teamsAdapter.setClickListener(new TeamsAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(), "You clicked " + teamsAdapter.getItem(position).getName() + " on row number " + position, Toast.LENGTH_SHORT).show();

//                Bundle bundle = new Bundle();
//                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(position));
//                List<NameUrl> list = spellsList.getResult();
//                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, list.get(position).getName());
//                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
//
//                Intent intent = new Intent(MainListActivity.this, DeatailsActivity.class);
//                intent.putExtra(KEY_URL, teamsAdapter.getItem(position).getUrl());
//                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                mainPresenter.showTeams();
                textView.setText("dsadsa");
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void showTeams(List<Team> teams) {
        this.textView.setText(teams.toString());
    }
}
