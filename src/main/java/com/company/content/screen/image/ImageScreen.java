package com.company.content.screen.image;

import io.jmix.ui.component.Image;
import io.jmix.ui.component.StreamResource;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;

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
                image.setSource(StreamResource.class).setStreamSupplier(() -> new ByteArrayInputStream((byte[]) img));
            }
        }
    }


}
