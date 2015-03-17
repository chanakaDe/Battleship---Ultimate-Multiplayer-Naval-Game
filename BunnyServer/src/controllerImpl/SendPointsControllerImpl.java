/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerImpl;

import controller.SendPointContoller;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import observer.SendPointsObserver;
import observerble.SendPointObsererble;

/**
 *
 * @author Shashi
 */
public class SendPointsControllerImpl extends UnicastRemoteObject implements SendPointContoller{

    public static SendPointObsererble obsererble=new SendPointObsererble();
    
    public SendPointsControllerImpl()throws RemoteException{
        
    }
    
    @Override
    public boolean addSendPointObserver(SendPointsObserver observer) throws RemoteException {
        return obsererble.addSendPointObserver(observer);
    }

    @Override
    public boolean removeSendPointObserver(SendPointsObserver observer) throws RemoteException {
        return obsererble.removeSendPointObserver(observer);
    }

    @Override
    public void sendPoint(int k,boolean b,String playerName) throws RemoteException {
        obsererble.notifyObserver(k,b,playerName);
    }
    
}
