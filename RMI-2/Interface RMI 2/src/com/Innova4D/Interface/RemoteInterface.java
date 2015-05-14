package com.Innova4D.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote {
	
	/*
	 * Aquí se definen los métodos a implementarse en el servidor.
	 */
	public Object[][] getMapaPistas()  throws RemoteException;
	
	/*
	 * Métodos para el avión
	 */
	public Boolean checkInAvion(Avion a)      throws RemoteException;
	public Avion   getAvion(String id, int c) throws RemoteException;
	public Boolean moverAvion(Avion a, int c) throws RemoteException;
	
	/*
	 * Métodos para el auto.
	 */
	/**
	 * Registra al auto en la pista.
	 * @param a el auto que se desea hacer checkIn.
	 * @return
	 * @throws RemoteException
	 */
	public Boolean checkInAuto(Auto a)       throws RemoteException;
	public Auto    getAuto(String id, int c) throws RemoteException;
	public Boolean moverAuto(Auto a, int c)  throws RemoteException;
    /*
     * Metodos para la moto
     */
    public Boolean checkInMoto(Moto a)       throws RemoteException;
    public Moto    getMoto(String id, int c) throws RemoteException;
    public Boolean moverMoto(Moto a, int c)  throws RemoteException;
    /*
    * Metodos para la moto
    */
    public Boolean checkInMonociclo(Monociclo a)       throws RemoteException;
    public Monociclo    getMonociclo(String id, int c) throws RemoteException;
    public Boolean moverMonociclo(Monociclo a, int c)  throws RemoteException;
}
