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
import javax.swing.*;
import java.awt.*;

public class TaoGiaoDichPanel extends JPanel {
    private JTextField txtMaThe = new JTextField(20);
    private JTextField txtMaNhanVien = new JTextField(20);
    private JTextField txtMaViTri = new JTextField(20);
    private JTextArea txtResult = new JTextArea(10, 30);
    private MainFrame parent;
    private GiaoDichServiceImpl service = new GiaoDichServiceImpl();

    public TaoGiaoDichPanel(MainFrame parent) {
        this.parent = parent;
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));
        form.add(new JLabel("Mã thẻ xe:"));
        form.add(txtMaThe);
        form.add(new JLabel("Mã nhân viên:"));
        form.add(txtMaNhanVien);
        form.add(new JLabel("Mã vị trí:"));
        form.add(txtMaViTri);

        JButton btnSave = new JButton("Tạo giao dịch");
        JButton btnBack = new JButton("Quay lại");

        btnSave.addActionListener(e -> taoGiaoDich());
        btnBack.addActionListener(e -> parent.showPanel("list"));

        txtResult.setEditable(false);

        JPanel center = new JPanel(new BorderLayout());
        center.add(form, BorderLayout.NORTH);
        center.add(new JScrollPane(txtResult), BorderLayout.CENTER);
        JPanel south = new JPanel();
        south.add(btnSave);
        south.add(btnBack);
        center.add(south, BorderLayout.SOUTH);

        add(center);
    }

    private void taoGiaoDich() {
        String maThe = txtMaThe.getText().trim();
        String maNV = txtMaNhanVien.getText().trim();
        String maVT = txtMaViTri.getText().trim();

        if (maThe.isEmpty() || maNV.isEmpty() || maVT.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ!");
            return;
        }

        try {
            GiaoDich gd = service.taoGiaoDichMoi(maThe, maNV, maVT);
            txtResult.append("✅ " + gd.getMaGiaoDich() + " - " + gd.getThoiGianVao() + "\n");
            JOptionPane.showMessageDialog(this, "Tạo thành công!");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
        }
    }
}
