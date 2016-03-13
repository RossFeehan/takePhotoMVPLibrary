package ross.feehan.com.takephoto;
/*
 * Created by Ross Feehan on 13/03/2016.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.File;


public class TakePhotoActivity extends AppCompatActivity implements TakePhotoViewInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    //INTERFACE METHODS
    //TakePhotoViewInterface METHODS
    @Override
    public void displayTakenPhoto(File imageFile) {

    }
}
