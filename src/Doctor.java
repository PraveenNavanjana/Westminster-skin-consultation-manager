import java.util.Date;

public class Doctor extends Person implements Comparable<Doctor> {
    private String medicalLicenseNumber;
    private String specialization;

    public Doctor() {
    }

    public Doctor(String name, String surname, Date birthDate, String mobileNumber, String gender, String medicalLicenseNumber, String specialization) {
        super(name, surname, birthDate, mobileNumber, gender);
        this.medicalLicenseNumber = medicalLicenseNumber;
        this.specialization = specialization;
    }



    public String getMedicalLicenseNumber() {
        return medicalLicenseNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public int compareTo(Doctor o) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.getSurname(), o.getSurname());
    }
}
