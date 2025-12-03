/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
/**
 *
 * @author yuhna
 */
import Model.GiaoDich;
import Repository.GiaoDichRepository;
import Service.GiaoDichService;
import Service.BangGiaService; 
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class GiaoDichServiceImpl implements GiaoDichService {

    private final GiaoDichRepository repo;
    private final BangGiaService bangGiaService; 
    
    public GiaoDichServiceImpl(BangGiaService bangGiaService) {
        this.repo = new GiaoDichRepository();
        this.bangGiaService = bangGiaService; 
    }

    @Override
public GiaoDich taoGiaoDichMoi(String maThe, String maNhanVien, String maViTri) {
    GiaoDich gd = new GiaoDich();
    gd.setMaGiaoDich("GD" + System.currentTimeMillis());
    gd.setMaThe(maThe);
    gd.setMaNhanVien(maNhanVien);
    gd.setMaViTri(maViTri);
    gd.setMaMucGiaApDung("MG001");
    gd.batDauGiaoDich();
    repo.insert(gd);
    return gd;
}

@Override
public void ketThucGiaoDich(String maGiaoDich) {
    GiaoDich gd = repo.findByMa(maGiaoDich);
    if (gd == null) {
        throw new IllegalArgumentException("Giao dịch không tồn tại!");
    }
    gd.setThoiGianRa(LocalDateTime.now());
    gd.setPhiDoXe(tinhPhiDoXe(maGiaoDich));
    gd.setTrangThaiThanhToan("Đã thanh toán");
    repo.update(gd);
}

    @Override
    public double tinhPhiDoXe(String maGiaoDich) {
        GiaoDich gd = repo.findByMa(maGiaoDich);
        if (gd == null || gd.getThoiGianVao() == null) {
            return 0.0;
        }

        LocalDateTime thoiGianRa = gd.getThoiGianRa() != null 
            ? gd.getThoiGianRa() 
            : LocalDateTime.now();

        long minutes = Duration.between(gd.getThoiGianVao(), thoiGianRa).toMinutes();
        long hours = (minutes + 59) / 60; 

        double giaCoBan = bangGiaService.getGiaTheoMa(gd.getMaMucGiaApDung()); 

        return hours * giaCoBan;
    }
    @Override
    public java.util.List<GiaoDich> getAllGiaoDich() {
        return repo.findAll(); 
}
}
