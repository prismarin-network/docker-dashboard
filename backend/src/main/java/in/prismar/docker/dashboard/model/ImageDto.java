package in.prismar.docker.dashboard.model;

import com.github.dockerjava.api.model.Image;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ImageDto {

    private String id;
    private String[] tags;
    private long created;
    private long size;

    public ImageDto(Image image) {
        this.id = image.getId();
        this.tags = image.getRepoTags();
        this.created = image.getCreated();
        this.size = image.getSize();
    }
}
