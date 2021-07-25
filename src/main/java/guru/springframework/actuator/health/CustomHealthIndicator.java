package guru.springframework.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;


/**
 * Created by ronnen on 25-Jul-2021
 */

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {

        Random random = new Random();

        if(!random.nextBoolean()){

            // example of a failure, 'ERR-001' is an error example
            // 'Random failure' is an Object as a second param
            return Health.down().withDetail("ERR-001", "Random failure").build();
        }

        // if the system is healthy
        return Health.up().build();
    }
}
