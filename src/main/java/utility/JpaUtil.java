package utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class JpaUtil {
    public static EntityManager getEntityManager(){
        return Persistence.createEntityManagerFactory("hrPU").createEntityManager();
    }
}
