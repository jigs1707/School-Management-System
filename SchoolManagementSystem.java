
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SchoolManagementSystem 
{
    //Initialisation of different class objects
    static School schoolObject = new School();
    static AcademicStaff aStaffObject = new AcademicStaff();
    static HDRStudent hdrStudentObject = new HDRStudent();
    static CourseWorkStudent cStudentObject = new CourseWorkStudent();
    static Subject subObject = new Subject();
    


public static void main(String[] args)
    {
        System.out.println("Welcome to the School of Computer Science");
        System.out.println();
        
        Scanner sc = new Scanner(System.in);
        
        //Calls the method to display the menu and options
        menu();

           
    }
    
    
    public static void menu()
    {
        int selection;
        
        //A loop to display the menu after the end of each option, till the user enters 8
        do
        {
            //Prints out the system options to user
            System.out.println();
        System.out.println("Please make a select from the following items:");
        System.out.println("1: initialise the school");
        System.out.println("2: add a staff");
        System.out.println("3: add a subject");
        System.out.println("4: add a student");
        System.out.println("5: display the school staff");
        System.out.println("6: display the school subjects");
        System.out.println("7: display the school students");
        System.out.println("8: exit the system");
        
        Scanner sc = new Scanner(System.in);

        //Gets user input for option
        selection = sc.nextInt();
        
        //Uses user input to call the different menu options
        switch(selection)
        {
            //initialises the system and creates the objects with pre-entered information which are then added into the school object
            case 1: {
            try {
                initialiseSchool();
            } catch (CloneNotSupportedException ex) {
                ex.printStackTrace();
            }
        }
                    break;
            //adds new staff member        
            case 2: addStaff();
            break;
            
            //adds new subject
            case 3: addSubject();
            break;
            
            //adds new student
            case 4: addStudent();
            break;
            
            //displays all the staff members in the school
            case 5: System.out.println("School Staff List: ");
                displaySchoolStaff();
            break;
            
            //displays all the subjects in the school
            case 6: System.out.println("School Subject List: ");
                displaySchoolSubjects();
            break;
            
            //displays all the students in the school
            case 7: System.out.println("School Student List: ");
                displaySchoolStudents();
            break;
            
            //prints out a exit confirmation message
            case 8: System.out.println("Thanks for using the SMS, see you next time.");
                    break;
                    
            default:
            break;
        }
        } while(selection != 8);
    }
    
    
    public static void addStaff()
    {
        
        
        Scanner sc = new Scanner(System.in);
        
        //requests user for input on new staff member's details
        System.out.println("Please input the staff name:");
        String name = sc.nextLine();
        
        System.out.println("Please input the staff ID:");
        String id = sc.nextLine();
        
        System.out.println("Please input the staff title:");
        String title = sc.nextLine();
        
        System.out.println("Please input the staff gender:");
        String gender = sc.nextLine();
        
        System.out.println("Please input the staff position:");
        String position = sc.nextLine();
        
        System.out.println("Please input the staff phone number:");
        String pNumber = sc.nextLine();
        
        System.out.println("Please input the staff email address:");
        String email = sc.nextLine();
        
        System.out.println("Please input the staff office location:");
        String location = sc.nextLine();
        
        System.out.println("Is this (1) a professional staff or (2) an academic staff?");
        int staffType = sc.nextInt();
        
        //if input is 1 then the new staff is created as a professional staff and added to school 
        if(staffType == 1)
        {
            ProfessionalStaff pStaff = new ProfessionalStaff(name, id, gender, title, position, email, location, pNumber);
            schoolObject.addToStaffList(pStaff);
            
        }
        
        //if input is 2 then the new staff is created as an academic staff and added to school and academic staff list
        else if(staffType == 2)
        {
            AcademicStaff aStaff = new AcademicStaff(name, id, gender, title, position, email, location, pNumber);
            schoolObject.addToStaffList(aStaff);
            aStaffObject.addStaffToList(aStaff);
           
            
        }
        
        //if wrong input entered then user is directed back to main menu
        else
        {
            System.out.println("Incorrect input entered");
        }
        
        System.out.println();

        
    }
    
    
    public static void addSubject()
    {
        Scanner sc = new Scanner(System.in);

        //requests user input on the new subject's information
        System.out.println("Please input the subject code:");
        String subCode = sc.nextLine();
        
        System.out.println("Please input the subject name:");
        String subName = sc.nextLine();
        
        System.out.println("Please input the subject session and year (such as Autumn 2021):");
        String session = sc.nextLine();
        
        System.out.println("Please input the campus (Wollongong or SWS):");
        String campus = sc.nextLine();
        
        System.out.println("Please nominate a subject coordinator from the following staff:");
        
        int x = 0;
        
        //uses instanceof to print out all the academic staff from school staff list
        for(Staff a: schoolObject.staffList)
        {
            
            if(a instanceof AcademicStaff)
            {
                
                System.out.println(x + ". " + a.toString());
                x++;
            }
        }
        
                System.out.println("Please input the index for the subject coordinator:");
        
                int cord = sc.nextInt();
                
                //creates new subject object
                subObject = new Subject(subCode, subName, session, campus);

                //uses user input to select subject coordinator 
                for(int i=0; i < aStaffObject.aStaffList.size(); i++)
                {
                    
                        aStaffObject = aStaffObject.aStaffList.get(cord);
                        
                }
                
                //sets subject coordinator for subject
                //sets staff's teaching subject
                //adds subject to school
                aStaffObject.setTeachingSubjects(subObject);
                subObject.setCoordinator(aStaffObject);
                schoolObject.addToSubjectList(subObject);
                

                

        

        
    }
    
    
    public static void addStudent()
    {
        Scanner sc = new Scanner(System.in);
        int x = 0;
       
        //requests user input for new student's information
        System.out.println("Please input the student name: ");
        String name = sc.nextLine();
        
        System.out.println("Please input the student ID: ");
        String ID = sc.nextLine();
        
        System.out.println("Please input the student gender: ");
        String gender = sc.nextLine();
        
        System.out.println("Please input the student course (BCS, BIT, MCS, MIT or PhD): ");
        String course = sc.nextLine();
        
        //if student enter "PhD" then prints out the academic staffs using instanceof
        if(course.equals("PhD"))
        {
            for(Staff a: schoolObject.staffList)
        {
            
            if(a instanceof AcademicStaff)
            {
                
                System.out.println(x + ". " + a.toString());
                x++;
            }
        }
            
            System.out.println("Please input the index for the supervisor: ");
            
            //requests user input to select supervisor
            int supervisor = sc.nextInt();
            
            //creates new HDRStudentObject
            HDRStudent hdrStudentObject = new HDRStudent(ID, name, gender, course);
            
            //uses user input to get academic staff
            for(int i=0; i < aStaffObject.aStaffList.size(); i++)
                {
                    
                        aStaffObject = aStaffObject.aStaffList.get(supervisor);
                        
                        
                }
            
            //sets staff as supervisor
            //adds student to school
            aStaffObject.setHDRStudentSupervision(hdrStudentObject);
            hdrStudentObject.setSupervisor(aStaffObject);
            schoolObject.addToStudentList(hdrStudentObject);
        }
        
        
        
        //if other course options are entered then prints out the current subjects in school
        else if(course.equals("BCS") || course.equals("BIT") || course.equals("MCS") || course.equals("MIT"))
        {
           System.out.println("Please enrol at least one subject offered by the school: ");
           
            for(Subject s: schoolObject.subjectList)
            {
                System.out.println(x + ". " + s.getSubCode() + " (" + s.getSubName() + ")");
                x++;
            }
            
            System.out.println("Please input the index for the subjects (seperate by comma): ");
            
            //requests user's input to select subjects to enroll
            String sub = sc.nextLine();
            
            //creates new CourseWorkStudent object
            CourseWorkStudent cStudentObject = new CourseWorkStudent(ID, name, gender, course);
            
            //an array is implemented to split the user input with a comma
            String[] subjectArray = sub.split(",");
            
            //loops through the array and selects the subject based off the int value
            //sets subject as the student's enrolled subject
            //updates subject's enrolled student
            for(int i = 0; i < subjectArray.length; i++)
            {
                int subPick = Integer.valueOf(subjectArray[i]);

                subObject = schoolObject.subjectList.get(subPick);

                cStudentObject.setSubjectEnrolled(subObject);
                subObject.setStudentEnrolled(cStudentObject);
                
            }
            
            schoolObject.addToStudentList(cStudentObject);
        }
        
        //prints out wrong course entered and goes back to main menu
        else
        {
            System.out.println("Wrong course entered");
        }
    }
    
    //calls the school class method to print out staff members in school
    public static void displaySchoolStaff()
    {

        schoolObject.getStaffList();
    }
    
    //calls the school class method to print out subjects in school
    public static void displaySchoolSubjects()
    {
        
        schoolObject.getSubjectList();
    }
    
    //calls the school class method to print out students in school
    public static void displaySchoolStudents()
    {
        schoolObject.getStudentList();
    }
    
    
    //initialise school
    public static void initialiseSchool() throws CloneNotSupportedException
    {

        //creates new staff objects
        Staff aStaff1 = new AcademicStaff("David", "100001", "Male", "Professor", "HoS", "david@university.edu.au", "3.001", "4221-1111");
        Staff aStaff2 = new AcademicStaff("Liam", "100003", "Male", "Dr.", "Lecturer", "liam@university.edu.au", "3.003", "4221-1113");
        Staff aStaff3 = new AcademicStaff("Noah", "100004", "Male", "Dr.", "Lecturer", "noah@university.edu.au", "3.004", "4221-1114");
        Staff aStaff4 = new AcademicStaff("William", "100005", "Male", "Dr.", "Lecturer", "william@university.edu.au", "3.005", "4221-1115");
        Staff aStaff5 = new AcademicStaff("Emma", "100006", "Female", "Dr.", "Lecturer", "emma@university.edu.au", "3.006", "4221-1116");
        Staff aStaff6 = new AcademicStaff("Ava", "100007", "Female", "Dr.", "Lecturer", "ava@university.edu.au", "3.007", "4221-1117");
        Staff aStaff7 = new AcademicStaff("Mia", "100008", "Female", "Dr.", "Lecturer", "mia@university.edu.au", "3.008", "4221-1118");
        
        Staff pStaff1 = new ProfessionalStaff("Mon. ~ Thur.", "Cindy", "100002", "Female", "Miss", "Manager", "cindy@university.edu.au", "3.002", "4221-1112");
        
        
        
        

        

        

        //creates new subject objects and clones certain ones that are also offered in the SWS campus
        //changes the cloned subjects code and campus
        Subject sub1 = new Subject("CSIT111", "Programming Fundamentals", "Autumn 2021", "Wollongong", (AcademicStaff) aStaff2);
        Subject sub1b = (Subject)((Subject) sub1).clone();
        sub1b.setSubCode("CSIT111SWS");
        sub1b.setCampus("SWS");

        
        Subject sub2 = new Subject("CSIT113", "Problem Solving", "Autumn 2021", "Wollongong", (AcademicStaff) aStaff3);
        Subject sub2b = (Subject)((Subject) sub2).clone();
        sub2b.setSubCode("CSIT113SWS");
        sub2b.setCampus("SWS");

        
        Subject sub3 = new Subject("CSIT114", "System Analysis", "Autumn 2021", "Wollongong", (AcademicStaff) aStaff4);
        Subject sub3b = (Subject)((Subject) sub3).clone();
        sub3b.setSubCode("CSIT114SWS");
        sub3b.setCampus("SWS");

        
        Subject sub4 = new Subject("CSIT115", "Data Management and Security", "Autumn 2021", "Wollongong", (AcademicStaff) aStaff5);
        Subject sub5 = new Subject("CSIT121", "Object Oriented Design and Programming", "Autumn 2021", "Wollongong", (AcademicStaff) aStaff6);
        Subject sub6 = new Subject("CSIT127", "Networks and Communications", "Autumn 2021", "Wollongong", (AcademicStaff) aStaff7);
        Subject sub7 = new Subject("CSIT128", "Introduction to Web Technology", "Autumn 2021", "Wollongong", (AcademicStaff) aStaff7);
        Subject sub8 = new Subject("CSCI214", "IT Project Management", "Autumn 2021", "Wollongong", (AcademicStaff) aStaff1);
        Subject sub9 = new Subject("CSCI235", "Database Systems", "Autumn 2021", "Wollongong", (AcademicStaff) aStaff5);
        Subject sub10 = new Subject("CSCI251", "Advanced Programming", "Autumn 2021", "Wollongong", (AcademicStaff) aStaff6);
        
        
        

        //creates new student objects
        Student cStudent1 = new CourseWorkStudent("1234501", "Isabella", "Female", "BCS", sub1);
        Student cStudent2 = new CourseWorkStudent("1234502", "James", "Male", "BCS", sub1b);
        Student cStudent3 = new CourseWorkStudent("1234503", "Sophia", "Female", "BCS", sub2);
        Student cStudent4 = new CourseWorkStudent("1234504", "Logan", "Male", "BCS", sub2b);
        Student cStudent5 = new CourseWorkStudent("1234505", "Charlotte", "Female", "BCS", sub3);
        Student cStudent6 = new CourseWorkStudent("1234506", "Benjamin", "Male", "BCS", sub3b);
        Student cStudent7 = new CourseWorkStudent("1234507", "Amelia", "Female", "BCS", sub4);
        Student cStudent8 = new CourseWorkStudent("1234508", "Mason", "Male", "BCS", sub5);
        Student cStudent9 = new CourseWorkStudent("1234509", "Evelyn", "Female", "BCS", sub6);
        Student cStudent10 = new CourseWorkStudent("12345010", "Elijah", "Male", "BCS", sub7);
        Student cStudent11 = new CourseWorkStudent("12345011", "Emily", "Female", "BCS", sub8);
        Student cStudent12 = new CourseWorkStudent("12345012", "Aiden", "Male", "BCS", sub9);
        Student cStudent13 = new CourseWorkStudent("12345013", "Selena", "Female", "BCS", sub10);
        
        
        Student hdrStudent1 = new HDRStudent((AcademicStaff) aStaff1, "12345014", "Sofia", "Female", "PhD");
        Student hdrStudent2 = new HDRStudent((AcademicStaff) aStaff2, "12345015", "Lucas", "Male", "PhD");
        Student hdrStudent3 = new HDRStudent((AcademicStaff) aStaff3, "12345016", "Ella", "Female", "PhD");
        Student hdrStudent4 = new HDRStudent((AcademicStaff) aStaff4, "12345017", "Ethan", "Male", "PhD");
        Student hdrStudent5 = new HDRStudent((AcademicStaff) aStaff5, "12345018", "Victoria", "Female", "PhD");
        Student hdrStudent6 = new HDRStudent((AcademicStaff) aStaff6, "12345019", "Daniel", "Male", "PhD");
        Student hdrStudent7 = new HDRStudent((AcademicStaff) aStaff7, "12345020", "Grace", "Female", "PhD");
        
        //sets the student enrolled in a subject
        sub1.setStudentEnrolled((CourseWorkStudent) cStudent1);
        sub1b.setStudentEnrolled((CourseWorkStudent) cStudent2);
        sub2.setStudentEnrolled((CourseWorkStudent) cStudent3);
        sub2b.setStudentEnrolled((CourseWorkStudent) cStudent4);
        sub3.setStudentEnrolled((CourseWorkStudent) cStudent5);
        sub3b.setStudentEnrolled((CourseWorkStudent) cStudent6);
        sub4.setStudentEnrolled((CourseWorkStudent) cStudent7);
        sub5.setStudentEnrolled((CourseWorkStudent) cStudent8);
        sub6.setStudentEnrolled((CourseWorkStudent) cStudent9);
        sub7.setStudentEnrolled((CourseWorkStudent) cStudent10);
        sub8.setStudentEnrolled((CourseWorkStudent) cStudent11);
        sub9.setStudentEnrolled((CourseWorkStudent) cStudent12);
        sub10.setStudentEnrolled((CourseWorkStudent) cStudent13);
        
        
        
        //clones academic staff members to set student supervision and teaching subjects
        AcademicStaff aStaff1b = (AcademicStaff)((AcademicStaff) aStaff1).clone();
        aStaff1b.setHDRStudentSupervision((HDRStudent) hdrStudent1);
        aStaff1b.setTeachingSubjects(sub8);
        
                AcademicStaff aStaff2b = (AcademicStaff)((AcademicStaff) aStaff2).clone();
        aStaff2b.setHDRStudentSupervision((HDRStudent) hdrStudent2);
        aStaff2b.setTeachingSubjects(sub1);
        aStaff2b.setTeachingSubjects(sub1b);
        
                AcademicStaff aStaff3b = (AcademicStaff)((AcademicStaff) aStaff3).clone();
        aStaff3b.setHDRStudentSupervision((HDRStudent) hdrStudent3);
        aStaff3b.setTeachingSubjects(sub2);
        aStaff3b.setTeachingSubjects(sub2b);
        
                AcademicStaff aStaff4b = (AcademicStaff)((AcademicStaff) aStaff4).clone();
        aStaff4b.setHDRStudentSupervision((HDRStudent) hdrStudent4);
        aStaff4b.setTeachingSubjects(sub3);
        aStaff4b.setTeachingSubjects(sub3b);
        
                AcademicStaff aStaff5b = (AcademicStaff)((AcademicStaff) aStaff5).clone();
        aStaff5b.setHDRStudentSupervision((HDRStudent) hdrStudent5);
        aStaff5b.setTeachingSubjects(sub4);
        aStaff5b.setTeachingSubjects(sub9);
        
                AcademicStaff aStaff6b = (AcademicStaff)((AcademicStaff) aStaff6).clone();
        aStaff6b.setHDRStudentSupervision((HDRStudent) hdrStudent6);
        aStaff6b.setTeachingSubjects(sub5);
        aStaff6b.setTeachingSubjects(sub10);
        
                AcademicStaff aStaff7b = (AcademicStaff)((AcademicStaff) aStaff7).clone();
        aStaff7b.setHDRStudentSupervision((HDRStudent) hdrStudent7);
        aStaff7b.setTeachingSubjects(sub6);
        aStaff7b.setTeachingSubjects(sub7);
                
        //adds final staff members to school
        schoolObject.addToStaffList(aStaff1b);
        schoolObject.addToStaffList(aStaff2b);
        schoolObject.addToStaffList(aStaff3b);
        schoolObject.addToStaffList(aStaff4b);
        schoolObject.addToStaffList(aStaff5b);
        schoolObject.addToStaffList(aStaff6b);
        schoolObject.addToStaffList(aStaff7b);
        schoolObject.addToStaffList(pStaff1);
        
        //adds final academic staff members to the academic staff array list
        aStaffObject.addStaffToList(aStaff1b);
        aStaffObject.addStaffToList(aStaff2b);
        aStaffObject.addStaffToList(aStaff3b);
        aStaffObject.addStaffToList(aStaff4b);
        aStaffObject.addStaffToList(aStaff5b);
        aStaffObject.addStaffToList(aStaff6b);
        aStaffObject.addStaffToList(aStaff7b);


        
        
        
        //adds subjects to school
        schoolObject.addToSubjectList(sub1);
        schoolObject.addToSubjectList(sub1b);
        schoolObject.addToSubjectList(sub2);
        schoolObject.addToSubjectList(sub2b);
        schoolObject.addToSubjectList(sub3);
        schoolObject.addToSubjectList(sub3b);
        schoolObject.addToSubjectList(sub4);
        schoolObject.addToSubjectList(sub5);
        schoolObject.addToSubjectList(sub6);
        schoolObject.addToSubjectList(sub7);
        schoolObject.addToSubjectList(sub8);
        schoolObject.addToSubjectList(sub9);
        schoolObject.addToSubjectList(sub10);
        
        //adds students to school
        schoolObject.addToStudentList(cStudent1);
        schoolObject.addToStudentList(cStudent2);
        schoolObject.addToStudentList(cStudent3);
        schoolObject.addToStudentList(cStudent4);
        schoolObject.addToStudentList(cStudent5);
        schoolObject.addToStudentList(cStudent6);
        schoolObject.addToStudentList(cStudent7);
        schoolObject.addToStudentList(cStudent8);
        schoolObject.addToStudentList(cStudent9);
        schoolObject.addToStudentList(cStudent10);
        schoolObject.addToStudentList(cStudent11);
        schoolObject.addToStudentList(cStudent12);
        schoolObject.addToStudentList(cStudent13);
        schoolObject.addToStudentList(hdrStudent1);
        schoolObject.addToStudentList(hdrStudent2);
        schoolObject.addToStudentList(hdrStudent3);
        schoolObject.addToStudentList(hdrStudent4);
        schoolObject.addToStudentList(hdrStudent5);
        schoolObject.addToStudentList(hdrStudent6);
        schoolObject.addToStudentList(hdrStudent7);


    }
}
