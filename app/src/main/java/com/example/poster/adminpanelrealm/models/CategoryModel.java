package com.example.poster.adminpanelrealm.models;


import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CategoryModel extends RealmObject{
    @PrimaryKey
    private int id;
    private String name;
    private RealmList<SubCategoryModel> subCategories = new RealmList<>();

    public CategoryModel() {
    }

    public CategoryModel(int id, String name, RealmList<SubCategoryModel> subCategories) {
        this.id = id;
        this.name = name;
        this.subCategories = subCategories;
    }

    public CategoryModel(String name, RealmList<SubCategoryModel> subCategories) {
        this.name = name;
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

    public RealmList<SubCategoryModel> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(RealmList<SubCategoryModel> subCategories) {
        this.subCategories = subCategories;
    }

    @Override
    public String toString() {
        return "name = " + name  + " ; ";
    }

    public static class StaticCategory{

        private static List<CategoryModel> categoryModels = new ArrayList<>();

        public static void setCategoryModels(List<CategoryModel> categoryModels){
            StaticCategory.categoryModels = categoryModels;
        }
        public  static List<CategoryModel> getCategoryModels(){
            return categoryModels;
        }
    }
}
