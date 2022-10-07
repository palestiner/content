package com.company.content.screen.nomenclature;

import com.company.content.entity.Nomenclature;
import io.jmix.ui.component.FileUploadField;
import io.jmix.ui.component.SingleFileUploadField;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("content_Nomenclature.edit")
@UiDescriptor("nomenclature-edit.xml")
@EditedEntityContainer("nomenclatureDc")
public class NomenclatureEdit extends StandardEditor<Nomenclature> {

    @Autowired
    private FileUploadField imageField;

    @Subscribe("imageField")
    public void onImageFieldFileUploadSucceed(SingleFileUploadField.FileUploadSucceedEvent event) {
        String fileName = event.getFileName();
        getEditedEntity().setFileName(fileName);
    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        String fileName = getEditedEntity().getFileName();
        imageField.setFileName(fileName);
    }
}
