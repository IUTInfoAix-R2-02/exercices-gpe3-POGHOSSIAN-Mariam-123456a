package fr.amu.iut.exercice16;




import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;




public class ConvertisseurTemperatures extends Application {




    @Override
    public void start(Stage primaryStage) {
        VBox panneauCelsius = new VBox(10);
        VBox panneauFahrenheit = new VBox(10);




        Label labelCelsius = new Label("°C");
        labelCelsius.setStyle("-fx-font-weight: bold;");
        Slider sliderCelsius = new Slider(0, 100, 0);
        sliderCelsius.setOrientation(Orientation.VERTICAL);
        sliderCelsius.setShowTickMarks(true);
        sliderCelsius.setShowTickLabels(true);
        sliderCelsius.setMajorTickUnit(10);
        sliderCelsius.setMinorTickCount(5);
        sliderCelsius.setBlockIncrement(1);
        sliderCelsius.setPrefHeight(600); // longueur vertical des barres de temperatures
        panneauCelsius.setMargin(sliderCelsius, new Insets(0, 0, 20, 0)); //eloigner les cases de temp. avec les barres de temperatures
        TextField textFieldCelsius = new TextField("0");




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
        panneauFahrenheit.setMargin(sliderFahrenheit, new Insets(0, 0, 20, 0));
        TextField textFieldFahrenheit = new TextField("32");




        panneauCelsius.getChildren().addAll(labelCelsius, sliderCelsius, textFieldCelsius);
        panneauFahrenheit.getChildren().addAll(labelFahrenheit, sliderFahrenheit, textFieldFahrenheit);




        HBox root = new HBox(30, panneauCelsius, panneauFahrenheit);
        root.setPadding(new Insets(20));




        // Liaison bidirectionnelle entre les sliders
        DoubleProperty celsiusProperty = new SimpleDoubleProperty();
        DoubleProperty fahrenheitProperty = new SimpleDoubleProperty();




        celsiusProperty.bindBidirectional(sliderCelsius.valueProperty());
        fahrenheitProperty.bindBidirectional(sliderFahrenheit.valueProperty());




        // Conversion entre Celsius et Fahrenheit
        celsiusProperty.addListener((obs, oldVal, newVal) -> {
            double fahrenheitValue = newVal.doubleValue() * 9 / 5 + 32;
            if (fahrenheitProperty.get() != fahrenheitValue) {
                fahrenheitProperty.set(fahrenheitValue);
            }
        });




        fahrenheitProperty.addListener((obs, oldVal, newVal) -> {
            double celsiusValue = (newVal.doubleValue() - 32) * 5 / 9;
            if (celsiusProperty.get() != celsiusValue) {
                celsiusProperty.set(celsiusValue);
            }
        });




        // Liaison bidirectionnelle entre les sliders et les champs de texte
        Bindings.bindBidirectional(textFieldCelsius.textProperty(), sliderCelsius.valueProperty(), new javafx.util.StringConverter<Number>() {
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




        Bindings.bindBidirectional(textFieldFahrenheit.textProperty(), sliderFahrenheit.valueProperty(), new javafx.util.StringConverter<Number>() {
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




        primaryStage.setScene(new Scene(root, 200, 710));
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}









