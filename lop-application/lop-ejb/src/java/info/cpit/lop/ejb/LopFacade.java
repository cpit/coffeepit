/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.cpit.lop.ejb;

import info.cpit.lop.entities.Lop;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author chris
 */
@Stateless
public class LopFacade extends AbstractFacade<Lop> {
    @PersistenceContext(unitName = "lop-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LopFacade() {
        super(Lop.class);
    }
    
}
