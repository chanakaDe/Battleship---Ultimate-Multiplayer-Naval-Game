/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerImpl;

import controller.SendXYController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import observer.SendXYObserver;
import observerble.SendXYObserverble;

/**
 *
 * @author Shashi
 */
public class SendXYControllerImpl extends UnicastRemoteObject implements SendXYController {

    public static SendXYObserverble observerble = new SendXYObserverble();

    public SendXYControllerImpl() throws RemoteException {
    }

    @Override
    public boolean addSendXYObserver(SendXYObserver observer) throws RemoteException {
        return observerble.addSendXYObserver(observer);
    }

    @Override
    public boolean removeSendXYObserver(SendXYObserver observer) throws RemoteException {
        return observerble.removeSendXYObserver(observer);
    }

    @Override
    public void sendXY(int x, int y,String playerName,boolean isLock) throws RemoteException {
        observerble.notifyObserver(x, y,playerName,isLock);
    }
}
