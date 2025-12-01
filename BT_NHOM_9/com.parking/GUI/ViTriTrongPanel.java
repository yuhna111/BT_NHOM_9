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
import Service.ViTriDoService;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ViTriTrongPanel extends JPanel {
    private final MainFrame parent;
    private final ViTriDoService viTriDoService;

    public ViTriTrongPanel(MainFrame parent, ViTriDoService viTriDoService) {
        this.parent = parent;
        this.viTriDoService = viTriDoService;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JLabel lblTitle = new JLabel("Danh sách vị trí trống", JLabel.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(lblTitle, BorderLayout.NORTH);

        DefaultTableModel model = new DefaultTableModel(
            new String[]{"Mã vị trí", "Loại", "Trạng thái", "Khu vực"}, 0
        );

        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);
        table.getTableHeader().setReorderingAllowed(false);

        List<ViTriDo> list = viTriDoService.getAllViTriTrong(); 

        for (ViTriDo vt : list) {
            model.addRow(new Object[]{
                vt.getMaViTri(),
                vt.getLoaiCho(),
                vt.getTrangThai(),
                vt.getMaKhuVuc() == null ? "—" : vt.getMaKhuVuc()
            });
        }

        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
