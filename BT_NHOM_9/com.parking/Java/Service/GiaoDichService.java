/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.GiaoDich;

/**
 *
 * @author yuhna
 */
public interface GiaoDichService {
    GiaoDich taoGiaoDichMoi(String maThe, String maNhanVien, String maViTri);
    void ketThucGiaoDich(String maGiaoDich);
    double tinhPhiDoXe(String maGiaoDich);
    java.util.List<GiaoDich> getAllGiaoDich();
}
