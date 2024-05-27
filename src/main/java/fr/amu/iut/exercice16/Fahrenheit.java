package fr.amu.iut.exercice16;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Fahrenheit extends VBox {

    public Fahrenheit() {
        Label labelFahrenheit = new Label("°F");
        labelFahrenheit.setStyle("-fx-font-weight: bold;");
        Slider sliderFahrenheit = new Slider(0, 212, 32);
        sliderFahrenheit.setOrientation(Orientation.VERTICAL);
        sliderFahrenheit.setShowTickMarks(true);
        sliderFahrenheit.setShowTickLabels(true);
        sliderFahrenheit.setMajorTickUnit(20);
        sliderFahrenheit.setMinorTickCount(5);
        sliderFahrenheit.setBlockIncrement(1);
        sliderFahrenheit.setPrefHeight(600);
        setMargin(sliderFahrenheit, new Insets(0, 0, 20, 0));

        TextField textFieldFahrenheit = new TextField("32");

        getChildren().addAll(labelFahrenheit, sliderFahrenheit, textFieldFahrenheit);

        bindProperties(sliderFahrenheit, textFieldFahrenheit, "Fahrenheit");
    }

    private void bindProperties(Slider sliderFahrenheit, TextField textFieldFahrenheit, String fahrenheit) {
    }
}