package project113;

import java.util.Scanner;

public class ClinicTester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // مصفوفات لإدارة العيادة
        Doctor[] doctors = new Doctor[10];
        int nbDoctors = 0;

        Patient[] patients = new Patient[20];
        int nbPatients = 0;

        // إضافة بيانات مبدئية بناءً على الترتيب الجديد
        // Doctor: Name, ID, Phone, Salary, StaffID, Specialty
        doctors[nbDoctors++] = new Doctor("Dr. Ahmed", 1155460044, 0500000000, 15000.0, 201, "Cardiology");
        
        // Patient: ID, Name, Phone, Age, MaxAppointments
        patients[nbPatients++] = new Patient(1155466444, "Khalid", 0555555555, 30, 10); 
        patients[nbPatients++] = new Patient(1155464444, "omar", 0555666655, 25, 10); 

        System.out.println("********* ******* Clinic Management System ******* ***************");
        System.out.println("Welcome to the Clinic Management System!");

        int choice;
        do {
            System.out.println("\n==================================");
            System.out.println("1. Add a new Doctor");
            System.out.println("2. Add a new Patient");
            System.out.println("3. Add appointment for a patient");
            System.out.println("4. Find appointment");
            System.out.println("5. Cancel appointment");
            System.out.println("6. Display all appointments for a patient");
            System.out.println("7. Print patient bill & Process payment");
            System.out.println("8. Exit");
            System.out.print("Your choice is: ");
            
            choice = input.nextInt();

            switch (choice) {
                case 1: // Add Doctor (معدل ليطابق الكونستركتر الجديد)
                    if (nbDoctors < doctors.length) {
                        System.out.print("Enter Name: ");
                        String dName = input.next();
                        System.out.print("Enter Doctor ID (National ID): ");
                        int dId = input.nextInt();
                        System.out.print("Enter Phone: ");
                        int dPhone = input.nextInt();
                        System.out.print("Enter Base Salary: ");
                        double sal = input.nextDouble();
                        System.out.print("Enter Staff ID: ");
                        int sId = input.nextInt();
                        System.out.print("Enter Specialty: ");
                        String spec = input.next();

                        doctors[nbDoctors++] = new Doctor(dName, dId, dPhone, sal, sId, spec);
                        System.out.println("✅ Doctor added successfully!");
                    } else {
                        System.out.println("❌ No space for more doctors.");
                    }
                    break;

                case 2: // Add Patient (معدل ليطابق الكونستركتر الجديد)
                    if (nbPatients < patients.length) {
                        System.out.print("Enter Patient ID (National ID): ");
                        int pId = input.nextInt();
                        System.out.print("Enter Name: ");
                        String pName = input.next();
                        System.out.print("Enter Phone: ");
                        int pPhone = input.nextInt();
                        System.out.print("Enter Age: ");
                        int age = input.nextInt();

                        patients[nbPatients++] = new Patient(pId, pName, pPhone, age, 10);
                        System.out.println("✅ Patient added successfully!");
                    } else {
                        System.out.println("❌ No space for more patients.");
                    }
                    break;

                case 3: // Add Appointment
                    if (nbPatients == 0 || nbDoctors == 0) {
                        System.out.println("❌ You must add at least one patient and one doctor first.");
                        break;
                    }
                    
                    System.out.println("\n--- Select Patient ---");
                    for (int i = 0; i < nbPatients; i++) {
                        System.out.println(i + ". " + patients[i].getName());
                    }
                    System.out.print("Enter patient number: ");
                    int pIndex = input.nextInt();

                    System.out.println("\n--- Select Doctor ---");
                    for (int i = 0; i < nbDoctors; i++) {
                        System.out.println(i + ". " + doctors[i].getName() + " (" + doctors[i].calculateAmount() + " SAR)");
                    }
                    System.out.print("Enter doctor number: ");
                    int dIndex = input.nextInt();

                    if (pIndex >= 0 && pIndex < nbPatients && dIndex >= 0 && dIndex < nbDoctors) {
                        System.out.print("Enter appointment date (e.g., 2026-04-10): ");
                        String date = input.next();
                        
                        Appointment newAppt = new Appointment(date, doctors[dIndex]);
                        
                        if (patients[pIndex].addAppointment(newAppt)) {
                            System.out.println("✅ Appointment added successfully! Appointment ID: " + newAppt.getAppointmentId());
                        } else {
                            System.out.println("❌ Failed to add appointment. Patient's schedule is full.");
                        }
                    } else {
                        System.out.println("❌ Invalid patient or doctor selection.");
                    }
                    break;
                    
                case 4: // Find Appointment
                    System.out.print("Enter Patient number (Index): ");
                    int searchPatIndex = input.nextInt();
                    if (searchPatIndex >= 0 && searchPatIndex < nbPatients) {
                        System.out.print("Enter Appointment ID to find: ");
                        int findId = input.nextInt();
                        
                        Appointment found = patients[searchPatIndex].searchAppointmentRecursive(findId, 0);
                        if (found != null) {
                            System.out.println("✅ Appointment found:");
                            found.displayAppointment();
                        } else {
                            System.out.println("❌ Appointment not found.");
                        }
                    } else {
                        System.out.println("❌ Invalid patient selection.");
                    }
                    break;
                    
                case 5: // Cancel Appointment
                    System.out.print("Enter Patient number (Index): ");
                    int cancelPatIndex = input.nextInt();
                    if (cancelPatIndex >= 0 && cancelPatIndex < nbPatients) {
                        System.out.print("Enter Appointment ID to cancel: ");
                        int cancelId = input.nextInt();
                        if (patients[cancelPatIndex].removeAppointment(cancelId)) {
                            System.out.println("✅ Appointment cancelled successfully.");
                        } else {
                            System.out.println("❌ Appointment not found.");
                        }
                    } else {
                        System.out.println("❌ Invalid patient selection.");
                    }
                    break;
                    
                case 6: // Display all
                    System.out.print("Enter Patient number (Index): ");
                    int dispPatIndex = input.nextInt();
                    if (dispPatIndex >= 0 && dispPatIndex < nbPatients) {
                        System.out.println("\n--- All appointments for patient: " + patients[dispPatIndex].getName() + " ---");
                        patients[dispPatIndex].displayAllAppointments();
                    } else {
                        System.out.println("❌ Invalid patient selection.");
                    }
                    break;
                    
                case 7: // Process Payment
                    System.out.print("Enter Patient number (Index): ");
                    int payPatIndex = input.nextInt();
                    if (payPatIndex >= 0 && payPatIndex < nbPatients) {
                        System.out.println("\n--- Financial Operations ---");
                        patients[payPatIndex].processPayment();
                    } else {
                        System.out.println("❌ Invalid patient selection.");
                    }
                    break;
                    
                case 8:
                    System.out.println("Thank you for using the Clinic Management System. Goodbye!");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

    }
}