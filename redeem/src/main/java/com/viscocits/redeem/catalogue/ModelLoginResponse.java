package com.viscocits.redeem.catalogue;

public class ModelLoginResponse {

    private String StatusCode;
    private String StatusMsg;
    private ModelLoginData Data;

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

    public ModelLoginData getData() {
        return Data;
    }

    public void setData(ModelLoginData data) {
        Data = data;
    }
}
