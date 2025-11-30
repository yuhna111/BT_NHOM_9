/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.parking.repository;

/**
 *
 * @author yuhna
 */
import com.parking.model.NhanVien;
public interface NhanVienRepo {
    boolean save(NhanVien nv);
    NhanVien findById(String maNhanVien);
    NhanVien findByUsernameAndPassword(String tenDangNhap, String matKhau);
}
