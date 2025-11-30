/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.parking.repository;

/**
 *
 * @author yuhna
 */
import com.parking.model.BangGia;
import java.util.List;
public interface BangGiaRepo {
    BangGia findByMaMucGia(String maMucGia);
    List<BangGia> findAll();
    boolean updateGiaCoBan(String maMucGia, double giaMoi);
}
