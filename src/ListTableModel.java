import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

class ListTableModel extends AbstractTableModel {
    private final String[] columnName = {"Medical License Number", "Name of the doctor", "Date Of Birth", "Gender", "Mobile Number", "Specialization"};
    private final ArrayList<Doctor> docList;

    public ListTableModel(ArrayList<Doctor> listOfDoc){
        docList = listOfDoc;
    }

    @Override
    public int getRowCount() {
        return docList.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        if(columnIndex == 0){
            temp = docList.get(rowIndex).getMedicalLicenseNumber();
        }else if(columnIndex == 1){
            temp = docList.get(rowIndex).getName() + " " + docList.get(rowIndex).getSurname();
        }else if(columnIndex == 2){
            temp = docList.get(rowIndex).getDateOfBirth();
        }else if(columnIndex == 3){
            temp = docList.get(rowIndex).getGender();
        }else if(columnIndex == 4){
            temp = docList.get(rowIndex).getMobileNumber();
        }else if(columnIndex == 5){
            temp = docList.get(rowIndex).getSpecialization();
        }
        return temp;
    }

    public String getColumnName(int col){
        return columnName[col];
    }

    public Class getColumnClass(int col){
        if(col == 0){
            return String.class;
        }else if(col == 1){
            return String.class;
        }else if(col == 2){
            return Date.class;
        }else if(col == 3){
            return String.class;
        }else if(col == 4){
            return String.class;
        }else if(col == 5){
            return String.class;
        }
        else {
            return null;
        }
    }
}
