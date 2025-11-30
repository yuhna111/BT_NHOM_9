/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parking.model;

/**
 *
 * @author yuhna
 */
import java.time.Duration;
import java.time.LocalDateTime;
import com.parking.model.BangGia;

public class GiaoDich {
    private String maGiaoDich;
    private LocalDateTime thoiGianVao;
    private LocalDateTime thoiGianRa;
    private double phiDoXe;
    private String trangThaiThanhToan; // "CHUA_THANH_TOAN","DA_THANH_TOAN"
    private BangGia bangGia;
    private PhuongTien phuongTien;
    private TheXe theXe;
    private NhanVien nhanVien;

    public GiaoDich(){
        
    }
    public GiaoDich(String ma, PhuongTien p, TheXe t, BangGia bg, NhanVien nv) {
        this.maGiaoDich = ma;
        this.phuongTien = p;
        this.theXe = t;
        this.bangGia = bg;
        this.nhanVien = nv;
    }
    public void batDauGiaoDich() {
        thoiGianVao = LocalDateTime.now();
        trangThaiThanhToan = "CHUA_THANH_TOAN";
    }
    public void ketThucGiaoDich() {
        this.thoiGianRa = LocalDateTime.now();
        this.phiDoXe = tinhPhiDoXe();
    }
    public double tinhPhiDoXe() {
        if (thoiGianVao == null) return 0;
        LocalDateTime end = thoiGianRa != null ? thoiGianRa : LocalDateTime.now();
        long minutes = Duration.between(thoiGianVao, end).toMinutes();
        String loai = (phuongTien instanceof Oto) ? "OTO" : "XEMAY";
        return BangGia.layGiaTheoLoai(loai, minutes);
    }
    public void thanhToan() {
        this.trangThaiThanhToan = "DA_THANH_TOAN";
    }
    public LocalDateTime getThoiGianVao(){
        return this.thoiGianVao;
    }
    public LocalDateTime getThoiGianRa(){
        return this.thoiGianRa;
    }
    public String getTrangThaiThanhToan(){
        return this.trangThaiThanhToan;
    }
    public String getMaGiaoDich() {
        return maGiaoDich;
    }
    public void setMaGiaoDich(String maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }
    public void setThoiGianVao(LocalDateTime thoiGianVao) {
        this.thoiGianVao = thoiGianVao;
    }
    public void setThoiGianRa(LocalDateTime thoiGianRa) {
        this.thoiGianRa = thoiGianRa;
    }
    public double getPhiDoXe() {
        return phiDoXe;
    }
    public void setPhiDoXe(double phiDoXe) {
        this.phiDoXe = phiDoXe;
    }
    public void setTrangThaiThanhToan(String trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }
    public BangGia getBangGia() {
        return bangGia;
    }
    public void setBangGia(BangGia bangGia) {
        this.bangGia = bangGia;
    }
    public PhuongTien getPhuongTien() {
        return phuongTien;
    }
    public void setPhuongTien(PhuongTien phuongTien) {
        this.phuongTien = phuongTien;
    }
    public TheXe getTheXe() {
        return theXe;
    }
    public void setTheXe(TheXe theXe) {
        this.theXe = theXe;
    }
    public NhanVien getNhanVien() {
        return nhanVien;
    }
    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
}
