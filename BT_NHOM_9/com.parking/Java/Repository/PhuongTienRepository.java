/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

/**
 *
 * @author yuhna
 */
import Model.PhuongTien;
import config.DBConnectionUtil;
import java.sql.*;

public abstract class PhuongTienRepository {

    protected void saveCommonFields(PhuongTien pt, String tableName) {
        String sql = "INSERT INTO " + tableName + " (bienSo, mauSac, hangXe, maThe) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pt.getBienSo());
            stmt.setString(2, pt.getMauSac());
            stmt.setString(3, pt.getHangXe());
            stmt.setString(4, pt.getMaThe());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected PhuongTien findCommonFields(String bienSo, String tableName) {
        String sql = "SELECT * FROM " + tableName + " WHERE bienSo = ?";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, bienSo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                PhuongTien pt = createInstance(tableName); 
                pt.setBienSo(rs.getString("bienSo"));
                pt.setMauSac(rs.getString("mauSac"));
                pt.setHangXe(rs.getString("hangXe"));
                pt.setMaThe(rs.getString("maThe"));
                return pt;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected abstract PhuongTien createInstance(String tableName);
}
