
import java.util.ArrayList;

public class Subject implements Cloneable
{
    
    private String subCode;
    private String subName;
    private String session;
    private String campus;
    private AcademicStaff coordinator;
    private CourseWorkStudent studentEnrolled;
    private ArrayList<CourseWorkStudent> enrolledStudent;

    public Subject(String subCode, String subName, String session, String campus, AcademicStaff coordinator) {
        this.subCode = subCode;
        this.subName = subName;
        this.session = session;
        this.campus = campus;
        this.coordinator = coordinator;
        
        enrolledStudent = new ArrayList<>();
        
        
    }
    


    public Subject(String subCode, String subName, String session, String campus) {
        this.subCode = subCode;
        this.subName = subName;
        this.session = session;
        this.campus = campus;
        
        enrolledStudent = new ArrayList<>();
    }
    
    public Subject()
    {
        
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public AcademicStaff getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(AcademicStaff coordinator) {
        this.coordinator = coordinator;
    }

    public ArrayList<CourseWorkStudent> getEnrolledStudent() {
        return enrolledStudent;
    }

    public void setEnrolledStudent(ArrayList<CourseWorkStudent> enrolledStudent) {
        this.enrolledStudent = enrolledStudent;
    }

    public CourseWorkStudent getStudentEnrolled() {
        return studentEnrolled;
    }

    public void setStudentEnrolled(CourseWorkStudent studentEnrolled) {
        
        enrolledStudent.add(studentEnrolled);
    }
    
    //prints the enrolled students in a subject
    public String printEnrolledStudents()
    {
        String sub = "";
        for(CourseWorkStudent a: enrolledStudent)
        {
            sub += a.getStName() + ", ";
        }
        
        return sub;
    }
    
    
    
    
    //returns academic staff coordinator 
     public AcademicStaff selectCoordinatorForSubject(AcademicStaff cord)
    {
        
        
        cord = coordinator;
        
        return cord;
    }
     
     
    

     //prints subject's information
    @Override
    public String toString() {
        return "Code: " + subCode + "\nName: " + subName + "\nSession and Year: " + session + "\nCampus: " + campus 
                + "\nCoordinator: " + coordinator.getStName() + "\nEnrolled Students: " + printEnrolledStudents() + "\n";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Subject clone() throws CloneNotSupportedException 
    {
    Subject cloned = (Subject) super.clone();
    
    return cloned;
    }
}
