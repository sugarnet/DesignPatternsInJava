package C_structural.D_decorator;

public class E_Exercise {
}

class Bird
{
    public int age;

    public String fly()
    {
        return age < 10 ? "flying" : "too old";
    }
}

class Lizard
{
    public int age;

    public String crawl()
    {
        return (age > 1) ? "crawling" : "too young";
    }
}

class Dragon
{
    private int age;
    public void setAge(int age)
    {
        // todo
    }
    public String fly()
    {
        // todo
    }
    public String crawl()
    {
        // todo
    }
}