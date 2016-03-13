package ross.feehan.com.takephoto;

import java.io.File;

/*
 * Created by Ross Feehan on 13/03/2016.
 */
class TakePhotoLogicImpl implements TakePhotoLogicInterface {

    private TakePhotoWithDefaultCameraInterface takePhotoWithDefaultCamera;
    private PhotoFileUtils photoFileUtils;
    private TakePhotoViewInterface view;
    private File photoFile;

    //CONSTRUCTOR
    public TakePhotoLogicImpl(TakePhotoWithDefaultCameraInterface takePhotoWithDefaultCamera,
                              PhotoFileUtils photoFileUtils, TakePhotoViewInterface view){

        this.takePhotoWithDefaultCamera = takePhotoWithDefaultCamera;
        this.photoFileUtils = photoFileUtils;
        this.view = view;

    }

    //CLASS METHODS
    private void pictureNotTakenSuccessfully() {
        photoFileUtils.deletePhotoFile(photoFile);
    }

    private void pictureTakenSuccessfully() {
        view.displayTakenPhoto(photoFile);
    }

    //Interface methods
    //TakePhotoLogicInterface methods
    @Override
    public void onTakePhotoBtnClicked() {
        photoFile = photoFileUtils.createFileForDefaultCamera();
        takePhotoWithDefaultCamera.takePhotoWithCameraApp(photoFile);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode) {
        if (requestCode == TakePhotoWithDefaultCameraInterface.REQUEST_IMAGE_CAPTURE
                && resultCode == TakePhotoWithDefaultCameraInterface.REQUEST_RESULT_CODE_OK) {
            pictureTakenSuccessfully();
        }
        else{
            pictureNotTakenSuccessfully();
        }
    }
}
