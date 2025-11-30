/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parking.dao;

/**
 *
 * @author yuhna
 */
import com.parking.model.PhuongTien;
import com.parking.model.Oto;
import com.parking.model.XeMay;
import com.parking.repository.PhuongTienRepo;
import config.DBConnectionUtil;
import java.sql.*;

public class PhuongTienDao implements PhuongTienRepo {
    private static final String SELECT_BY_BIENSO_SQL = 
        "SELECT bienSo, mauSac, hangXe, maTheLienKet, loaiPhuongTien " + 
        "FROM PhuongTien WHERE bienSo = ?";
    private static final String SELECT_BY_MATHE_SQL = 
        "SELECT bienSo, mauSac, hangXe, maTheLienKet, loaiPhuongTien " + 
        "FROM PhuongTien WHERE maTheLienKet = ?";

    @Override
    public boolean save(PhuongTien pt) {
        return false;
    }

    @Override
    public PhuongTien findByBienSo(String bienSo) {
        PhuongTien pt = null;
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_BIENSO_SQL)) {
            
            ps.setString(1, bienSo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pt = mapResultSetToPhuongTien(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi tìm Phương Tiện theo Biển Số: " + e.getMessage());
        }
        return pt;
    }
    
    @Override
    public PhuongTien findByMaThe(String maThe) {
        PhuongTien pt = null;
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_MATHE_SQL)) {
            
            ps.setString(1, maThe);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pt = mapResultSetToPhuongTien(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi tìm Phương Tiện theo Mã Thẻ: " + e.getMessage());
        }
        return pt;
    }

    private PhuongTien mapResultSetToPhuongTien(ResultSet rs) throws SQLException {
        String loai = rs.getString("loaiPhuongTien");
        String bienSo = rs.getString("bienSo");
        
        if ("OTO".equalsIgnoreCase(loai)) {
            return findOtoDetails(bienSo, rs);
        } else if ("XEMAY".equalsIgnoreCase(loai)) {
            return findXeMayDetails(bienSo, rs);
        }
        return null;
    }
    
    private Oto findOtoDetails(String bienSo, ResultSet rsPhuongTien) throws SQLException {
        Oto oto = null;
        String SELECT_OTO_SQL = "SELECT soChoNgoi, dungTichDongCo FROM Oto WHERE bienSo = ?";
        
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_OTO_SQL)) {
            
            ps.setString(1, bienSo);
            try (ResultSet rsOto = ps.executeQuery()) {
                if (rsOto.next()) {
                    oto = new Oto(
                        rsPhuongTien.getString("bienSo"),
                        rsPhuongTien.getString("mauSac"),
                        rsPhuongTien.getString("hangXe"),
                        rsOto.getInt("soChoNgoi"),         
                        rsOto.getString("dungTichDongCo")  
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi tìm chi tiết Oto: " + e.getMessage());
        }
        return oto;
    }

    private XeMay findXeMayDetails(String bienSo, ResultSet rsPhuongTien) throws SQLException {
        XeMay xeMay = null;
        String SELECT_XM_SQL = "SELECT dungTichXiLanh, coHopSoTuDong FROM XeMay WHERE bienSo = ?";
        
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_XM_SQL)) {
            
            ps.setString(1, bienSo);
            try (ResultSet rsXeMay = ps.executeQuery()) {
                if (rsXeMay.next()) {
                    xeMay = new XeMay(
                        rsPhuongTien.getString("bienSo"),
                        rsPhuongTien.getString("mauSac"),
                        rsPhuongTien.getString("hangXe"),
                        rsXeMay.getInt("dungTichXiLanh"),
                        rsXeMay.getBoolean("coHopSoTuDong")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi tìm chi tiết Xe Máy: " + e.getMessage());
        }
        return xeMay;
    }
}
