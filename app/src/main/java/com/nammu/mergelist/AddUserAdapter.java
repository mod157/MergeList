package com.nammu.mergelist;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.nammu.mergelist.model.UserInfo;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by mod15 on 2017-03-20.
 */

public class AddUserAdapter extends RecyclerView.Adapter<AddUserAdapter.ViewHolder>  {
    ArrayList<UserInfo> itemList;
    AddUserAdapter(Array<UserInfo> list){
        this.itemList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
