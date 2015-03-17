/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerImpl;

import controller.ClickLockController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import observer.ClickLockObserver;
import observerble.ClickLockObserverble;

/**
 *
 * @author Shashi
 */
public class ClickLockControllerImpl extends UnicastRemoteObject implements ClickLockController{
    public static ClickLockObserverble observerble=new ClickLockObserverble();
    public ClickLockControllerImpl()throws RemoteException{
        
    }
    @Override
    public boolean addClickObserver(ClickLockObserver observer) throws RemoteException {
        return observerble.addClickObserver(observer);
    }

    @Override
    public boolean removeClickObserver(ClickLockObserver observer) throws RemoteException {
        return observerble.removeClickObserver(observer);
    }

    @Override
    public void sendClick(boolean isClick,String name) throws RemoteException {
        observerble.notifyObserver(isClick,name);
    }
    
}
