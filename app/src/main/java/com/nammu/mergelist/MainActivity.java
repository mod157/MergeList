package com.nammu.mergelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nammu.mergelist.model.UserMenuInfo;
import com.nammu.mergelist.module.RealmDB;
import com.nammu.mergelist.model.UserInfo;
import com.nammu.mergelist.module.SLog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmObject;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rv_list)
    RecyclerView recyclerView;
    @OnClick(R.id.fab)
    public void fabClick(View view){
        UserDialog dialog = new UserDialog(this);
        dialog.show();
       // Intent addIntent = new Intent(this, AddListActivity.class);
       // startActivity(addIntent);
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
        setTestData();
        setRecyclerListView();
    }
    private void setTestData(){
        UserInfo info = new UserInfo(UserInfo.countNumber(), "이순재", "01047308395");
        RealmDB.insertOrUpdate(this,info);
        UserMenuInfo menuInfo1 = new UserMenuInfo();
        menuInfo1.setItemNumber(UserMenuInfo.countNumber());
        menuInfo1.setNumber("1");
        menuInfo1.setName("이순재");
        menuInfo1.setTitle("사아아");
        menuInfo1.setContext("todotodtdo");
        RealmDB.insert(this,menuInfo1);
    }

    private void setRecyclerListView() {
        Realm realm = RealmDB.realmInit(getApplicationContext());
        ArrayList<UserInfo> itemList = new ArrayList<>(realm.where(UserInfo.class).findAll());
        SLog.d(itemList.toString());
        UserListAdapter adapter = new UserListAdapter(itemList, this);
        recyclerView.setAdapter(adapter);
    }

}
