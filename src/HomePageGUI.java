import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class HomePageGUI extends JFrame {
    private JButton button1 = null;
    private JButton button2 = null;

    public HomePageGUI() {
        createUI();
        setupButton1();
        setupButton2();

        setTitle("Westminster Skin Consultation Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1440, 800);
        setResizable(false);
        setVisible(true);
    }

    private void createUI() {
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Add background image
        JLabel background = new JLabel(new ImageIcon("bg.jpg"));
        background.setBounds(0, 0, 1440, 772);
        contentPane.add(background);

        // Add welcome letter
        JLabel welcomeLetter = new JLabel("Westminster Skin Consultation Manager");
        welcomeLetter.setBounds(80, 15, 1100, 50);
        welcomeLetter.setForeground(Color.BLACK);
        welcomeLetter.setFont(new Font("Calibre", Font.BOLD, 45));
        background.add(welcomeLetter);
    }

    private void setupButton1() {
        button1 = new JButton("Doctor Information");
        button1.setBounds(250, 350, 400, 100);
        button1.setFont(new Font("Comic Sans", Font.BOLD, 25));
        button1.addActionListener(e -> {
            dispose();
            new DoctorListGUI();
        });
        getContentPane().add(button1);
    }

    private void setupButton2() {
        button2 = new JButton("Book a Consultation");
        button2.setBounds(750, 350, 400, 100);
        button2.setFont(new Font("Comic Sans", Font.BOLD, 25));
        button2.addActionListener(e -> {
            dispose();
            new ConsultationGUI();
        });
        getContentPane().add(button2);
    }
}
