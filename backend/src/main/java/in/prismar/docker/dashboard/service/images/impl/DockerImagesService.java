package in.prismar.docker.dashboard.service.images.impl;

import com.github.dockerjava.api.model.Image;
import in.prismar.docker.dashboard.model.ImageDto;
import in.prismar.docker.dashboard.service.DockerConnection;
import in.prismar.docker.dashboard.service.images.ImagesService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class DockerImagesService implements ImagesService {

    @Inject
    DockerConnection connection;


    @Override
    public List<ImageDto> getAllImages() {
        List<ImageDto> images = new ArrayList<>();
        for(Image image : connection.getClient().listImagesCmd().exec()) {
            images.add(new ImageDto(image));
        }
        return images;
    }


    @Override
    public ImageDto getImage(String id) {
        for(Image image : connection.getClient().listImagesCmd().exec()) {
            if(image.getId().equalsIgnoreCase(id)) {
                return new ImageDto(image);
            }
        }
        return null;
    }

    @Override
    public boolean deleteImage(String id) {
        try {
            connection.getClient().removeImageCmd(id).exec();
            return true;
        }catch (Exception exception) {
            return false;
        }
    }
}
