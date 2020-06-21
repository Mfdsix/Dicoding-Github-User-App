package com.zgenit.githubuserapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    GithubUser user;
    CircleImageView imgUser;
    TextView tvFullname, tvUsername, tvFollowers, tvFollowings, tvRepositories, tvCompany, tvLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // toolbar
        ActionBar toolbar = getSupportActionBar();
        toolbar.setTitle("Detail User");
        toolbar.setDisplayHomeAsUpEnabled(true);

        // init views by id
        imgUser = findViewById(R.id.img_user);
        tvFullname = findViewById(R.id.tv_fullname);
        tvUsername = findViewById(R.id.tv_username);
        tvFollowers = findViewById(R.id.tv_followers);
        tvFollowings = findViewById(R.id.tv_followings);
        tvRepositories = findViewById(R.id.tv_repositories);
        tvCompany = findViewById(R.id.tv_company);
        tvLocation = findViewById(R.id.tv_location);

        // parse and show user data
        user = getIntent().getParcelableExtra(MainActivity.EXTRA_USER);
        showUserDetail();
    }

    @SuppressLint("SetTextI18n")
    public void showUserDetail(){
        Glide.with(DetailActivity.this)
                .load(user.getAvatar())
                .into(imgUser);

        tvFullname.setText(user.getName());
        tvUsername.setText(user.getUsername());
        tvFollowers.setText(user.getFollower()+"\nfollowers");
        tvFollowings.setText(user.getFollowing()+"\nfollowings");
        tvRepositories.setText(user.getRepository()+"\nrepositories");
        tvCompany.setText(user.getCompany());
        tvLocation.setText(user.getLocation());
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}