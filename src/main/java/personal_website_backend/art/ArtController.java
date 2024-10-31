package personal_website_backend.art;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/art") //http://localhost:8080/api/art
public class ArtController {
    private final ArtService artService;
    @Autowired
    public ArtController(ArtService artService) {
        this.artService = artService;
    }
    @GetMapping()
    public ResponseEntity<String> getArtById() {
//        String description = artService.getArtById(id).getDescription();
//        if (description != null) {
//            return new ResponseEntity<>(description, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
}
