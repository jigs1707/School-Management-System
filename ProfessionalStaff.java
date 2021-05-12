
public class ProfessionalStaff extends Staff
{
    private String workingHours;

    public ProfessionalStaff(String workingHours, String stName, String stID, String gender, String title, String position, String email, String location, String number) {
        super(stName, stID, gender, title, position, email, location, number);
        this.workingHours = workingHours;
    }
    
    public ProfessionalStaff()
    {
        
    }

    public ProfessionalStaff(String stName, String stID, String gender, String title, String position, String email, String location, String pNumber) {
        super(stName, stID, gender, title, position, email, location, pNumber);
    }

    @Override
    public String toString() {
        return super.toString() + "\nWorking Hours: " + workingHours + "\n";
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setName(String stName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setID(String stID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
