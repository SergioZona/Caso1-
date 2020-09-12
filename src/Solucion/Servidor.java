package Solucion;

import java.util.ArrayList;

/**
 * Clase del servidor de la aplicación. Extiende de Thread.
 * @author Kevin Steven Gamez Abril y Sergio Julian Zona Moreno. 
 *
 */
public class Servidor extends Thread
{
	
	
	/**
	 * Atributo con el máximo de mensajes que puede procesar el servidor.
	 */
	private int maxMensajes;

	/**
	 * Atributo Buffer.
	 */
	private Buffer buffer;
	
	private ArrayList<Mensaje> mensajes;
	
	private int id;
	
	private boolean centinela;
	
	/**
	 * Inicializa el servidor.
	 * @param pMaxMensajes Cantidad maxima de mensajes que el servidor puede manejar.
	 * @param pBuffer Referencia al buffer que contiene los mensajes.
	 */
	public Servidor(int pId, int pMaxMensajes, Buffer pBuffer)
	{
		id=pId;
		buffer=pBuffer;
		maxMensajes=pMaxMensajes;
		mensajes=new ArrayList<Mensaje>();
		centinela=false;
	}
	
	public synchronized void run() 
	{
		while(mensajes.size()<=maxMensajes){
			
			Mensaje mensaje =buffer.retirar();
			if(mensaje==null)
			{
				notifyAll();
			}
			else
			{
				mensaje.setRespuesta("Respuesta completa.");
				mensajes.add(mensaje);
				if(maxMensajes==mensajes.size())
				{
					for(int i=0; i< mensajes.size();++i)
					{
						Cliente cliente=mensajes.get(0).getCliente();
						System.out.println("El servidor "+id+" respondió el mensaje "+mensajes.get(0).getNumMensaje()+" al cliente "+cliente.idCliente());
						mensajes.remove(0);					
					}
				}
			}			
			try 
			{
				this.sleep(100);
			} 
			catch (InterruptedException e) {
				
			}
		}
	}
}
