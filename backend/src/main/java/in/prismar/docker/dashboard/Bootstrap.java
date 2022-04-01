package in.prismar.docker.dashboard;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import javax.ws.rs.core.Application;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
@OpenAPIDefinition(
        info = @Info(
                title = "Docker Dashboard API",
                version = "1.0.0",
                description = "View all endpoints of docker dashboard"
        )
)
public class Bootstrap extends Application {

}
