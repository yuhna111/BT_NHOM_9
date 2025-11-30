/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impl;

/**
 *
 * @author yuhna
 */
import com.parking.model.TheXe;
import service.TheXeService;
import com.parking.dao.TheXeDao;
import com.parking.repository.TheXeRepo;

public class TheXeServiceImpl implements TheXeService {

    private final TheXeRepo theXeRepo = new TheXeDao();

    @Override
    public TheXe kiemTraTheHopLe(String maThe) {
        TheXe theXe = theXeRepo.findByMaThe(maThe);
        
        if (theXe == null) {
            System.err.println("Lỗi: Không tìm thấy thẻ xe " + maThe);
            return null;
        }
        
        if (!"HOAT_DONG".equalsIgnoreCase(theXe.getTrangThai())) {
            System.err.println("Lỗi: Thẻ xe " + maThe + " đang ở trạng thái " + theXe.getTrangThai());
            return null;
        }
        return theXe;
    }

    @Override
    public boolean capNhatTrangThaiThe(String maThe, String trangThaiMoi) {
        return theXeRepo.updateTrangThai(maThe, trangThaiMoi);
    }
}
