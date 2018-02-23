package hw7;

import hw7.person.Person;
import hw7.student.Student;
import hw7.student.collegeStudent.CollegeStudent;
import hw7.teacher.Teacher;

public class Main
{
    public static void main(String[] args)
    {
        Person[] persons = new Person[5];
        persons[0] = new Person("Иванов И.И.", 25,  "M");
        persons[1] = new Student("Василенко В.В", 20,  "M", "A88880000",4.5);
        persons[2] = new CollegeStudent("Сидоренко Л.Н.", 21,  "F", "A88882222",4.0, 2, "Chemistry");
        persons[3] = new Teacher("Васильев В.Н.", 55,  "M", "Sociology", 2000);
        persons[4] = new Teacher("Калинин К.К.", 50,  "M", "Ukrainian language", 2500);

        for(Person i:persons)
        {
            System.out.println(i.toString());
        }
    }
}
