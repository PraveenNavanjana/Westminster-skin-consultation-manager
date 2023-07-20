import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class ConsultationGUI extends JFrame {
    public static final ArrayList<Patient> patientList = new ArrayList<>();
    public static final ArrayList<Consultation> consultationList = new ArrayList<>();
    private final JTextField textFieldForFName, textFieldForSurname, textFieldForMobile;
    private final JLabel labelFieldForDOB, labelForDate;
    private final JTextArea textAreaForNotes;
    private final JRadioButton male;
    private final DefaultComboBoxModel<Object> docNames = new DefaultComboBoxModel<>();
    private final DefaultComboBoxModel<Object> specializationBoxModel = new DefaultComboBoxModel<>();
    private final DefaultComboBoxModel<Object> timeSlotBoxModel = new DefaultComboBoxModel<>();
    private JButton backToHomeBtn;
    private String gender, dob, pickedDate, nameOfTheSelectedDoctor;
    private Date date, pickedDate1;
    private JComboBox comboForSpecialization, comboBoxForDocName, jComboBoxForTime;

    ConsultationGUI() {
        JLabel patientDetails = new JLabel("Patient Details");
        patientDetails.setFont(new Font("Arial", Font.BOLD, 25));
        patientDetails.setBounds(650, 55, 300, 100);

        textFieldForFName = new JTextField();
        textFieldForFName.setBounds(790, 150, 200, 40);
        textFieldForFName.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldForFName.setBackground(new Color(124, 208, 227));

        JLabel forFirstName = new JLabel("First Name");
        forFirstName.setBounds(640, 150, 100, 35);
        forFirstName.setFont(new Font("Arial", Font.PLAIN, 18));

        textFieldForSurname = new JTextField();
        textFieldForSurname.setBounds(1190, 150, 200, 40);
        textFieldForSurname.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldForSurname.setBackground(new Color(124, 208, 227));

        JLabel forSurName = new JLabel("Surname");
        forSurName.setBounds(1040, 150, 100, 35);
        forSurName.setFont(new Font("Arial", Font.PLAIN, 18));

        labelFieldForDOB = new JLabel();
        labelFieldForDOB.setBounds(790, 230, 150, 35);
        labelFieldForDOB.setFont(new Font("Arial", Font.PLAIN, 18));
        labelFieldForDOB.setBackground(new Color(124, 208, 227));
        labelFieldForDOB.setOpaque(true);

        JButton calenderBtn = new JButton();
        calenderBtn.setBounds(945, 230, 50, 40);
        calenderBtn.setIcon(new ImageIcon("calendar.png"));
        calenderBtn.addActionListener(ae -> labelFieldForDOB.setText(new DatePicker(this).setPickedDate()));

        JLabel forDOB = new JLabel("Date Of Birth");
        forDOB.setBounds(640, 230, 150, 35);
        forDOB.setFont(new Font("Arial", Font.PLAIN, 18));

        textFieldForMobile = new JTextField();
        textFieldForMobile.setBounds(1190, 230, 200, 40);
        textFieldForMobile.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldForMobile.setBackground(new Color(124, 208, 227));

        JLabel forMobile = new JLabel("Mobile Number");
        forMobile.setBounds(1040, 230, 150, 35);
        forMobile.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 18));
        gender.setSize(100, 20);
        gender.setLocation(640, 310);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(790, 310);

        JRadioButton female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(860, 310);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);


        JLabel addConsultation = new JLabel("Add Consultation");
        addConsultation.setFont(new Font("Arial", Font.BOLD, 25));
        addConsultation.setBounds(650, 360, 300, 50);

        JLabel selectDocLabel = new JLabel("Select a Doctor");
        selectDocLabel.setBounds(1040, 430, 150, 35);
        selectDocLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel labelForSpec = new JLabel("Specialization");
        labelForSpec.setBounds(640, 430, 150, 35);
        labelForSpec.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel forDate = new JLabel("Pick a Date");
        forDate.setBounds(640, 510, 120, 35);
        forDate.setFont(new Font("Arial", Font.PLAIN, 18));

        labelForDate = new JLabel();
        labelForDate.setBounds(790, 510, 150, 35);
        labelForDate.setFont(new Font("Arial", Font.PLAIN, 18));
        labelForDate.setBackground(new Color(124, 208, 227));
        labelForDate.setOpaque(true);

        JButton calenderBtn2 = new JButton();
        calenderBtn2.setBounds(945, 510, 50, 40);
        calenderBtn2.setIcon(new ImageIcon("calendar.png"));
        calenderBtn2.addActionListener(ae -> labelForDate.setText(new DatePicker(this).setPickedDate()));

        JLabel labelForDuration = new JLabel("Time Slot");
        labelForDuration.setBounds(1040, 510, 150, 35);
        labelForDuration.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel labelForNote = new JLabel("Add Notes");
        labelForNote.setBounds(640, 590, 100, 35);
        labelForNote.setFont(new Font("Arial", Font.PLAIN, 18));

        textAreaForNotes = new JTextArea();
        textAreaForNotes.setLineWrap(true);
        textAreaForNotes.setFont(new Font("Arial", Font.PLAIN, 15));
        textAreaForNotes.setBackground(new Color(124, 208, 227));
        textAreaForNotes.setOpaque(true);

        JScrollPane textAreaScroll = new JScrollPane(textAreaForNotes);
        textAreaScroll.setBounds(790, 590, 200, 75);

        JLabel labelForImg = new JLabel("Upload an Image");
        labelForImg.setBounds(1040, 590, 170, 35);
        labelForImg.setFont(new Font("BOLD", Font.PLAIN, 18));

        JButton fileChooser = new JButton("Browse");
        fileChooser.setIcon(new ImageIcon("folder.png"));
        fileChooser.setBounds(1210, 590, 150, 35);
        fileChooser.addActionListener(ae -> {
            if (ae.getSource() == fileChooser) {
                JFileChooser jFileChooser = new JFileChooser();
                FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
                jFileChooser.addChoosableFileFilter(fileNameExtensionFilter);
                int value = jFileChooser.showSaveDialog(null);

                if (value == JFileChooser.APPROVE_OPTION) {
                    File selectedImage = jFileChooser.getSelectedFile();
                    String filePath = selectedImage.getAbsolutePath();
                    JOptionPane.showMessageDialog(null, filePath);
                }
            }
        });

        this.setTitle("Westminster Skin Consultation Manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1440, 800);
        this.setBackground(new Color(169, 218, 231));
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        this.add(LeftPanel());
        this.add(RightUpperPanel());
        this.add(textFieldForFName);
        this.add(patientDetails);
        this.add(forFirstName);
        this.add(textFieldForSurname);
        this.add(forSurName);
        this.add(forDOB);
        this.add(forMobile);
        this.add(textFieldForMobile);
        this.add(labelFieldForDOB);
        this.add(calenderBtn);
        this.add(addConsultation);
        this.add(selectDocLabel);
        this.add(DoctorNames());
        this.add(labelForSpec);
        this.add(forDate);
        this.add(labelForDate);
        this.add(calenderBtn2);
        this.add(labelForDuration);
        this.add(labelForNote);
        this.add(textAreaScroll);
        this.add(labelForImg);
        this.add(fileChooser);
        this.add(Book());
        this.add(ResetButton());
        this.add(ListOfAppointments());
        this.add(RightDownPanel());
        this.add(gender);
        this.add(male);
        this.add(female);
        this.add(DoctorSpecialization());
        this.add(TimeSlot());
    }

    public static void SaveInFile() {
        try {
            FileOutputStream fo = new FileOutputStream("PatientList.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fo);

            for (Patient patient : patientList) {
                oos.writeObject(patient);
            }
            fo.close();
            oos.close();


            FileOutputStream fo1 = new FileOutputStream("Consultation.txt");
            ObjectOutputStream oos1 = new ObjectOutputStream(fo1);

            for (Consultation consultation : consultationList) {
                oos1.writeObject(consultation);
            }
            fo1.close();
            oos1.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private JPanel LeftPanel() {
        final JLabel jLabel = new JLabel();
        jLabel.setIcon(new ImageIcon("bg2.jpeg"));
        jLabel.setBounds(0, 0, 600, 800);


        final JPanel jPanel = new JPanel();
        jPanel.setBounds(0, 0, 600, 800);
        jPanel.add(jLabel);
        return jPanel;
    }

    private JPanel RightUpperPanel() {
        backToHomeBtn = new JButton();
        backToHomeBtn.setBounds(700, 5, 100, 50);
        backToHomeBtn.setIcon(new ImageIcon("HomeIcon.png"));
        backToHomeBtn.addActionListener(e -> {
            if (e.getSource() == backToHomeBtn) {
                backToHomeBtn.setBackground(new Color(124, 208, 227));
                this.dispose();
                new HomePageGUI();
            }
        });
        JLabel label = new JLabel("Book a Consultation");
        label.setBounds(200, 5, 840, 50);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("BOLD", Font.BOLD, 30));

        final JLabel jLabel = new JLabel();
        jLabel.setBounds(0, 0, 840, 70);
        jLabel.setIcon(new ImageIcon("upimg1.jpg"));
        jLabel.add(backToHomeBtn);

        final JPanel jPanel = new JPanel();
        jPanel.setBounds(600, 0, 840, 70);
        jPanel.add(jLabel);
        jLabel.add(label);
        return jPanel;
    }

    private JComboBox DoctorNames() {
        comboBoxForDocName = new JComboBox(docNames);
        comboBoxForDocName.setBounds(1190, 423, 200, 50);
        comboBoxForDocName.setFont(new Font("Arial", Font.PLAIN, 15));
        return comboBoxForDocName;
    }

    private JComboBox DoctorSpecialization() {
        int count = WestminsterSkinConsultationManager.list.size();
        String[] specialization = new String[count];
        int iteration = 0;
        for (Doctor doc : WestminsterSkinConsultationManager.list) {
            specialization[iteration] = doc.getSpecialization();
            iteration++;
        }

        specializationBoxModel.addElement("-- Select --");
        docNames.addElement("-- Select --");


        for (int i = 0; i < count; i++) {
            int flag = 0;
            for (int j = 0; j < i; j++) {
                if (specialization[i].equals(specialization[j])) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                specializationBoxModel.addElement(specialization[i]);
            }
        }

        comboForSpecialization = new JComboBox(specializationBoxModel);
        comboForSpecialization.setBounds(790, 423, 200, 50);
        comboForSpecialization.setFont(new Font("Arial", Font.PLAIN, 15));
        comboForSpecialization.addActionListener(ae -> {
            if (ae.getSource() == comboForSpecialization) {
                docNames.removeAllElements();
                for (Doctor doctor : WestminsterSkinConsultationManager.list) {
                    if (doctor.getSpecialization().equals(comboForSpecialization.getSelectedItem())) {
                        docNames.addElement(doctor.getName() + " " + doctor.getSurname());
                    }
                }
            }
        });
        return comboForSpecialization;
    }

    private JButton Book() {
        JButton book = new JButton("Reserve");
        book.setBounds(1030, 700, 150, 35);
        book.setFont(new Font("Arial", Font.BOLD, 12));
        book.setForeground(Color.BLACK);
        book.addActionListener(ae -> {
            if (ae.getSource() == book) {
                if (!textFieldForFName.getText().isEmpty() && !textFieldForSurname.getText().isEmpty() && !labelFieldForDOB.getText().isEmpty() && !textFieldForMobile.getText().isEmpty()) {
                    String fName = textFieldForFName.getText();
                    String lName = textFieldForSurname.getText();
                    try {
                        dob = labelFieldForDOB.getText();
                        date = WestminsterSkinConsultationManager.dateFormat.parse(dob);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    String mobile = textFieldForMobile.getText();

                    if (male.isSelected()) {
                        gender = "Male";
                    } else {
                        gender = "Female";
                    }
                    String specialization = (String) DoctorSpecialization().getSelectedItem();
                    String doctorName = (String) DoctorNames().getSelectedItem();
                    try {
                        pickedDate = labelForDate.getText();
                        pickedDate1 = WestminsterSkinConsultationManager.dateFormat.parse(pickedDate);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    String time = (String) TimeSlot().getSelectedItem();
                    String notes = textAreaForNotes.getText();

                    int flag = 0;

                    for (Patient patient : patientList) {
                        if (fName.equalsIgnoreCase(patient.getName()) && lName.equalsIgnoreCase(patient.getSurname())) {
                            flag = 1;
                            break;
                        }
                    }
                    int yesOrNo;
                    if (flag == 1) {
                        yesOrNo = JOptionPane.showConfirmDialog(this, "Consultation Fee :- £25\nDo you want to book the consultation?", "Westminster Skin Consultation Manager", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Question.png"));
                        if (yesOrNo == 0) {
                            String consultationFee = "£25";
                            Consultation consultation = new Consultation(doctorName, specialization, pickedDate1, time, notes, consultationFee);
                            Patient patient = new Patient(fName, lName, date, mobile, gender);
                            patientList.add(patient);
                            consultationList.add(consultation);
                            JOptionPane.showMessageDialog(this, "Your consultation reserved Successfully!", "ALERT!", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("confirm.png"));
                        }
                    } else {
                        yesOrNo = JOptionPane.showConfirmDialog(this, "Consultation Fee :- £15\nDo you want to book the consultation?", "Westminster Skin Consultation Manager", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Question.png"));
                        if (yesOrNo == 0) {
                            String consultationFee = "£15";
                            Consultation consultation = new Consultation(doctorName, specialization, pickedDate1, time, notes, consultationFee);
                            Patient patient = new Patient(fName, lName, date, mobile, gender);
                            patientList.add(patient);
                            consultationList.add(consultation);
                            JOptionPane.showMessageDialog(this, "Your consultation reserved Successfully!", "ALERT!", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("confirm.png"));
                        }
                    }
                    if (yesOrNo == 1) {
                        JOptionPane.showMessageDialog(this, "Cancelled!", "ALERT!", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("cross.png"));
                    }
                    SaveInFile();
                    Reset();
                } else {
                    JOptionPane.showMessageDialog(this, "Please fill all the fields.", "ALERT!", JOptionPane.WARNING_MESSAGE, new ImageIcon("AlertIcon.png"));
                }
            }
        });
        return book;
    }

    private JComboBox TimeSlot() {
        ArrayList<String> doctors = new ArrayList<>();

        timeSlotBoxModel.addElement("-- Select --");
        timeSlotBoxModel.addElement("8 a.m. - 9 a.m.");
        timeSlotBoxModel.addElement("9 a.m. - 10 a.m.");
        timeSlotBoxModel.addElement("10 a.m. - 11 a.m.");
        timeSlotBoxModel.addElement("11 a.m. - 12 a.m.");
        timeSlotBoxModel.addElement("2 p.m. - 3 p.m.");
        timeSlotBoxModel.addElement("3 p.m. - 4 p.m.");
        timeSlotBoxModel.addElement("4 p.m. - 5 p.m.");
        timeSlotBoxModel.addElement("5 p.m. - 6 p.m.");

        jComboBoxForTime = new JComboBox(timeSlotBoxModel);
        jComboBoxForTime.setBounds(1190, 503, 200, 50);
        jComboBoxForTime.setFont(new Font("Arial", Font.PLAIN, 15));
        jComboBoxForTime.addActionListener(ae -> {
            if (ae.getSource() == jComboBoxForTime) {
                if (!isDoctorAvailable()) {
                    var yesOrNo = JOptionPane.showConfirmDialog(this, "Doctor is not available in selected date and time.\nDo you want allocate another the doctor to this specific date and time?", "ALERT!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("bell.png"));
                    if (yesOrNo == 0) {
                        docNames.removeAllElements();
                        for (Doctor doc : WestminsterSkinConsultationManager.list) {
                            String name = doc.getName() + " " + doc.getSurname();
                            if (doc.getSpecialization().equals(comboForSpecialization.getSelectedItem()) && !name.equalsIgnoreCase(nameOfTheSelectedDoctor)) {
                                for (Consultation consultation : consultationList) {
                                    if (name.equalsIgnoreCase(consultation.getDoctorName()) && Objects.equals(comboForSpecialization.getSelectedItem(), consultation.getSpecialization())) {
                                        try {
                                            if (!(consultation.getTimeSlot().equals(jComboBoxForTime.getSelectedItem()) && WestminsterSkinConsultationManager.dateFormat.parse(labelForDate.getText()).equals(consultation.getDate()))) {
                                                doctors.add(name);
                                                break;
                                            }
                                        } catch (ParseException e) {
                                            throw new RuntimeException(e);
                                        }
                                    } else {
                                        doctors.add(name);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
        for (String name :
                doctors) {
            for (Consultation consul :
                    consultationList) {
                try {
                    if (!(name.equals(consul.getDoctorName()) && WestminsterSkinConsultationManager.dateFormat.parse(labelForDate.getText()).equals(consul.getDate()) && consul.getTimeSlot().equals(jComboBoxForTime.getSelectedItem()))){
                        docNames.addElement(name);
                    }
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return jComboBoxForTime;
    }

    private boolean isDoctorAvailable() {
        for (Consultation consultation : consultationList) {
            try {
                if (consultation.getTimeSlot().equals(jComboBoxForTime.getSelectedItem()) && Objects.equals(comboBoxForDocName.getSelectedItem(), consultation.getDoctorName()) && Objects.equals(comboForSpecialization.getSelectedItem(), consultation.getSpecialization()) && WestminsterSkinConsultationManager.dateFormat.parse(labelForDate.getText()).equals(consultation.getDate())) {
                    nameOfTheSelectedDoctor = (String) comboBoxForDocName.getSelectedItem();
                    return false;
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    private JPanel RightDownPanel() {
        final JPanel jPanel = new JPanel();
        jPanel.setBounds(600, 760, 840, 20);
        jPanel.setBackground(new Color(255, 255, 255));
        return jPanel;
    }

    private JButton ListOfAppointments() {
        JButton listOfAppointment = new JButton("List of Appointments");
        listOfAppointment.setBounds(1220, 720, 200, 35);
        listOfAppointment.setFont(new Font("Arial", Font.BOLD, 12));
        listOfAppointment.addActionListener(ae -> {
            if (ae.getSource() == listOfAppointment) {
                new AppointmentsGUI();
            }
        });
        return listOfAppointment;
    }

    private JButton ResetButton() {
        JButton reset = new JButton("Clear");
        reset.setBounds(1030, 650, 150, 35);
        reset.setFont(new Font("Arial", Font.BOLD, 12));
        reset.setForeground(Color.BLACK);
        reset.addActionListener(ae -> {
            if (ae.getSource() == reset) {
                Reset();
            }
        });
        return reset;
    }

    private void Reset() {
        String def = "";
        textFieldForFName.setText(def);
        textFieldForSurname.setText(def);
        textFieldForMobile.setText(def);
        labelFieldForDOB.setText(def);
        labelForDate.setText(def);
        textAreaForNotes.setText(def);
        specializationBoxModel.removeAllElements();
        DoctorSpecialization();
        DoctorNames();
        timeSlotBoxModel.removeAllElements();
        TimeSlot();
        labelForDate.setText(def);
        textAreaForNotes.setText(def);
    }
}
