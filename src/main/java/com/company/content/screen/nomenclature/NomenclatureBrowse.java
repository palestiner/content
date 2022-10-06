package com.company.content.screen.nomenclature;

import io.jmix.ui.screen.*;
import com.company.content.entity.Nomenclature;

@UiController("content_Nomenclature.browse")
@UiDescriptor("nomenclature-browse.xml")
@LookupComponent("nomenclaturesTable")
public class NomenclatureBrowse extends StandardLookup<Nomenclature> {}
