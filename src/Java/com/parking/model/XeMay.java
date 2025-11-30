/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parking.model;
/**
 *
 * @author yuhna
 */
public class XeMay extends PhuongTien {
    private int dungTichXiLanh;
    private boolean coHopSoTuDong;

    public XeMay(String bienSo, String mauSac, String hangXe, int dungTich, boolean tuDong) {
        super(bienSo, mauSac, hangXe);
        this.dungTichXiLanh = dungTich;
        this.coHopSoTuDong = tuDong;
    }
    @Override
    public double tinhKhauHao(long minutes) {
        double hours = Math.ceil(minutes / 60.0);
        return 0.5 * hours; 
    }
    public int getDungTichXiLanh() {
        return dungTichXiLanh;
    }
    public void setDungTichXiLanh(int dungTichXiLanh) {
        this.dungTichXiLanh = dungTichXiLanh;
    }
    public boolean isCoHopSoTuDong() {
        return coHopSoTuDong;
    }
    public void setCoHopSoTuDong(boolean coHopSoTuDong) {
        this.coHopSoTuDong = coHopSoTuDong;
    }
}
