package com.zgenit.githubuserapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class GithubUserAdapter extends BaseAdapter {

    private Context context;

    public void setGithubUsers(ArrayList<GithubUser> githubUsers) {
        this.githubUsers = githubUsers;
    }

    private ArrayList<GithubUser> githubUsers = new ArrayList<>();

    public GithubUserAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return githubUsers.size();
    }

    @Override
    public Object getItem(int position) {
        return githubUsers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GithubUser user = githubUsers.get(position);

        View itemView = convertView;
        if(itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_github_user, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);
        viewHolder.bind(user);
        return itemView;
    }

    private class ViewHolder{
        CircleImageView imgUser;
        TextView tvName, tvCompany, tvLocation;

        ViewHolder(View view){
            imgUser = view.findViewById(R.id.img_user);
            tvName = view.findViewById(R.id.tv_name);
            tvCompany = view.findViewById(R.id.tv_company);
            tvLocation = view.findViewById(R.id.tv_location);
        }

        void bind(GithubUser user){
            Glide.with(context)
                    .load(user.getAvatar())
                    .into(imgUser);

            tvName.setText(user.getName());
            tvCompany.setText(user.getCompany());
            tvLocation.setText(user.getLocation());
        }
    }
}
