/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remotefactory;

import controller.ClickLockController;
import controller.SendPointContoller;
import controller.SendShootMessageController;
import controller.SendXYController;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Shashi
 */
public interface RemoteFactory extends Remote {

    public SendXYController getSendXYController() throws RemoteException;

    public SendPointContoller getSendPointContoller() throws RemoteException;

    public ClickLockController getClickLockController() throws RemoteException;

    public SendShootMessageController getSendShootMessageController() throws RemoteException;
}
