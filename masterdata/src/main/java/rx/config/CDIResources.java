package rx.config;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CDIResources {
	@Produces
    @PersistenceContext
    private EntityManager entityManager;

}
