/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.parking.repository;

/**
 *
 * @author yuhna
 */
import com.parking.model.KhachHang;
import java.util.List;

public interface KhachHangRepo {
    boolean save(KhachHang kh);
    KhachHang findById(String maKhachHang);
    List<KhachHang> findAll();
}
