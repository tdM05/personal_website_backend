package personal_website_backend.art;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArtService {
    private final ArtRepository artRepository;
    private final String connectionString = "DefaultEndpointsProtocol=https;AccountName=blobsforwebsite;AccountKey=ALIVkEvhCvKrsr9bTP7WPBnLFERw5AFyE63sL3lC111F8oZnu4SvVI/0u44sZl90CGqTR7dQrEvN+AStaBdF+A==;EndpointSuffix=core.windows.net";
    private final String containerName = "art"; // Container name

    @Autowired
    public ArtService(ArtRepository artRepository) {
        this.artRepository = artRepository;
    }
    public Art getArtById(int id) {
        return artRepository.findById(id).orElse(null);
    }
    public byte[] getImageByName(String imageName) {
        BlobClient blobClient = new BlobClientBuilder()
                .connectionString(connectionString)
                .containerName(containerName)
                .blobName(imageName)
                .buildClient();

        // Download the blob content as a byte array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        blobClient.download(outputStream);
        return outputStream.toByteArray();
    }
    public List<Integer> getIds() {
        List<Art> allArt = artRepository.findAll();
        List<Integer> res = new ArrayList<>();
        for(Art art : allArt) {
            res.add(art.getArt_id());
        }
        return res;
    }
}
