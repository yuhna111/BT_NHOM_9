/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author yuhna
 */
import com.parking.model.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class MockGiaoDichService {
    private List<GiaoDich> mockGiaoDichList = new ArrayList<>();
    
    public MockGiaoDichService() {
        PhuongTien mockPt = new XeMay("43-B1 12345", "YAMAHA", "EXCITER", 150, true);
        ViTriDo mockVt = new ViTriDo("XM05", "XEMAY");
        
        try {
            GiaoDich gd1 = new GiaoDich(); 
            gd1.setMaGiaoDich(UUID.randomUUID().toString());
            gd1.setPhuongTien(mockPt);
            gd1.setViTriDo(mockVt);
            gd1.setThoiGianVao(LocalDateTime.now().minusHours(2));
            
            mockGiaoDichList.add(gd1);
        } catch (Exception e) {
        }
    }

    public List<GiaoDich> layTatCaGiaoDichDangDo() {
        return mockGiaoDichList.stream()
            .filter(gd -> gd.getThoiGianRa() == null)
            .collect(Collectors.toList());
    }

    public GiaoDich xuLyGuiXe(String bienSo, String loaiXe, String maNhanVien) throws Exception {
        if (mockGiaoDichList.size() >= 5) { 
             throw new Exception("Bãi đỗ đầy (Mock).");
        }
        PhuongTien pt = loaiXe.equals("OTO") ? new Oto(bienSo, "NA", "NA", 4, "1.0L") : new XeMay(bienSo, "NA", "NA", 150, true);
        ViTriDo vt = new ViTriDo("MOCK_" + (mockGiaoDichList.size() + 1), loaiXe);    
        GiaoDich gd = new GiaoDich(); 
        gd.setMaGiaoDich(UUID.randomUUID().toString());
        gd.setPhuongTien(pt);
        gd.setViTriDo(vt);
        gd.setThoiGianVao(LocalDateTime.now());
        
        mockGiaoDichList.add(gd);
        return gd;
    }

    public GiaoDich xuLyNhanXe(String maGiaoDich) throws Exception {
        for (GiaoDich gd : mockGiaoDichList) {
            if (gd.getMaGiaoDich().equals(maGiaoDich) && gd.getThoiGianRa() == null) {
                gd.setThoiGianRa(LocalDateTime.now());
                gd.setPhiDoXe(5000.0); 
                
                return gd;
            }
        }
        return null;
    }

    public boolean thanhToanGiaoDich(String maGiaoDich) throws Exception {
        GiaoDich gdToRemove = null;
        for (GiaoDich gd : mockGiaoDichList) {
            if (gd.getMaGiaoDich().equals(maGiaoDich) && gd.getThoiGianRa() != null) {
                // ✅ DÒNG ĐÃ SỬA: Thay thế gd.thanhToan() bằng setter
                gd.setTrangThaiThanhToan("DA_THANH_TOAN"); 
                gdToRemove = gd;
                break;
            }
        }
        if (gdToRemove != null) {
            mockGiaoDichList.remove(gdToRemove);
            return true;
        }
        return false;
    }
}