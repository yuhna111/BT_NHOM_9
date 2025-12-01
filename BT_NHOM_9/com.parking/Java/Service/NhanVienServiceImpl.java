/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.NhanVien;
import Model.GiaoDich;
import Model.NguoiDung;
import Repository.NhanVienRepository;
import Repository.NguoiDungRepository;
import Service.NhanVienService;

public class NhanVienServiceImpl implements NhanVienService {

    private final NguoiDungRepository nguoiDungRepo = new NguoiDungRepository();
    private final NhanVienRepository nhanVienRepo = new NhanVienRepository();

    @Override
    public NhanVien taoNhanVienMoi(String maNhanVien, String tenDangNhap, String matKhau, String caLamViec) {
        NguoiDung nd = new NguoiDung();
        nd.setMaNguoiDung(maNhanVien);
        nd.setTenDangNhap(tenDangNhap);
        nd.setMatKhau(matKhau);
        nguoiDungRepo.save(nd);

        NhanVien nv = new NhanVien();
        nv.setMaNhanVien(maNhanVien);
        nv.setMaNguoiDung(maNhanVien);
        nv.setCaLamViec(caLamViec);
        nhanVienRepo.save(nv);

        return nv;
    }

    @Override
    public void xuLyKetThucGiaoDich(GiaoDich giaoDich) {
        giaoDich.ketThucGiaoDich(java.time.LocalDateTime.now());
    }
}
