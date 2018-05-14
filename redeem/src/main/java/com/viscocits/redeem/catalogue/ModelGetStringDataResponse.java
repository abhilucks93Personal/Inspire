package com.viscocits.redeem.catalogue;

public class ModelGetStringDataResponse {

    private String StatusCode;
    private String StatusMsg;
    private String Data;

    public String getData() {
        if (Data == null)
            Data = "";
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

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


}
