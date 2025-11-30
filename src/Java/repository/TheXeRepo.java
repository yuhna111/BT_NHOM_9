/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parking.repository;

/**
 *
 * @author yuhna
 */
import com.parking.model.TheXe;

public interface TheXeRepo {
    boolean save(TheXe theXe);
    TheXe findByMaThe(String maThe);
    boolean updateTrangThai(String maThe, String trangThai);
}