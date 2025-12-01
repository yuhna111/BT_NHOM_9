/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author yuhna
 */
import java.time.LocalDateTime;

public class GiaoDich {
    private String maGiaoDich;
    private LocalDateTime thoiGianVao;
    private LocalDateTime thoiGianRa;
    private double phiDoXe;
    private String trangThaiThanhToan;
    private String maMucGiaApDung;
    private String maThe;
    private String maNhanVien;
    private String maViTri;

    public void batDauGiaoDich() {
        this.thoiGianVao = LocalDateTime.now();
        this.trangThaiThanhToan = "Chưa thanh toán";
    }

    public void ketThucGiaoDich(LocalDateTime timeRa) {
        this.thoiGianRa = timeRa;
        this.phiDoXe = tinhPhiDoXe();
        this.trangThaiThanhToan = "Đã thanh toán";
    }

    public double tinhPhiDoXe() {
        return 20000.0;
    }
    public String getMaGiaoDich() { return maGiaoDich; }
    public void setMaGiaoDich(String maGiaoDich) { this.maGiaoDich = maGiaoDich; }
    public LocalDateTime getThoiGianVao() { return thoiGianVao; }
    public void setThoiGianVao(LocalDateTime thoiGianVao) { this.thoiGianVao = thoiGianVao; }
    public LocalDateTime getThoiGianRa() { return thoiGianRa; }
    public void setThoiGianRa(LocalDateTime thoiGianRa) { this.thoiGianRa = thoiGianRa; }
    public double getPhiDoXe() { return phiDoXe; }
    public void setPhiDoXe(double phiDoXe) { this.phiDoXe = phiDoXe; }
    public String getTrangThaiThanhToan() { return trangThaiThanhToan; }
    public void setTrangThaiThanhToan(String trangThaiThanhToan) { this.trangThaiThanhToan = trangThaiThanhToan; }
    public String getMaMucGiaApDung() { return maMucGiaApDung; }
    public void setMaMucGiaApDung(String maMucGiaApDung) { this.maMucGiaApDung = maMucGiaApDung; }
    public String getMaThe() { return maThe; }
    public void setMaThe(String maThe) { this.maThe = maThe; }
    public String getMaNhanVien() { return maNhanVien; }
    public void setMaNhanVien(String maNhanVien) { this.maNhanVien = maNhanVien; }
    public String getMaViTri() { return maViTri; }
    public void setMaViTri(String maViTri) { this.maViTri = maViTri; }
}
