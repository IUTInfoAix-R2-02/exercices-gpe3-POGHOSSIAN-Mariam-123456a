package tp1.exercice6;

import fr.amu.iut.exercice6.Dico;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IHMPendu extends Application {

    private ImageView imagePendu;
    private Label texteNbVies;
    private Label motEnCours;
    private ArrayList<Button> listeBoutons;
    private GridPane alphabetAffiche;
    private Button rejouer;
    private VBox root;
    private Dico dico;
    private String motATrouver;
    int nbVies;

    private final EventHandler<ActionEvent> actionValiderLettre = new EventHandler<>() {
        @Override
        public void handle(ActionEvent mouseEvent) {
            if (nbVies != 0 && !motTrouve()) {
                char lettre = ((Button) mouseEvent.getSource()).getText().charAt(0);
                ArrayList<Integer> listePosition = dico.getPositions(lettre, motATrouver);
                if (listePosition.size() == 0) {
                    texteNbVies.setText("Nombre de vies : " + --nbVies);
                    imagePendu.setImage(new Image("exercice6/pendu" + String.valueOf(nbVies) + ".png"));
                    ((Button) mouseEvent.getSource()).setDisable(true);
                } else {
                    StringBuilder sb = new StringBuilder(motEnCours.getText());
                    for (int i : listePosition)
                        sb.setCharAt(i, lettre);
                    motEnCours.setText(sb.toString());
                    if (motTrouve())
                        imagePendu.setImage(new Image("exercice6/penduWin.png"));
                }
            }
//            else initJeu();
        }
    };

    /**
     * Création et paramétrage d'un bouton
     */
    public Button creerBouton(String lettre) {
        Button bouton = new Button();
        bouton.setStyle("-fx-font-size:20px;-fx-text-fill:#50CEB9;-fx-font-weight:bold;-fx-border-width: 1px;-fx-border-color:#FFB786;-fx-border-radius: 10;-fx-background-color: #DAFDF7;/*-fx-background-color: rgba(255, 255, 255, 0.5);*/");
        bouton.setPrefWidth(50);
        bouton.setText(lettre);
        bouton.setOnAction(actionValiderLettre);
        return bouton;
    }

    /**
     * Création de la liste de boutons de l'alphabet
     */
    public void creerListeBoutons() {
        List<Character> listeVoyelles = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y');
        listeBoutons = new ArrayList<>();
        for (char voyelle : listeVoyelles)
            listeBoutons.add(creerBouton(String.valueOf(voyelle)));
        for(int i = 0; i < 26; i++) {
            char lettre = (char) (i + 97);
            if (!listeVoyelles.contains(lettre))
                listeBoutons.add(creerBouton(String.valueOf(lettre)));
        }
    }

    /**
     * Initialisation des composants de l'interface graphique correspondants à l'alphabet
     */
    public void initAlphabet() {
        if (alphabetAffiche == null) {
            alphabetAffiche = new GridPane();
            alphabetAffiche.setStyle("-fx-background-color: #DAFDF7;");
            creerListeBoutons();
            for (int i = 0; i < 6 ; i++)
                alphabetAffiche.add(listeBoutons.get(i), i + 2, 0);
            for (int i = 6; i < 16 ; i++)
                alphabetAffiche.add(listeBoutons.get(i), i - 6, 1);
            for (int i = 16; i < 26 ; i++)
                alphabetAffiche.add(listeBoutons.get(i), i - 16, 2);
        } else {
            reactiverBoutonsAlphabets();
        }

    }

    private void reactiverBoutonsAlphabets() {
        for (Button bouton : listeBoutons) {
            bouton.setDisable(false);
        }
    }

    private void construireMotATrouver() {
        motATrouver = dico.getMot();
        System.out.println(motATrouver);
        StringBuilder texteLabel = new StringBuilder();
        for (int index = 0; index < motATrouver.length(); index++) {
            texteLabel.append('*');
        }
        motEnCours.setText(texteLabel.toString());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);
        initComposants();

        initJeu();
        root.getChildren().addAll(imagePendu, texteNbVies, motEnCours, alphabetAffiche, rejouer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void initComposants() {
        dico = new Dico();
        root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(15);
        root.setStyle("-fx-background-color: #DAFDF7;");
        texteNbVies = new Label();
        texteNbVies.setFont(Font.font("Courier", FontWeight.BOLD, 20));
        motEnCours = new Label();
        motEnCours.setFont(Font.font("Courier", FontWeight.BOLD, 40));
        rejouer = new Button("Rejouer");
        rejouer.setStyle("-fx-font-family:Courier;-fx-font-size:16px;-fx-text-fill:#FFB786;-fx-font-weight:bold;-fx-border-width:2px;-fx-border-color:#50CEB9;-fx-border-radius:20;-fx-background-color:#DAFDF7;cursor: pointer;");
        rejouer.setOnAction(event -> initJeu());
        imagePendu = new ImageView();
    }

    private void initJeu() {
        construireMotATrouver();
        initAlphabet();
        initVies();
    }

    private void initVies() {
        nbVies = 7;
        texteNbVies.setText("Nombre de vies : " + nbVies);
        imagePendu.setImage(new Image("exercice6/pendu7.png"));
    }

    private boolean motTrouve() {
        return !motEnCours.getText().contains("*");
    }

    public static void main(String[] args) {
        launch(args);
    }
}