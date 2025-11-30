/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.parking.repository;

/**
 *
 * @author yuhna
 */
import com.parking.model.NguoiDung;
public interface NguoiDungRepo {
    boolean save(NguoiDung nd);
    NguoiDung findById(String maNguoiDung);
    NguoiDung findByUsernameAndPassword(String tenDangNhap, String matKhau);
}
