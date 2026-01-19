package factory;

import junior.JuniorDeveloper;
import middles.MiddleDeveloper;
import seniors.SeniorDeveloper;

public class PythonCourse extends DeveloperCourse {
    public JuniorDeveloper createJunior(){
        return new JuniorDeveloper() {
            @Override
            public void fixBugs() {
                System.out.println("Исправляет мелкие баги в Веб-проекте.");
            }
        };
    }
    public MiddleDeveloper createMiddle(){
        return new MiddleDeveloper() {
            @Override
            public void writeNewModule() {
                System.out.println("Пишет новый модуль для системы машинного обучения.");
            }
        };
    }
    public SeniorDeveloper createSenior(){
        return new SeniorDeveloper() {
            @Override
            public void designArchitecture() {
                System.out.println("Разрабатывает архитектуру нового проекта ИИ.");
            }
        };
    }
}
