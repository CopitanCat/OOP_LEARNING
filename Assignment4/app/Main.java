package app;

import console.Console;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Console console = new Console();
        for(int i = 0; i<10; i++) {
            console.start();
        }
    }
}
