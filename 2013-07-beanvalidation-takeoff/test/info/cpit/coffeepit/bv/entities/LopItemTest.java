/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.cpit.coffeepit.bv.entities;

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
