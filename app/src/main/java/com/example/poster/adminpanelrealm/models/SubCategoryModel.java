package com.example.poster.adminpanelrealm.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class SubCategoryModel extends RealmObject {
    @PrimaryKey
    private int id;
    private String name;
    private RealmList<ProductModel> productModelList = new RealmList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealmList<ProductModel> getProductModelList() {
        return productModelList;
    }

    public void setProductModelList(RealmList<ProductModel> productModelList) {
        this.productModelList = productModelList;
    }
}
