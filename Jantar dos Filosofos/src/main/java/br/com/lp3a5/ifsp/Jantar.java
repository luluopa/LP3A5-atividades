package main.java.br.com.lp3a5.ifsp;

import java.util.concurrent.Semaphore;


public class Jantar {

    private static final int numeroDeSemaforos = 5;

    public static void main(String[] args) {
        Semaphore[] garfo = new Semaphore[numeroDeSemaforos];

        for (int i = 0; i < numeroDeSemaforos; i++) {
        	garfo[i] = new Semaphore(1);
        }

        Filosofo[] Filosofos = new Filosofo[numeroDeSemaforos];

        for (int i = 0; i < numeroDeSemaforos; i++) {
            Filosofos[i] = new Filosofo(i, garfo[i], garfo[(i + 1) % numeroDeSemaforos]);
            new Thread(Filosofos[i]).start();
        }

    }

}
