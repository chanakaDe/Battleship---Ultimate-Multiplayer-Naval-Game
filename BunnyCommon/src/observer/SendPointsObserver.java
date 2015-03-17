/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Shashi
 */
public interface SendPointsObserver extends Remote {

    public void update(int k,boolean b,String playerName) throws RemoteException;
}
