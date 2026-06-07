package edu.eci.arsw.samples;

public class Main {

	public static void main(String[] args) {
		int numHilos=20;
		
		HiloProc[] hilos=new HiloProc[numHilos];
		
		for (int i=0;i<numHilos;i++){
			hilos[i]=new HiloProc(i);
		}
		for (int i=0;i<numHilos;i++){
			hilos[i].start();
		}

		for (int i=0;i<numHilos;i++){
			try {
				hilos[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		long tiempoPromedio=0;

		for (int i=0;i<numHilos;i++){
			tiempoPromedio+=hilos[i].getResultado();
		}

		System.out.println("El tiempo promedio de la ejecucion fue de: " + (tiempoPromedio / numHilos) + " ms");
	}
	
}
