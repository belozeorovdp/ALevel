package hw10.person;

import hw10.bag.Bag;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Person
{
    private String name;
    Bag bag;
    private Map bags = new HashMap<String, Bag>();

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

    public void addBagToMap(Bag bag)
    {
        Date date = new Date();
        this.bags.put(date.toString(), bag);
    }

    public Map getMap()
    {
        return bags;
    }

}
