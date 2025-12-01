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
import Service.GiaoDichServiceImpl;
import Repository.GiaoDichRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class GiaoDichListPanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private MainFrame parent;
    private GiaoDichServiceImpl giaoDichService = new GiaoDichServiceImpl();
    private GiaoDichRepository giaoDichRepo = new GiaoDichRepository();

    public GiaoDichListPanel(MainFrame parent) {
        this.parent = parent;
        setLayout(new BorderLayout());

        // Tạo model cho bảng
        tableModel = new DefaultTableModel(
            new Object[]{"Mã GD", "Mã Thẻ", "Vào", "Ra", "Phí", "Trạng thái"}, 0
        );
        table = new JTable(tableModel);
        table.setAutoCreateRowSorter(true);

        loadGiaoDich();

        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        JButton btnNew = new JButton("Tạo giao dịch");
        JButton btnRefresh = new JButton("Làm mới");
        JButton btnKetThuc = new JButton("Kết thúc giao dịch");
        JButton btnViTri = new JButton("Vị trí trống");

        btnNew.addActionListener(e -> parent.showPanel("tao"));
        btnRefresh.addActionListener(e -> loadGiaoDich());
        btnViTri.addActionListener(e -> parent.showPanel("vitri"));

        btnKetThuc.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn giao dịch!");
                return;
            }
            String maGD = (String) table.getValueAt(row, 0);
            ketThucGiaoDich(maGD);
            loadGiaoDich(); 
        });

        btnPanel.add(btnNew);
        btnPanel.add(btnKetThuc);
        btnPanel.add(btnViTri);
        btnPanel.add(btnRefresh);
        add(btnPanel, BorderLayout.SOUTH);
    }

    private void loadGiaoDich() {
        tableModel.setRowCount(0); 
        List<GiaoDich> list = giaoDichRepo.findAll();
        for (GiaoDich gd : list) {
            tableModel.addRow(new Object[]{
                gd.getMaGiaoDich(),
                gd.getMaThe(),
                gd.getThoiGianVao(),
                gd.getThoiGianRa() == null ? "Đang đỗ" : gd.getThoiGianRa(),
                gd.getPhiDoXe(),
                gd.getTrangThaiThanhToan()
            });
        }
    }

    private void ketThucGiaoDich(String maGiaoDich) {
        JOptionPane.showMessageDialog(this, "Kết thúc giao dịch: " + maGiaoDich + "\nPhí: 20.000 VND");
    }
}
