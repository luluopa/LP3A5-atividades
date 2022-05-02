package main.java.br.com.lp3a5.ifsp;

import java.util.concurrent.Semaphore;


public class Jantar {

    private static final int numeroDeSemaforos = 5;

    public static void main(String[] args) {
        Semaphore[] chopsticks = new Semaphore[numeroDeSemaforos];

        for (int i = 0; i < numeroDeSemaforos; i++) {
            chopsticks[i] = new Semaphore(1);
        }

        Philosopher[] philosophers = new Philosopher[numeroDeSemaforos];

        for (int i = 0; i < numeroDeSemaforos; i++) {
            philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % numeroDeSemaforos]);
            new Thread(philosophers[i]).start();
        }

    }

}
