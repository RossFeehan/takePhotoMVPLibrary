package ross.feehan.com.takephoto.TakePhoto;
/*
 * Created by Ross Feehan on 13/03/2016.
 */

import android.app.Activity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ross.feehan.com.takephoto.Utils.PhotoFileUtils;

@Module(complete = false, library = true)
public class TakePhotoDIModule {

    private Activity activity;
    private TakePhotoViewInterface view;

    //CONSTRUCTOR
    public TakePhotoDIModule (Activity activity, TakePhotoViewInterface view){
        this.activity = activity;
        this.view = view;
    }

    @Provides @Singleton
    public TakePhotoWithDefaultCameraInterface provideTakePhotoWithDefaultCameraInterface(){
        return new TakePhotoWithDefaultCameraImpl(activity);
    }

    @Provides @Singleton
    public TakePhotoLogicInterface provideTakePhotoLogicInterface(TakePhotoWithDefaultCameraInterface takePhotoWithDefaultCamera,
                                                                  PhotoFileUtils photoFileUtils){
        return new TakePhotoLogicImpl(takePhotoWithDefaultCamera, photoFileUtils, view);
    }


}
