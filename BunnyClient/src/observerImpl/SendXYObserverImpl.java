/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package observerImpl;


import bunnyclient.MainFrame;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import observer.SendXYObserver;

/**
 *
 * @author Shashi
 */
public class SendXYObserverImpl extends UnicastRemoteObject implements SendXYObserver{

    private MainFrame mainFrame;
    
    public SendXYObserverImpl(MainFrame mainFrame)throws RemoteException{
        this.mainFrame=mainFrame;
    }
    
    @Override
    public void update(int x, int y,String playerName,boolean isLock) throws RemoteException {
        mainFrame.setXY(x, y,playerName,isLock);
    }
    
}
