package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");


        Parameters params = getParameters();
        int width = 500;
        int height = 300;

        if (params.getRaw().size() > 0) {
            // Utiliser le premier argument passé en ligne de commande comme largeur de la fenêtre
           width = Integer.parseInt(params.getRaw().get(0));
        }

        if (params.getRaw().size() > 1) {
            // Utiliser le deuxième argument passé en ligne de commande comme hauteur de la fenêtre
            height = Integer.parseInt(params.getRaw().get(1));
        }


        BorderPane bp = new BorderPane();

        MenuBar menuBar = new MenuBar();

        Menu fichier = new Menu("File");
        MenuItem fichierr= new MenuItem("New");
        MenuItem fichierrr = new MenuItem("Open");
        MenuItem fichierrrr = new MenuItem("Save");
        MenuItem fichierrrrrr = new MenuItem("Exit");

        fichier.getItems().addAll(fichierr, fichierrr, fichierrrr, fichierrrrrr);



        Menu edit = new Menu("Edit");
        MenuItem edit1= new MenuItem("Cut");
        MenuItem edit2 = new MenuItem("Copy");
        MenuItem edit3 = new MenuItem("Paste");
        edit.getItems().addAll(edit1 , edit2, edit3);

        menuBar.getMenus().addAll(fichier, edit, new Menu("Help"));

        Menu help = new Menu("Help");

        VBox leftBox = new VBox();
        leftBox.setAlignment(Pos.CENTER);
        leftBox.setSpacing(10);



        bp.setTop(menuBar);



        leftBox.setAlignment(Pos.CENTER);
        leftBox.setSpacing(10);
        Label buttonLabel = new Label("Boutons :");

        Button button1 = new Button("Bouton 1");
        Button button2 = new Button("Bouton 2");
        Button button3 = new Button("Bouton 3");
        leftBox.getChildren().addAll(buttonLabel,button1, button2, button3);

        // add separator between left section and center section
        bp.setLeft(new HBox(leftBox, new Separator(Orientation.VERTICAL)));


        // Création du conteneur principal
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        leftBox.setSpacing(10);




        GridPane grilleFormulaire = new GridPane();
        grilleFormulaire.setAlignment(Pos.CENTER);
        grilleFormulaire.setHgap(10);
        grilleFormulaire.setVgap(10);
        grilleFormulaire.setPadding(new Insets(10));


        grilleFormulaire.addRow(0, new Label("Name:"), new TextField());
        grilleFormulaire.addRow(1, new Label("Email:"), new TextField());
        grilleFormulaire.addRow(2, new Label("Password:"), new PasswordField());


        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);


        buttonBox.getChildren().addAll(new Button("Submit"), new Button("Cancel"));

        grilleFormulaire.add(buttonBox, 0, 3, 2, 1);

        bp.setCenter(grilleFormulaire);



        // Création du bandeau en bas de la fenêtre
        Label a = new Label("Ceci est un label de bas de page");
        VBox bas = new VBox(new Separator(Orientation.HORIZONTAL),a);
        bas.setAlignment(Pos.CENTER);
        bp.setBottom(bas);

        bp.setBottom(bas);













        // Ajout du conteneur à la scene
        Scene scene = new Scene(bp, 600, 400);

        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        primaryStage.setWidth( 800 );
        primaryStage.setHeight( 600 );


        // Affichage de la fenêtre
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}

