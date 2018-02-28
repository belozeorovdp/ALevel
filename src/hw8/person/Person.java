package hw8.person;

import hw8.bag.Bag;

public class Person
{
    private String name;
    public enum Status
    {
        OPEN("OPEN"),
        PAID("PAID");
        private String description;
        Status(String description)
        {
            this.description = description;
        }
        public String getDescription()
        {
            return description;
        }
    };
    Status status = Status.OPEN;
    public String getStatus()
    {
        return status.getDescription();
    }
    public void setStatus(String stringStatus)
    {
        if (stringStatus.equals("OPEN"))
        {
            status = Status.OPEN;
        }
        else if(stringStatus.equals("PAID"))
        {
            status = Status.PAID;
        }
    }

    Bag bag;

    public Person(String name)
    {
        this.name = name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public Bag getBag()
    {
        return bag;
    }

    public void setBag(Bag bag)
    {
        this.bag = bag;
    }

    @Override
    public String toString()
    {
        return this.name;
    }



}
