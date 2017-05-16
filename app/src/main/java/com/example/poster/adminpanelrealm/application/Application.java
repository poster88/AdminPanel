package com.example.poster.adminpanelrealm.application;

import com.example.poster.adminpanelrealm.models.CategoryModel;

import io.realm.Realm;
import io.realm.RealmList;


public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmList<CategoryModel> realmList  = new RealmList<>();
        realmList.addAll(Realm.getDefaultInstance().where(CategoryModel.class).findAll());
        CategoryModel.StaticCategory.setCategoryModels(realmList);
    }
}
