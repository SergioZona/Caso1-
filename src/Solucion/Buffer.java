package Solucion;

import java.util.ArrayList;

public class Buffer 
{
	/**
	 * ArrayList del Buffer.
	 */
	private ArrayList buff;

	/**
	 * Tamaño del arreglo.
	 */
	private int n;

	/**
	 * Número de mensajes en Buffer.
	 */
	private int numMensajes;

	/**
	 * Objetos de la clase.
	 */
	Object lleno, vacio;

	/**
	 * Método constructor de la clase Buffer inicializa los objetos.
	 * @param pN
	 */
	public Buffer(int pN)
	{
		n=pN;
		buff = new ArrayList<Mensaje>();
		lleno = new Object();
		vacio = new Object();
		numMensajes=0;
	}

	public ArrayList<Mensaje> getBuff() {
		return buff;
	}

	public int getN()
	{
		return n;
	}

	public int getNumMensajes()
	{
		return numMensajes;
	}

	public void almacenar(Mensaje pMensaje)
	{
		synchronized (lleno) 
		{
			while(buff.size()==n)
			{
				try 
				{
					System.out.println("Un mensaje está esperando.");
					lleno.wait();
					System.out.println("El mensaje dejó de esperar.");
				} 
				catch (InterruptedException e)
				{

				}
			}

		}
		synchronized (this) 
		{ 
			buff.add(pMensaje);
		}
		synchronized (vacio) 
		{ 
			vacio.notifyAll();
		}
	}

	public Mensaje retirar()
	{
		synchronized(vacio) {
			while (buff.size() == 0) 
				try {
					vacio.wait() ;
				} catch (InterruptedException e) {}
		}
		Mensaje pMensaje;
		synchronized (this) 
		{ 
			if(buff.isEmpty()==true)
			{
				return null;
			}
			else
			{
				pMensaje = (Mensaje) buff.remove(0) ; 
			}
		}
		synchronized (lleno)
		{ 
			lleno.notifyAll();
		}
		return pMensaje ;
	}

}
