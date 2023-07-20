import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppointmentsGUI extends JFrame {
    private JTable table;

    AppointmentsGUI() {
        this.setTitle("Westminster Skin Consultation Manager");
        this.setSize(1300, 683);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        this.add(UpperPanel(), BorderLayout.NORTH);
        this.add(Table(), BorderLayout.CENTER);
        this.add(DownPanel(), BorderLayout.SOUTH);
        this.add(LeftPanel(), BorderLayout.WEST);
        this.add(RightPanel(), BorderLayout.EAST);
    }

    private JPanel UpperPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(1300, 85));

        JLabel label = new JLabel(new ImageIcon("up.jpg"));
        panel.add(label);

        return panel;
    }

    private JPanel LeftPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(60, 683));

        JLabel label = new JLabel(new ImageIcon("left.jpg"));
        panel.add(label);

        return panel;
    }

    private JPanel RightPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(70, 500));

        JLabel label = new JLabel(new ImageIcon("right.jpg"));
        panel.add(label);

        return panel;
    }

    private JPanel DownPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(1300, 85));

        JLabel label = new JLabel(new ImageIcon("down.jpg"));
        panel.add(label);

        return panel;
    }

    private JScrollPane Table() {
        AppointmentTableModel appointmentTableModel = new AppointmentTableModel(ConsultationGUI.patientList, ConsultationGUI.consultationList);
        table = new JTable(appointmentTableModel);
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        table.setSelectionBackground(new Color(236, 150, 129));
        table.setSelectionForeground(Color.BLACK);
        table.setGridColor(Color.BLACK);
        table.setFont(new Font("Calibri", Font.PLAIN, 13));
        table.setRowHeight(40);
        table.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(150, 50));
        table.getTableHeader().setForeground(new Color(1, 6, 65));
        table.setAutoCreateRowSorter(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(120);
        table.getColumnModel().getColumn(4).setPreferredWidth(90);
        table.getColumnModel().getColumn(5).setPreferredWidth(150);
        table.getColumnModel().getColumn(6).setPreferredWidth(200);
        table.getColumnModel().getColumn(7).setPreferredWidth(200);
        table.getColumnModel().getColumn(8).setPreferredWidth(200);
        table.getColumnModel().getColumn(9).setPreferredWidth(170);
        table.getColumnModel().getColumn(10).setPreferredWidth(60);

        JMenuItem add = new JMenuItem("Add new Consultation");
        JMenuItem delete = new JMenuItem("Delete selected Consultation");

        add.addActionListener(ae -> {
            new ConsultationGUI();
        });

        delete.addActionListener(ae -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                // Perform delete operation
            }
        });

        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.add(add);
        popupMenu.addSeparator();
        popupMenu.add(delete);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    popupMenu.show(table, e.getX(), e.getY());
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        return scrollPane;
    }
}
