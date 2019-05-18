package com.tutorkomputer.ujianonlinerevisi.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Siswa {

    public List<Data> getHasil() {
        return hasil;
    }

    @SerializedName("data")
    public List<Data> hasil;

    public class Data{
        @SerializedName("id")
        private int id;
        @SerializedName("Nama")
        private String Nama;
        @SerializedName("Kelas")
        private int Kelas;
        @SerializedName("nik")
        private String nik;
        @SerializedName("jenis_kelamin")
        private String jenis_kelamin;
        @SerializedName("Benar")
        private int Benar;
        @SerializedName("Salah")
        private int Salah;
        @SerializedName("Kosong")
        private int Kosong;
        @SerializedName("Nilai")
        private String Nilai;
        @SerializedName("Keterangan")
        private String Keterangan;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNama() {
            return Nama;
        }

        public void setNama(String nama) {
            Nama = nama;
        }

        public int getKelas() {
            return Kelas;
        }

        public void setKelas(int kelas) {
            Kelas = kelas;
        }

        public String getNik() {
            return nik;
        }

        public void setNik(String nik) {
            this.nik = nik;
        }

        public String getJenis_kelamin() {
            return jenis_kelamin;
        }

        public void setJenis_kelamin(String jenis_kelamin) {
            this.jenis_kelamin = jenis_kelamin;
        }

        public int getBenar() {
            return Benar;
        }

        public void setBenar(int benar) {
            Benar = benar;
        }

        public int getSalah() {
            return Salah;
        }

        public void setSalah(int salah) {
            Salah = salah;
        }

        public int getKosong() {
            return Kosong;
        }

        public void setKosong(int kosong) {
            Kosong = kosong;
        }

        public String getNilai() {
            return Nilai;
        }

        public void setNilai(String nilai) {
            Nilai = nilai;
        }

        public String getKeterangan() {
            return Keterangan;
        }

        public void setKeterangan(String keterangan) {
            Keterangan = keterangan;
        }


    }
}
