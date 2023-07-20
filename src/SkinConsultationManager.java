import java.util.ArrayList;

public interface SkinConsultationManager {
    void AddDoctor();
    void DeleteDoctor();
    void DoctorList();
    void SaveFile();
    void LoadFile(ArrayList<Doctor> list);

}
