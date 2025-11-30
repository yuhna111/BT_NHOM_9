package com.parking;

import java.time.Duration;
import java.time.LocalDateTime;

public class GiaoDich {
    private String maGiaoDich;
    private LocalDateTime thoiGianVao;
    private LocalDateTime thoiGianRa;
    private double phiDoXe;
    private String trangThaiThanhToan;
    private BangGia bangGia;
    private PhuongTien phuongTien;
    private TheXe theXe;
    private NhanVien nhanVien;
    private ViTriDo viTriDo; // ✅ THÊM TRƯỜNG NÀY

    public GiaoDich(String ma, PhuongTien p, TheXe t, BangGia bg, NhanVien nv) {
        this.maGiaoDich = ma;
        this.phuongTien = p;
        this.theXe = t;
        this.bangGia = bg;
        this.nhanVien = nv;
        this.trangThaiThanhToan = "CHUA_THANH_TOAN";
    }

    public void batDauGiaoDich() {
        thoiGianVao = LocalDateTime.now();
    }

    public void ketThucGiaoDich() {
        this.thoiGianRa = LocalDateTime.now();
        this.phiDoXe = tinhPhiDoXe();
    }

    public double tinhPhiDoXe() {
        if (thoiGianVao == null) return 0;
        LocalDateTime end = thoiGianRa != null ? thoiGianRa : LocalDateTime.now();
        double minutes = Duration.between(thoiGianVao, end).toMillis() / 60000.0;
        String loai = (phuongTien instanceof Oto) ? "OTO" : "XEMAY";
        return BangGia.layGiaTheoLoai(loai, minutes);
    }

    public void thanhToan() {
        this.trangThaiThanhToan = "DA_THANH_TOAN";
    }

    // ✅ THÊM GETTER/SETTER CHO VI TRÍ
    public ViTriDo getViTriDo() {
        return viTriDo;
    }

    public void setViTriDo(ViTriDo viTriDo) {
        this.viTriDo = viTriDo;
    }

    // Getters
    public String getMaGiaoDich() { return maGiaoDich; }
    public LocalDateTime getThoiGianVao() { return thoiGianVao; }
    public LocalDateTime getThoiGianRa() { return thoiGianRa; }
    public double getPhiDoXe() { return phiDoXe; }
    public String getTrangThaiThanhToan() { return trangThaiThanhToan; }
    public PhuongTien getPhuongTien() { return phuongTien; }
    public TheXe getTheXe() { return theXe; }
    public NhanVien getNhanVien() { return nhanVien; }
}