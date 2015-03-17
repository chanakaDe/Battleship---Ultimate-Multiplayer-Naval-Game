/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import observer.SenShootMessageObserver;

/**
 *
 * @author LAHIRU
 */
public interface SendShootMessageController extends Remote {

    public boolean addSendShootMessageObserver(SenShootMessageObserver observer) throws RemoteException;

    public boolean removeSendShootMessageObserver(SenShootMessageObserver observer) throws RemoteException;

    public void sendIsShoot(String isShoot,String name) throws RemoteException;
}
