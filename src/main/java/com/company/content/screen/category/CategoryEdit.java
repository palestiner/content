package com.company.content.screen.category;

import com.company.content.entity.Category;
import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("content_Category.edit")
@UiDescriptor("category-edit.xml")
@EditedEntityContainer("categoryDc")
public class CategoryEdit extends StandardEditor<Category> {}
