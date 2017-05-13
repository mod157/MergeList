package com.nammu.mergelist.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mod15 on 2017-03-15.
 */

public class UserMenuInfo extends RealmObject {
    private String ItemNumber;
    private String MemberNumber;
    private String Name;
    private String Title;
    private String Context;

    private static int itemNumber = 0;
    public static int countNumber(){
        itemNumber++;
        return itemNumber;
    }
    public void setItemNumber(int itemNumber) {
        ItemNumber = itemNumber+"";
    }

    public void setNumber(String number){
        this.MemberNumber = number;
    }

    public void setName(String name){
        this.Name = name;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setContext(String context) {
        Context = context;
    }

    public String getItemNumber() {
        return ItemNumber;
    }

    public String getNumber() {
        return MemberNumber;
    }

    public String getName() {
        return Name;
    }

    public String getTitle() {
        return Title;
    }

    public String getContext() {
        return Context;
    }


}
