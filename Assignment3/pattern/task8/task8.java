import factory.*;

public class task8 {
    public static void main(String[] args) {
       Team javaTeam = new Team(new JavaRush());
       javaTeam.hireSeniors(1);
       javaTeam.hireMiddles(3);
       javaTeam.hireJuniors(8);
       javaTeam.produceCode();
    }
}
