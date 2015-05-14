package com.server;

import com.interf.test.TestRemote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author   José Ramón Ruiz Castro 147014
 * @version  0.1
 * @since    2015-01-10
 */
public class ServerDefinition extends UnicastRemoteObject implements TestRemote {

	/**
	 * Identificador único de la serialización (Default).
	 */
	private static final long serialVersionUID = 1L;

	protected ServerDefinition() throws RemoteException {
		super();
	}

	@Override
	public Boolean test(String test) throws RemoteException {
		if(test.equalsIgnoreCase("test")) return true;
		return false;
	}

    @Override
    public int primero(int a , int b )throws RemoteException{
        //int donde se guarda el resultado de la multiplicacion
        int resultado;
        //se realiza la multiplicacion
        resultado = a * b;
        //regresa el resultado
        return resultado;
    }//end primero

    @Override
    public boolean segundo ( String palindromo)throws RemoteException{
        //variable booleana para determinar si es palindromo o no
        boolean a = false ;
        //string donde se va a guardar la palabra recibida volteada
        String contrario = "";
        //string donde se va a guardar la palabra recibida sin espacios
        String palindromosinespacios = "";

        //for para quitar los espacios a la palabra
        for(int i = 0 ; i<palindromo.length() ; i++ ){
            if(palindromo.substring(i , i+1).equals(" ")==false)
                palindromosinespacios = palindromosinespacios + palindromo.substring(i , i+1);
        }//end for i
        ///////////////////////////////////////

        //for para voltear la palabra
        for(int i = palindromosinespacios.length() ; i >=1 ; i--){
            contrario = contrario + palindromosinespacios.substring(i-1 , i);
        }//end for i

        //Determinar si es palindromo o no, comparando la palabra sin espacio con la palabra volteada
        if(palindromosinespacios.equals(contrario))
            a=true;
        //regresa el resultado
        return a;
    }//end segundo

}
