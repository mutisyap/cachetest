package ke.natujenge.config;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;

public class ApacheIgniteConfiguration {
    private static Ignite ignite;

    public static Ignite getIgniteInstance() {
        if (ignite != null) {
            return ignite;
        }

        IgniteConfiguration igniteConfiguration = new IgniteConfiguration();

        ignite = Ignition.start(igniteConfiguration);

        return ignite;
    }
}
