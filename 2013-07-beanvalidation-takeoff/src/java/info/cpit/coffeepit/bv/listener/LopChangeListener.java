/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.cpit.coffeepit.bv.listener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author Chris
 */
public class LopChangeListener implements PropertyChangeListener{

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Property: " + evt.getPropertyName()+": alter Wert="+evt.getOldValue()+", neuer Wert=" +evt.getNewValue());
    }
}
