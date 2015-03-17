/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remotefactoryImpl;

import controller.ClickLockController;
import controller.SendPointContoller;
import controller.SendShootMessageController;
import controller.SendXYController;
import controllerImpl.ClickLockControllerImpl;
import controllerImpl.SenShootMessageControllerImpl;
import controllerImpl.SendPointsControllerImpl;
import controllerImpl.SendXYControllerImpl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import remotefactory.RemoteFactory;

/**
 *
 * @author Shashi
 */
public class RemoteFactoryImpl extends UnicastRemoteObject implements RemoteFactory {

    public RemoteFactoryImpl() throws RemoteException {
    }

    @Override
    public SendXYController getSendXYController() throws RemoteException {
        return new SendXYControllerImpl();
    }

    @Override
    public SendPointContoller getSendPointContoller() throws RemoteException {
        return new SendPointsControllerImpl();
    }

    @Override
    public ClickLockController getClickLockController() throws RemoteException {
        return new ClickLockControllerImpl();
    }

    @Override
    public SendShootMessageController getSendShootMessageController() throws RemoteException {
        return new SenShootMessageControllerImpl();
    }
}
