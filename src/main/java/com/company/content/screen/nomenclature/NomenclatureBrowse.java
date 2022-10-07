package com.company.content.screen.nomenclature;

import com.company.content.entity.Nomenclature;
import com.company.content.screen.image.ImageScreen;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.UiComponents;
import io.jmix.ui.component.Component;
import io.jmix.ui.component.LinkButton;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

@UiController("content_Nomenclature.browse")
@UiDescriptor("nomenclature-browse.xml")
@LookupComponent("nomenclaturesTable")
public class NomenclatureBrowse extends StandardLookup<Nomenclature> {

    @Autowired
    private UiComponents uiComponents;

    @Autowired
    private ScreenBuilders screenBuilders;

    @Install(to = "nomenclaturesTable.image", subject = "columnGenerator")
    private Component nomenclaturesTableImageColumnGenerator(Nomenclature nomenclature) {
        byte[] image = nomenclature.getImage();
        if (image != null) {
            Map<String, Object> params = new HashMap<>();
            params.put("image", image);
            LinkButton linkButton = uiComponents.create(LinkButton.class);
            linkButton.setCaption(nomenclature.getFileName());
            linkButton.addClickListener(clickEvent -> screenBuilders.screen(this)
                    .withOptions(new MapScreenOptions(params))
                    .withOpenMode(OpenMode.DIALOG)
                    .withScreenClass(ImageScreen.class)
                    .build()
                    .show());
            return linkButton;
        }
        return null;
    }

}
