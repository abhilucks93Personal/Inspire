package com.viscocits.redeem.catalogue;

import java.util.ArrayList;

public class ModelGetAllProductsResponse {

    private String StatusCode;
    private String StatusMsg;
    private ArrayList<ModelGetAllProductsData> Data;

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

    public ArrayList<ModelGetAllProductsData> getData() {
        return Data;
    }

    public void setData(ArrayList<ModelGetAllProductsData> data) {
        Data = data;
    }
}
