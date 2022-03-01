package override.exercise;

public class Student extends Person
{
    private int id;
    private double score;

    public Student()
    {
        super();
        this.id = 0;
        this.score = 0.0;
    }

    public Student(String name, int age, int id, double score)
    {
        super(name, age);
        setId(id);
        setScore(score);
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return this.id;
    }

    public void setScore(double score)
    {
        this.score = score;
    }
    public double getScore()
    {
        return this.score;
    }

    public String say()
    {
        return super.say() + "  id: " + this.getId() + "  成绩： " + this.getScore();
    }


}
