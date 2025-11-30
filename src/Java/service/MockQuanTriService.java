/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author yuhna
 */
import com.parking.model.BangGia;
import java.util.HashMap;
import java.util.Map;

public class MockQuanTriService {   
    private Map<String, Double> mockBangGia = new HashMap<>();
    private double mockTongDoanhThu = 1500000.0; 

    public MockQuanTriService() {
        mockBangGia.put("XEMAY", 2000.0);
        mockBangGia.put("OTO", 10000.0);
    }

    public double tinhTongDoanhThu() {
        return mockTongDoanhThu;
    }

    public boolean capNhatBangGia(BangGia bg) throws Exception {
        if (mockBangGia.containsKey(bg.getLoaiPhuongTien())) {
            mockBangGia.put(bg.getLoaiPhuongTien(), bg.getGiaTienCoBan());
            mockTongDoanhThu += 1000.0; 
            return true;
        }
        return false;
    }
}

