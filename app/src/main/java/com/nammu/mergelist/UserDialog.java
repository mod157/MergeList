package com.nammu.mergelist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.EditText;

import com.nammu.mergelist.model.UserInfo;
import com.nammu.mergelist.model.UserMenuInfo;
import com.nammu.mergelist.module.RealmDB;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * Created by mod15 on 2017-03-29.
 */

public class UserDialog extends Dialog {
    @BindView(R.id.rv_dialog_menu)
    RecyclerView rv_dialog_menu;
    @BindView(R.id.et_dialog_name)
    EditText et_dialog_name;

    public UserDialog(@NonNull Context context) {
        super(context);
    }

    public UserDialog(@NonNull Context context, UserInfo userInfo){
        super(context);
        ArrayList<UserMenuInfo> list = new ArrayList<>(RealmDB.selete(context, userInfo.getNumber(), userInfo.getName()));
        setItemListView(list, context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.9f;
        getWindow().setAttributes(lpWindow);
        setContentView(R.layout.dialog_user);
        ButterKnife.bind(this);
    }

    private void setItemListView(ArrayList<UserMenuInfo> itemList, Context context){
        rv_dialog_menu.setLayoutManager(new LinearLayoutManager(rv_dialog_menu.getContext()));
        UserItemMenuAdapter adapter = new UserItemMenuAdapter(itemList, context);
        rv_dialog_menu.setAdapter(adapter);
    }

}
