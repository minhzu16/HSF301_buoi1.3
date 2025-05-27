package aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Before("execution (* org.example.repository.JobRepositoryImpl.findById(..))")
    public void logBefore() {
        logger.info("Logging Before Find ById");
        System.out.println("Logging Before Find ById");
    }
}