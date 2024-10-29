package personal_website_backend.art;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ArtRepository extends JpaRepository<Art, Integer> {
}
