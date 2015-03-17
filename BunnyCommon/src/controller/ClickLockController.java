/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import observer.ClickLockObserver;

/**
 *
 * @author Shashi
 */
public interface ClickLockController extends Remote {

    public boolean addClickObserver(ClickLockObserver observer) throws RemoteException;

    public boolean removeClickObserver(ClickLockObserver observer) throws RemoteException;

    public void sendClick(boolean isClick,String name) throws RemoteException;
}
