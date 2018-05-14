package com.viscocits.redeem.catalogue;

import java.util.ArrayList;

public class ModelGetWishlistDetailsResponse {

    private String StatusCode;
    private String StatusMsg;
    private ArrayList<ModelGetWishlistDetailsData> Data;

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

    public ArrayList<ModelGetWishlistDetailsData> getData() {
        return Data;
    }

    public void setData(ArrayList<ModelGetWishlistDetailsData> data) {
        Data = data;
    }
}
