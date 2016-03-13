package ross.feehan.com.takephoto;

/*
 * Created by Ross Feehan on 13/03/2016.
 */

import java.io.File;

/**
 * Shows UI to user
 * Reports user's interaction with it to {@link TakePhotoLogicImpl}
 */
public interface TakePhotoViewInterface {

    void displayTakenPhoto(File imageFile);

}
