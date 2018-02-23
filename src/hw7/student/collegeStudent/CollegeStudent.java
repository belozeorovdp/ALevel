package hw7.student.collegeStudent;

import hw7.student.Student;

public class CollegeStudent extends Student
{
    private int year;
    private String major;

    public CollegeStudent(String name, int age, String gender, String idNumber, double gpa, int year, String major)
    {
        super(name, age, gender, idNumber, gpa);
        this.year = year;
        this.major = major;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public String getMajor()
    {
        return major;
    }

    public void setMajor(String major)
    {
        this.major = major;
    }

    @Override
    public String toString()
    {
        return super.getName() + ", age:" + super.getAge() + ", gender:" + super.getGender() + ", student id:" + super.getIdNumber() + ", gpa:" + super.getGpa() + ", year:" + this.year + ", major:" + this.major;
    }
}
