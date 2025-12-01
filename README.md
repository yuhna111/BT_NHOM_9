# 🅿️ Hệ Thống Quản Lý Bãi Đỗ Xe

## 📝 Giới Thiệu Dự Án
**Hệ thống Quản lý Bãi đỗ xe** là một ứng dụng desktop toàn diện được xây dựng bằng **Java Swing**, nhằm mục đích tự động hóa các quy trình check-in, check-out và tính phí trong bãi đỗ.

Dự án áp dụng mô hình kiến trúc **đa tầng (Multi-Tier Architecture)** bao gồm **Service Layer** và **Repository Pattern** để đảm bảo tính module hóa, dễ kiểm thử (Testability) và dễ mở rộng.

| Thuộc tính             | Chi tiết                                      |
|------------------------|-----------------------------------------------|
| **Ngôn ngữ lập trình** | Java (OOP)                                    |
| **Giao diện**          | Java Swing / AWT (Ứng dụng Desktop)           |
| **Cơ sở dữ liệu**      | MySQL Server 8.0+                             |
| **Kiến trúc**          | Service Layer + Repository Pattern (3 Tầng Logic) |
| **Phương pháp phát triển** | Sử dụng Dependency Injection (qua Constructor) cho các Service |

---

## 🎯 Tính Năng Chính

### 👨‍💼 Module Nhân Viên (`NhanVienForm`)
Tập trung vào quy trình xử lý xe ra/vào hằng ngày.

- **Ghi nhận Xe Vào (Check-in):**
  - Nhập Biển số xe và Mã thẻ xe (`TheXe`).
  - Tự động kiểm tra và gán `ViTriDo` phù hợp với loại xe (Ô tô, Xe máy).
  - Lưu thông tin `ThoiGianVao` vào đối tượng `GiaoDich`.

- **Tính Phí & Thanh Toán (Check-out):**
  - Truy vấn `GiaoDich` đang hoạt động theo Biển số xe.
  - Tự động tính `PhiDoXe` dựa trên chênh lệch thời gian đỗ và `BangGia` hiện tại.
  - Cập nhật trạng thái `TrangThaiThanhToan` và `ThoiGianRa`.

- **Quản lý trạng thái Bãi đỗ:**
  - Hiển thị danh sách các `GiaoDich` đang hoạt động theo thời gian thực.

### 👑 Module Quản Trị Viên (`QuanTriForm`)
Tập trung vào quản lý hệ thống và báo cáo.

- **Quản lý Bảng Giá:**
  - CRUD (Create, Read, Update, Delete) các quy tắc tính phí trong `BangGia`.

- **Quản lý Tài Khoản:**
  - Quản lý thông tin và tài khoản đăng nhập của các `NhanVien`.

- **Báo Cáo Doanh Thu:**
  - Xem tổng hợp doanh thu theo các tiêu chí (Ngày/Tháng/Năm).
  - Thống kê số lượng xe đã xử lý theo từng loại xe.

---

## 💻 Yêu Cầu Hệ Thống & Công Nghệ

| Thành phần            | Yêu cầu/Phiên bản         | Chi tiết                                      |
|------------------------|----------------------------|-----------------------------------------------|
| **Java Development**   | JDK 17+                   | Sử dụng các tính năng hiện đại (ví dụ: `LocalDateTime`) |
| **Database**           | MySQL Server 8.0+         | Hỗ trợ cấu trúc schema và indexing           |
| **Kết nối**            | MySQL JDBC Driver         | Cần thêm vào Project Library/Dependencies    |
| **IDE**                | NetBeans, IntelliJ IDEA, hoặc Eclipse | Khuyến nghị dùng IDE hỗ trợ Swing Designer |

---

## 📂 Cấu Trúc Dự Án (Project Structure)
```text
src/
├── Java/
│   ├── model/
│   ├── repository/
│   ├── service/
│   │   └── impl/
│   ├── config/
│   └── gui/
└── Main/
```

### 1. 📦 `Java.model` – Tầng Model (Entity)
Chứa các lớp Entity (POJO) ánh xạ trực tiếp từ các bảng DB và UML.  
**Files:**  
- `GiaoDich.java`  
- `TheXe.java`  
- `PhuongTien.java`  
- `Oto.java`, `XeMay.java`  
- `NhanVien.java`, `QuanTriVien.java`, `NguoiDung.java`  
- `BangGia.java`  
- `ViTriDo.java`, `KhuVuc.java`, `BaiDo.java`  
- `KhachHang.java`

### 2. 💾 `Java.repository` – Tầng Repository / DAO
Chứa các Data Access Object xử lý giao tiếp DB bằng JDBC.  
**Files:**  
- `GiaoDichRepository.java`
- `BaiDoRepository.java`  
- `TheXeRepository.java`  
- `NhanVienRepository.java`  
- `BangGiaRepository.java`  
- `ViTriDoRepository.java`, v.v.

### 3. 💼 `Java.service` – Tầng Service (Logic nghiệp vụ)
Định nghĩa và triển khai logic nghiệp vụ. 
**Files:**  
- `GiaoDichService.java` 
- `GiaoDichServiceImpl.java`  
- `NhanVienService.java`
- `NhanVienServiceImpl.java`  
- `QuanTriService.java`
- `QuanTriServiceImpl.java`  
- `TheXeService.java`  
- `TheXeServiceImpl.java` 

### 4. ⚙️ `Java.config`
- `DBConnectionUtil.java` – Quản lý kết nối cơ sở dữ liệu

### 5. 🖥️ `Java.gui` – Tầng Presentation (UI/Controller)
Chứa các lớp giao diện Java Swing và xử lý sự kiện người dùng.  
**Files:**  
- `LoginFrame.java`  
- `MainFrame.java`  
- `GiaoDichListPanel.java`  
- `TaoGiaoDichPanel.java`
- `ViTriTrongPanel.java`

### 6. ▶️ `Java.Main` – Lớp Khởi chạy chính
- `MainApp.java` – Khởi tạo Service và chạy `LoginFrame`

---

## ⚙️ Cài Đặt & Setup

### 1. Cấu Hình Database
- Cài đặt **MySQL Server 8.0+**.
- Tạo một database mới (ví dụ: `quanlybaidoxe`).
- Thực thi các script SQL:
  - `mysql_schema.sql`: Chứa lệnh tạo bảng.
  - `insert_data.sql`: Chứa dữ liệu mẫu (admin, nv1, bảng giá).
- Cập nhật file `Java.config.DBConnectionUtil.java` với các thông tin kết nối chính xác (URL, User, Password).

### 2. Chạy Ứng Dụng
- Thêm thư viện **MySQL JDBC Connector** (JAR file) vào Project Library.
- Mở dự án trong IDE (NetBeans/IntelliJ).
- Chạy lớp `MainApp.java` (Chứa phương thức `public static void main(String[] args)`).

---

## 🔑 Hướng Dẫn Đăng Nhập (Dữ Liệu Mẫu)

| Vai trò           | Tên đăng nhập | Mật khẩu | Màn hình truy cập |
|-------------------|---------------|----------|-------------------|
| Nhân Viên         | `nv1`         | `123`    | `NhanVienForm`    |
| Quản Trị Viên     | `admin`       | `admin`  | `QuanTriForm`     |

---

## 👥 Đóng Góp & Liên Hệ

### 📋 Thành Viên Nhóm

| STT | Mã Sinh Viên | Họ và Tên           | Vai Trò Chính                     |
|-----|--------------|---------------------|-----------------------------------|
| 1   | B23DCVT209   | Nguyễn An Huy       | 👑 Nhóm Trưởng / Back-end + DB    |
| 2   | B23DCVT041   | Hồ Trọng Bách       | 💻 Lập trình viên Back-end        |
| 3   | B23DCCN253   | Chu Ngọc Giang      | 💻 Lập trình viên Back-end        |
| 4   | B23DCDT001   | Lê Hữu Trường An    | 🎨 Lập trình viên Front-end (UI)  |
| 5   | B23DCVT257   | Nguyễn Thành Long   | 🎨 Lập trình viên Front-end (UI)  |

---

## 💡 Nguyên Tắc Thiết Kế & Troubleshooting

| Nguyên tắc               | Mô tả chi tiết |
|--------------------------|----------------|
| **Dependency Injection** | Các tầng GUI (Form) chỉ tương tác với các tầng Service thông qua Constructor (ví dụ: `new LoginForm(service)`), không tự tạo Service bên trong. |
| **Kiểu dữ liệu Thời gian** | Sử dụng `java.time.LocalDateTime` thay cho `java.util.Date` hoặc `Timestamp` để xử lý thời gian chính xác và hiện đại hơn. |

### 🛠️ Các Lỗi Thường Gặp

- **`UnsupportedOperationException: Not supported yet.`**  
  → Xảy ra khi gọi constructor mặc định (không tham số) do IDE tự sinh.  
  **Giải pháp**: Xóa hoặc sửa constructor mặc định, chỉ sử dụng constructor có tham số Service.

---

## 📜 Giấy Phép (License)
Dự án này được cấp phép theo Giấy phép **MIT**.

> Bạn được phép sử dụng, sửa đổi và phân phối lại mã nguồn.
