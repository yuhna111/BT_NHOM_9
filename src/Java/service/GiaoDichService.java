/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author yuhna
 */
import com.parking.model.GiaoDich;
import com.parking.model.NhanVien;
import com.parking.model.PhuongTien;

public interface GiaoDichService {
    GiaoDich xuLyGuiXe(String maGiaoDich, PhuongTien phuongTien, String maThe, NhanVien nv);
    GiaoDich xuLyNhanXe(String maThe);
}
