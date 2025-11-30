/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parking.repository;

/**
 *
 * @author yuhna
 */
import com.parking.model.GiaoDich;

public interface GiaoDichRepo {
    boolean save(GiaoDich gd);
    boolean update(GiaoDich gd);
    GiaoDich findPendingByMaThe(String maThe);
}
