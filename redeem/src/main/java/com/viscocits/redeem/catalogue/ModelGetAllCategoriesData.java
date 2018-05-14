package com.viscocits.redeem.catalogue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ModelGetAllCategoriesData {

    @SerializedName("CatId")
    @Expose
    private int id;

    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("ParentId")
    @Expose
    private int parentId;

    @SerializedName("Productcount")
    @Expose
    private int productCount;

    private ArrayList<ModelGetAllCategoriesData> subCategories;

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

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public ArrayList<ModelGetAllCategoriesData> getSubCategories() {
        if (subCategories == null)
            subCategories = new ArrayList<>();
        return subCategories;
    }

    public void setSubCategories(ArrayList<ModelGetAllCategoriesData> subCategories) {
        this.subCategories = subCategories;
    }
}
