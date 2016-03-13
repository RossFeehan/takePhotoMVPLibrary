package ross.feehan.com.takephoto;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;

import ross.feehan.com.takephoto.Utils.PhotoFileUtils;

import static org.mockito.Mockito.verify;

/*
* Created by Ross Feehan on 13/03/2016.
*/

/**
 * Single Responsibility:
 *
 * Tests for {@link TakePhotoLogicImpl}
 */
@RunWith(MockitoJUnitRunner.class)
public class TakePhotoLogicImplTest extends TestCase {

    public static final int REQUEST_CODE = 1;
    public static final int RESULT_CODE_OK = -1;
    public static final int RESULT_CODE_FAIL = 0;

    TakePhotoLogicImpl takePhotoLogic;
    @Mock TakePhotoWithDefaultCameraInterface takePhotoWithDefaultCamera;
    @Mock
    PhotoFileUtils photoFileUtils;
    @Mock File photoFile;
    @Mock TakePhotoViewInterface view;

    @Before
    public void setup(){
        takePhotoLogic = new TakePhotoLogicImpl(takePhotoWithDefaultCamera, photoFileUtils, view);
        photoFile = photoFileUtils.createFileForDefaultCamera();
    }

    //Scenario - user has clicked take photo button
    @Test
    public void when_userClicksTakePhotoButton_then_startTheDefaultCamera(){
        //WHEN
        takePhotoLogic.onTakePhotoBtnClicked();
        //THEN
        verify(takePhotoWithDefaultCamera).takePhotoWithCameraApp(photoFile);
    }

    //Scenario - a photo was not taken successfully
    @Test
    public void when_photoIsNotTakenSuccessfully_then_thePhotoFileShouldBeDeleted(){
        //WHEN
        takePhotoLogic.onActivityResult(REQUEST_CODE, RESULT_CODE_FAIL);
        //THEN
        verify(photoFileUtils).deletePhotoFile(photoFile);
    }

    //Scenario - a photo was taken successfully
    @Test
    public void when_photoIsTakenSuccessfully_then_displayThePhotoToUser(){
        //WHEN
        takePhotoLogic.onActivityResult(REQUEST_CODE,RESULT_CODE_OK);
        //THEN
        verify(view).displayTakenPhoto(photoFile);
    }
}