/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author yuhna
 */
import com.parking.model.NhanVien;
import com.parking.model.PhuongTien;
import com.parking.model.XeMay; 
import com.parking.model.GiaoDich;
import impl.NhanVienServiceImpl;
import impl.GiaoDichServiceImpl;
import service.NhanVienService;
import service.GiaoDichService;

public class test {
    private static final NhanVienService nhanVienService = new NhanVienServiceImpl();
    private static final GiaoDichService giaoDichService = new GiaoDichServiceImpl();
    
    public static void main(String[] args) {    
        NhanVien nv = nhanVienService.dangNhap("nhanvien", "123456"); 
        if (nv == null) return;
        String maGiaoDich = "GD001";
        String maTheXe = "T-Oto-01"; 
        PhuongTien xeGui = new XeMay("29B1-678.90", "Trang", "Honda", 150, true);
        
        GiaoDich gdGui = giaoDichService.xuLyGuiXe(maGiaoDich, xeGui, maTheXe, nv);
        
        if (gdGui != null) {
            System.out.println("GUI XE THANH CONG! Ma GD: " + gdGui.getMaGiaoDich());
        }
        GiaoDich gdNhan = giaoDichService.xuLyNhanXe(maTheXe);
        
        if (gdNhan != null) {
            System.out.println("NHAN XE THANH CONG! Phi: " + gdNhan.getPhiDoXe());
        }
    }
}

