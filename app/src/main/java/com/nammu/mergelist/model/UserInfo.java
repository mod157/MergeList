package com.nammu.mergelist.model;

import android.content.Context;

import com.nammu.mergelist.module.RealmDB;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mod15 on 2017-03-15.
 */

public class UserInfo extends RealmObject {
    @PrimaryKey
    private int Number;
    private String Name;
    private String PhoneNumber;
    private static int memberNumber = 0;
    public static int countNumber(){
        memberNumber++;
        return memberNumber;
    }
   // private RealmResults<UserMenuInfo> UserMenu;
    public UserInfo(){}
   public UserInfo(int num, String name, String phoneNumber){
        Number = num;
        Name = name;
        PhoneNumber = phoneNumber;
    }
    public void setNumber(int num){
        Number = num;
    }
    public int getNumber(){return Number;
    }
    public void setName(String name){
        Name = name;
    }
    public String getName(){
        return Name;
    }
    public void setPhoneNumber(String phoneNumber){
        PhoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return PhoneNumber;
    }
   /* public void setUserMenu(RealmResults<UserMenuInfo> userMenu){
        UserMenu = userMenu;
    }
    public RealmResults<UserMenuInfo> getUserMenu(Context context, int id, String name){
        return RealmDB.selete(context, id, name);
    }*/
}
