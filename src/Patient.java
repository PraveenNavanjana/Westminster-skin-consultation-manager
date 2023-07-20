import java.util.Date;
import java.util.UUID;

public class Patient extends Person {
    private final int id;

    public Patient(String name, String surname, Date birthDate, String mobileNumber, String gender) {
        super(name, surname, birthDate, mobileNumber, gender);
        this.id = generateUniqueId();
    }

    public int getId() {
        return this.id;
    }

    private static int generateUniqueId() {
        UUID randomUUID = UUID.randomUUID();
        long mostSignificantBits = randomUUID.getMostSignificantBits();
        long leastSignificantBits = randomUUID.getLeastSignificantBits();
        int uid = (int) (mostSignificantBits ^ leastSignificantBits);
        return Math.abs(uid);
    }
}
