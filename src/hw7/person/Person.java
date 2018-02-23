package hw7.person;

public class Person
{
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender)
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public String getGender()
    {
        return gender;
    }

    @Override
    public String toString()
    {
        return this.name + ", age:" + this.age + ", gender:" + this.gender;
    }
}
