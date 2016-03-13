package ross.feehan.com.takephoto.TakePhoto;

/*
 * Created by Ross Feehan on 13/03/2016.
 */

import java.io.File;

import ross.feehan.com.takephoto.TakePhoto.TakePhotoLogicImpl;

/**
 * Shows UI to user
 * Reports user's interaction with it to {@link TakePhotoLogicImpl}
 */
public interface TakePhotoViewInterface {

    void displayTakenPhoto(File imageFile);

}
