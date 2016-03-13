package ross.feehan.com.takephoto;
/*
 * Created by Ross Feehan on 13/03/2016.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;

class TakePhotoWithDefaultCameraImpl implements TakePhotoWithDefaultCameraInterface {

    private Activity activity;//The actvity that will receive the onResult callback from default camera
    private Context ctx;

    //CONSTRUCTOR
    public TakePhotoWithDefaultCameraImpl(Activity activity){
        this.activity = activity;
        this.ctx = activity.getApplication();
    }

    //Interface methods
    //TakePhotoWithDefaultCameraInterface methods
    @Override
    public void takePhotoWithCameraApp(File imageFile) {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (canIntentBeHandled(ctx, intent)) {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imageFile));
            activity.startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }

    private boolean canIntentBeHandled(Context ctx, Intent intent) {
        return intent.resolveActivity(ctx.getPackageManager()) != null;
    }
}