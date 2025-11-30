package gui;

import com.parking.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NhanVienForm extends javax.swing.JFrame {

    private BaiDo baiDo;
    private Map<String, KhuVuc> khuVucMap = new HashMap<>();
    private KhachHang khachHangLe;
    private TheXe theLe;
    private NhanVien nhanVien;
    private GiaoDich giaoDichHienTai;
    private ViTriDo viTriHienTai;
    private List<GiaoDich> danhSachGiaoDichDangHoatDong = new ArrayList<>();
    private DefaultTableModel tableModel;
    private JLabel lblSucChuaTitle;  
    private JLabel lblXeMayCount;    
    private JLabel lblOtoCount;     

 
    public static BaiDo baiDoStatic;
    public static List<GiaoDich> danhSachGiaoDichDangHoatDongStatic = new ArrayList<>();

   
    private JTextField txtTimKiem;
    private JButton btnTimKiem;
    private JButton btnHienTatCa;

    public NhanVienForm() {
        khoiTaoDuLieu();
        initComponents();
        setLocationRelativeTo(null);
     
        NhanVienForm.baiDoStatic = this.baiDo;
        NhanVienForm.danhSachGiaoDichDangHoatDongStatic = this.danhSachGiaoDichDangHoatDong;
    }

    private void khoiTaoDuLieu() {
        giaoDichHienTai = null;
        viTriHienTai = null;
        danhSachGiaoDichDangHoatDong.clear();
        
        if (baiDo == null) {
            baiDo = new BaiDo("BD01", 20);
            KhuVuc kvXeMay = new KhuVuc("KVXM", "Khu Xe Máy");
            KhuVuc kvOto = new KhuVuc("KVO", "Khu Ô Tô");
            baiDo.addKhuVuc(kvXeMay);
            baiDo.addKhuVuc(kvOto);
            khuVucMap.put("XEMAY", kvXeMay);
            khuVucMap.put("OTO", kvOto);

            for (int i = 1; i <= 10; i++) {
                kvXeMay.addViTri(new ViTriDo("XM" + i, "XEMAY"));
                kvOto.addViTri(new ViTriDo("OT" + i, "OTO"));
            }

            khachHangLe = new KhachHang("KH00", "Khách vãng lai");
            theLe = khachHangLe.dangKiTheXe("TLE");
            nhanVien = new NhanVien("ND01", "nv1", "123", "NV01", "Ca Sáng");
            tableModel = new DefaultTableModel(new Object[]{"Biển số", "Loại xe", "Vị trí", "Giờ vào"}, 0);
        }
    }

    private void initComponents() {
        setTitle("NHÂN VIÊN - QUẢN LÝ XE RA/VÀO");
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("NHẬP/XUẤT XE", JLabel.LEFT);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0x0057AD));
        titleLabel.setBounds(20, 10, 250, 30);

        btnDangXuat = new JButton("Đăng xuất");
        btnDangXuat.setBounds(450, 10, 100, 30);
        btnDangXuat.setBackground(new Color(0x0057AD));
        btnDangXuat.setForeground(Color.WHITE);
        btnDangXuat.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnDangXuat.setFocusPainted(false);
        btnDangXuat.setBorderPainted(false);
        btnDangXuat.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnDangXuat.addActionListener(evt -> {
            new LoginForm().setVisible(true);
            this.dispose();
        });

        JLabel lblBienSo = new JLabel("Biển số:");
        lblBienSo.setBounds(20, 60, 80, 25);
        txtBienSo = new JTextField();
        txtBienSo.setBounds(110, 60, 150, 25);
        txtBienSo.setBorder(BorderFactory.createLineBorder(new Color(0x0057AD), 1));

        JLabel lblLoaiXe = new JLabel("Loại xe:");
        lblLoaiXe.setBounds(280, 60, 80, 25);
        cmbLoaiXe = new JComboBox<>(new String[]{"XEMAY", "OTO"});
        cmbLoaiXe.setBounds(370, 60, 120, 25);
        cmbLoaiXe.setBorder(BorderFactory.createLineBorder(new Color(0x0057AD), 1));

        btnNhapXe = new JButton("NHẬP XE");
        btnNhapXe.setBounds(20, 100, 120, 35);
        btnNhapXe.setBackground(new Color(0x0057AD));
        btnNhapXe.setForeground(Color.WHITE);
        btnNhapXe.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnNhapXe.setFocusPainted(false);
        btnNhapXe.setBorderPainted(false);
        btnNhapXe.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNhapXe.addActionListener(evt -> btnNhapXeActionPerformed(evt));

        btnXuatXe = new JButton("XUẤT XE");
        btnXuatXe.setBounds(160, 100, 120, 35);
        btnXuatXe.setBackground(new Color(0xFBDA0C));
        btnXuatXe.setForeground(new Color(0x333333));
        btnXuatXe.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnXuatXe.setFocusPainted(false);
        btnXuatXe.setBorderPainted(false);
        btnXuatXe.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnXuatXe.addActionListener(evt -> btnXuatXeActionPerformed(evt));

        btnThanhToan = new JButton("THANH TOÁN");
        btnThanhToan.setBounds(300, 100, 120, 35);
        btnThanhToan.setBackground(new Color(0x28A745));
        btnThanhToan.setForeground(Color.WHITE);
        btnThanhToan.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnThanhToan.setFocusPainted(false);
        btnThanhToan.setBorderPainted(false);
        btnThanhToan.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnThanhToan.addActionListener(evt -> btnThanhToanActionPerformed(evt));

        JLabel lblViTriStatic = new JLabel("Vị trí:");
        lblViTriStatic.setBounds(20, 150, 60, 20);
        this.lblViTri = new JLabel("Chưa có");
        this.lblViTri.setBounds(80, 150, 100, 20);

        JLabel lblVaoStatic = new JLabel("Vào:");
        lblVaoStatic.setBounds(20, 180, 60, 20);
        this.lblThoiGianVao = new JLabel("Chưa có");
        this.lblThoiGianVao.setBounds(80, 180, 200, 20);

        JLabel lblRaStatic = new JLabel("Ra:");
        lblRaStatic.setBounds(20, 210, 60, 20);
        this.lblThoiGianRa = new JLabel("Chưa có");
        this.lblThoiGianRa.setBounds(80, 210, 200, 20);

        JLabel lblPhiStatic = new JLabel("Phí:");
        lblPhiStatic.setBounds(20, 240, 60, 20);
        this.lblPhi = new JLabel("0 VNĐ");
        this.lblPhi.setBounds(80, 240, 100, 20);

         
        lblSucChuaTitle = new JLabel("Số xe trong bãi:");
        lblSucChuaTitle.setBounds(300, 150, 120, 20);
        
        lblXeMayCount = new JLabel("Xe máy: 0/10");
        lblXeMayCount.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblXeMayCount.setForeground(new Color(0x17a2b8));
        lblXeMayCount.setBounds(420, 150, 120, 20);
        
        lblOtoCount = new JLabel("Ô tô: 0/10");
        lblOtoCount.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblOtoCount.setForeground(new Color(0x17a2b8));
        lblOtoCount.setBounds(420, 175, 120, 20); // Y tăng 25px để xuống dòng

        capNhatSucChua();  

        tblXeDangDo = new JTable(tableModel);
        tblXeDangDo.getTableHeader().setBackground(new Color(0x0057AD));
        tblXeDangDo.getTableHeader().setForeground(Color.WHITE);
        tblXeDangDo.setSelectionBackground(new Color(0xFBDA0C));
        tblXeDangDo.setSelectionForeground(new Color(0x333333));
        tblXeDangDo.setRowHeight(25);
        tblXeDangDo.setEnabled(true);

        tblXeDangDo.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (!evt.getValueIsAdjusting() && tblXeDangDo.getSelectedRow() != -1) {
                    int selectedRow = tblXeDangDo.getSelectedRow();
                    if (selectedRow < danhSachGiaoDichDangHoatDong.size()) {
                        GiaoDich selectedGiaoDich = danhSachGiaoDichDangHoatDong.get(selectedRow);
                        giaoDichHienTai = selectedGiaoDich;
                        viTriHienTai = selectedGiaoDich.getViTriDo();
                        
                        
                        NhanVienForm.this.lblViTri.setText(viTriHienTai != null ? viTriHienTai.getMaViTri() : "Chưa có");
                        NhanVienForm.this.lblThoiGianVao.setText(
                            giaoDichHienTai.getThoiGianVao().format(
                                DateTimeFormatter.ofPattern("HH:mm dd/MM")
                            )
                        );
                        
                        if (giaoDichHienTai.getThoiGianRa() != null) {
                            NhanVienForm.this.lblThoiGianRa.setText(
                                giaoDichHienTai.getThoiGianRa().format(
                                    DateTimeFormatter.ofPattern("HH:mm dd/MM")
                                )
                            );
                            NhanVienForm.this.lblPhi.setText(String.format("%.0f VNĐ", giaoDichHienTai.getPhiDoXe()));
                        } else {
                            NhanVienForm.this.lblThoiGianRa.setText("Chưa có");
                            NhanVienForm.this.lblPhi.setText("0 VNĐ");
                        }
                    }
                    revalidate();
                    repaint();
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(tblXeDangDo);
        scrollPane.setBounds(20, 280, 530, 120);

        
        JLabel lblTimKiem = new JLabel("Tìm biển số:");
        lblTimKiem.setBounds(20, 410, 80, 25);
        txtTimKiem = new JTextField();
        txtTimKiem.setBounds(110, 410, 150, 25);
        txtTimKiem.setBorder(BorderFactory.createLineBorder(new Color(0x0057AD), 1));

        btnTimKiem = new JButton("TÌM KIẾM");
        btnTimKiem.setBounds(270, 410, 100, 25);
        btnTimKiem.setBackground(new Color(0x17A2B8)); // Xanh cyan
        btnTimKiem.setForeground(Color.WHITE);
        btnTimKiem.setFont(new Font("Segoe UI", Font.BOLD, 11));
        btnTimKiem.setFocusPainted(false);
        btnTimKiem.setBorderPainted(false);
        btnTimKiem.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnTimKiem.addActionListener(evt -> timKiemXe());

         
        btnHienTatCa = new JButton("HIỂN THỊ TẤT CẢ");
        btnHienTatCa.setBounds(380, 410, 140, 25); // Tăng width từ 120 → 140
        btnHienTatCa.setBackground(new Color(0x6C757D)); // Xám
        btnHienTatCa.setForeground(Color.WHITE);
        btnHienTatCa.setFont(new Font("Segoe UI", Font.BOLD, 11));
        btnHienTatCa.setFocusPainted(false);
        btnHienTatCa.setBorderPainted(false);
        btnHienTatCa.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnHienTatCa.addActionListener(evt -> hienThiTatCa());

        add(titleLabel);
        add(btnDangXuat);
        add(lblBienSo);
        add(txtBienSo);
        add(lblLoaiXe);
        add(cmbLoaiXe);
        add(btnNhapXe);
        add(btnXuatXe);
        add(btnThanhToan);
        add(lblViTriStatic);
        add(this.lblViTri);
        add(lblVaoStatic);
        add(this.lblThoiGianVao);
        add(lblRaStatic);
        add(this.lblThoiGianRa);
        add(lblPhiStatic);
        add(this.lblPhi);
        add(lblSucChuaTitle);
        add(lblXeMayCount);
        add(lblOtoCount);
        add(scrollPane);
        add(lblTimKiem);
        add(txtTimKiem);
        add(btnTimKiem);
        add(btnHienTatCa);

        setLayout(null);
        setSize(580, 545);  
    }

    private void btnNhapXeActionPerformed(java.awt.event.ActionEvent evt) {
        String bienSo = txtBienSo.getText().trim();
        String loai = (String) cmbLoaiXe.getSelectedItem();

        if (bienSo.isEmpty()) {
            showCustomMessage("Vui lòng nhập biển số xe!");
            return;
        }

        KhuVuc khu = khuVucMap.get(loai);
        viTriHienTai = khu.timViTriTrong(loai);

        if (viTriHienTai == null) {
            showCustomMessage("Không còn chỗ trống cho loại xe này!");
            return;
        }

        PhuongTien pt;
        if ("XEMAY".equals(loai)) {
            pt = new XeMay(bienSo, "Không rõ", "Không rõ", 150, true);
        } else {
            pt = new Oto(bienSo, "Không rõ", "Không rõ", 5, "1.5L");
        }
        pt.lienKetThe(theLe);

        BangGia bg = new BangGia("BG1", loai, loai.equals("XEMAY") ? 2000 : 10000);
        giaoDichHienTai = nhanVien.taoGiaoDichMoi("GD" + System.currentTimeMillis(), pt, theLe, bg);
        giaoDichHienTai.batDauGiaoDich();
        giaoDichHienTai.setViTriDo(viTriHienTai);

        viTriHienTai.datTrangThai("DA_DO");
        baiDo.capNhatSucChua(1);
        danhSachGiaoDichDangHoatDong.add(giaoDichHienTai);
        capNhatBangXeDangDo();
        capNhatSucChua();  

        
        this.lblViTri.setText(viTriHienTai.getMaViTri());
        this.lblThoiGianVao.setText(giaoDichHienTai.getThoiGianVao().format(DateTimeFormatter.ofPattern("HH:mm dd/MM")));
        
        txtBienSo.setText("");
        showCustomMessage("Nhập xe thành công!");
    }

    private void btnXuatXeActionPerformed(java.awt.event.ActionEvent evt) {
        if (giaoDichHienTai == null) {
            showCustomMessage("Chưa chọn xe cần xuất!");
            return;
        }

        if (giaoDichHienTai.getThoiGianRa() != null) {
            showCustomMessage("Xe này đã được xuất rồi!");
            return;
        }

        nhanVien.xuLyKetThucGiaoDich(giaoDichHienTai);
        double phi = giaoDichHienTai.tinhPhiDoXe();

         
        this.lblThoiGianRa.setText(
            giaoDichHienTai.getThoiGianRa().format(
                DateTimeFormatter.ofPattern("HH:mm dd/MM")
            )
        );
        this.lblPhi.setText(String.format("%.0f VNĐ", phi));
        capNhatBangXeDangDo();
        capNhatSucChua();  
        showCustomMessage("Đã kết thúc giao dịch. Vui lòng thanh toán!");
    }

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {
        if (giaoDichHienTai == null || 
            "DA_THANH_TOAN".equals(giaoDichHienTai.getTrangThaiThanhToan())) {
            showCustomMessage("Không có giao dịch cần thanh toán!");
            return;
        }

        if (giaoDichHienTai.getThoiGianRa() == null) {
            showCustomMessage("Vui lòng xuất xe trước khi thanh toán!");
            return;
        }

        double phi = giaoDichHienTai.getPhiDoXe();
        giaoDichHienTai.thanhToan();
        viTriHienTai.datTrangThai("TRONG");
        baiDo.capNhatSucChua(-1);
        
        danhSachGiaoDichDangHoatDong.remove(giaoDichHienTai);
        capNhatBangXeDangDo();
        capNhatSucChua(); // Cập nhật sức chứa

       
        this.lblViTri.setText("Chưa có");
        this.lblThoiGianVao.setText("Chưa có");
        this.lblThoiGianRa.setText("Chưa có");
        this.lblPhi.setText("0 VNĐ");

        QuanTriForm.tongDoanhThu += phi;
        QuanTriForm.tongSoXeDaXuLy++;
        
        giaoDichHienTai = null;
        viTriHienTai = null;
        
        showCustomMessage("Đã thanh toán thành công!");
    }

    private void capNhatBangXeDangDo() {
        tableModel.setRowCount(0);
        for (GiaoDich gd : danhSachGiaoDichDangHoatDong) {
            if (gd == null) continue;
             
            if (gd.getThoiGianRa() == null) {
                String bienSo = gd.getPhuongTien().getBienSo();
                String loai = (gd.getPhuongTien() instanceof Oto) ? "OTO" : "XEMAY";
                String viTri = gd.getViTriDo() != null ? gd.getViTriDo().getMaViTri() : "—";
                String gioVao = gd.getThoiGianVao().format(DateTimeFormatter.ofPattern("HH:mm dd/MM"));
                tableModel.addRow(new Object[]{bienSo, loai, viTri, gioVao});
            }
        }
    }

     
    private void capNhatSucChua() {
        int xeMayCount = 0;
        int otoCount = 0;
        
        for (GiaoDich gd : danhSachGiaoDichDangHoatDong) {
            if (gd.getThoiGianRa() == null) {
                if (gd.getPhuongTien() instanceof XeMay) {
                    xeMayCount++;
                } else if (gd.getPhuongTien() instanceof Oto) {
                    otoCount++;
                }
            }
        }
        
         
        lblXeMayCount.setText(String.format("Xe máy: %d/10", xeMayCount));
        lblOtoCount.setText(String.format("Ô tô: %d/10", otoCount));
        
         
        int hienTai = xeMayCount + otoCount;
        int tong = 20; 
        
        if (hienTai <= tong * 0.6) {
            lblXeMayCount.setForeground(new Color(0x28a745));  
            lblOtoCount.setForeground(new Color(0x28a745)); 
        } else if (hienTai <= tong * 0.8) {
            lblXeMayCount.setForeground(new Color(0xffc107));  
            lblOtoCount.setForeground(new Color(0xffc107)); 
        } else {
            lblXeMayCount.setForeground(new Color(0xdc3545));  
            lblOtoCount.setForeground(new Color(0xdc3545));  
        }
    }

     
    private void timKiemXe() {
        String bienSoTimKiem = txtTimKiem.getText().trim().toLowerCase();
        
        if (bienSoTimKiem.isEmpty()) {
            showCustomMessage("Vui lòng nhập biển số cần tìm!");
            return;
        }
        
 
        List<GiaoDich> ketQua = new ArrayList<>();
        
        for (GiaoDich gd : danhSachGiaoDichDangHoatDong) {
             
            if (gd.getThoiGianRa() == null) {
                String bienSoXe = gd.getPhuongTien().getBienSo().toLowerCase();
                
                if (bienSoXe.contains(bienSoTimKiem)) {
                    ketQua.add(gd);
                }
            }
        }
        
        
        tableModel.setRowCount(0);
        for (GiaoDich gd : ketQua) {
            String bienSo = gd.getPhuongTien().getBienSo();
            String loai = (gd.getPhuongTien() instanceof Oto) ? "OTO" : "XEMAY";
            String viTri = gd.getViTriDo() != null ? gd.getViTriDo().getMaViTri() : "—";
            String gioVao = gd.getThoiGianVao().format(DateTimeFormatter.ofPattern("HH:mm dd/MM"));
            tableModel.addRow(new Object[]{bienSo, loai, viTri, gioVao});
        }
        
        if (ketQua.isEmpty()) {
            showCustomMessage("Không tìm thấy xe nào với biển số này!");
        }
    }

    private void hienThiTatCa() {
        capNhatBangXeDangDo();
        txtTimKiem.setText("");
    }

 
    private void showCustomMessage(String message) {
        JDialog dialog = new JDialog(this, "Thông báo", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(320, 160);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new BorderLayout(10, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        panel.setBackground(Color.WHITE);
        
        JLabel lblMessage = new JLabel(message, JLabel.CENTER);
        lblMessage.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblMessage.setForeground(new Color(0x333333));
        
        JButton btnOK = new JButton("OK");
        btnOK.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnOK.setBackground(new Color(0x0057AD));
        btnOK.setForeground(Color.WHITE);
        btnOK.setFocusPainted(false);
        btnOK.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        btnOK.setBorderPainted(false);
        btnOK.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnOK.addActionListener(e -> dialog.dispose());
        
        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Color.WHITE);
        btnPanel.add(btnOK);
        
        panel.add(lblMessage, BorderLayout.CENTER);
        panel.add(btnPanel, BorderLayout.SOUTH);
        
        dialog.add(panel);
        dialog.setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new NhanVienForm().setVisible(true);
        });
    }

    private JTextField txtBienSo;
    private JComboBox<String> cmbLoaiXe;
    private JButton btnNhapXe;
    private JButton btnXuatXe;
    private JButton btnThanhToan;
    private JButton btnDangXuat;
    private JLabel lblViTri;
    private JLabel lblThoiGianVao;
    private JLabel lblThoiGianRa;
    private JLabel lblPhi;
    private JTable tblXeDangDo;
}