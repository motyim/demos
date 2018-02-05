package me.motyim.learn.spring.UploadFilesSpring.storage;

import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since Feb 5, 2018 
 */
public interface StorageService {
    
    void init();

    void store(MultipartFile file);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();


}
