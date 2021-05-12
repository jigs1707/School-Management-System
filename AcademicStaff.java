
import java.util.ArrayList;

public class AcademicStaff extends Staff implements Cloneable
{
    ArrayList<Subject> teachingSubjects;
    ArrayList<HDRStudent> HDRStudentSupervision;
    ArrayList<AcademicStaff> aStaffList;

    //constructor
    public AcademicStaff(String stName, String stID, String gender, String title, String position, String email, String location, String number) {
        super(stName, stID, gender, title, position, email, location, number);
        
        aStaffList = new ArrayList<>();
        teachingSubjects = new ArrayList<>();
        HDRStudentSupervision = new ArrayList<>();
    }
    
    public AcademicStaff()
    {
        aStaffList = new ArrayList<>();
        teachingSubjects = new ArrayList<>();
        HDRStudentSupervision = new ArrayList<>();
    }

    public ArrayList<Subject> getTeachingSubjects() {
        return teachingSubjects;
    }

    public void setTeachingSubjects(Subject subjects) {
        teachingSubjects.add(subjects);
    }

    public ArrayList<HDRStudent> getHDRStudentSupervision() {
        return HDRStudentSupervision;
    }

    public void setHDRStudentSupervision(HDRStudent student) {
        HDRStudentSupervision.add(student);
    }

    public ArrayList<AcademicStaff> getaStaffList() 
    {
        return aStaffList;
    }

    public void setaStaffList(ArrayList<AcademicStaff> aStaffList) {
        this.aStaffList = aStaffList;
    }
    
    //prints the teaching subjects
    public String printSubjects()
    {
        String sub = "";
        for(Subject a: teachingSubjects)
        {
            sub += a.getSubCode() + ", ";
        }
        
        return sub;
    }
    
    //prints the HDR student supervision list
    public String printSupervision()
    {
        String supervision = "";
        for(HDRStudent a: HDRStudentSupervision)
        {
            supervision = a.getStName();
        }
        
        return supervision;
    }
    
    
    //prints the academic staff list
    public String printAStaffList()
    {
        String names = null;
        aStaffList = new ArrayList<>();
        for(AcademicStaff a: aStaffList)
        {
            int i = 0;
            
            names = i + ": " + a.getStName() + "\n";
            i++;
        }
        
        return names;
    }

    //gets academic staff member based off int input
     public AcademicStaff selectCoordinatorForSubject(int cord)
    {
        AcademicStaff coordinator = new AcademicStaff();
        
        coordinator = aStaffList.get(cord);
        
        return coordinator;
    }
     
     //adds academic staff to academic staff list
     public void addStaffToList(AcademicStaff a)
     {
         aStaffList.add(a);
     }
    

     //prints the academic staff information
    @Override
    public String toString() {
        return super.toString() + "\nTeaching Subjects: " + printSubjects() + "\nHDR Student Supervision: " + printSupervision() + "\n";
    }
    
    
    
    
    //clone method
    public AcademicStaff clone() throws CloneNotSupportedException 
    {
    AcademicStaff cloned = (AcademicStaff) super.clone();
    
    return cloned;
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
