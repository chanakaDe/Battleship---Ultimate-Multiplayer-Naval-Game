/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package observerble;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import observer.SendPointsObserver;

/**
 *
 * @author Shashi
 */
public class SendPointObsererble {

    private List<SendPointsObserver> observerList = new ArrayList<>();

    public SendPointObsererble() {
    }

    public boolean addSendPointObserver(SendPointsObserver observer) {
        return observerList.add(observer);
    }

    public boolean removeSendPointObserver(SendPointsObserver observer) {
        return observerList.remove(observer);
    }

    public void notifyObserver(int k,boolean b,String name) {
        for (SendPointsObserver observer : observerList) {
            new NotifyObsetver(observer,k, b,name).start();
        }
    }

    class NotifyObsetver extends Thread{
        private SendPointsObserver observer;
        private String name;
        private boolean b;
        private int k;

        public NotifyObsetver() {
        }
        
        public NotifyObsetver(SendPointsObserver observer, int k,boolean b,String name) {
            this.observer=observer;
            this.name=name; 
            this.b=b;
            this.k=k;
        }

        @Override
        public void run() {
            try {
                observer.update(k,b,name);
            } catch (RemoteException ex) {
                Logger.getLogger(SendPointObsererble.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
