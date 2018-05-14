package com.viscocits.redeem.catalogue;

import java.util.ArrayList;

public class ModelGetCartDetailsResponse {

    private String StatusCode;
    private String StatusMsg;
    private ArrayList<ModelGetCartDetailsData> Data;

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

    public ArrayList<ModelGetCartDetailsData> getData() {
        return Data;
    }

    public void setData(ArrayList<ModelGetCartDetailsData> data) {
        Data = data;
    }
}
