package com.viscocits.redeem.catalogue;

import java.util.ArrayList;

public class ModelGetCampaignResponse {

    private String StatusCode;
    private String StatusMsg;
    private ArrayList<ModelGetCampaignData> Data;

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

    public ArrayList<ModelGetCampaignData> getData() {
        return Data;
    }

    public void setData(ArrayList<ModelGetCampaignData> data) {
        Data = data;
    }
}
