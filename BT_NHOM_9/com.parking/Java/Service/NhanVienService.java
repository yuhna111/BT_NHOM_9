/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.GiaoDich;
import Model.NhanVien;

/**
 *
 * @author yuhna
 */
public interface NhanVienService {
    NhanVien taoNhanVienMoi(String maNhanVien, String tenDangNhap, String matKhau, String caLamViec);
    void xuLyKetThucGiaoDich(GiaoDich giaoDich);
}
