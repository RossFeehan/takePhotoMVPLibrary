package ross.feehan.com.takephoto.Utils;
/*
 * Created by Ross Feehan on 13/03/2016.
 */

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;


public class TakePhotoApplication extends Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate(){
        super.onCreate();

        objectGraph = ObjectGraph.create(getModules().toArray());
        objectGraph.inject(this);
    }

    private List<Object> getModules(){
        return Arrays.<Object>asList(new SharedDIModule());
    }

    public ObjectGraph getObjectGraph(){
        return objectGraph;
    }
}
