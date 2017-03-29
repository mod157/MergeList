package com.nammu.mergelist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nammu.mergelist.model.UserMenuInfo;

import java.util.ArrayList;

/**
 * Created by mod15 on 2017-03-20.
 */

public class UserItemMenuAdapter extends RecyclerView.Adapter<UserItemMenuAdapter.ViewHolder>  {
    private ArrayList<UserMenuInfo> itemList;
    private Context context;
    UserItemMenuAdapter(ArrayList<UserMenuInfo> list, Context context){
        this.itemList = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_layout, parent, false);
        return new UserItemMenuAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
