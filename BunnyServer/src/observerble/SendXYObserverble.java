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
import observer.SendXYObserver;

/**
 *
 * @author Shashi
 */
public class SendXYObserverble {

    private List<SendXYObserver> observerList = new ArrayList<>();

    public SendXYObserverble() {
    }

    public boolean addSendXYObserver(SendXYObserver observer) {
        return observerList.add(observer);
    }

    public boolean removeSendXYObserver(SendXYObserver observer) {
        return observerList.remove(observer);
    }

    public void notifyObserver(int x, int y,String playerName,boolean isLock) {
        for (SendXYObserver observer : observerList) {
            new NotifyObserver(observer, x, y,playerName,isLock).start();
        }
    }

    class NotifyObserver extends Thread {

        private SendXYObserver observer;
        private int x;
        private int y;
        private String playerName;
        private boolean isLock;

        public NotifyObserver() {
        }

        public NotifyObserver(SendXYObserver observer, int x, int y,String playerName,boolean isLock) {
            this.observer = observer;
            this.x = x;
            this.y = y;
            this.playerName = playerName;
            this.isLock = isLock;
        }

        @Override
        public void run() {
            try {
                observer.update(x, y,playerName,isLock);
            } catch (RemoteException ex) {
                Logger.getLogger(SendXYObserverble.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
