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

// Sử dụng các lớp Model giả định (cần đảm bảo các lớp Model này tồn tại)
public class MockQuanTriService {
    
    private Map<String, Double> mockBangGia = new HashMap<>();
    private double mockTongDoanhThu = 1500000.0; 

    public MockQuanTriService() {
        mockBangGia.put("XEMAY", 2000.0);
        mockBangGia.put("OTO", 10000.0);
    }

    public double tinhTongDoanhThu() {
        // Trả về giá trị mock cố định hoặc tính toán đơn giản từ mock data
        return mockTongDoanhThu;
    }

    public boolean capNhatBangGia(BangGia bg) throws Exception {
        // Logic mô phỏng: Cập nhật giá trong Map
        if (mockBangGia.containsKey(bg.getLoaiPhuongTien())) {
            mockBangGia.put(bg.getLoaiPhuongTien(), bg.getGiaTienCoBan());
            // Cập nhật doanh thu để thấy sự thay đổi (chỉ là mock)
            mockTongDoanhThu += 1000.0; 
            return true;
        }
        return false;
    }
}
