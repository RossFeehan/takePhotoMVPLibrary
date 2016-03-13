package ross.feehan.com.takephoto.TakePhoto;
/*
 * Created by Ross Feehan on 13/03/2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ross.feehan.com.takephoto.R;
import ross.feehan.com.takephoto.Utils.TakePhotoApplication;


public class TakePhotoActivity extends AppCompatActivity implements TakePhotoViewInterface {

    @Inject TakePhotoLogicInterface logic;

    @Bind(R.id.photoPreview) ImageView photoPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        initDependencies();
    }

    private void initUI(){
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void initDependencies() {
        ((TakePhotoApplication)getApplication()).getObjectGraph().plus(new TakePhotoDIModule(this, this)).inject(this);
    }

    //CLASS METHODS
    @OnClick(R.id.takePictureFAB)
    void onTakePictureBtnClicked(){
        logic.onTakePhotoBtnClicked();
    }

    //INTERFACE METHODS
    //TakePhotoViewInterface METHODS
    @Override
    public void displayTakenPhoto(File imageFile) {
        Picasso.with(this).load(imageFile).into(photoPreview);
    }

    //ACTIVITY LIFECYCLE METHODS
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        logic.onActivityResult(requestCode, resultCode);
    }
}