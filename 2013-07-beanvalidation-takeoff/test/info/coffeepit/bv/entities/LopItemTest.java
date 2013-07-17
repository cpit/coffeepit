/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.coffeepit.bv.entities;

import info.coffeepit.bv.entities.Status;
import info.coffeepit.bv.entities.LopItem;
import org.junit.Test;

/**
 *
 * @author Chris
 */
public class LopItemTest extends EntitiesTestCase{
    
    
    @Test
    public void testSetStatus() {
        LopItem item = new LopItem();
        item.setText("Todo blahblah");
        
        item.setStatus(Status.NEU);
        item.setStatus(Status.IN_ARBEIT);
    }
}
