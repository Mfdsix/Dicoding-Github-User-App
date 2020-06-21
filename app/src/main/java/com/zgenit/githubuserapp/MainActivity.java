package com.zgenit.githubuserapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_USER = "extra_user";

    private String[] dataUsername;
    private String[] dataName;
    private TypedArray dataAvatar;
    private String[] dataCompany;
    private String[] dataLocation;
    private int[] dataRepository;
    private int[] dataFollower;
    private int[] dataFollowing;

    private GithubUserAdapter adapter;
    private ArrayList<GithubUser> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup listview and adapter
        ListView lvUser = findViewById(R.id.lv_github_user);
        adapter = new GithubUserAdapter(this);
        lvUser.setAdapter(adapter);

        prepareDatas();

        // handle clickable views action
        lvUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GithubUser user = users.get(position);
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(EXTRA_USER, user);
                startActivity(intent);
            }
        });
    }

    private void prepareDatas(){
        dataName = getResources().getStringArray(R.array.name);
        dataUsername = getResources().getStringArray(R.array.username);
        dataAvatar = getResources().obtainTypedArray(R.array.avatar);
        dataCompany = getResources().getStringArray(R.array.company);
        dataLocation = getResources().getStringArray(R.array.location);
        dataRepository = getResources().getIntArray(R.array.repository);
        dataFollower = getResources().getIntArray(R.array.followers);
        dataFollowing = getResources().getIntArray(R.array.following);

        addItems();
    }

    private void addItems(){
        users = new ArrayList<>();

        for(int i = 0; i < dataName.length; i++){
            GithubUser githubUser = new GithubUser();
            githubUser.setName(dataName[i]);
            githubUser.setUsername(dataUsername[i]);
            githubUser.setAvatar(dataAvatar.getResourceId(i, -1));
            githubUser.setCompany(dataCompany[i]);
            githubUser.setLocation(dataLocation[i]);
            githubUser.setRepository(dataRepository[i]);
            githubUser.setFollower(dataFollower[i]);
            githubUser.setFollowing(dataFollowing[i]);

            users.add(githubUser);
        }

        populateListView();
    }

    private void populateListView(){
        adapter.setGithubUsers(users);
        adapter.notifyDataSetChanged();
    }
}
