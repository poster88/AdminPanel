package com.example.poster.adminpanelrealm.application;

import com.example.poster.adminpanelrealm.models.CategoryModel;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;

/**
 * Created by POSTER on 08.05.2017.
 */

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmList<CategoryModel> realmList  = new RealmList<>();
        realmList.addAll(Realm.getDefaultInstance().where(CategoryModel.class).findAll());
        CategoryModel.StaticCategory.setCategoryModels(realmList);

        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
    }
}
