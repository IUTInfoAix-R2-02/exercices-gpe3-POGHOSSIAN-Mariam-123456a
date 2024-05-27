package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
//exo 1
@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private IntegerProperty nbFois = new SimpleIntegerProperty(0);
    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private StringProperty message = new SimpleStringProperty("");
    private StringProperty couleurPanneau = new SimpleStringProperty("#000000");

    private Label texteDuHaut;
    private Label texteDuBas;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);
        panneau.styleProperty().bind(Bindings.concat("-fx-background-color: ", couleurPanneau));

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        texteDuBas.textProperty().bind(Bindings.concat(message, " est une jolie couleur !"));
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        vert.setOnAction(event -> {
            nbFois.set(nbVert++);
            message.set("Vert");
            couleurPanneau.set("#00FF00"); // Vert
        });

        rouge.setOnAction(event -> {
            nbFois.set(nbRouge++);
            message.set("Rouge");
            couleurPanneau.set("#FF0000"); // Rouge
        });

        bleu.setOnAction(event -> {
            nbFois.set(nbBleu++);
            message.set("Bleu");
            couleurPanneau.set("#0000FF"); // Bleu
        });

        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        createBindings();

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createBindings() {
        BooleanProperty pasEncoreDeClic = new SimpleBooleanProperty(true);
        pasEncoreDeClic.bind(Bindings.equal(0, nbFois));

        texteDuHaut.textProperty().bind(
                Bindings.concat(
                        "Le bouton a été cliqué ",
                        Bindings.when(pasEncoreDeClic)
                                .then("aucune fois")
                                .otherwise(Bindings.concat(Bindings.convert(nbFois), " fois"))
                )
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}
