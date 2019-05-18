package com.tutorkomputer.ujianonlinerevisi.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CallResponse {

    //mengambil response dari api
    public String getStatus() {
        return status;
    }

    @SerializedName("status")
    private String status;


    public List<UserResponse> getData() {
        return data;
    }

    @SerializedName("data")
    private List<UserResponse> data;





}
