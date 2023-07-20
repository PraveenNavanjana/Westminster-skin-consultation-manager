import java.util.Date;
import java.io.Serializable;

public class Consultation implements Serializable {
    private final String doctorName;
    private final String specialization;
    private final Date date;
    private final String timeSlot;
    private final String cost;
    private String notes;

    public Consultation(String doctorName, String specialization, Date date, String timeSlot, String notes, String cost) {
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.date = date;
        this.timeSlot = timeSlot;
        this.notes = notes;
        this.cost = cost;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public Date getDate() {
        return date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public String getCost() {
        return cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
