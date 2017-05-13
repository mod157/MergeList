package com.nammu.mergelist;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.nammu.mergelist.model.UserMenuInfo;
import com.nammu.mergelist.module.RealmDB;
import com.nammu.mergelist.module.SLog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
        holder.et_menuTitle.setText(itemList.get(position).getTitle());
        holder.et_menuContext.setText(itemList.get(position).getContext());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.et_menuTitle)
        EditText et_menuTitle;
        @BindView(R.id.et_menuContext)
        EditText et_menuContext;

        @OnClick(R.id.img_remove)
        public void itemRemove(View v){
            SLog.d("item remove");
            int position = getPosition();
            UserMenuInfo userMenuInfo = itemList.get(position);
            RealmDB.delete(context, userMenuInfo);
            if(getItemCount() != 1)
                notifyItemRemoved(position);
        }

        @OnClick(R.id.img_pasts)
        public void itemDataPasts(View v){
            SLog.d("item pasts");
            String data = et_menuContext.getText().toString();
            setClipBoardLink(data);
        }

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setClipBoardLink(String link){
            ClipboardManager clipboardManager = (ClipboardManager)context.getSystemService(context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("label", link);
            clipboardManager.setPrimaryClip(clipData);
            Toast.makeText(context, "'"+et_menuTitle.getText() +"' 복사 완료", Toast.LENGTH_SHORT).show();
        }
    }
}
