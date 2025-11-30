/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.parking.repository;

/**
 *
 * @author yuhna
 */
import com.parking.model.PhuongTien;

public interface PhuongTienRepo {
    boolean save(PhuongTien pt);
    PhuongTien findByBienSo(String bienSo);
    PhuongTien findByMaThe(String maThe);
}
