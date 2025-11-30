/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author yuhna
 */
import com.parking.model.TheXe;

public interface TheXeService {
    TheXe kiemTraTheHopLe(String maThe);

    boolean capNhatTrangThaiThe(String maThe, String trangThaiMoi);
}
