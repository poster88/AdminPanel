package com.example.poster.adminpanelrealm.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class ProductModel extends RealmObject {
    @PrimaryKey
    private int id;
    private String name;
    private String description;
    private int count;
    private RealmList<SubCategoryModel> subCategories;

    public ProductModel() {
    }

    public ProductModel(int id, String name, String description, int count, RealmList<SubCategoryModel> subCategories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.count = count;
        this.subCategories = subCategories;
    }

    public ProductModel(String name, String description, int count, RealmList<SubCategoryModel> subCategories) {
        this.name = name;
        this.description = description;
        this.count = count;
        this.subCategories = subCategories;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public RealmList<SubCategoryModel> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(RealmList<SubCategoryModel> subCategories) {
        this.subCategories = subCategories;
    }
}
