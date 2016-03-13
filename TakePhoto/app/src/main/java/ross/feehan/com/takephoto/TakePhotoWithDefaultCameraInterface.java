package ross.feehan.com.takephoto;

/*
 * Created by Ross Feehan on 13/03/2016.
 */

import java.io.File;

public interface TakePhotoWithDefaultCameraInterface {

    /** Request to capture and image, such as take a photo */
    int REQUEST_IMAGE_CAPTURE = 1;
    int REQUEST_RESULT_CODE_OK = -1;

    /**
     * Requests default camera app to take a picture and save it into the file provided
     */
    void takePhotoWithCameraApp(File imageFile);
}
