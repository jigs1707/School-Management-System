
import java.util.ArrayList;


public class CourseWorkStudent extends Student
{
    private ArrayList<Subject> enrolledSubjects;
    private Subject subjectEnrolled;

    public CourseWorkStudent(String stID, String stName, String gender, String course) {
        super(stID, stName, gender, course);
        
        enrolledSubjects = new ArrayList<>();
        

    }
    
    public CourseWorkStudent(String stID, String stName, String gender, String course, Subject subjectEnrolled)
    {
        super(stID, stName, gender, course);
        
        this.subjectEnrolled = subjectEnrolled;
        
        enrolledSubjects = new ArrayList<>();
        enrolledSubjects.add(subjectEnrolled);
        
    }
    
    public CourseWorkStudent()
    {
        
    }

    public ArrayList<Subject> getEnrolledSubjects() {
        return enrolledSubjects;
    }

    public void setEnrolledSubjects(ArrayList<Subject> enrolledSubjects) {
        this.enrolledSubjects = enrolledSubjects;
    }

    public Subject getSubjectEnrolled() {
        return subjectEnrolled;
    }

    public void setSubjectEnrolled(Subject subjectEnrolled) {
        enrolledSubjects.add(subjectEnrolled);
    }
    
    //prints the student's enrolled subjects
     public String printSubjects()
    {
        String sub = "";
        for(Subject a: enrolledSubjects)
        {
            sub += a.getSubCode() + ", ";
        }
        
        return sub;
    }
    
    

     //prints course work student's information
    @Override
    public String toString() {
        return super.toString() + "\nEnrolled Subjects: " + printSubjects() + "\n";
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
