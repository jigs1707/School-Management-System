
public abstract class Staff implements PersonalInformation
{
    private String stName;
    private String stID;
    private String gender;
    private String title;
    private String position;
    private String email;
    private String location;
    private String number;

    public Staff(String stName, String stID, String gender, String title, String position, String email, String location, String number) {
        this.stName = stName;
        this.stID = stID;
        this.gender = gender;
        this.title = title;
        this.position = position;
        this.email = email;
        this.location = location;
        this.number = number;
    }
    
    
    public Staff()
    {
        
    }

    public String getStName() {
        return this.stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getStID() {
        return this.stID;
    }

    public void setStID(String stID) {
        this.stID = stID;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    
    
    
    
    
    
    @Override
    public String toString() {
        return title + " " + stName + "\nStaff ID: " + stID + "\nGender: " + gender + "\nPhone: " + number + "\nEmail: " + email
                + "\nLocation: " + location + "\nPosition: " + position;
                //"Staff{" + "stName=" + stName + ", stID=" + stID + ", gender=" + gender + ", title=" + title + ", position=" + position + ", email=" + email + ", location=" + location + ", number=" + number + '}';
    }
    
    
    
    
}
