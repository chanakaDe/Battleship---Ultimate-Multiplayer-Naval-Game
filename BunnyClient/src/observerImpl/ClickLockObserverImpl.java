/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package observerImpl;

import bunnyclient.ShootArea;
import controller.ClickLockController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import observer.ClickLockObserver;

/**
 *
 * @author Shashi
 */
public class ClickLockObserverImpl extends UnicastRemoteObject implements ClickLockObserver{
    
    private ShootArea shootArea;
    
    public ClickLockObserverImpl(ShootArea shootArea)throws RemoteException{
        this.shootArea=shootArea;
    }

    @Override
    public void update(boolean isClick,String name) throws RemoteException {
       shootArea.lockClick(isClick,name);
    }
    
}
