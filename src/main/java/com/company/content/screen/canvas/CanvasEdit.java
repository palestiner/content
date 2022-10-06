package com.company.content.screen.canvas;

import com.company.content.entity.Canvas;
import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("content_Canvas.edit")
@UiDescriptor("canvas-edit.xml")
@EditedEntityContainer("canvasDc")
public class CanvasEdit extends StandardEditor<Canvas> {}
