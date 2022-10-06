package com.company.content.screen.canvas;

import com.company.content.entity.Canvas;
import io.jmix.core.DataManager;
import io.jmix.ui.UiComponents;
import io.jmix.ui.component.ColorPicker;
import io.jmix.ui.component.Component;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Consumer;

@UiController("content_Canvas.browse")
@UiDescriptor("canvas-browse.xml")
@LookupComponent("canvasesTable")
public class CanvasBrowse extends StandardLookup<Canvas> {


    @Autowired
    private UiComponents uiComponents;

    @Autowired
    private DataManager dataManager;

    @Install(to = "canvasesTable.color", subject = "columnGenerator")
    private Component canvasesTableColorColumnGenerator(Canvas canvas) {
        String color = canvas.getColor();
        ColorPicker colorPicker = uiComponents.create(ColorPicker.class);
        colorPicker.setValue(color);
        colorPicker.setRGBVisible(true);
        colorPicker.setHSVVisible(true);
        colorPicker.setSwatchesVisible(true);
        colorPicker.setDefaultCaptionEnabled(true);
        colorPicker.addValueChangeListener(valueChangeEventConsumer(canvas));
        return colorPicker;
    }

    private Consumer<HasValue.ValueChangeEvent<String>> valueChangeEventConsumer(Canvas canvas) {
        return event -> {
            String newColor = event.getValue();
            canvas.setColor(newColor);
            dataManager.save(canvas);
        };
    }
}
