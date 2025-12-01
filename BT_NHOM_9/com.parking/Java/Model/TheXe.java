/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author yuhna
 */
public class TheXe {
    private String maThe;
    private String trangThai;
    private String loaiThe;
    private String maKhachHang;

    public TheXe() {}

    public TheXe(String maThe, String trangThai, String loaiThe) {
        this.maThe = maThe;
        this.trangThai = trangThai;
        this.loaiThe = loaiThe;
    }

    public boolean kiemTraTrangThaiHopLe() {
        return "Hoạt động".equals(trangThai);
    }

    public void khoaThe() { this.trangThai = "Khóa"; }
    public void moKhoaThe() { this.trangThai = "Hoạt động"; }
    public String getMaThe() { return maThe; }
    public void setMaThe(String maThe) { this.maThe = maThe; }
    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }
    public String getLoaiThe() { return loaiThe; }
    public void setLoaiThe(String loaiThe) { this.loaiThe = loaiThe; }
    public String getMaKhachHang() { return maKhachHang; }
    public void setMaKhachHang(String maKhachHang) { this.maKhachHang = maKhachHang; }
}