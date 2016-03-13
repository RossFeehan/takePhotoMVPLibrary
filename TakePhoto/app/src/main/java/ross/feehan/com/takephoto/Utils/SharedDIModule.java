package ross.feehan.com.takephoto.Utils;

/*
 * Created by Ross Feehan on 13/03/2016.
 */

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(injects = TakePhotoApplication.class,
        library = true)
public class SharedDIModule {

    @Provides @Singleton
    public PhotoFileUtils providePhotoFileUtils(){
        return new PhotoFileUtils();
    }
}
