package com.tutorkomputer.ujianonlinerevisi.data.model;

import com.google.gson.annotations.SerializedName;

public class SignResponse {

    public String getStatus() {
        return status;
    }

    @SerializedName("status")
    private String status;
}
