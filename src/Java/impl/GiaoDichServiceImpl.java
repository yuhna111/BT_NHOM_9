/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impl;

/**
 *
 * @author yuhna
 */
import com.parking.model.GiaoDich;
import com.parking.model.BangGia;
import com.parking.model.NhanVien;
import com.parking.model.TheXe;
import com.parking.model.PhuongTien;
import service.GiaoDichService; 
import com.parking.repository.GiaoDichRepo; 
import com.parking.repository.TheXeRepo; 
import com.parking.repository.BangGiaRepo; 
import com.parking.repository.PhuongTienRepo; 
import com.parking.dao.GiaoDichDao;
import com.parking.dao.TheXeDao;
import com.parking.dao.BangGiaDao;
import com.parking.dao.PhuongTienDao;

public class GiaoDichServiceImpl implements GiaoDichService {

    private final GiaoDichRepo giaoDichRepo = new GiaoDichDao();
    private final TheXeRepo theXeRepo = new TheXeDao();
    private final BangGiaRepo bangGiaRepo = new BangGiaDao() {
        @Override
        public boolean update(BangGia bangGia) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    };
    private final PhuongTienRepo phuongTienRepo = new PhuongTienDao();

    @Override
    public GiaoDich xuLyGuiXe(String maGiaoDich, PhuongTien phuongTien, String maThe, NhanVien nv) {
        
        TheXe theXe = theXeRepo.findByMaThe(maThe);
        if (theXe == null || !"HOAT_DONG".equalsIgnoreCase(theXe.getTrangThai())) {
            System.err.println("Lỗi nghiệp vụ: Thẻ xe không hợp lệ hoặc đã bị khóa.");
            return null;
        }
        
        if (giaoDichRepo.findPendingByMaThe(maThe) != null) {
            System.err.println("Lỗi nghiệp vụ: Xe đã gửi và chưa thanh toán.");
            return null;
        }

        String maMucGia = phuongTien.getLoaiPhuongTien().equals("Oto") ? "GIA_OTO" : "GIA_XEMAY";
        BangGia giaApDung = bangGiaRepo.findByMaMucGia(maMucGia); 
        
        if (giaApDung == null) {
            System.err.println("Lỗi: Không tìm thấy bảng giá áp dụng.");
            return null;
        }
        
        GiaoDich gd = new GiaoDich(maGiaoDich, phuongTien, theXe, giaApDung, nv);
        
        gd.batDauGiaoDich(); 
        
        if (giaoDichRepo.save(gd)) {
            return gd;
        }
        
        System.err.println("Lỗi hệ thống: Không thể lưu Giao Dịch vào DB.");
        return null;
    }

    @Override
    public GiaoDich xuLyNhanXe(String maThe) {
        
        GiaoDich gd = giaoDichRepo.findPendingByMaThe(maThe);
        if (gd == null) {
            System.err.println("Lỗi nghiệp vụ: Không tìm thấy giao dịch đang đỗ cho thẻ này.");
            return null;
        }
        
        gd.ketThucGiaoDich();
        gd.tinhPhiDoXe();
        gd.thanhToan();
        
        System.out.printf("Phí đỗ xe cần thanh toán: %.0f VNĐ\n", gd.getPhiDoXe());

        if (giaoDichRepo.update(gd)) {
            System.out.println("Giao dịch kết thúc thành công. Đã cập nhật vào DB.");
            return gd;
        }
        
        System.err.println("Lỗi hệ thống: Không thể cập nhật Giao Dịch vào DB.");
        return null; 
    }
}
