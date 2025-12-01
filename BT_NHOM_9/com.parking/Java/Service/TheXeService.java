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

public interface TheXeService {
    TheXe dangKiTheXe(String maThe, String loaiThe, String maKhachHang);
    void khoaThe(String maThe);
    void moKhoaThe(String maThe);
}
