package com.viscocits.redeem.catalogue;

import java.util.ArrayList;

public class ModelGetAllCategoriesResponse {

    private String StatusCode;
    private String StatusMsg;
    private ArrayList<ModelGetAllCategoriesData> Data;

    public String getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(String statusCode) {
        StatusCode = statusCode;
    }

    public String getStatusMsg() {
        return StatusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        StatusMsg = statusMsg;
    }

    public ArrayList<ModelGetAllCategoriesData> getData() {
        return Data;
    }

    public void setData(ArrayList<ModelGetAllCategoriesData> data) {
        Data = data;
    }
}
