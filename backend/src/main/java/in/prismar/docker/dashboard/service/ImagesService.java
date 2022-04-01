package in.prismar.docker.dashboard.service;

import com.github.dockerjava.api.model.Image;
import in.prismar.docker.dashboard.model.ImageDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class ImagesService {

    @Inject
    DockerConnection connection;

    /**
     * Retrieve all docker all images {@link Image}
     * and convert it into a DTO {@link ImageDto}
     *
     * @return List of {@link ImageDto}
     */
    public List<ImageDto> getAllImages() {
        List<ImageDto> images = new ArrayList<>();
        for(Image image : connection.getClient().listImagesCmd().exec()) {
            images.add(new ImageDto(image));
        }
        return images;
    }

    /**
     * Retrieve a Image with the matching id. (Example: sha256:adads...)
     *
     * @param id
     * @return {@link ImageDto}
     */
    public ImageDto getImage(String id) {
        for(Image image : connection.getClient().listImagesCmd().exec()) {
            if(image.getId().equalsIgnoreCase(id)) {
                return new ImageDto(image);
            }
        }
        return null;
    }

    /**
     * Delete a image with the matching id
     *
     * @param id
     * @return if deletion was successful
     */
    public boolean deleteImage(String id) {
        try {
            connection.getClient().removeImageCmd(id).exec();
            return true;
        }catch (Exception exception) {
            return false;
        }
    }
}
