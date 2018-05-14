package com.viscocits.redeem.catalogue;

import java.util.ArrayList;

public class ModelGetBooleanDataResponse {

    private String StatusCode;
    private String StatusMsg;

    public Boolean getData() {
        if (Data == null)
            Data = false;
        return Data;
    }

    public void setData(Boolean data) {
        Data = data;
    }

    private Boolean Data;

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
