package app;

import console.Console;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Console console = new Console();
        console.start();
        while (console.isRun()) {
            console.run();
            Thread.sleep(100);
        }
    }
}
