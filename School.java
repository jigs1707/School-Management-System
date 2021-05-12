import java.util.*;

public class School 
{
    private String sName;
    private AcademicStaff HoS;
    private ProfessionalStaff schoolManager;
    ArrayList<Staff> staffList;
    ArrayList<Subject> subjectList;
    ArrayList<Student> studentList;

    
    public School()
    {
        staffList = new ArrayList<>();
        subjectList = new ArrayList<>();
        studentList = new ArrayList<>();
    }
    
    
    //adds staff to staff list
    public void addToStaffList(Staff s)
    {
        staffList.add(s);
    }
    
    //adds subject to subject list
    public void addToSubjectList(Subject s)
    {
        subjectList.add(s);
    }
    
    //adds student to student list
    public void addToStudentList(Student s)
    {
        studentList.add(s);
    }

    
    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public AcademicStaff getHoS() {
        return HoS;
    }

    public void setHoS(AcademicStaff HoS) {
        this.HoS = HoS;
    }

    public ProfessionalStaff getSchoolManager() {
        return schoolManager;
    }

    public void setSchoolManager(ProfessionalStaff schoolManager) {
        this.schoolManager = schoolManager;
    }

    //prints out the staff memebers in the school
    public void getStaffList() {
        for(Staff a: staffList)
        {
            System.out.println(a);
        }
    }

    public void setStaffList(ArrayList<Staff> staffList) {
        this.staffList = staffList;
    }

    //prints out the subjects in the school
    public void getSubjectList() {
        for(Subject a: subjectList)
        {
            System.out.println(a.toString());
        }
    }

    public void setSubjectList(ArrayList<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    //prints out the students in the school
    public void getStudentList() {
        for(Student a: studentList)
        {
            System.out.println(a);
        }
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    
   
    
    //prints out school information
    @Override
    public String toString() {
        return "School{" + "sName=" + sName + ", HoS=" + HoS + ", schoolManager=" + schoolManager + ", staffList=" + staffList + ", subjectList=" + subjectList + ", studentList=" + studentList + '}';
    }
    
    
    
}
