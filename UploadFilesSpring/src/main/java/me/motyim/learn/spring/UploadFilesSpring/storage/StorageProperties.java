package me.motyim.learn.spring.UploadFilesSpring.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since Feb 5, 2018 
 */
@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
