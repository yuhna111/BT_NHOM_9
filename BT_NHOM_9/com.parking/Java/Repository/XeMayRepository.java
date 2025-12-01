/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

/**
 *
 * @author yuhna
 */
import Model.XeMay;
import Model.PhuongTien;
import config.DBConnectionUtil;
import java.sql.*;
import java.util.Optional;

public class XeMayRepository extends PhuongTienRepository {

    @Override
    protected PhuongTien createInstance(String tableName) {
        return new XeMay();
    }

    public void save(XeMay xeMay) {
        // Lưu trường chung vào bảng phuongtien trước
        super.saveCommonFields(xeMay, "phuongtien");

        // Sau đó lưu riêng vào bảng xemay
        String sql = "INSERT INTO xemay (bienSo, dungTichXiLanh, coHopSoTuDong) VALUES (?, ?, ?)";
        try (Connection conn = config.DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, xeMay.getBienSo());
            stmt.setInt(2, xeMay.getDungTichXiLanh());
            stmt.setBoolean(3, xeMay.isCoHopSoTuDong());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public XeMay findByBienSo(String bienSo) {
        XeMay xeMay = (XeMay) super.findCommonFields(bienSo, "phuongtien");
        if (xeMay != null) {
            String sql = "SELECT dungTichXiLanh, coHopSoTuDong FROM xemay WHERE bienSo = ?";
            try (Connection conn = config.DBConnectionUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, bienSo);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    xeMay.setDungTichXiLanh(rs.getInt("dungTichXiLanh"));
                    xeMay.setCoHopSoTuDong(rs.getBoolean("coHopSoTuDong"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return xeMay;
    }
}