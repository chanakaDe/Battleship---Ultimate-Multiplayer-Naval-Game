/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import observer.SendPointsObserver;

/**
 *
 * @author Shashi
 */
public interface SendPointContoller extends Remote {

    public boolean addSendPointObserver(SendPointsObserver observer) throws RemoteException;

    public boolean removeSendPointObserver(SendPointsObserver observer) throws RemoteException;

    public void sendPoint(int k,boolean b,String playerName) throws RemoteException;
}
