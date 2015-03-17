/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import remotefactoryImpl.RemoteFactoryImpl;

/**
 *
 * @author Shashi
 */
public class Server {
    
            public static void main(String[] args) {
        try {
            Registry rmiRegistry=LocateRegistry.createRegistry(5051);
            rmiRegistry.rebind("BattleshipGameServer", new RemoteFactoryImpl());
            System.out.println("Server Starts...");
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
