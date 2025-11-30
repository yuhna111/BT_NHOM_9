CREATE DATABASE QuanLyBaiDoXe;
USE QuanLyBaiDoXe;

CREATE TABLE BangGia (
    maMucGia VARCHAR(50) PRIMARY KEY,
    loaiPhuongTien VARCHAR(50),
    giaTienCoBan DECIMAL(10, 2)
);

CREATE TABLE BaiDo (
    maBaiDo VARCHAR(50) PRIMARY KEY,
    sucChuaHienTai INT,
    tongSoCho INT
);

CREATE TABLE KhuVuc (
    maKhuVuc VARCHAR(50) PRIMARY KEY,
    tenKhuVuc VARCHAR(100),
    maBaiDo VARCHAR(50),
    FOREIGN KEY (maBaiDo) REFERENCES BaiDo(maBaiDo)

);

CREATE TABLE ViTriDo (
    maViTri VARCHAR(50) PRIMARY KEY,
    trangThai VARCHAR(50),
    loaiCho VARCHAR(50),
    maKhuVuc VARCHAR(50),
    FOREIGN KEY (maKhuVuc) REFERENCES KhuVuc(maKhuVuc)
);

CREATE TABLE NguoiDung (
    maNguoiDung VARCHAR(50) PRIMARY KEY,
    tenDangNhap VARCHAR(50) NOT NULL UNIQUE,
    matKhau VARCHAR(255) NOT NULL
);

CREATE TABLE NhanVien (
    maNhanVien VARCHAR(50) PRIMARY KEY,
    maNguoiDung VARCHAR(50) UNIQUE,
    caLamViec VARCHAR(50),
    FOREIGN KEY (maNguoiDung) REFERENCES NguoiDung(maNguoiDung)
);

CREATE TABLE QuanTriVien (
    maNguoiDung VARCHAR(50) PRIMARY KEY,
    viTri VARCHAR(100),
    FOREIGN KEY (maNguoiDung) REFERENCES NguoiDung(maNguoiDung)
);

CREATE TABLE KhachHang (
    maKhachHang VARCHAR(50) PRIMARY KEY,
    tenKhachHang VARCHAR(100)
);

CREATE TABLE TheXe (
    maThe VARCHAR(50) PRIMARY KEY,
    trangThai VARCHAR(50),
    loaiThe VARCHAR(50),
    maKhachHang VARCHAR(50),
    FOREIGN KEY (maKhachHang) REFERENCES KhachHang(maKhachHang)
);

CREATE TABLE PhuongTien (
    bienSo VARCHAR(20) PRIMARY KEY,
    mauSac VARCHAR(50),
    hangXe VARCHAR(50),
    maThe VARCHAR(50),
    FOREIGN KEY (maThe) REFERENCES TheXe(maThe)
);

CREATE TABLE Oto (
    bienSo VARCHAR(20) PRIMARY KEY,
    soChoNgoi INT,
    dungTichDongCo VARCHAR(50),
    FOREIGN KEY (bienSo) REFERENCES PhuongTien(bienSo)
);

CREATE TABLE XeMay (
    bienSo VARCHAR(20) PRIMARY KEY,
    dungTichXiLanh INT,
    coHopSoTuDong BOOLEAN,
    FOREIGN KEY (bienSo) REFERENCES PhuongTien(bienSo)
);

CREATE TABLE GiaoDich (
    maGiaoDich VARCHAR(50) PRIMARY KEY,
    thoiGianVao DATETIME,
    thoiGianRa DATETIME,
    phiDoXe DECIMAL(10, 2),
    trangThaiThanhToan VARCHAR(50),
    maMucGiaApDung VARCHAR(50),
    maThe VARCHAR(50),
    maNhanVien VARCHAR(50),
    maViTri VARCHAR(50),
    FOREIGN KEY (maMucGiaApDung) REFERENCES BangGia(maMucGia),
    FOREIGN KEY (maThe) REFERENCES TheXe(maThe),
    FOREIGN KEY (maNhanVien) REFERENCES NhanVien(maNhanVien),
    FOREIGN KEY (maViTri) REFERENCES ViTriDo(maViTri)
);