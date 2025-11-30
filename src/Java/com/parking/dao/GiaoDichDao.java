/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parking.dao;

/**
 *
 * @author yuhna
 */
import com.parking.model.GiaoDich;
import com.parking.model.BangGia;
import com.parking.model.NhanVien;
import com.parking.model.TheXe;
import com.parking.repository.GiaoDichRepo; 
import com.parking.repository.TheXeRepo; 
import com.parking.repository.NhanVienRepo; 
import com.parking.repository.BangGiaRepo; 
import com.parking.repository.PhuongTienRepo;
import config.DBConnectionUtil;
import com.parking.model.PhuongTien;
import java.sql.*;

public class GiaoDichDao implements GiaoDichRepo {
    private final TheXeRepo theXeRepo = new TheXeDao();
    private final NhanVienRepo nhanVienRepo = new NhanVienDao();
    private final BangGiaRepo bangGiaRepo = new BangGiaDao();
    private final PhuongTienRepo phuongTienRepo = new PhuongTienDao();

    private static final String INSERT_SQL = 
        "INSERT INTO GiaoDich (maGiaoDich, thoiGianVao, trangThaiThanhToan, maNhanVien, maMucGiaApDung, maThe) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = 
        "UPDATE GiaoDich SET thoiGianRa = ?, phiDoXe = ?, trangThaiThanhToan = ? WHERE maGiaoDich = ?";
    private static final String SELECT_PENDING_SQL = 
        "SELECT maGiaoDich, thoiGianVao, maThe, maMucGiaApDung, maNhanVien, trangThaiThanhToan " +
        "FROM GiaoDich WHERE maThe = ? AND thoiGianRa IS NULL"; 

    @Override
    public boolean save(GiaoDich gd) {
        boolean rowInserted = false;
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            
            // ... (Logic ánh xạ dữ liệu không đổi) ...
            ps.setString(1, gd.getMaGiaoDich());
            ps.setTimestamp(2, Timestamp.valueOf(gd.getThoiGianVao()));
            ps.setString(3, gd.getTrangThaiThanhToan());
            ps.setString(4, gd.getNhanVien().getMaNhanVien()); 
            ps.setString(5, gd.getBangGia().getMaMucGia());
            ps.setString(6, gd.getTheXe().getMaThe()); 

            rowInserted = ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi gửi xe: " + e.getMessage());
        }
        return rowInserted;
    }
    
    @Override
    public boolean update(GiaoDich gd) {
        boolean rowUpdated = false;
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            
            // ... (Logic cập nhật dữ liệu không đổi) ...
            ps.setTimestamp(1, Timestamp.valueOf(gd.getThoiGianRa()));
            ps.setDouble(2, gd.getPhiDoXe()); 
            ps.setString(3, gd.getTrangThaiThanhToan()); 
            ps.setString(4, gd.getMaGiaoDich());

            rowUpdated = ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi nhận xe: " + e.getMessage());
        }
        return rowUpdated;
    }

    @Override
    public GiaoDich findPendingByMaThe(String maThe) {
        GiaoDich gd = null;
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_PENDING_SQL)) {
            
            ps.setString(1, maThe);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    gd = mapResultSetToGiaoDich(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi SQL khi tìm giao dịch đang đỗ: " + e.getMessage());
        }
        return gd;
    }
    
    
    private GiaoDich mapResultSetToGiaoDich(ResultSet rs) throws SQLException {
        String maGiaoDich = rs.getString("maGiaoDich");
        Timestamp tsVao = rs.getTimestamp("thoiGianVao");
        String maThe = rs.getString("maThe");
        String maNV = rs.getString("maNhanVien");
        String maBG = rs.getString("maMucGiaApDung");
        String trangThai = rs.getString("trangThaiThanhToan");

        TheXe theXe = theXeRepo.findByMaThe(maThe); 
        NhanVien nv = nhanVienRepo.findById(maNV);
        BangGia bg = bangGiaRepo.findByMaMucGia(maBG);
      
        PhuongTien phuongTien = phuongTienRepo.findByMaThe(maThe); 
        
        GiaoDich gd = new GiaoDich(); 
        
        gd.setMaGiaoDich(maGiaoDich);
        if (tsVao != null) {
            gd.setThoiGianVao(tsVao.toLocalDateTime());
        }
        gd.setTrangThaiThanhToan(trangThai);
        gd.setTheXe(theXe);
        gd.setNhanVien(nv);
        gd.setBangGia(bg);
        gd.setPhuongTien(phuongTien); 

        return gd;
    }
}