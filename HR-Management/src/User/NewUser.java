package User;

public class NewUser {
    private String Fname;
    private String Lname;
    private String Education;
    private long MobNo;
    private String DOB;
    private String Email;
    private String gender;
    private float CGPA;
    public NewUser() {}

    public NewUser(String fname, String lname, String education, long mobNo, String DOB,float cgpa, String email, String gender) {
        this.Fname = fname;
        this.Lname = lname;
        this.Education = education;
        this.MobNo = mobNo;
        this.DOB = DOB;
        this.Email = email;
        this.gender = gender;
        this.CGPA = cgpa;
    }

    public float getCGPA() {
        return CGPA;
    }

    public void setCGPA(float CGPA) {
        this.CGPA = CGPA;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public long getMobNo() {
        return MobNo;
    }

    public void setMobNo(long mobNo) {
        MobNo = mobNo;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}