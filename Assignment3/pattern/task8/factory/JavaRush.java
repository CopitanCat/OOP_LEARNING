package factory;

import junior.JuniorDeveloper;
import middles.MiddleDeveloper;
import seniors.SeniorDeveloper;

public class JavaRush extends DeveloperCourse{
    public JuniorDeveloper createJunior(){
        return new JuniorDeveloper() {
            @Override
            public void fixBugs() {
                System.out.println("Исправляет мелкие баги в корпоративной системе документооборота.");
            }
        };
    }
    public MiddleDeveloper createMiddle(){
        return new MiddleDeveloper() {
            @Override
            public void writeNewModule() {
                System.out.println("Пишет новое десктопное приложение.");
            }
        };
    }
    public SeniorDeveloper createSenior(){
        return new SeniorDeveloper() {
            @Override
            public void designArchitecture() {
                System.out.println("Разрабатывает архитектуру нового Веб-проекта.");
            }
        };
    }
}
