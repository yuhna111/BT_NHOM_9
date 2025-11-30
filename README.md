# 🅿️ HỆ THỐNG QUẢN LÝ BÃI ĐỖ XE 





## 📝 GIỚI THIỆU DỰ ÁN (Project Overview)

**Hệ thống Quản lý Bãi đỗ xe** là một ứng dụng desktop toàn diện được xây dựng bằng **Java Swing**, nhằm mục đích tự động hóa các quy trình check-in, check-out, và tính phí trong bãi đỗ.

Dự án áp dụng mô hình kiến trúc **đa tầng (Multi-Tier Architecture)** bao gồm **Service Layer** và **Repository Pattern** để đảm bảo tính module hóa, dễ kiểm thử (Testability) và dễ mở rộng.

| Thuộc tính | Chi tiết |
| :--- | :--- |
| **Ngôn ngữ lập trình** | Java (OOP) |
| **Giao diện** | Java Swing / AWT (Ứng dụng Desktop) |
| **Cơ sở dữ liệu** | MySQL Server 8.0+ |
| **Kiến trúc** | Service Layer + Repository Pattern (3 Tầng Logic) |
| **Phương pháp phát triển** | Sử dụng Dependency Injection (qua Constructor) cho các Service. |

---

## 🎯 TÍNH NĂNG CHÍNH (Key Features)

### 👨‍💼 Module Nhân Viên (NhanVienForm)
Tập trung vào quy trình xử lý xe ra/vào hằng ngày.

1.  **Ghi nhận Xe Vào (Check-in):**
    * Nhập Biển số xe và Mã thẻ xe (**TheXe**).
    * Tự động kiểm tra và gán **ViTriDo** phù hợp với **LoaiXe** (Ô tô, Xe máy).
    * Lưu thông tin **ThoiGianVao** vào đối tượng **GiaoDich**.
2.  **Tính Phí & Thanh Toán (Check-out):**
    * Truy vấn **GiaoDich** đang hoạt động theo Biển số xe.
    * Tự động tính **PhiDoXe** dựa trên chênh lệch thời gian đỗ và **BangGia** hiện tại.
    * Cập nhật trạng thái **TrangThaiThanhToan** và **ThoiGianRa**.
3.  **Quản lý trạng thái Bãi đỗ:**
    * Hiển thị danh sách các **GiaoDich** đang hoạt động theo thời gian thực.

### 👑 Module Quản Trị Viên (QuanTriForm)
Tập trung vào quản lý hệ thống và báo cáo.

1.  **Quản lý Bảng Giá:**
    * CRUD (Create, Read, Update, Delete) các quy tắc tính phí trong **BangGia**.
2.  **Quản lý Tài Khoản:**
    * Quản lý thông tin và tài khoản đăng nhập của các **NhanVien**.
3.  **Báo Cáo Doanh Thu:**
    * Xem tổng hợp doanh thu theo các tiêu chí (Ngày/Tháng/Năm).
    * Thống kê số lượng xe đã xử lý theo từng **LoaiXe**.

---

## 💻 YÊU CẦU HỆ THỐNG & CÔNG NGHỆ

| Thành phần | Yêu cầu/Phiên bản | Chi tiết |
| :--- | :--- | :--- |
| **Java Development** | JDK 17+ | Sử dụng các tính năng hiện đại của Java (như `LocalDateTime`). |
| **Database** | MySQL Server 8.0+ | Hỗ trợ cấu trúc schema và indexing. |
| **Kết nối** | MySQL JDBC Driver | Cần thêm vào Project Library/Dependencies. |
| **IDE** | NetBeans, IntelliJ IDEA, hoặc Eclipse | Khuyến nghị sử dụng IDE có hỗ trợ Swing Designer. |

---

## 📂 CẤU TRÚC DỰ ÁN (Project Structure)

src/ └── com/parking/ 
├── model/ # 1. Tầng Model (Entity) 
├── repository/ # 2. Tầng Repository/DAO 
├── service/ # 3. Tầng Service (Logic nghiệp vụ) 
└── util/ # Tầng Hỗ trợ/Tiện ích └── gui/ # 4. Tầng Presentation (UI/Controller) 
└── Main/ # 5. Lớp Khởi chạy chính

### 1. 📦 `com.parking.model` (Tầng Model - Entities)
* Chứa các lớp **Entity (POJO)** ánh xạ trực tiếp từ các bảng DB và UML.
* **Files:** `GiaoDich.java`, `TheXe.java`, `PhuongTien.java`, `NhanVien.java`, `BangGia.java`, `ViTriDo.java`, `LoaiXe.java`.

### 2. 💾 `com.parking.repository` (Tầng Repository / DAO)
* Chứa các **Data Access Object** xử lý giao tiếp DB bằng JDBC.
* **Files:** `GiaoDichDao.java`, `TheXeDao.java`, `NhanVienDao.java`, `BangGiaDao.java`, v.v. (bao gồm Interface và Implementation - `...DaoImpl`).

### 3. 💼 `com.parking.service` (Tầng Service - Business Logic)
* Định nghĩa và triển khai logic nghiệp vụ (ví dụ: `kiemTraXeVao()`, `tinhPhi()`).
* **Files:** `GiaoDichService.java` (Interface), `GiaoDichServiceImpl.java`, **`MockGiaoDichService.java`** (dùng cho môi trường dev), `QuanTriService.java`.

### 4. 🖥️ `gui` (Tầng Presentation - UI/Controller)
* Chứa các lớp giao diện Java Swing và xử lý sự kiện người dùng.
* **Files:** **`LoginForm.java`**, **`NhanVienForm.java`**, **`QuanTriForm.java`**, `BaoCaoForm.java`.

### 5. ▶️ `Main` (Lớp Khởi chạy)
* Điểm khởi động ứng dụng.
* **Files:** `MainApp.java` (Khởi tạo Service và chạy `LoginForm`).

---

## ⚙️ CÀI ĐẶT & SETUP

### 1. Cấu Hình Database
1.  **Cài đặt MySQL Server 8.0+**.
2.  Tạo một database mới (ví dụ: `quanlybaidoxe`).
3.  Thực thi các script SQL:
    * `mysql_schema.sql`: Chứa lệnh tạo bảng.
    * `insert_data.sql`: Chứa dữ liệu mẫu (admin, nv1, bảng giá).
4.  Cập nhật file **`com.parking.util.DatabaseUtil.java`** với các thông tin kết nối chính xác (URL, User, Password).

### 2. Chạy Ứng Dụng
1.  Thêm thư viện **MySQL JDBC Connector** (JAR file) vào Project Library.
2.  Mở dự án trong IDE (NetBeans/IntelliJ).
3.  Chạy lớp `MainApp.java` (Chứa phương thức `public static void main(String[] args)`).

---

## 🔑 HƯỚNG DẪN ĐĂNG NHẬP (Dữ liệu mẫu)

| Vai trò | Tên đăng nhập | Mật khẩu | Màn hình truy cập |
| :--- | :--- | :--- | :--- |
| **Nhân Viên** | `nv1` | `123` | NhanVienForm |
| **Quản Trị Viên** | `admin` | `admin` | QuanTriForm |

---

## 👥 ĐÓNG GÓP & LIÊN HỆ (Contribution & Contact)

Phần này liệt kê các thành viên đã tham gia phát triển dự án.

### 📋 Thành viên nhóm

| STT | Mã Sinh Viên | Họ và Tên | Vai Trò Chính |
| :--- | :--- | :--- | :--- |
| **1** | **B23DCVT209** | **Nguyễn An Huy** | **👑 Nhóm Trưởng / Back-end + database** |
| 2 | B23DCVT041 | Hồ Trọng Bách | 💻 Lập trình viên Back-end |
| 3 | B23DCVT041 | Chu Ngọc Giang | 💻 Lập trình viên Back-end |
| 4 | B23DCDT001 | Lê Hữu Trường An | 🎨 Lập trình viên Front-end (UI) |
| 5 | B23DCVT257 | Nguyễn Thành Long | 🎨 Lập trình viên Front-end (UI) |

---

## 💡 NGUYÊN TẮC THIẾT KẾ & TROUBLESHOOTING

| Nguyên tắc | Mô tả chi tiết |
| :--- | :--- |
| **Dependency Injection** | Các tầng GUI (Form) **chỉ** tương tác với các tầng Service thông qua **Constructor** (ví dụ: `new LoginForm(service)`), không tự tạo Service bên trong. |
| **Lớp Mock** | Sử dụng **`MockGiaoDichService`** để tách biệt việc phát triển UI khỏi Database thật, giúp tăng tốc độ phát triển và dễ kiểm thử. |
| **Kiểu dữ liệu Thời gian** | Sử dụng **`java.time.LocalDateTime`** thay cho `java.util.Date` hoặc `Timestamp` để xử lý thời gian chính xác và hiện đại hơn. |

### 🛠️ Các Lỗi Thường Gặp
* **`UnsupportedOperationException: Not supported yet.`**: Xảy ra khi gọi constructor mặc định (không tham số) do IDE tự sinh. **Giải pháp:** Xóa hoặc sửa constructor mặc định, chỉ sử dụng constructor có tham số Service.
* **`Cannot convert MockService to RealService`**: Xảy ra khi một Form yêu cầu `GiaoDichService` nhưng lại được truyền vào `MockGiaoDichService`. **Giải pháp:** Cần sửa **Constructor** và **Field** của Form đó (ví dụ: `QuanTriForm.java`) để chấp nhận kiểu `MockService`.

---

## 📜 GIẤY PHÉP (License)

Dự án này được cấp phép theo Giấy phép **MIT**.

*Bạn được phép sử dụng, sửa đổi và phân phối lại mã nguồn.*
