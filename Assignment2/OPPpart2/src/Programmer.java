public class Programmer {
    private int salary = 1000;

    public int getSalary(int salary)
    {
        return salary;
    }
    public void setSalary(int salary)
    {
        if(salary > this.salary)
        {
            this.salary = salary;
        }
    }
}
