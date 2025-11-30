package gui;

import com.parking.model.*;
import service.MockGiaoDichService;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class NhanVienForm extends javax.swing.JFrame {
    private final MockGiaoDichService giaoDichService;
    private final NhanVien nhanVienDangNhap;
    private static final Logger LOGGER = Logger.getLogger(NhanVienForm.class.getName());
    private GiaoDich giaoDichHienTai;
    private ViTriDo viTriHienTai;
    private List<GiaoDich> danhSachGiaoDichDangHoatDong = new ArrayList<>();
    private DefaultTableModel tableModel;
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

    public NhanVienForm(NhanVien nv, MockGiaoDichService giaoDichService) {
        this.nhanVienDangNhap = nv;
        this.giaoDichService = giaoDichService;
        
        tableModel = new DefaultTableModel(new Object[]{"Biển số", "Loại xe", "Vị trí", "Giờ vào"}, 0);
        
        try {
            danhSachGiaoDichDangHoatDong = this.giaoDichService.layTatCaGiaoDichDangDo();
        } catch (Exception e) {
            LOGGER.severe("Lỗi kết nối CSDL khi tải giao dịch: " + e.getMessage());
        }
        
        initComponents();
        capNhatBangXeDangDo(); 
        setLocationRelativeTo(null);
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
            System.exit(0); 
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
        btnNhapXe.addActionListener(this::btnNhapXeActionPerformed);

        btnXuatXe = new JButton("XUẤT XE");
        btnXuatXe.setBounds(160, 100, 120, 35);
        btnXuatXe.setBackground(new Color(0xFBDA0C));
        btnXuatXe.setForeground(new Color(0x333333));
        btnXuatXe.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnXuatXe.setFocusPainted(false);
        btnXuatXe.setBorderPainted(false);
        btnXuatXe.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnXuatXe.addActionListener(this::btnXuatXeActionPerformed);

        btnThanhToan = new JButton("THANH TOÁN");
        btnThanhToan.setBounds(300, 100, 120, 35);
        btnThanhToan.setBackground(new Color(0x28A745));
        btnThanhToan.setForeground(Color.WHITE);
        btnThanhToan.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnThanhToan.setFocusPainted(false);
        btnThanhToan.setBorderPainted(false);
        btnThanhToan.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnThanhToan.addActionListener(this::btnThanhToanActionPerformed);

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
                            NhanVienForm.this.lblPhi.setText(String.format("%,.0f VNĐ", giaoDichHienTai.getPhiDoXe()));
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
        add(scrollPane);

        setLayout(null);
        setSize(580, 450);
    }

    private void btnNhapXeActionPerformed(ActionEvent evt) {
        String bienSo = txtBienSo.getText().trim();
        String loai = (String) cmbLoaiXe.getSelectedItem();

        if (bienSo.isEmpty()) {
            showCustomMessage("Vui lòng nhập biển số xe!");
            return;
        }

        try {
            giaoDichHienTai = giaoDichService.xuLyGuiXe(
                bienSo, 
                loai, 
                nhanVienDangNhap.getMaNhanVien() 
            );

            if (giaoDichHienTai != null) {
                viTriHienTai = giaoDichHienTai.getViTriDo();
                danhSachGiaoDichDangHoatDong = giaoDichService.layTatCaGiaoDichDangDo(); // Lấy lại danh sách mới
                capNhatBangXeDangDo();
                this.lblViTri.setText(viTriHienTai.getMaViTri());
                this.lblThoiGianVao.setText(giaoDichHienTai.getThoiGianVao().format(DateTimeFormatter.ofPattern("HH:mm dd/MM")));
                this.lblThoiGianRa.setText("Chưa có");
                this.lblPhi.setText("0 VNĐ");
                
                txtBienSo.setText("");
                showCustomMessage("Nhập xe thành công! Vị trí: " + viTriHienTai.getMaViTri());
            } else {
                showCustomMessage("Lỗi nhập xe. Có thể không còn chỗ trống hoặc dữ liệu không hợp lệ.");
            }
        } catch (Exception e) {
            LOGGER.severe("Lỗi hệ thống trong quá trình nhập xe: " + e.getMessage());
            showCustomMessage("Lỗi hệ thống trong quá trình nhập xe.");
        }
    }

    private void btnXuatXeActionPerformed(ActionEvent evt) {
        if (giaoDichHienTai == null) {
            showCustomMessage("Chưa chọn xe cần xuất!");
            return;
        }
        
        if (giaoDichHienTai.getThoiGianRa() != null) {
             showCustomMessage("Xe này đã được xuất rồi. Vui lòng thanh toán!");
             return;
        }

        try {
            GiaoDich updatedGd = giaoDichService.xuLyNhanXe(giaoDichHienTai.getMaGiaoDich());

            if (updatedGd != null) {
                giaoDichHienTai = updatedGd; 
                this.lblThoiGianRa.setText(
                    giaoDichHienTai.getThoiGianRa().format(DateTimeFormatter.ofPattern("HH:mm dd/MM"))
                );
                this.lblPhi.setText(String.format("%,.0f VNĐ", giaoDichHienTai.getPhiDoXe()));
                
                capNhatBangXeDangDo(); 
                showCustomMessage("Đã kết thúc giao dịch. Vui lòng thanh toán!");
            } else {
                showCustomMessage("Lỗi khi xử lý xuất xe.");
            }
        } catch (Exception e) {
            LOGGER.severe("Lỗi hệ thống khi xuất xe: " + e.getMessage());
            showCustomMessage("Lỗi hệ thống khi xuất xe.");
        }
    }

    private void btnThanhToanActionPerformed(ActionEvent evt) {
        if (giaoDichHienTai == null || giaoDichHienTai.getThoiGianRa() == null) {
            showCustomMessage("Vui lòng xuất xe và chọn giao dịch cần thanh toán!");
            return;
        }
        
        if ("DA_THANH_TOAN".equals(giaoDichHienTai.getTrangThaiThanhToan())) {
             showCustomMessage("Giao dịch này đã thanh toán rồi!");
             return;
        }

        try {
            boolean success = giaoDichService.thanhToanGiaoDich(giaoDichHienTai.getMaGiaoDich());

            if (success) {
                danhSachGiaoDichDangHoatDong = giaoDichService.layTatCaGiaoDichDangDo(); 
                capNhatBangXeDangDo();
                this.lblViTri.setText("Chưa có");
                this.lblThoiGianVao.setText("Chưa có");
                this.lblThoiGianRa.setText("Chưa có");
                this.lblPhi.setText("0 VNĐ");

                giaoDichHienTai = null;
                viTriHienTai = null;
                
                showCustomMessage("Đã thanh toán thành công!");
            } else {
                showCustomMessage("Thanh toán thất bại. Vui lòng thử lại.");
            }
        } catch (Exception e) {
            LOGGER.severe("Lỗi hệ thống khi thanh toán: " + e.getMessage());
            showCustomMessage("Lỗi hệ thống khi thanh toán.");
        }
    }
    
    private void capNhatBangXeDangDo() {
        tableModel.setRowCount(0);
        
        for (GiaoDich gd : danhSachGiaoDichDangHoatDong) {
            if (gd == null || gd.getPhuongTien() == null || gd.getThoiGianVao() == null) continue;
            
            String bienSo = gd.getPhuongTien().getBienSo();
            String loai = (gd.getPhuongTien() instanceof Oto) ? "OTO" : "XEMAY"; 
            String viTri = gd.getViTriDo() != null ? gd.getViTriDo().getMaViTri() : "—";
            String gioVao = gd.getThoiGianVao().format(DateTimeFormatter.ofPattern("HH:mm dd/MM"));
            tableModel.addRow(new Object[]{bienSo, loai, viTri, gioVao});
        }
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
}