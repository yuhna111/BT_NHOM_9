/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parking.model;

/**
 *
 * @author yuhna
 */
public class Oto extends PhuongTien {
    private int soChoNgoi;
    private String dungTichDongCo;

    public Oto(String bienSo, String mauSac, String hangXe, int soCho, String dungTich) {
        super(bienSo, mauSac, hangXe);
        this.soChoNgoi = soCho;
        this.dungTichDongCo = dungTich;
    }

    public double tinhThueTruocBa() {
        return 0; 
    }
    @Override
    public double tinhKhauHao(long minutes) {
        double hours = Math.ceil(minutes / 60.0);
        return 1.5 * hours; 
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }
    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }
    public String getDungTichDongCo() {
        return dungTichDongCo;
    }
    public void setDungTichDongCo(String dungTichDongCo) {
        this.dungTichDongCo = dungTichDongCo;
    }
}

