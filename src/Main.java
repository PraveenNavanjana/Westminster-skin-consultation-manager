import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class
        Main {
    public static void main(String[] args) {
        boolean ans = true;
        Scanner scanner = new Scanner(System.in);
        WestminsterSkinConsultationManager west = new WestminsterSkinConsultationManager();

        System.out.println("\n...Welcome to Westminster Skin Consultation Manager...");

        while (ans) {
            printMenu();
            System.out.println("Enter your selection:");
            String choice = scanner.next().toUpperCase();

            switch (choice) {
                case "A":
                    west.AddDoctor();
                    break;
                case "D":
                    west.DeleteDoctor();
                    break;
                case "P":
                    west.DoctorList();
                    break;
                case "S":
                    west.SaveFile();
                    break;
                case "G":
                    displayInterface();
                    break;
                case "Q":
                    ans = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        System.out.println("\nThank you for your time. Have a nice day!");
    }

    private static void printMenu() {
        System.out.println("Menu");
        System.out.println("A - Add new Doctor");
        System.out.println("D - Delete a Doctor");
        System.out.println("P - Print the list of Doctors");
        System.out.println("S - Save in file");
        System.out.println("G - Display Interface");
        System.out.println("Q - Exit");
    }

    private static void displayInterface() {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                     UnsupportedLookAndFeelException e) {
                throw new RuntimeException(e);
            }
            new HomePageGUI();
        });
    }
}


