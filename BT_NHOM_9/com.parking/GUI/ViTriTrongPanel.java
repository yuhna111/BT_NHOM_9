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
import Service.ViTriDoService;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ViTriTrongPanel extends JPanel {
    private final MainFrame parent;

    public ViTriTrongPanel(MainFrame parent, ViTriDoService viTriDoService) {
        this.parent = parent;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JLabel lblTitle = new JLabel("Danh sách vị trí trống", JLabel.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        add(lblTitle, BorderLayout.NORTH);

        DefaultTableModel model = new DefaultTableModel(
            new String[]{"Mã vị trí", "Loại xe", "Trạng thái", "Khu vực"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setFillsViewportHeight(true);
        table.getTableHeader().setReorderingAllowed(false);

        ViTriDoRepository repo = new ViTriDoRepository();
        List<ViTriDo> list = repo.findTrong(); 

        for (ViTriDo vt : list) {
            model.addRow(new Object[]{
                vt.getMaViTri(),
                vt.getLoaiCho(),
                vt.getTrangThai(),
                vt.getMaKhuVuc() != null ? vt.getMaKhuVuc() : "—"
            });
        }

        if (list.isEmpty()) {
            model.addRow(new Object[]{"", "Không có vị trí trống", "", ""});
        }

        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
