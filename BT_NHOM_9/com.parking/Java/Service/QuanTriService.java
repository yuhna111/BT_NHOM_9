/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.BangGia;
import Model.NguoiDung;

/**
 *
 * @author yuhna
 */
public interface QuanTriService {
    void capNhatBangGia(BangGia bangGia, double giaMoi);
    void xemBaoCaoDoanhThu();
    void quanLyNguoiDung(NguoiDung nguoiDung);
}
