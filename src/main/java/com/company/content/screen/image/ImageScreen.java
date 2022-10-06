package com.company.content.screen.image;

import io.jmix.core.FileRef;
import io.jmix.ui.component.FileStorageResource;
import io.jmix.ui.component.Image;
import io.jmix.ui.component.RelativePathResource;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("content_ImageScreen")
@UiDescriptor("image-screen.xml")
public class ImageScreen extends Screen {

    @Autowired
    private Image image;

    @Subscribe
    public void onInit(InitEvent event) {
        ScreenOptions options = event.getOptions();
        if (options instanceof MapScreenOptions) {
            MapScreenOptions mapScreenOptions = (MapScreenOptions) options;
            Object img = mapScreenOptions.getParams().get("image");
            if (img != null) {
                FileRef fileRef = (FileRef) img;
                image.setSource(FileStorageResource.class).setFileReference(fileRef);
            }
        }
    }


}
