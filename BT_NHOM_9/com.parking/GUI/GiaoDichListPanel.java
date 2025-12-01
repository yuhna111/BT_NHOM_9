/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author yuhna
 */
import Model.GiaoDich;
import Service.GiaoDichService;
import Service.NhanVienService;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.format.DateTimeFormatter;

public class GiaoDichListPanel extends JPanel {
    private final GiaoDichService giaoDichService;
    private final NhanVienService nhanVienService;
    private final MainFrame parent;
    private JTable table;
    private DefaultTableModel model;

    public GiaoDichListPanel(
        MainFrame parent,
        GiaoDichService giaoDichService,
        NhanVienService nhanVienService
    ) {
        this.parent = parent;
        this.giaoDichService = giaoDichService;
        this.nhanVienService = nhanVienService;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        model = new DefaultTableModel(
            new String[]{"Mã GD", "Mã Thẻ", "Vào", "Ra", "Phí (VND)", "Trạng thái"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setFillsViewportHeight(true);
        table.getTableHeader().setReorderingAllowed(false);

        loadGiaoDich();

        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton btnKetThuc = new JButton("Kết thúc giao dịch");
        btnKetThuc.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnKetThuc.addActionListener(e -> handleKetThuc());

        JPanel south = new JPanel(new FlowLayout(FlowLayout.LEFT));
        south.add(btnKetThuc);
        south.setBackground(Color.WHITE);
        add(south, BorderLayout.SOUTH);
    }

    private void loadGiaoDich() {
        model.setRowCount(0);
        java.util.List<GiaoDich> list = giaoDichService.getAllGiaoDich(); 

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        for (GiaoDich gd : list) {
            String thoiGianVao = gd.getThoiGianVao() != null ? 
                gd.getThoiGianVao().format(formatter) : "";
            String thoiGianRa = gd.getThoiGianRa() != null ? 
                gd.getThoiGianRa().format(formatter) : "Đang đỗ";

            model.addRow(new Object[]{
                gd.getMaGiaoDich(),
                gd.getMaThe(),
                thoiGianVao,
                thoiGianRa,
                gd.getPhiDoXe() > 0 ? String.format("%,.0f", gd.getPhiDoXe()) : "",
                gd.getTrangThaiThanhToan() != null ? gd.getTrangThaiThanhToan() : "Chưa thanh toán"
            });
        }
    }

    private void handleKetThuc() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giao dịch cần kết thúc!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String maGD = (String) model.getValueAt(row, 0);
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Bạn có chắc muốn kết thúc giao dịch\nMã: " + maGD + "?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                giaoDichService.ketThucGiaoDich(maGD);
                loadGiaoDich();
                JOptionPane.showMessageDialog(this, "Đã kết thúc giao dịch và cập nhật cơ sở dữ liệu!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi khi kết thúc giao dịch: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
