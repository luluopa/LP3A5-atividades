package main.java.br.com.lp3a5.ifsp;

import java.util.Random;
import java.util.concurrent.Semaphore;

class Filosofo implements Runnable {
	
	final private int loopIterationQuantidade = 100;
	final private int quantidadeDeFilosofo = 5;

    private int id;
    private int tempoDeComer;

    private int quantidade=0;


    private Semaphore garfoEsquerda;
    private Semaphore garfoDireita;


    public Filosofo(int id, Semaphore garfoEsquerda, Semaphore garfoDireita) {
        this.id = id;
        this.garfoEsquerda = garfoEsquerda;
        this.garfoDireita = garfoDireita;
    }

    public void run() {
        try {
            while (quantidade < loopIterationQuantidade){
                pensar();
                pegarColherEsquerda();
                pegarColherDireita();
                comer();
                desocuparColheres();
            }
        } catch (InterruptedException e) {
            System.out.println("Filosofo " + id + " foi interrompido.\n");
        }
    }


    private void pensar() throws InterruptedException {
        System.out.println("Filosofo " + id + " esta pensando.\n");
        System.out.flush();
        Thread.sleep(new Random().nextInt(10));
    }


    private void pegarColherEsquerda() throws InterruptedException{
        if(garfoEsquerda.availablePermits() == 0){
            System.out.println("Filosofo " +id +" esta esperando pelo talher da esquerda");
        }

        garfoEsquerda.acquire();
        System.out.println("Filosofo " + id + " esta segurando o talher da esquerda.\n");
    }


    private void pegarColherDireita()  throws InterruptedException{
        if(garfoDireita.availablePermits() ==0){
            System.out.println("Filosofo " +id +" esta esperando pelo talher da direita");
        }

        garfoDireita.acquire();
        System.out.println("Filosofo " + id + " esta segurando o talher da direita.\n");

    }
    
    private int gerarNumeroAleatorioMenorQueIndexMaiorQueZero(int index) throws InterruptedException {
    	if (index > 0) {
    		return new Random().nextInt(index);
    	}
    	else {
    		throw new InterruptedException("funcao: gerarNumeroAleatorioMenorQueIndexMaiorQueZero deve ter parametro maior que 0");
    	}
    }


    private void comer() throws InterruptedException {
        System.out.println("Filosofo " + id + " esta comendo.\n");
        System.out.flush();
        do{
            tempoDeComer = this.gerarNumeroAleatorioMenorQueIndexMaiorQueZero(10);
        }while (tempoDeComer<=0);

        if (quantidade + tempoDeComer * quantidadeDeFilosofo > loopIterationQuantidade){
            tempoDeComer = (loopIterationQuantidade - quantidade)/quantidadeDeFilosofo;
            quantidade = loopIterationQuantidade;
        }else {
            quantidade = quantidade + tempoDeComer * quantidadeDeFilosofo;
        }

        Thread.sleep(tempoDeComer);
    }


    private void desocuparColheres() {
        garfoEsquerda.release();
        garfoDireita.release();
        System.out.println("Filosofo " + id +  " comeu "+quantidade+"% e"+" soltou os talheres da esquerda e direita \n");
    }

}
