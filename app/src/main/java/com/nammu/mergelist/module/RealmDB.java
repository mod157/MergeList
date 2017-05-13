package com.nammu.mergelist.module;

import android.content.Context;

import com.nammu.mergelist.model.UserInfo;
import com.nammu.mergelist.model.UserMenuInfo;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by SunJae on 2017-01-26.
 */

public class RealmDB {

    public static Realm realmInit(Context context){
        Realm realm = null;
        realm.init(context);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(realmConfiguration);
        realm = Realm.getDefaultInstance();
        return realm;
    }

    public static void insertOrUpdate(Context context, final UserInfo data){
        Realm realm = realmInit(context);
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(data);
            }
        });
        realm.close();
    }
    public static void insert(Context context, final UserMenuInfo data){
        Realm realm = realmInit(context);
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(data);
            }
        });
        realm.close();
    }
    public static void delete(Context context, final UserInfo data){
        Realm realm = realmInit(context);
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                data.deleteFromRealm();
            }
        });
    }

    public static void delete(Context context, final UserMenuInfo data){
        Realm realm = realmInit(context);
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                data.deleteFromRealm();
            }
        });
    }

    public static RealmResults<UserMenuInfo> selete(Context context, int id, String name){
        Realm realm = RealmDB.realmInit(context);
        return realm.where(UserMenuInfo.class).equalTo("MemberNumber",id+"").equalTo("Name",name).findAll();
    }


}
