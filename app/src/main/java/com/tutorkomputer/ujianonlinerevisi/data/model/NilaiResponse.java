package com.tutorkomputer.ujianonlinerevisi.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NilaiResponse {

    @SerializedName("data")
    private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public class Data{
        @SerializedName("benar")
        private int benar;
        @SerializedName("salah")
        private int salah;
        @SerializedName("kosong")
        private int kosong;
        @SerializedName("score")
        private String score;
        @SerializedName("nik")
        private String nik;
        @SerializedName("android_id")
        private String android_id;
        @SerializedName("name")
        private String name;
        @SerializedName("jenis_kelamin")
        private String jenis_kelamin;
        @SerializedName("kelas")
        private int kelas;
        @SerializedName("email")
        private String email;

        public int getBenar() {
            return benar;
        }

        public void setBenar(int benar) {
            this.benar = benar;
        }

        public String getNik() {
            return nik;
        }

        public void setNik(String nik) {
            this.nik = nik;
        }


        public int getSalah() {
            return salah;
        }

        public void setSalah(int salah) {
            this.salah = salah;
        }

        public int getKosong() {
            return kosong;
        }

        public void setKosong(int kosong) {
            this.kosong = kosong;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

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

        public String getJenis_kelamin() {
            return jenis_kelamin;
        }

        public void setJenis_kelamin(String jenis_kelamin) {
            this.jenis_kelamin = jenis_kelamin;
        }

        public int getKelas() {
            return kelas;
        }

        public void setKelas(int kelas) {
            this.kelas = kelas;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

    }


}
