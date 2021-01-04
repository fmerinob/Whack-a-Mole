package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProcesoRMI extends Remote {
	// Calculate the square of a number
	public String print () throws RemoteException;

}

