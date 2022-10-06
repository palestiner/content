package com.company.content.screen.nomenclature;

import io.jmix.ui.screen.*;
import com.company.content.entity.Nomenclature;

@UiController("content_Nomenclature.edit")
@UiDescriptor("nomenclature-edit.xml")
@EditedEntityContainer("nomenclatureDc")
public class NomenclatureEdit extends StandardEditor<Nomenclature> {}
