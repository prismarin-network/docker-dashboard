package in.prismar.docker.dashboard.config;

import lombok.Getter;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
@Getter
public class ConfigurationContainer {

    @ConfigProperty(name = "docker.host", defaultValue = "default")
    String dockerHost;

    @ConfigProperty(name = "docker.maxConnections", defaultValue = "100")
    int dockerMaxConnections;

    @ConfigProperty(name = "docker.dockerConnectionTimeout", defaultValue = "30")
    int dockerConnectionTimeout;

    @ConfigProperty(name = "docker.dockerResponseTimeOut", defaultValue = "45")
    int dockerResponseTimeOut;

}
