package com.tutorkomputer.ujianonlinerevisi.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {


    @SerializedName("data")
    private Data data;

    public Data getData() {
        return data;
    }

    public class Data{

        public String getAndroid_id() {
            return android_id;
        }

        public void setAndroid_id(String android_id) {
            this.android_id = android_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getKelas() {
            return kelas;
        }

        public void setKelas(String kelas) {
            this.kelas = kelas;
        }

        public String getNo_hp_ortu() {
            return no_hp_ortu;
        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setNo_hp_ortu(String no_hp_ortu) {
            this.no_hp_ortu = no_hp_ortu;
        }

        @SerializedName("android_id")
        private String android_id;

        @SerializedName("id")
        private int id;

        @SerializedName("name")
        private String name;

        @SerializedName("email")
        private String email;

        @SerializedName("kelas")
        private String kelas;

        @SerializedName("no_hp_ortu")
        private String no_hp_ortu;

    }



}

