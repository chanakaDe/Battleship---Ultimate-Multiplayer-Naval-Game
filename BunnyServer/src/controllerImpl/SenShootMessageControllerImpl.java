/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerImpl;

import controller.SendShootMessageController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import observer.SenShootMessageObserver;
import observerble.SenShootMessageObserverble;

/**
 *
 * @author LAHIRU
 */
public class SenShootMessageControllerImpl extends UnicastRemoteObject implements SendShootMessageController {

    public static SenShootMessageObserverble observerble = new SenShootMessageObserverble();

    public SenShootMessageControllerImpl() throws RemoteException {

    }

    @Override
    public boolean addSendShootMessageObserver(SenShootMessageObserver observer) throws RemoteException {
        return observerble.addSenShootMessageObserver(observer);
    }

    @Override
    public boolean removeSendShootMessageObserver(SenShootMessageObserver observer) throws RemoteException {
       return observerble.removeSenShootMessageObserver(observer);
    }

    @Override
    public void sendIsShoot(String isShoot,String name) throws RemoteException {
        observerble.notifyObserver(isShoot,name);
    }

}
