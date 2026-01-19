package factory;

import junior.JuniorDeveloper;
import middles.MiddleDeveloper;
import seniors.SeniorDeveloper;

public class JavaScriptCourse extends DeveloperCourse {
    public JuniorDeveloper createJunior(){
        return new JuniorDeveloper() {
            @Override
            public void fixBugs() {
                System.out.println("Пишет небольшое мобильное приложение.");
            }
        };
    }
    public MiddleDeveloper createMiddle(){
        return new MiddleDeveloper() {
            @Override
            public void writeNewModule() {
                System.out.println("Пишет новое расширение для браузера.");
            }
        };
    }
    public SeniorDeveloper createSenior(){
        return new SeniorDeveloper() {
            @Override
            public void designArchitecture() {
                System.out.println("Разрабатывает архитектуру новой браузерной игры.");
            }
        };
    }
}
