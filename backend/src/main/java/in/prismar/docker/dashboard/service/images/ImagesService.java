package in.prismar.docker.dashboard.service.images;

import com.github.dockerjava.api.model.Image;
import in.prismar.docker.dashboard.model.ImageDto;

import javax.ws.rs.ext.Provider;
import java.util.List;

/**
 * Copyright (c) Maga, All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Maga
 **/
public interface ImagesService {

    /**
     * Retrieve all docker all images {@link Image}
     * and convert it into a DTO {@link ImageDto}
     *
     * @return List of {@link ImageDto}
     */
    List<ImageDto> getAllImages();


    /**
     * Retrieve a Image with the matching id. (Example: sha256:adads...)
     *
     * @param id
     * @return {@link ImageDto}
     */
    ImageDto getImage(String id);

    /**
     * Delete a image with the matching id
     *
     * @param id
     * @return if deletion was successful
     */
    boolean deleteImage(String id);
}
