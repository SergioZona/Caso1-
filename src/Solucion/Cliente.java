package Solucion;

import java.util.ArrayList;

/**
 * Clase que maneja los clientes. Extiende de Thread.
 * @author Kevin Steven Gamez Abril y Sergio Julian Zona Moreno. 
 *
 */
public class Cliente extends Thread
{
	/**
	 * Atributo con el máximo de mensajes que puede procesar el .
	 */
	private int numMensajes;
	
	/**
	 * Atributo Buffer.
	 */
	private Buffer buffer;
	
	private int idCliente;
	
	private ArrayList<Mensaje> mensajes;
	
	public Cliente(int pId, int pNumMensajes, Buffer pBuffer)
	{
		idCliente=pId;
		buffer=pBuffer;
		numMensajes=pNumMensajes;
		mensajes=new ArrayList<Mensaje>();
	}
	
	public int idCliente()
	{
		return idCliente;
	}
	
	public synchronized void run()
	{
		for(int i=0; i<numMensajes; ++i)
		{
			mensajes.add(new Mensaje(i,"Mensaje que espera respuesta", this));
		}
		for(int i=0; i<numMensajes;++i)
		{
			buffer.almacenar(mensajes.get(i));
		}
	}

}
