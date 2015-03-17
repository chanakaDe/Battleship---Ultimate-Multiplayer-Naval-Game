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
public interface SendXYObserver extends Remote {

    public void update(int x, int y,String playerName,boolean isLock) throws RemoteException;
}
