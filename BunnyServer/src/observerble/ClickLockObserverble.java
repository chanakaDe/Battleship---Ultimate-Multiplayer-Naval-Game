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
import observer.ClickLockObserver;

/**
 *
 * @author Shashi
 */
public class ClickLockObserverble {

    private List<ClickLockObserver> observerList = new ArrayList<>();
    public ClickLockObserverble(){
        
    }
    public boolean addClickObserver(ClickLockObserver observer){
        return observerList.add(observer);
    }
    public boolean removeClickObserver(ClickLockObserver observer){
        return observerList.remove(observer);
    }
    public void notifyObserver(boolean isClick,String name){
        for (ClickLockObserver observer : observerList) {
            new NotifyObserver(observer,isClick,name).start();
        }
    }

      class NotifyObserver extends Thread{
        
        private ClickLockObserver observer;
        private boolean isClick;
        private String name;

        public NotifyObserver() {
        }

        public NotifyObserver(ClickLockObserver observer, boolean isClick,String name) {
            this.observer = observer;
            this.isClick = isClick;
            this.name = name;
        }

        @Override
        public void run() {
              try {
                  observer.update(isClick,name);
              } catch (RemoteException ex) {
                  Logger.getLogger(ClickLockObserverble.class.getName()).log(Level.SEVERE, null, ex);
              }
        }
        
    }
}
