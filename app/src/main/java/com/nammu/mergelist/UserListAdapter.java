package com.nammu.mergelist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.nammu.mergelist.model.UserInfo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mod15 on 2017-03-15.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder>  {
    private ArrayList<UserInfo> list;
    private Activity activity;

    UserListAdapter(ArrayList<UserInfo> list, Activity activity){
        this.list = list;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_friendName.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.tv_friendName)
        TextView tv_friendName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(activity.getApplicationContext(), tv_friendName.getText().toString(),Toast.LENGTH_SHORT).show();
            UserDialog dialog = new UserDialog(activity, list.get(getPosition()));
            //UserDialog dialog = new UserDialog(context);
            dialog.show();
        }
    }
}
