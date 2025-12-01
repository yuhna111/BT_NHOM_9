/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
/**
 *
 * @author yuhna
 */
import Model.BangGia;
import Model.NguoiDung;
import Repository.BangGiaRepository;
import Repository.NguoiDungRepository;
import Service.QuanTriService;

public class QuanTriServiceImpl implements QuanTriService {

    private final BangGiaRepository bangGiaRepo = new BangGiaRepository();
    private final NguoiDungRepository nguoiDungRepo = new NguoiDungRepository();

    @Override
    public void capNhatBangGia(BangGia bangGia, double giaMoi) {
        bangGia.setGiaTienCoBan(giaMoi);
        bangGiaRepo.save(bangGia);
    }

    @Override
    public void xemBaoCaoDoanhThu() {
        System.out.println("=== BÁO CÁO DOANH THU ===");
        System.out.println("Tổng doanh thu: 10.000.000 VND");
    }

    @Override
    public void quanLyNguoiDung(NguoiDung nguoiDung) {
        nguoiDungRepo.save(nguoiDung);
        System.out.println("Quản lý người dùng: " + nguoiDung.getTenDangNhap());
    }
}
