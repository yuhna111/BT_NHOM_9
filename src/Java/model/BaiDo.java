/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parking.model;

/**
 *
 * @author yuhna
 */
import java.util.ArrayList;
import java.util.List;

public class BaiDo {
    private String maBaiDo;
    private int sucChuaHienTai;
    private int tongSoCho;
    private List<KhuVuc> khuVucs = new ArrayList<>();

    public BaiDo(String maBaiDo, int tongSoCho) {
        this.maBaiDo = maBaiDo;
        this.tongSoCho = tongSoCho;
        this.sucChuaHienTai = 0;
    }

    public void capNhatSucChua(int delta) {
        this.sucChuaHienTai += delta;
        if (this.sucChuaHienTai < 0) this.sucChuaHienTai = 0;
        if (this.sucChuaHienTai > tongSoCho) this.sucChuaHienTai = tongSoCho;
    }

    public boolean kiemTraConChoTrong() {
        return sucChuaHienTai < tongSoCho;
    }

    public void addKhuVuc(KhuVuc k) {
        khuVucs.add(k);
    }
    public String getMaBaiDo(String maBaiDo){
        return maBaiDo;
    }
    public void setmaBaiDo(String maBaiDo){
        this.maBaiDo = maBaiDo;
    }
    public int getSucChuaHienTai(int sucChuaHienTai){
        return sucChuaHienTai;
    }
    public void setSucChuaHienTai(int sucChuaHienTai){
        this.sucChuaHienTai = sucChuaHienTai;
    }
    public int getTongSoCho() {
        return tongSoCho;
    }
    public void setTongSoCho(int tongSoCho) {
        this.tongSoCho = tongSoCho;
    }
    public List<KhuVuc> getKhuVucs() {
        return khuVucs;
    }
    public void setKhuVucs(List<KhuVuc> khuVucs) {
        this.khuVucs = khuVucs;
    }
}

