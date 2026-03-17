package project113;

import java.util.Scanner;



public class ClinicTester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        Doctor doc1 = new Doctor("Dr. Ahmed", 1155460044,  0500000000, 15000.0, 201, "Cardiology");
        
        
        
        
        Patient currentPatient = new Patient( 1155466444, "Khalid", 0555555555, 30, 10); 

        System.out.println("********* ******* Clinic Management System ******* ***************");
        System.out.println("Welcome to the Clinic Management System, what do you need today? (Enter your menu option)");

        int choice;
        do {
            System.out.println("\n1. Add appointment");
            System.out.println("2. Find appointment");
            System.out.println("3. Cancel appointment");
            System.out.println("4. Display all appointments for that user");
            System.out.println("5. Print patient bill & Process payment");
            System.out.println("6. Exit");
            System.out.print("Your choice is: ");
            
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter appointment date (e.g., 2026-04-10): ");
                    String date = input.next();
                    Appointment newAppt = new Appointment(date, doc1); 
                    
                    if (currentPatient.addAppointment(newAppt)) {
                        System.out.println("✅ Appointment added successfully! Appointment ID: " + newAppt.getAppointmentId());
                    } else {
                        System.out.println("❌ Failed to add appointment. Array is full.");
                    }
                    break;
                    
                case 2:
                    System.out.print("Enter Appointment ID to find: ");
                    int findId = input.nextInt();
                    Appointment found = currentPatient.searchAppointmentRecursive(findId, 0);
                    if (found != null) {
                        System.out.println("✅ Appointment found:");
                        found.displayAppointment();
                    } else {
                        System.out.println("❌ Appointment not found.");
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter Appointment ID to cancel: ");
                    int cancelId = input.nextInt();
                    if (currentPatient.removeAppointment(cancelId)) {
                        System.out.println("✅ Appointment cancelled successfully.");
                    } else {
                        System.out.println("❌ Appointment not found.");
                    }
                    break;
                    
                case 4:
                    System.out.println("\n--- All appointments for patient: " + currentPatient.getName() + " ---");
                    currentPatient.displayAllAppointments();
                    break;
                    
                case 5:
                    System.out.println("\n--- Financial Operations ---");
                    currentPatient.processPayment();
                    break;
                    
                case 6:
                    System.out.println("Thank you for using the Clinic Management System. Goodbye!");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        input.close();
    }
}
