/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

/**
 *
 * @author yuhna
 */
import Model.Oto;
import Model.PhuongTien;
import config.DBConnectionUtil;
import java.sql.*;

public class OtoRepository extends PhuongTienRepository {

    @Override
    protected PhuongTien createInstance(String tableName) {
        return new Oto();
    }

    public void save(Oto oto) {
        super.saveCommonFields(oto, "phuongtien");
        String sql = "INSERT INTO oto (bienSo, soChoNgoi, dungTichDongCo) VALUES (?, ?, ?)";
        try (Connection conn = config.DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, oto.getBienSo());
            stmt.setInt(2, oto.getSoChoNgoi());
            stmt.setString(3, oto.getDungTichDongCo());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Oto findByBienSo(String bienSo) {
        Oto oto = (Oto) super.findCommonFields(bienSo, "phuongtien");
        if (oto != null) {
            String sql = "SELECT soChoNgoi, dungTichDongCo FROM oto WHERE bienSo = ?";
            try (Connection conn = config.DBConnectionUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, bienSo);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    oto.setSoChoNgoi(rs.getInt("soChoNgoi"));
                    oto.setDungTichDongCo(rs.getString("dungTichDongCo"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return oto;
    }
}