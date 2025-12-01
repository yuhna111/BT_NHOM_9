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
import java.time.LocalDateTime;

public class GiaoDichServiceImpl implements GiaoDichService {

    private final GiaoDichRepository repo = new GiaoDichRepository();

    @Override
    public GiaoDich taoGiaoDichMoi(String maThe, String maNhanVien, String maViTri) {
        GiaoDich gd = new GiaoDich();
        gd.setMaGiaoDich("GD" + System.currentTimeMillis());
        gd.setMaThe(maThe);
        gd.setMaNhanVien(maNhanVien);
        gd.setMaViTri(maViTri);
        gd.setMaMucGiaApDung("MG001"); 
        gd.batDauGiaoDich();
        repo.save(gd);
        return gd;
    }

    @Override
    public void ketThucGiaoDich(String maGiaoDich) {

    }

    @Override
    public double tinhPhiDoXe(String maGiaoDich) {
    
        return 20000.0;
    }
}
