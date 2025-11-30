USE QuanLyBaiDoXe; 

INSERT INTO BangGia (maMucGia, loaiPhuongTien, giaTienCoBan) VALUES
('GIA001', 'Oto', 15000.00),         
('GIA002', 'XeMay', 5000.00),        
('GIA003', 'XeDap', 2000.00);        

INSERT INTO BaiDo (maBaiDo, sucChuaHienTai, tongSoCho) VALUES 
('BD01', 1, 150);

INSERT INTO KhuVuc (maKhuVuc, tenKhuVuc, maBaiDo) VALUES 
('KV_A', 'Khu A - Ô tô', 'BD01'),
('KV_B', 'Khu B - Xe máy', 'BD01');

INSERT INTO ViTriDo (maViTri, trangThai, loaiCho, maKhuVuc) VALUES 
('VT_A01', 'DangDo', 'Oto', 'KV_A'),    
('VT_A02', 'Trong', 'Oto', 'KV_A'),     
('VT_B01', 'Trong', 'XeMay', 'KV_B');  

INSERT INTO NguoiDung (maNguoiDung, tenDangNhap, matKhau) VALUES
('ND001', 'admin', '123456'),        
('ND002', 'nhanvien', '123456'),     
('ND003', 'khachhang', '123456');   

INSERT INTO QuanTriVien (maNguoiDung, viTri) VALUES 
('ND001', 'TruongPhong');

INSERT INTO NhanVien (maNhanVien, maNguoiDung, caLamViec) VALUES 
('NV001', 'ND002', 'Ca Chieu');

INSERT INTO KhachHang (maKhachHang, tenKhachHang) VALUES 
('KH001', 'Le Thi B'),
('KH002', 'Tran Van C');

INSERT INTO TheXe (maThe, trangThai, loaiThe, maKhachHang) VALUES 
('T-Oto-01', 'KichHoat', 'VIP', 'KH001'),  
('T-XeMay-02', 'Khoa', 'Thuong', 'KH002'); 

INSERT INTO PhuongTien (bienSo, mauSac, hangXe, maThe) VALUES
('30A-123.45', 'Trang', 'Toyota', 'T-Oto-01'),      
('29B1-678.90', 'Den', 'Honda', 'T-XeMay-02');      

INSERT INTO Oto (bienSo, soChoNgoi, dungTichDongCo) VALUES
('30A-123.45', 7, '2.5L');

INSERT INTO XeMay (bienSo, dungTichXiLanh, coHopSoTuDong) VALUES
('29B1-678.90', 150, TRUE); 

INSERT INTO GiaoDich (maGiaoDich, thoiGianVao, thoiGianRa, phiDoXe, trangThaiThanhToan, maMucGiaApDung, maThe, maNhanVien, maViTri) VALUES
('GD001', NOW(), NULL, 0.00, 'ChuaThanhToan', 'GIA001', 'T-Oto-01', 'NV001', 'VT_A01');