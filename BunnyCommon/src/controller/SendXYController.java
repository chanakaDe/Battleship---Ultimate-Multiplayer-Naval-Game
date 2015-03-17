/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import observer.SendXYObserver;

/**
 *
 * @author Shashi
 */
public interface SendXYController extends Remote {

    public boolean addSendXYObserver(SendXYObserver observer) throws RemoteException;

    public boolean removeSendXYObserver(SendXYObserver observer) throws RemoteException;

    public void sendXY(int x, int y,String playerName,boolean isLock) throws RemoteException;
}
