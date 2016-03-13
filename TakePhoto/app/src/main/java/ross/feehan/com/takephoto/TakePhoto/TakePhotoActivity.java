package ross.feehan.com.takephoto.TakePhoto;
/*
 * Created by Ross Feehan on 13/03/2016.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

import javax.inject.Inject;

import ross.feehan.com.takephoto.R;
import ross.feehan.com.takephoto.Utils.TakePhotoApplication;


public class TakePhotoActivity extends AppCompatActivity implements TakePhotoViewInterface {

    @Inject TakePhotoLogicInterface logic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        initDependencies();
    }

    private void initUI(){
        setContentView(R.layout.activity_main);
    }

    private void initDependencies() {
        ((TakePhotoApplication)getApplication()).getObjectGraph().plus(new TakePhotoDIModule(this, this)).inject(this);
    }

    //INTERFACE METHODS
    //TakePhotoViewInterface METHODS
    @Override
    public void displayTakenPhoto(File imageFile) {

    }
}