package me.motyim.learn.spring.UploadFilesSpring.storage;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since Feb 5, 2018 
 */
public class StorageFileNotFoundException extends StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}