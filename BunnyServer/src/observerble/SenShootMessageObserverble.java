/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerble;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import observer.SenShootMessageObserver;

/**
 *
 * @author LAHIRU
 */
public class SenShootMessageObserverble {

    private List<SenShootMessageObserver> observerList = new ArrayList<>();

    public SenShootMessageObserverble() {

    }

    public boolean addSenShootMessageObserver(SenShootMessageObserver observer) {
        return observerList.add(observer);
    }

    public boolean removeSenShootMessageObserver(SenShootMessageObserver observer) {
        return observerList.remove(observer);
    }

    public void notifyObserver(String isShoot,String name) {
        for (SenShootMessageObserver observer : observerList) {
            new NotifyObserver(observer, isShoot,name).start();
        }
    }

    class NotifyObserver extends Thread {

        private SenShootMessageObserver observer;
        String isShoot;
        String name;

        public NotifyObserver() {
        }

        public NotifyObserver(SenShootMessageObserver observer, String isShoot,String name) {
            this.observer = observer;
            this.isShoot = isShoot;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                observer.update(isShoot,name);//To change body of generated methods, choose Tools | Templates.
            } catch (RemoteException ex) {
                Logger.getLogger(SenShootMessageObserverble.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
