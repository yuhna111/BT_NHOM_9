/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

/**
 *
 * @author yuhna
 */
import java.util.List;
import com.parking.model.BangGia;

public interface QuanTriService {
    double tinhTongDoanhThu();
    List<BangGia> layDanhSachBangGia();
    boolean capNhatBangGia(BangGia bangGia);
}
