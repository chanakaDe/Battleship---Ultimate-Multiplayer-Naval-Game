/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerImpl;

import bunnyclient.MainFrame;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import observer.SenShootMessageObserver;

/**
 *
 * @author LAHIRU
 */
public class SenShootMessageObserverImpl extends UnicastRemoteObject implements SenShootMessageObserver {

    private MainFrame mainFrame;

    public SenShootMessageObserverImpl(MainFrame mainFrame) throws RemoteException {
        this.mainFrame = mainFrame;
    }

    @Override
    public void update(String isMissing, String name) throws RemoteException {
        mainFrame.setShootMessage(isMissing, name);
    }

}
