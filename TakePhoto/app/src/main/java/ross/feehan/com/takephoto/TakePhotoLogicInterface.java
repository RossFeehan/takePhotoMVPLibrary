package ross.feehan.com.takephoto;
/*
 * Created by Ross Feehan on 13/03/2016.
 */

/**
 * Makes decisions for {@link TakePhotoActivity}
 */
public interface TakePhotoLogicInterface {

    /** User has clicked on the area where their image would be displayed */
    void onTakePhotoBtnClicked();

    /** Called from activity with result code and request code */
    void onActivityResult(int requestCode, int resultCode);

}
