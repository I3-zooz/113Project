package project113;


public class Patient extends Person implements FinancialOperations {
 private int age;
 private Appointment[] appointments; 
 private int nbAppointments;

 public Patient(int id, String name, int phone, int age, int maxAppointments) {
     super(name, id, phone);
     this.age = age;
     this.appointments = new Appointment[maxAppointments];
     this.nbAppointments = 0;
 }

 @Override
 public void displayInfo() {
     System.out.println("Patient Name: " + getName() + " | Age: " + age);
 }

 @Override
 public double calculateAmount() {
     return nbAppointments * 150.0;
 }

 @Override
 public boolean processPayment() {
     System.out.println("Patient " + getName() + " paid bill of: " + calculateAmount());
     return true;
 }

 
 public boolean addAppointment(Appointment a) {
     if (nbAppointments < appointments.length) {
         appointments[nbAppointments++] = a;
         return true;
     }
     return false;
 }

 
 public boolean removeAppointment(int appId) {
     for (int i = 0; i < nbAppointments; i++) {
         if (appointments[i].getAppointmentId() == appId) {
             appointments[i] = appointments[nbAppointments - 1]; 
             appointments[nbAppointments - 1] = null;
             nbAppointments--;
             return true;
         }
     }
     return false;
 }

 
 public Appointment searchAppointmentRecursive(int appId, int index) {
     if (index == nbAppointments) {
         return null;
     }
     // Base case 2: تم العثور عليه
     if (appointments[index].getAppointmentId() == appId) {
         return appointments[index];
     }
     // Recursive call
     return searchAppointmentRecursive(appId, index + 1);
 }

 // عرض كل المواعيد
 public void displayAllAppointments() {
     for (int i = 0; i < nbAppointments; i++) {
         appointments[i].displayAppointment();
         System.out.println("-------------------");
     }
 }
}
