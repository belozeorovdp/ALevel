package hw7.student;

import hw7.person.Person;

public class Student extends Person
{
    private String idNumber;
    private double gpa;

    public Student(String name, int age, String gender, String idNumber, double gpa)
    {
        super(name, age, gender);
        this.idNumber = idNumber;
        this.gpa = gpa;
    }

    public String getIdNumber()
    {
        return idNumber;
    }

    public void setIdNumber(String idNumber)
    {
        this.idNumber = idNumber;
    }

    public double getGpa()
    {
        return gpa;
    }

    public void setGpa(double gpa)
    {
        this.gpa = gpa;
    }

    @Override
    public String toString()
    {
        return super.getName() + ", age:" + super.getAge() + ", gender:" + super.getGender() + ", student id:" + idNumber + ", gpa:" + gpa;
    }
}
