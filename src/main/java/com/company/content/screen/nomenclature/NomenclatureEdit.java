package com.company.content.screen.nomenclature;

import com.company.content.entity.Nomenclature;
import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("content_Nomenclature.edit")
@UiDescriptor("nomenclature-edit.xml")
@EditedEntityContainer("nomenclatureDc")
public class NomenclatureEdit extends StandardEditor<Nomenclature> {}
