package personal_website_backend.art;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtService {
    private final ArtRepository artRepository;
    @Autowired
    public ArtService(ArtRepository artRepository) {
        this.artRepository = artRepository;
    }
    public Art getArtById(int id) {
        return artRepository.findById(id).orElse(null);
    }
}
