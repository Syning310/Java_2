package polyarr;

public class Student extends Person
{
    private double score;

    public Student()
    {
        super();
        this.score = 0.0;
    }
    public Student(String name, int age, double score)
    {
        super(name, age);
        this.setScore(score);
    }

    public String say()
    {
        return super.say() + "  score: " + this.getScore();
    }

    public String study()
    {
        return this.getName() + " 正在学习";
    }


    public void setScore(double score)
    {
        this.score = score;
    }
    public double getScore()
    {
        return this.score;
    }



}
