/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
/**
 *
 * @author yuhna
 */
import Model.TheXe;
import Repository.TheXeRepository;
import Service.TheXeService;

public class TheXeServiceImpl implements TheXeService {

    private final TheXeRepository repo = new TheXeRepository();

    @Override
    public TheXe dangKiTheXe(String maThe, String loaiThe, String maKhachHang) {
        TheXe the = new TheXe();
        the.setMaThe(maThe);
        the.setLoaiThe(loaiThe);
        the.setMaKhachHang(maKhachHang);
        the.setTrangThai("Hoạt động");
        repo.save(the);
        return the;
    }

    @Override
    public void khoaThe(String maThe) {
        TheXe the = repo.findByMa(maThe);
        if (the != null) {
            the.khoaThe();
            repo.save(the);
        }
    }

    @Override
    public void moKhoaThe(String maThe) {
        TheXe the = repo.findByMa(maThe);
        if (the != null) {
            the.moKhoaThe();
            repo.save(the);
        }
    }
    @Override
    public TheXe getTheXeByMa(String maThe) {
        return repo.findByMa(maThe);
    }
}
