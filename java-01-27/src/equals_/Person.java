package equals_;

public class Person
{
    private String name;
    private int age;
    private char gender;

    public Person()
    {
        this.name = null;
        this.age = 0;
        this.gender = 0;
    }
    public Person(String name, int age, char gender)
    {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }


    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (obj instanceof Person)
        {
            Person anPerson = (Person)obj;
            if (this.name.equals(anPerson.name) && this.age == anPerson.age && this.gender == anPerson.gender)
            {
                return true;
            }
        }

        return false;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setGender(char gender)
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

    public char getGender()
    {
        return gender;
    }
}
