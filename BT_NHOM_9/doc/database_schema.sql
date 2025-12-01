USE quanlybaidoxe;

-- 1. Bảng BaiDo
CREATE TABLE baido (
    maBaiDo VARCHAR(50) PRIMARY KEY,
    sucChuaHienTai INT,
    tongSoCho INT
);

-- 2. Bảng KhuVuc
CREATE TABLE khuvuc (
    maKhuVuc VARCHAR(50) PRIMARY KEY,
    tenKhuVuc VARCHAR(100),
    maBaiDo VARCHAR(50),
    FOREIGN KEY (maBaiDo) REFERENCES baido(maBaiDo)
);

-- 3. Bảng ViTriDo
CREATE TABLE vitrido (
    maViTri VARCHAR(50) PRIMARY KEY,
    trangThai VARCHAR(50),
    loaiCho VARCHAR(50),
    maKhuVuc VARCHAR(50),
    FOREIGN KEY (maKhuVuc) REFERENCES khuvuc(maKhuVuc)
);

-- 4. Bảng NguoiDung
CREATE TABLE nguoidung (
    maNguoiDung VARCHAR(50) PRIMARY KEY,
    tenDangNhap VARCHAR(50) NOT NULL UNIQUE,
    matKhau VARCHAR(255) NOT NULL
);

-- 5. Bảng NhanVien
CREATE TABLE nhanvien (
    maNhanVien VARCHAR(50) PRIMARY KEY,
    maNguoiDung VARCHAR(50),
    caLamViec VARCHAR(50),
    FOREIGN KEY (maNguoiDung) REFERENCES nguoidung(maNguoiDung)
);

-- 6. Bảng QuanTriVien
CREATE TABLE quantrivien (
    maNguoiDung VARCHAR(50) PRIMARY KEY,
    viTri VARCHAR(100),
    FOREIGN KEY (maNguoiDung) REFERENCES nguoidung(maNguoiDung)
);

-- 7. Bảng KhachHang
CREATE TABLE khachhang (
    maKhachHang VARCHAR(50) PRIMARY KEY,
    tenKhachHang VARCHAR(100)
);

-- 8. Bảng TheXe
CREATE TABLE thexe (
    maThe VARCHAR(50) PRIMARY KEY,
    trangThai VARCHAR(50),
    loaiThe VARCHAR(50),
    maKhachHang VARCHAR(50),
    FOREIGN KEY (maKhachHang) REFERENCES khachhang(maKhachHang)
);

-- 9. Bảng PhuongTien
CREATE TABLE phuongtien (
    bienSo VARCHAR(20) PRIMARY KEY,
    mauSac VARCHAR(50),
    hangXe VARCHAR(50),
    maThe VARCHAR(50),
    FOREIGN KEY (maThe) REFERENCES thexe(maThe)
);

-- 10. Bảng Oto
CREATE TABLE oto (
    bienSo VARCHAR(20) PRIMARY KEY,
    soChoNgoi INT,
    dungTichDongCo VARCHAR(50),
    FOREIGN KEY (bienSo) REFERENCES phuongtien(bienSo) ON DELETE CASCADE
);

-- 11. Bảng XeMay
CREATE TABLE xemay (
    bienSo VARCHAR(20) PRIMARY KEY,
    dungTichXiLanh INT,
    coHopSoTuDong BOOLEAN,
    FOREIGN KEY (bienSo) REFERENCES phuongtien(bienSo) ON DELETE CASCADE
);

-- 12. Bảng BangGia
CREATE TABLE banggia (
    maMucGia VARCHAR(50) PRIMARY KEY,
    loaiPhuongTien VARCHAR(50),
    giaTienCoBan DECIMAL(10,2)
);

INSERT INTO banggia VALUES ('MG001', 'Xe máy', 10000.00);
INSERT INTO banggia VALUES ('MG002', 'Ô tô', 25000.00);

-- 13. Bảng GiaoDich
CREATE TABLE giaodich (
    maGiaoDich VARCHAR(50) PRIMARY KEY,
    thoiGianVao DATETIME,
    thoiGianRa DATETIME NULL,
    phiDoXe DECIMAL(10,2),
    trangThaiThanhToan VARCHAR(50),
    maMucGiaApDung VARCHAR(50),
    maThe VARCHAR(50),
    maNhanVien VARCHAR(50),
    maViTri VARCHAR(50),
    FOREIGN KEY (maMucGiaApDung) REFERENCES banggia(maMucGia),
    FOREIGN KEY (maThe) REFERENCES thexe(maThe),
    FOREIGN KEY (maNhanVien) REFERENCES nhanvien(maNhanVien),
    FOREIGN KEY (maViTri) REFERENCES vitrido(maViTri)
);