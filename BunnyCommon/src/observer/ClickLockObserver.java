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
public interface ClickLockObserver extends Remote {

    public void update(boolean isClick,String name) throws RemoteException;
}
