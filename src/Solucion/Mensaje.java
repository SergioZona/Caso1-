package Solucion;

public class Mensaje 
{
	/**
	 * Atributo del escrito del mensaje.
	 */
	private String escrito;
	
	/**
	 * Atributo de la respuesta del mensaje.
	 */
	private String respuesta;
	
	/**
	 * Atributo del cliente que envía el mensaje.
	 */
	private Cliente cliente;
	
	private int numMensaje;
	
	public Mensaje(int pNumMensaje, String pEscrito, Cliente pCliente)
	{
		numMensaje=pNumMensaje;
		escrito=pEscrito;
		cliente=pCliente;
		respuesta="";
	}
	
	public void setRespuesta(String pRespuesta)
	{
		respuesta=pRespuesta;
	}
	
	public Cliente getCliente()
	{
		return cliente;
	}
	
	public int getNumMensaje()
	{
		return numMensaje;
	}
}
