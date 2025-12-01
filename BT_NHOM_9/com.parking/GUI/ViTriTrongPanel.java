/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author yuhna
 */
import Model.ViTriDo;
import Repository.ViTriDoRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ViTriTrongPanel extends JPanel {
    private MainFrame parent;

    public ViTriTrongPanel(MainFrame parent) {
        this.parent = parent;
        setLayout(new BorderLayout());

        DefaultTableModel model = new DefaultTableModel(
            new Object[]{"Mã vị trí", "Loại", "Trạng thái", "Khu vực"}, 0
        );
        JTable table = new JTable(model);

        // Tải dữ liệu
        ViTriDoRepository repo = new ViTriDoRepository();
        List<ViTriDo> list = repo.findAll();
        for (ViTriDo vt : list) {
            if ("Trống".equals(vt.getTrangThai())) {
                model.addRow(new Object[]{
                    vt.getMaViTri(),
                    vt.getLoaiCho(),
                    vt.getTrangThai(),
                    vt.getMaKhuVuc()
                });
            }
        }

        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton btnBack = new JButton("Quay lại");
        btnBack.addActionListener(e -> parent.showPanel("list"));
        add(btnBack, BorderLayout.SOUTH);
    }
}