/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

/**
 *
 * @author yuhna
 */
import Model.ViTriDo;
import config.DBConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViTriDoRepository {

    public void save(ViTriDo viTriDo) {
        String sql = "INSERT INTO vitrido (maViTri, trangThai, loaiCho, maKhuVuc) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, viTriDo.getMaViTri());
            stmt.setString(2, viTriDo.getTrangThai());
            stmt.setString(3, viTriDo.getLoaiCho());
            stmt.setString(4, viTriDo.getMaKhuVuc());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ViTriDo findByMa(String maViTri) {
        String sql = "SELECT * FROM vitrido WHERE maViTri = ?";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, maViTri);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ViTriDo vt = new ViTriDo();
                vt.setMaViTri(rs.getString("maViTri"));
                vt.setTrangThai(rs.getString("trangThai"));
                vt.setLoaiCho(rs.getString("loaiCho"));
                vt.setMaKhuVuc(rs.getString("maKhuVuc"));
                return vt;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ViTriDo> findAll() {
        List<ViTriDo> list = new ArrayList<>();
        String sql = "SELECT * FROM vitrido";
        try (Connection conn = DBConnectionUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ViTriDo vt = new ViTriDo();
                vt.setMaViTri(rs.getString("maViTri"));
                vt.setTrangThai(rs.getString("trangThai"));
                vt.setLoaiCho(rs.getString("loaiCho"));
                vt.setMaKhuVuc(rs.getString("maKhuVuc"));
                list.add(vt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<ViTriDo> findTrong() {
        List<ViTriDo> list = new ArrayList<>();
        String sql = "SELECT * FROM vitrido WHERE trangThai = 'Trống'";
        try (Connection conn = DBConnectionUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            ViTriDo vt = new ViTriDo();
            vt.setMaViTri(rs.getString("maViTri"));
            vt.setTrangThai(rs.getString("trangThai"));
            vt.setLoaiCho(rs.getString("loaiCho"));
            vt.setMaKhuVuc(rs.getString("maKhuVuc"));
            list.add(vt);
        }
    } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
