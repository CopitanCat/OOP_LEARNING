package factory;
import junior.JuniorDeveloper;
import middles.MiddleDeveloper;
import seniors.SeniorDeveloper;


public abstract class DeveloperCourse {
    public abstract JuniorDeveloper createJunior();
    public abstract MiddleDeveloper createMiddle();
    public abstract SeniorDeveloper createSenior();
}
