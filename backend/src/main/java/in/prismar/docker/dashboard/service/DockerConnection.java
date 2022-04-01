package in.prismar.docker.dashboard.service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;
import in.prismar.docker.dashboard.config.ConfigurationContainer;
import io.quarkus.runtime.StartupEvent;
import lombok.Getter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.time.Duration;


@ApplicationScoped
@Getter
public class DockerConnection {

    @Inject
    ConfigurationContainer container;

    private DockerClientConfig config;
    private DockerClient client;

    /**
     * Establish docker connection with properties of {@link ConfigurationContainer}
     *
     * @param event
     */
    public void onStart(@Observes StartupEvent event) {
        this.config = DefaultDockerClientConfig.createDefaultConfigBuilder().build();
        DockerHttpClient httpClient = new ApacheDockerHttpClient.Builder()
                .dockerHost(config.getDockerHost())
                .maxConnections(container.getDockerMaxConnections())
                .connectionTimeout(Duration.ofSeconds(container.getDockerConnectionTimeout()))
                .responseTimeout(Duration.ofSeconds(container.getDockerResponseTimeOut()))
                .build();
        this.client = DockerClientImpl.getInstance(config, httpClient);

    }




}
