package in.prismar.docker.dashboard;

import in.prismar.docker.dashboard.model.ImageDto;
import in.prismar.docker.dashboard.service.images.ImagesService;
import lombok.Getter;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;


@ApplicationScoped
@Priority(1)
@Alternative
@Getter
public class LocalImagesService implements ImagesService {

    private List<ImageDto> images;

    public LocalImagesService() {
        this.images = new ArrayList<>();

    }

    @Override
    public List<ImageDto> getAllImages() {
        return images;
    }


    @Override
    public ImageDto getImage(String id) {
        for(ImageDto image : images) {
            if(image.getId().equalsIgnoreCase(id)) {
                return image;
            }
        }
        return null;
    }

    @Override
    public boolean deleteImage(String id) {
        Iterator<ImageDto> iterator = images.iterator();
        while (iterator.hasNext()) {
            ImageDto image = iterator.next();
            if(image.getId().equalsIgnoreCase(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
