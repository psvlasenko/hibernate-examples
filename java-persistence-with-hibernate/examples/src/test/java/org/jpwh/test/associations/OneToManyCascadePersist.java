package org.jpwh.test.associations;


import org.jpwh.env.JPATest;
import org.jpwh.model.associations.onetomany.cascadepersist.Bid;
import org.jpwh.model.associations.onetomany.cascadepersist.Item;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import java.math.BigDecimal;
import java.util.Collection;

import static org.testng.Assert.assertEquals;

public class OneToManyCascadePersist extends JPATest {

    @Override
    public void configurePersistenceUnit() throws Exception {
        configurePersistenceUnit("OneToManyCascadePersistPU");
    }

    // p.204
    @Test
    public void storeAndLoadItemBids() throws Exception {
        UserTransaction tx = TM.getUserTransaction();
        try {
            tx.begin();
            EntityManager em = JPA.createEntityManager();

            var someItem = new Item("Some Item");
            em.persist(someItem); // Saves the bids automatically (later, at flush time) p.204

            var someBid = new Bid(new BigDecimal("123.00"), someItem);
            someItem.getBids().add(someBid);

            var secondBid = new Bid(new BigDecimal("456.00"), someItem);
            someItem.getBids().add(secondBid);

            tx.commit(); // Dirty checking, SQL execution

            em.close();

            Long ITEM_ID = someItem.getId();

            tx.begin();
            em = JPA.createEntityManager();

            var item = em.find(Item.class, ITEM_ID);
            assertEquals(item.getBids().size(), 2);

            for (Bid bid : item.getBids()) {
                em.remove(bid);
            }

            em.remove(item);

            tx.commit();
            em.close();

            tx.begin();
            em = JPA.createEntityManager();
            Collection<Bid> bids = em.createQuery("select b from Bid b where b.item.id = :itemId")
               .setParameter("itemId", ITEM_ID)
               .getResultList();
            assertEquals(bids.size(), 0); // Bids are gone
            tx.commit();
            em.close();

        } finally {
            TM.rollback();
        }
    }

}
