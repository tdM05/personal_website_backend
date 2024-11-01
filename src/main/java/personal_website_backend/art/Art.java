package personal_website_backend.art;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "art")
public class Art {
    @Id
    private int art_id;
    private String name;
    private String description;
    private String art_type;
    private String azure_image_name;

    public int getArt_id() {
        return art_id;
    }

    public void setArt_id(int art_id) {
        this.art_id = art_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getArt_type() {
        return this.art_type;
    }

    public void setArt_type(String type) {
        this.art_type = type;
    }
    public String getAzure_image_name() {
        return azure_image_name;
    }

    public void setAzure_image_name(String azure_image_name) {
        this.azure_image_name = azure_image_name;
    }
}
