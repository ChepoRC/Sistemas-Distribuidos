package com.Innova4D.Server;

import com.Innova4D.Interface.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ControlTower extends UnicastRemoteObject implements RemoteInterface {
	
	/*
	 * El constructor, protegido para asegurar la integridad de ControlTower.
	 * Protected: Accesible únicamente por ésta clase y sus subclases.
	 */
	protected ControlTower() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * { 0, 0, 0, 0, 0, 0, 0, 0 },
	 * { 0, 0, 0, 0, 0, 0, 0, 0 },
	 * { 0, 0, 0, 0, 0, 0, 0, 0 },
	 * { 0, 0, 0, 0, 0, 0, 0, 0 }
	 */	
	private Object[][] mapaPista = new Object[4][8];

	private static final long serialVersionUID = 1L;

	/**
 	* Regresa el mapa de las pistas.
 	*/
	@Override
	public Object[][] getMapaPistas() throws RemoteException {
		return this.mapaPista;
	}
	
	/**
	 * Mueve un avión en la matriz, un bloque a la vez. Izq. Der.
	 */
	@Override
	public Boolean moverAvion(Avion a, int c) throws RemoteException {
		Boolean flag = false;
		int newY = a.getY() + 1;
		if (newY < 8) {
		try {
				this.mapaPista[c][a.getY()] = null;
				this.mapaPista[c][newY] = a;
				a.setX(0);
				a.setY(newY);
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
		}
		return flag;
	}
	
  /**
 	* Busca por un avión en el mapa aéreo usando su ID.
 	* @param id El identificador del objeto.
 	* @param c  El carril donde se encuentra el objeto.
 	*/
	@Override
	public Avion getAvion(String id, int c) throws RemoteException {
		Avion a = null;
		for (int i = 0; i < 8; i++) {
		    if(this.mapaPista[c][i] != null){
		    	a = (Avion) this.mapaPista[c][i];
		    	if(!a.getId().equals(id))
		    		a = null;
		    }
		}
		return a;
	}

	@Override
	public Boolean checkInAvion(Avion a) throws RemoteException {
		if(this.mapaPista[a.getX()][a.getY()] == null)
			this.mapaPista[a.getX()][a.getY()] = a;
		return true;
	}

	/*
	 * Aquí comienzan los métodos del auto.
	 */
	
	@Override
	public Boolean checkInAuto(Auto a) throws RemoteException {
		if(this.mapaPista[a.getX()][a.getY()] == null)
			this.mapaPista[a.getX()][a.getY()] = a;
		return true;
	}

	@Override
	public Auto getAuto(String id, int c) throws RemoteException {
		Auto a = null;
		for (int i = 0; i < 8; i++) {
		    if(this.mapaPista[c][i] != null){
		    	a = (Auto) this.mapaPista[c][i];
		    	if(!a.getId().equals(id))
		    		a = null;
		    }
		}
		return a;
	}

	@Override
	public Boolean moverAuto(Auto a, int c) throws RemoteException {
		Boolean flag = false;
		int newY = a.getY() + 1;
		if (newY < 8) {
		try {
				this.mapaPista[c][a.getY()] = null;
				this.mapaPista[c][newY] = a;
				a.setX(0);
				a.setY(newY);
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
		}
		return flag;
	}

    /*
	 * Aquí comienzan los métodos de la moto.
	 */

    @Override
    public Boolean checkInMoto(Moto a) throws RemoteException {
        if(this.mapaPista[a.getX()][a.getY()] == null)
            this.mapaPista[a.getX()][a.getY()] = a;
        return true;
    }

    @Override
    public Moto getMoto(String id, int c) throws RemoteException {
        Moto a = null;
        for (int i = 0; i < 8; i++) {
            if(this.mapaPista[c][i] != null){
                a = (Moto) this.mapaPista[c][i];
                if(!a.getId().equals(id))
                    a = null;
            }
        }
        return a;
    }

    @Override
    public Boolean moverMoto(Moto a, int c) throws RemoteException {
        Boolean flag = false;
        int newY = a.getY() + 1;
        if (newY < 8) {
            try {
                this.mapaPista[c][a.getY()] = null;
                this.mapaPista[c][newY] = a;
                a.setX(0);
                a.setY(newY);
                flag = true;
            } catch (Exception e) {
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public Boolean checkInMonociclo(Monociclo a) throws RemoteException {
        if(this.mapaPista[a.getX()][a.getY()] == null)
            this.mapaPista[a.getX()][a.getY()] = a;
        return true;
    }

    @Override
    public Monociclo getMonociclo(String id, int c) throws RemoteException {
        Monociclo a = null;
        for (int i = 0; i < 8; i++) {
            if(this.mapaPista[c][i] != null){
                a = (Monociclo) this.mapaPista[c][i];
                if(!a.getId().equals(id))
                    a = null;
            }
        }
        return a;
    }

    @Override
    public Boolean moverMonociclo(Monociclo a, int c) throws RemoteException {
        Boolean flag = false;
        int newY = a.getY() + 1;
        if (newY < 8) {
            try {
                this.mapaPista[c][a.getY()] = null;
                this.mapaPista[c][newY] = a;
                a.setX(0);
                a.setY(newY);
                flag = true;
            } catch (Exception e) {
                flag = false;
            }
        }
        return flag;
    }
}