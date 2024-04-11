package fr.amu.iut.exercice1;

import javafx.application.Application;
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



        Menu fichier = new Menu("File");
        MenuItem fichierr= new MenuItem("New");
        MenuItem fichierrr = new MenuItem("Open");
        MenuItem fichierrrr = new MenuItem("Save");
        MenuItem fichierrrrrr = new MenuItem("Close");

        fichier.getItems().addAll(fichierr, fichierrr, fichierrrr, fichierrrrrr);


        Menu edit = new Menu("Edit");
        MenuItem edit1= new MenuItem("Cut");
        MenuItem edit2 = new MenuItem("Copy");
        MenuItem edit3 = new MenuItem("Paste");

        edit.getItems().addAll(edit1 , edit2, edit3);


        Menu help = new Menu("Help");


        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(fichier);
        menuBar.getMenus().add(edit);
        menuBar.getMenus().add(help);

        bp.setTop(menuBar);



        // Création du conteneur principal
        VBox vbox = new VBox();

       // TableView<Object> tblCustomers = new TableView<>();
        //tblCustomers.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //VBox.setVgrow( tblCustomers, Priority.ALWAYS );


        Label l1 = new Label("Name: ");
        Label l2 = new Label("Email: ");
        Label l3 = new Label("Name: ");

        Scene s1 = new Scene(l1 , 200 , 100);











        // Création du bandeau en bas de la fenêtre
        HBox bottomControls = new HBox();
        bottomControls.setAlignment(Pos.BOTTOM_CENTER );
        Label a = new Label("Ceci est un label de bas de page");
        bottomControls.getChildren().add( a );

        bp.setBottom(bottomControls);









        vbox.getChildren().add(menuBar);
        vbox.getChildren().add(bottomControls);
        vbox.getChildren().add(l1);
        vbox.getChildren().add(l2);
        vbox.getChildren().add(l3);
     //   vbox.getChildren().add(tblCustomers);





        // Ajout du conteneur à la scene
        Scene scene = new Scene(vbox);

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

