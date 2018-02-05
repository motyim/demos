package me.motyim.learn.spring.UploadFilesSpring.storage;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since Feb 5, 2018 
 */
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
