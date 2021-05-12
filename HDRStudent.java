
public class HDRStudent extends Student
{
    private AcademicStaff supervisor;

    public HDRStudent(AcademicStaff supervisor, String stID, String stName, String gender, String course) {
        super(stID, stName, gender, course);
        this.supervisor = supervisor;
        
    }
    
    
    public HDRStudent(String stID, String stName, String gender, String course)
    {
        super(stID, stName, gender, course);
    }
    
    
    public HDRStudent()
    {
        
    }

    public AcademicStaff getSupervisor() {
        return supervisor;
    }

    //sets supervisor for the HDR student
    public void setSupervisor(AcademicStaff supervisor) {
        this.supervisor = supervisor;
    }
    
    

    @Override
    public String toString() {
        return super.toString() + "\nSupervisor: " + supervisor.getStName() + "\n";
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
