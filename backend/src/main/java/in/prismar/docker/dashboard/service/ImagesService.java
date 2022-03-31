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

    public List<ImageDto> getAllImages() {
        List<ImageDto> images = new ArrayList<>();
        for(Image image : connection.getClient().listImagesCmd().exec()) {
            images.add(new ImageDto(image));
        }
        return images;
    }

    public ImageDto getImage(String id) {
        for(Image image : connection.getClient().listImagesCmd().exec()) {
            if(image.getId().equalsIgnoreCase(id)) {
                return new ImageDto(image);
            }
        }
        return null;
    }

    public boolean deleteImage(String id) {
        try {
            connection.getClient().removeImageCmd(id).exec();
            return true;
        }catch (Exception exception) {
            return false;
        }
    }
}
