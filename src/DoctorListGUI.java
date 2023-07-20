import javax.swing.*;
import java.awt.*;

public class DoctorListGUI extends JFrame {
    private JButton backToHomeBtn;

    DoctorListGUI(){
        //Code for the Frame
        ImageIcon imageR = new ImageIcon("r.jpeg");
        ImageIcon imageL = new ImageIcon("l.jpeg");
        ImageIcon imageB = new ImageIcon("d.jpeg");
        this.setTitle("Westminster Skin Consultation Manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1440, 800);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        this.add(LeftPanel(imageL));
        this.add(UpperPanel());
        this.add(BottomPanel(imageB));
        this.add(RightPanel(imageR));
        this.add(ScrollPane());
    }

    /**
     * upper panel codes
     * @return JPanel
     */
    private JPanel UpperPanel(){
        final JPanel upperPanel;
        final JLabel upperLabel;

        backToHomeBtn = new JButton();
        backToHomeBtn.setBounds(1270, 35, 100, 50);
        backToHomeBtn.setIcon(new ImageIcon(""));
        backToHomeBtn.addActionListener(e -> {
            if (e.getSource() == backToHomeBtn){
                backToHomeBtn.setBackground(new Color(224, 213, 247));
                this.dispose();
                new HomePageGUI();
            }
        });

        JLabel label = new JLabel("Doctor Information");
        label.setBounds(68, 35, 450, 70);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("BOLD", Font.BOLD,30));

        upperLabel = new JLabel(new ImageIcon("u.jpeg"));
        upperLabel.setBounds(0, 0, 1440, 120);

        upperPanel = new JPanel();
        upperPanel.setBounds(0, 0, 1440, 120);
        upperPanel.add(upperLabel);
        upperLabel.add(label);
        upperLabel.add(backToHomeBtn);
        return upperPanel;
    }

    /**
     * right panel Codes
     * @return JPanel
     */
    private JPanel RightPanel(ImageIcon image){
        JPanel rightSidePanel;
        JLabel rightLabel;

        rightLabel = new JLabel(image);
        rightLabel.setBounds(0, 0, 70, 580);
        rightSidePanel = new JPanel();
        rightSidePanel.setBounds(1370,120, 70, 580);
        rightSidePanel.add(rightLabel);

        return rightSidePanel;
    }

    /**
     * Left panel Codes
     * @return JPanel
     */
    private JPanel LeftPanel(ImageIcon image){
        JPanel leftSidePanel;
        JLabel leftLabel;

        leftLabel = new JLabel(image);
        leftLabel.setBounds(0,0, 70, 580);
        leftSidePanel = new JPanel();
        leftSidePanel.setBounds(0,120, 70, 580);
        leftSidePanel.add(leftLabel);

        return leftSidePanel;
    }

    /**
     * bottom panel Codes
     * @return JPanel
     */
    private JPanel BottomPanel(ImageIcon image){
        JPanel bottomPanel;
        JLabel bottomLabel;


        bottomLabel = new JLabel(image);
        bottomLabel.setBounds(0, 0,1440, 75);
        bottomPanel = new JPanel();
        bottomPanel.setBounds(0, 700, 1440,75);
        bottomPanel.add(bottomLabel);

        return bottomPanel;
    }

    /**
     * Codes that contain
     * @return JScrollPane
     */
    private JScrollPane ScrollPane(){
        final JScrollPane scrollPane;
        //Creating an object of custom table model class
        ListTableModel model = new ListTableModel(WestminsterSkinConsultationManager.list);

        //Defining the table
        JTable table = new JTable(model);
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        table.setSelectionBackground(new Color(130, 239, 219));
        table.setSelectionForeground(Color.BLACK);
        table.setGridColor(Color.BLACK);
        table.setFont(new Font("Calibri", Font.PLAIN,13));
        table.setRowHeight(40);
        table.getTableHeader().setFont(new Font("Calibri", Font.BOLD,14));
        table.getTableHeader().setPreferredSize(new Dimension(90,50));
        table.getTableHeader().setForeground(new Color(0, 0, 0));
        table.setAutoCreateRowSorter(true);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(70, 120, 1300,583);
        return scrollPane;
    }
}
