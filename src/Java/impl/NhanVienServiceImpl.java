/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impl;

/**
 *
 * @author yuhna
 */
import com.parking.model.NhanVien;
import service.NhanVienService;
import com.parking.dao.NhanVienDao;
import com.parking.repository.NhanVienRepo;

public class NhanVienServiceImpl implements NhanVienService {

    private final NhanVienRepo nhanVienRepo = new NhanVienDao();

    @Override
    public NhanVien dangNhap(String tenDangNhap, String matKhau) {
        NhanVien nv = nhanVienRepo.findByUsernameAndPassword(tenDangNhap, matKhau);
        
        if (nv != null) {
            System.out.println("Đăng nhập thành công: " + nv.getTenDangNhap());
        } else {
            System.err.println("Tên đăng nhập hoặc mật khẩu không đúng.");
        }
        return nv;
    }
}
