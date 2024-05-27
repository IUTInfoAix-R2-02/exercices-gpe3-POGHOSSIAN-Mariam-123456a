package fr.amu.iut.exercice16;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Celsius extends VBox {

    public Celsius() {
        Label labelCelsius = new Label("°C");
        labelCelsius.setStyle("-fx-font-weight: bold;");
        Slider sliderCelsius = new Slider(0, 100, 0);
        sliderCelsius.setOrientation(Orientation.VERTICAL);
        sliderCelsius.setShowTickMarks(true);
        sliderCelsius.setShowTickLabels(true);
        sliderCelsius.setMajorTickUnit(10);
        sliderCelsius.setMinorTickCount(5);
        sliderCelsius.setBlockIncrement(1);
        sliderCelsius.setPrefHeight(600);
        setMargin(sliderCelsius, new Insets(0, 0, 20, 0));

        TextField textFieldCelsius = new TextField("0");

        getChildren().addAll(labelCelsius, sliderCelsius, textFieldCelsius);

        bindProperties(sliderCelsius, textFieldCelsius, "Celsius");
    }

    private void bindProperties(Slider sliderCelsius, TextField textFieldCelsius, String celsius) {

    }
}