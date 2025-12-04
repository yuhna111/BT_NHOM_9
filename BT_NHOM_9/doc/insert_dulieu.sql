USE quanlybaidoxe;

INSERT INTO nguoidung VALUES ('ND001', 'admin', 'admin') 
ON DUPLICATE KEY UPDATE tenDangNhap = 'admin', matKhau = 'admin';

INSERT INTO nguoidung VALUES ('ND002', 'nv1', '123') 
ON DUPLICATE KEY UPDATE tenDangNhap = 'nv1', matKhau = '123';

INSERT INTO quantrivien VALUES ('ND001', 'Quản trị viên') 
ON DUPLICATE KEY UPDATE viTri = 'Quản trị viên';

INSERT INTO nhanvien VALUES ('NV001', 'ND002', 'Ca sáng') 
ON DUPLICATE KEY UPDATE caLamViec = 'Ca sáng';

INSERT INTO khachhang VALUES ('KH001', 'Nguyễn Văn A') 
ON DUPLICATE KEY UPDATE maKhachHang = 'KH001';
INSERT INTO khachhang VALUES ('KH001', 'Trần Thị B') 
ON DUPLICATE KEY UPDATE maKhachHang = 'KH002';
INSERT INTO khachhang VALUES ('KH001', 'Lê Văn C') 
ON DUPLICATE KEY UPDATE maKhachHang = 'KH003';

INSERT INTO thexe (maThe, trangThai, loaiThe, maKhachHang) 
VALUES 
('THE001', 'Hoạt động', 'Xe máy', 'KH001'),
('THE002', 'Hoạt động', 'Xe máy', 'KH002'),
('THE003', 'Hoạt động', 'Ô tô',   'KH003');

INSERT INTO baido (maBaiDo, sucChuaHienTai, tongSoCho) 
VALUES ('BD01', 2, 10);

INSERT INTO khuvuc (maKhuVuc, tenKhuVuc, maBaiDo) 
VALUES ('KV01', 'Khu A', 'BD01');

INSERT INTO vitrido (maViTri, trangThai, loaiCho, maKhuVuc) 
VALUES 
('VT01', 'Đang dùng', 'Xe máy', 'KV01'),  
('VT02', 'Trống',     'Xe máy', 'KV01'),  
('VT03', 'Trống',     'Xe máy', 'KV01');  
-- Vị trí Ô TÔ
INSERT INTO vitrido (maViTri, trangThai, loaiCho, maKhuVuc) 
VALUES 
('VT04', 'Trống',     'Ô tô',   'KV01'),  
('VT05', 'Trống',     'Ô tô',   'KV01');  

INSERT INTO banggia (maMucGia, loaiPhuongTien, giaTienCoBan) 
VALUES 
('MG001', 'Xe máy', 10000.00),
('MG002', 'Ô tô',   25000.00);

INSERT INTO giaodich (
    maGiaoDich, thoiGianVao, thoiGianRa, phiDoXe, 
    trangThaiThanhToan, maMucGiaApDung, maThe, maNhanVien, maViTri
) VALUES (
    'GD001', NOW(), NULL, 0.0, 
    'Chưa thanh toán', 'MG001', 'THE001', 'NV001', 'VT01'
);
