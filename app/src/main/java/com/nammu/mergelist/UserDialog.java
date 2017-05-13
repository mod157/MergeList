package com.nammu.mergelist;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.nammu.mergelist.model.UserInfo;
import com.nammu.mergelist.model.UserMenuInfo;
import com.nammu.mergelist.module.RealmDB;
import com.nammu.mergelist.module.SLog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.RealmResults;

/**
 * Created by mod15 on 2017-03-29.
 */

public class UserDialog extends Dialog{
    @BindView(R.id.rv_dialog_menu)
    RecyclerView rv_dialog_menu;
    @BindView(R.id.et_dialog_name)
    EditText et_dialog_name;

    private String userName;
    @OnClick(R.id.img_AddItem)
    public void addItem(View v){

    }

    @OnClick(R.id.tv_ok)
    public void dialogDataSave(View v){

    }

    @OnClick(R.id.tv_cancel)
    public void cancelDialog(View v){

    }

    private Activity activity;
    private ArrayList<UserMenuInfo> itemList;
    public UserDialog(@NonNull Activity activity) {
        super(activity);
        this.activity = activity;
    }

    public UserDialog(@NonNull Activity activity, UserInfo userInfo){
        super(activity);
        this.activity = activity;
        this.userName = userInfo.getName();
        this.itemList = new ArrayList<>(RealmDB.selete(activity.getApplicationContext(), userInfo.getNumber(), userInfo.getName()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_user);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        //This makes the dialog take up the full width
        lp.copyFrom(getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        lp.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lp.dimAmount = 0.3f;
        getWindow().setAttributes(lp);
        SLog.d("Dialog Create");
        ButterKnife.bind(this);
        if(itemList !=null && itemList.size() > 0){
            et_dialog_name.setText(userName);
            setItemListView();
        }else{
            initListView();
        }
    }

    private void initListView(){
        rv_dialog_menu.setLayoutManager(new LinearLayoutManager(activity));
        ArrayList<UserMenuInfo> itemList = new ArrayList<>();
        itemList.add(new UserMenuInfo());
        UserItemMenuAdapter adapter = new UserItemMenuAdapter(itemList, activity.getApplicationContext());
        rv_dialog_menu.setAdapter(adapter);
    }
    private void setItemListView(){
        rv_dialog_menu.setLayoutManager(new LinearLayoutManager(activity));
        UserItemMenuAdapter adapter = new UserItemMenuAdapter(itemList, activity.getApplicationContext());
        rv_dialog_menu.setAdapter(adapter);
    }

}
