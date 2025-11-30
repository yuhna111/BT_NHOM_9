/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package impl;

/**
 *
 * @author yuhna
 */
import service.QuanTriService;
import com.parking.repository.GiaoDichRepo;
import com.parking.repository.BangGiaRepo;
import com.parking.model.BangGia;
import java.util.List;
import java.util.logging.Logger;

public class QuanTriServiceImpl implements QuanTriService {

    // Khai báo Dependencies
    private final GiaoDichRepo giaoDichRepo;
    private final BangGiaRepo bangGiaRepo;
    
    private static final Logger LOGGER = Logger.getLogger(QuanTriServiceImpl.class.getName());

    // Constructor để nhận dependencies (DI)
    public QuanTriServiceImpl(GiaoDichRepo giaoDichRepo, BangGiaRepo bangGiaRepo) {
        this.giaoDichRepo = giaoDichRepo;
        this.bangGiaRepo = bangGiaRepo;
        LOGGER.info("QuanTriServiceImpl da khoi tao.");
    }

    @Override
    public double tinhTongDoanhThu() {
        // TODO: Triển khai logic: Gọi giaoDichRepo để lấy tổng phí các giao dịch PAID
        
        // Trả về giá trị giả định để test GUI
        return 12500000.00; 
    }

    @Override
    public List<BangGia> layDanhSachBangGia() {
        // TODO: Triển khai logic: Gọi bangGiaRepo.findAll()
        return bangGiaRepo.findAll();
    }

    @Override
    public boolean capNhatBangGia(BangGia bangGia) {
        // TODO: Triển khai logic: Gọi bangGiaRepo.update(bangGia)
        return bangGiaRepo.update(bangGia);
    }
}
