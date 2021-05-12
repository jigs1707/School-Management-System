
public abstract class Student implements PersonalInformation
{
    private String stID;
    private String stName;
    private String gender;
    private String course;

    public Student(String stID, String stName, String gender, String course) {
        this.stID = stID;
        this.stName = stName;
        this.gender = gender;
        this.course = course;
    }
    
    
    public Student()
    {
        
    }

    public String getStID() {
        return this.stID;
    }

    public void setStID(String stID) {
        this.stID = stID;
    }

    public String getStName() {
        return this.stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    
    
    

    @Override
    public String toString() {
        return "Student Name: " + stName + "\nStudent ID: " + stID + "\nGender: " + gender + "\nCourse: " + course;
                
    }
    
    
    
    
}
