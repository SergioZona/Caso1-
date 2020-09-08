package Solucion;

import java.util.ArrayList;

public class Buffer 
{
	/**
	 * ArrayList del Buffer.
	 */
	private ArrayList buff;
	
	/**
	 * Tama�o del arreglo.
	 */
	private int n;
	
	/**
	 * Objetos de la clase.
	 */
	Object lleno, vacio;
	
	/**
	 * M�todo constructor de la clase Buffer inicializa los objetos.
	 * @param pN
	 */
	public Buffer(int pN)
	{
		n=pN;
		buff = new ArrayList();
		lleno = new Object();
		vacio = new Object();
	}

}
