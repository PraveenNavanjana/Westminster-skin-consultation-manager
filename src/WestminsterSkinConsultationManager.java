import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {
    public static ArrayList<Doctor> list = new ArrayList<>(10);
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void AddDoctor() {
        String choice = null;
        do {
            try {
                int count = list.size();

                if (count < 10) {
                    System.out.println("                                            Add new doctor                                     ");
                    System.out.println("Enter the name of the doctor:");
                    String docName = scanner.next();

                    System.out.println("Enter the surname of the doctor:");
                    String surname = scanner.next();

                    System.out.println("Enter the mobile number of the doctor:");
                    String mob = scanner.next();

                    System.out.println("Select the gender:");
                    System.out.println("1. Male\n2. Female");
                    int select = scanner.nextInt();
                    String gen;
                    if (select == 1) {
                        gen = "Male";
                    } else if (select == 2) {
                        gen = "Female";
                    } else {
                        System.out.println("Sorry! wrong selection");
                        break;
                    }

                    System.out.println("Enter the doctor's Date of Birth (dd/MM/yyyy):");
                    String doctorDob = scanner.next();
                    Date dob = dateFormat.parse(doctorDob);

                    System.out.println("Enter the Medical License Number of the doctor:");
                    String medNumber = scanner.next();

                    System.out.println("Select the Doctor specialization from the below:");
                    System.out.println("1. Cosmetic dermatology\n2. Medical dermatology,\n3. Pediatric dermatology\n4. Other");
                    int num = scanner.nextInt();
                    String specialization;
                    if (num == 1) {
                        specialization = "Cosmetic dermatology";
                    } else if (num == 2) {
                        specialization = "Medical dermatology";
                    } else if (num == 3) {
                        specialization = "Pediatric dermatology";
                    } else if (num == 4) {
                        System.out.println("Enter the specialization:");
                        specialization = scanner.next();
                    } else {
                        System.out.println("Sorry! wrong selection");
                        break;
                    }

                    Doctor doc = new Doctor(docName, surname, dob, mob, gen, medNumber, specialization);
                    list.add(doc);
                    System.out.println("Doctor added successfully!");

                    System.out.println("Do you want to add another doctor?(Y/N):");
                    choice = scanner.next();
                } else {
                    System.out.println("Can't add doctors, Your center is full!");
                    break;
                }

            } catch (ParseException e) {
                System.out.println("Invalid date format! Please enter the date in the format dd/MM/yyyy");
            } catch (Exception e) {
                System.out.println("Something went wrong! Please try again!");
            }
        } while (choice.equalsIgnoreCase("Y"));
        System.out.println("Back to the main menu");
    }

    @Override
    public void DeleteDoctor() {
        try {
            System.out.println("                                                 Delete a doctor                                           ");

            System.out.println("Enter the medical license number:");
            String medicalLicense = scanner.next();

            boolean doctorFound = false;
            for (Doctor doctor : list) {
                if (medicalLicense.equals(doctor.getMedicalLicenseNumber())) {
                    System.out.println("Do you want to delete doctor " + doctor.getName() + " from the center? (Y/N)");
                    String ans = scanner.next();

                    if (ans.equalsIgnoreCase("Y")) {
                        list.remove(doctor);
                        System.out.println("Doctor deleted successfully!");
                    } else {
                        System.out.println("Back to the main menu");
                    }
                    doctorFound = true;
                    break;
                }
            }

            if (!doctorFound) {
                System.out.println("Sorry! Doctor not found!");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong! Please try again!");
        }
    }

    @Override
    public void DoctorList() {
        try {
            System.out.println("                                                  List of Doctors                                       ");
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %s\n",
                    "Name", "Surname", "Gender", "Date of birth", "Mobile number", "Medical License Number", "Specialization");

            if (list.isEmpty()) {
                System.out.println("\nData not found\n");
            } else {
                ArrayList<Doctor> sortedArrayList = new ArrayList<>(list);
                Collections.sort(sortedArrayList);
                for (Doctor doc : sortedArrayList) {
                    System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %s\n",
                            doc.getName(), doc.getSurname(), doc.getGender(), dateFormat.format(doc.getDateOfBirth()),
                            doc.getMobileNumber(), doc.getMedicalLicenseNumber(), doc.getSpecialization());
                }
            }
            System.out.println("\n***");
        } catch (Exception e) {
            System.out.println("Something went wrong! Please try again!");
        }
    }

    @Override
    public void SaveFile() {
        try (FileOutputStream fos = new FileOutputStream("data.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Doctor doctor : list) {
                oos.writeObject(doctor);
            }
            System.out.println("Saved to file!");
        } catch (Exception e) {
            System.out.println("Something went wrong! Please try again!");
        }
    }

    @Override
    public void LoadFile(ArrayList<Doctor> list) {
        try (FileInputStream fis = new FileInputStream("data.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                try {
                    Doctor doctor = (Doctor) ois.readObject();
                    list.add(doctor);
                } catch (EOFException e) {
                    break; // Reached end of file
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File not found or error reading from the file!");
        }
    }
}
