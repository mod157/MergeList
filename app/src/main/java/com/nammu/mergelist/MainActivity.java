package com.nammu.mergelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nammu.mergelist.module.RealmDB;
import com.nammu.mergelist.model.UserInfo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rv_list)
    RecyclerView recyclerView;
    @OnClick(R.id.fab)
    public void fabClick(View view){
        Intent addIntent = new Intent(this, AddListActivity.class);
        startActivity(addIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initializerRecyclerView();
    }

    private void initializerRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        setRecyclerListView();
    }

    private void setRecyclerListView() {
        Realm realm = RealmDB.realmInit(getApplicationContext());
        ArrayList<UserInfo> itemList = new ArrayList<>(realm.where(UserInfo.class).findAll());
        FriendListAdapter adapter = new FriendListAdapter(itemList, this);
        recyclerView.setAdapter(adapter);
    }

}
