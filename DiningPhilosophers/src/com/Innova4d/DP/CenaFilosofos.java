package com.Innova4d.DP;
import java.util.concurrent.locks.ReentrantLock;

/**
 * El problema de los filósofos (Esta versión causa un Deadlock).
 * @author Jose Ramon Ruiz Castro 147014
 * @version 1.0
 */
public class CenaFilosofos {
	// El número de filósofos...
	private static final int NUM_FILOSOFOS = 5;
	
	/**
	 * Una prueba de los filósofos.
	 * @param args Not used
	 */
	public static void main (String[] args) {
		/*
		 *  Cada tenedor es un recurso compartido.
		 *  Los recursos compartidos en Java se definen como tipo Lock.
		 *  
		 */

        ReentrantLock[] tenedores = new ReentrantLock[NUM_FILOSOFOS];
		for (int i = 0; i < NUM_FILOSOFOS; i++) {
			tenedores[i] = new ReentrantLock();
		}
		/*
		 *  Crear un arreglo de filósofos [5] 
		 *  En cada posición del arreglo, crear un filósofo
		 *  Inicializar el Thread para cada filósofo.
		 *   
		 *  En el siguiente ejemplo se implementa un código para inicializar un Thread con un filósofo, 
		 *  realiza el código para inicializar 5 ó más filósofos.
		 *  Checar la variable NUM_FILOSOFOS.
		 */
		Filosofo filosofo1 = new Filosofo(0, tenedores[0], tenedores[(0+1)%NUM_FILOSOFOS]);
        Filosofo filosofo2 = new Filosofo(1, tenedores[1], tenedores[(1+1)%NUM_FILOSOFOS]);
        Filosofo filosofo3 = new Filosofo(2, tenedores[2], tenedores[(2+1)%NUM_FILOSOFOS]);
        Filosofo filosofo4 = new Filosofo(3, tenedores[3], tenedores[(3+1)%NUM_FILOSOFOS]);
        Filosofo filosofo5 = new Filosofo(4, tenedores[4], tenedores[(4+1)%NUM_FILOSOFOS]);
		new Thread(filosofo1).start();
        new Thread(filosofo2).start();
        new Thread(filosofo3).start();
        new Thread(filosofo4).start();
        new Thread(filosofo5).start();
	}

}