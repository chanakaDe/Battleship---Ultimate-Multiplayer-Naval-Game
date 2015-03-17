/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connector;

import controller.ClickLockController;
import controller.SendPointContoller;
import controller.SendShootMessageController;
import controller.SendXYController;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import remotefactory.RemoteFactory;

/**
 *
 * @author Shashi
 */
public class ServerConnector {
    private RemoteFactory remoteFactory;
    private static ServerConnector serverConnector;
    private SendXYController sendXYController;
    private SendPointContoller sendPointContoller;
    private ClickLockController clickLockController;
    private SendShootMessageController sendShootMessageController;
    
    private ServerConnector()throws RemoteException, NotBoundException, MalformedURLException{
        if(remoteFactory==null){
            remoteFactory=(RemoteFactory) Naming.lookup("rmi://localhost:5051/BattleshipGameServer");
        }
        //169.254.87.150
    }
    public static ServerConnector getServerConnector() throws RemoteException, NotBoundException, MalformedURLException{
        if(serverConnector==null){
            serverConnector=new ServerConnector();
        }
        return serverConnector;
    }
    public SendXYController getSendXYController()throws RemoteException{
        if(sendXYController==null){
            sendXYController=remoteFactory.getSendXYController();
        }
        return sendXYController;
    }
    public SendPointContoller getSendPointContoller()throws RemoteException{
        if(sendPointContoller==null){
            sendPointContoller=remoteFactory.getSendPointContoller();
        }
        return sendPointContoller;
    }
    public ClickLockController getClickLockController()throws RemoteException{
        if(clickLockController==null){
            clickLockController=remoteFactory.getClickLockController();
        }
        return clickLockController;
    }
    public SendShootMessageController setSendShootMessageController()throws RemoteException{
        if(sendShootMessageController==null){
            sendShootMessageController=remoteFactory.getSendShootMessageController();
        }
        return sendShootMessageController;
    }
}
