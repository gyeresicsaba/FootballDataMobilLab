package com.example.gyere.footballdata.ui.main;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.gyere.footballdata.FootballDataApplication;
import com.example.gyere.footballdata.R;
import com.example.gyere.footballdata.model.Team;
import com.example.gyere.footballdata.model.TeamsResponse;
import com.example.gyere.footballdata.ui.details.DetailsActivity;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreen {

//    private FirebaseAnalytics mFirebaseAnalytics;

    @Inject
    MainPresenter mainPresenter;

    private TeamsResponse teamsResponse;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TeamsAdapter teamsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FootballDataApplication.injector.inject(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        teamsResponse = new TeamsResponse();
        teamsAdapter = new TeamsAdapter(this, teamsResponse);
        recyclerView.setAdapter(teamsAdapter);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayoutList);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mainPresenter.showTeams();
            }
        });

        teamsAdapter.setClickListener(new TeamsAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Bundle bundle = new Bundle();
//                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, String.valueOf(position));
//                List<NameUrl> list = spellsList.getResult();
//                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, list.get(position).getName());
//                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
//
                System.out.println(teamsAdapter.getItem(position).getId());
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("Key_id", "66");
                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
        mainPresenter.showTeams();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void showTeams(List<Team> teams) {
        System.out.println(teams);
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
        teamsResponse.setTeams(teams);
        teamsAdapter.notifyDataSetChanged();
    }
}
