/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

/**
 *
 * @author yuhna
 */
import Model.BaiDo;
import config.DBConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaiDoRepository {

    public void save(BaiDo baiDo) {
        String sql = "INSERT INTO baido (maBaiDo, sucChuaHienTai, tongSoCho) VALUES (?, ?, ?)";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, baiDo.getMaBaiDo());
            stmt.setInt(2, baiDo.getSucChuaHienTai());
            stmt.setInt(3, baiDo.getTongSoCho());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public BaiDo findByMa(String maBaiDo) {
        String sql = "SELECT * FROM baido WHERE maBaiDo = ?";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, maBaiDo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                BaiDo bd = new BaiDo();
                bd.setMaBaiDo(rs.getString("maBaiDo"));
                bd.setSucChuaHienTai(rs.getInt("sucChuaHienTai"));
                bd.setTongSoCho(rs.getInt("tongSoCho"));
                return bd;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<BaiDo> findAll() {
        List<BaiDo> list = new ArrayList<>();
        String sql = "SELECT * FROM baido";
        try (Connection conn = DBConnectionUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                BaiDo bd = new BaiDo();
                bd.setMaBaiDo(rs.getString("maBaiDo"));
                bd.setSucChuaHienTai(rs.getInt("sucChuaHienTai"));
                bd.setTongSoCho(rs.getInt("tongSoCho"));
                list.add(bd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
