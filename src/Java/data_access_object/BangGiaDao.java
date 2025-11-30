package com.parking.dao;

import com.parking.model.BangGia;
import com.parking.repository.BangGiaRepo;
import config.DBConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yuhna
 */
public abstract class BangGiaDao implements BangGiaRepo {
    private static final String SELECT_BY_ID_SQL = 
        "SELECT maMucGia, loaiPhuongTien, giaTienCoBan FROM BangGia WHERE maMucGia = ?";
    private static final String SELECT_ALL_SQL = 
        "SELECT maMucGia, loaiPhuongTien, giaTienCoBan FROM BangGia";
    private static final String UPDATE_GIA_CO_BAN_SQL = 
        "UPDATE BangGia SET giaTienCoBan = ? WHERE maMucGia = ?";

    @Override
    public BangGia findByMaMucGia(String maMucGia) {
        BangGia bg = null;
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            
            ps.setString(1, maMucGia);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    bg = mapResultSetToBangGia(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi tìm bảng giá: " + e.getMessage());
        }
        return bg;
    }

    @Override
    public List<BangGia> findAll() {
        List<BangGia> danhSachBangGia = new ArrayList<>();
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                danhSachBangGia.add(mapResultSetToBangGia(rs));
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi lấy tất cả bảng giá: " + e.getMessage());
        }
        return danhSachBangGia;
    }

    @Override
    public boolean updateGiaCoBan(String maMucGia, double giaMoi) {
        boolean rowUpdated = false;
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_GIA_CO_BAN_SQL)) {
            
            ps.setDouble(1, giaMoi);
            ps.setString(2, maMucGia);
            rowUpdated = ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi cập nhật giá: " + e.getMessage());
        }
        return rowUpdated;
    }

    private BangGia mapResultSetToBangGia(ResultSet rs) throws SQLException {
        BangGia bg = new BangGia(
            rs.getString("maMucGia"),
            rs.getString("loaiPhuongTien"),
            rs.getDouble("giaTienCoBan")
        );
        return bg;
    }
}