package com.parking;

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

    // Getters
    public String getMaBaiDo() { return maBaiDo; }
    public int getSucChuaHienTai() { return sucChuaHienTai; }
    public int getTongSoCho() { return tongSoCho; }
    public List<KhuVuc> getKhuVucs() { return khuVucs; }
}