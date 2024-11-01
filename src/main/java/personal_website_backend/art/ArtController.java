package personal_website_backend.art;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/art") //http://localhost:8080/api/art
public class ArtController {
    private final ArtService artService;
    @Autowired
    public ArtController(ArtService artService) {
        this.artService = artService;
    }
    @GetMapping("/text/{id}")
    public ResponseEntity<String> getArtTextById(@PathVariable int id) {
        String description = artService.getArtById(id).getDescription();
        if (description != null) {
            return new ResponseEntity<>(description, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/img/{id}")
    public ResponseEntity<byte[]> getImageById(@PathVariable int id) {
        String imageName = artService.getArtById(id).getAzure_image_name();
        byte[] imageBytes = artService.getImageByName(imageName);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(imageBytes);
    }
    @GetMapping(path="/ids", produces = "application/json")
    public ResponseEntity<List<Integer>> getArtIds() {
        return new ResponseEntity<>(artService.getIds(), HttpStatus.OK);
    }
}
