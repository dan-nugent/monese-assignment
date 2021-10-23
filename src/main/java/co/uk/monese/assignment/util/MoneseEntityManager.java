package co.uk.monese.assignment.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MoneseEntityManager {
    public static EntityManager create() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("monese");
        return entityManagerFactory.createEntityManager();
    }
}
