package fr.amu.iut.exercice16;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public abstract class PanneauTemperature {

    protected final Slider slider;
    protected final TextField textField;
    protected final DoubleProperty temperatureProperty;

    public PanneauTemperature(double min, double max, double initialValue) {
        slider = new Slider(min, max, initialValue);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setBlockIncrement(1);
        slider.setPrefHeight(600);

        textField = new TextField(String.valueOf(initialValue));

        temperatureProperty = new SimpleDoubleProperty();
        temperatureProperty.bindBidirectional(slider.valueProperty());

        bindProperties(slider, textField);
    }

    protected void bindProperties(Slider slider, TextField textField) {
        Bindings.bindBidirectional(textField.textProperty(), slider.valueProperty(), new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return String.format("%.2f", object);
            }

            @Override
            public Number fromString(String string) {
                try {
                    return Double.parseDouble(string);
                } catch (NumberFormatException e) {
                    return 0;
                }
            }
        });
    }
}