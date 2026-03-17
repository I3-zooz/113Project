package project113;


public class Appointment {
 private static int idCounter = 1;
 private int appointmentId;
 private String date;
 private Doctor doctor; 

 public Appointment( String date, Doctor doctor) {
	 this.appointmentId = idCounter++;
     this.date = date;
     this.doctor = doctor;
 }

 public void displayAppointment() {
     System.out.println("Appt ID: " + appointmentId + " | Date: " + date);
     System.out.print("With Doctor: ");
     doctor.displayInfo();
 }

 public int getAppointmentId() { return appointmentId; }
 public String getDate() { return date; }
}