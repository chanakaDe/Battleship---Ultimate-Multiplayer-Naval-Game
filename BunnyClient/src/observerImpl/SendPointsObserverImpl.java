/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package observerImpl;

import bunnyclient.MainFrame;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import observer.SendPointsObserver;

/**
 *
 * @author chanaka
 */
public class SendPointsObserverImpl extends UnicastRemoteObject implements SendPointsObserver{

    private MainFrame mainFrame;
    
    public SendPointsObserverImpl(MainFrame mainFrame)throws RemoteException{
        this.mainFrame=mainFrame;
    }
    
    @Override
    public void update(int k,boolean b,String playerName) throws RemoteException {
        mainFrame.sendMessage(k,b,playerName);
    }
    
}
