package sample;


import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class Menubar {

    Stage stage = new Stage();
    BorderPane root;
    Scene scene;

    public void LoginMenuBar() {
        //Conversion Machine Action

        Text textHomePage = new Text("Welcome to App22");
        textHomePage.setFill(Color.RED);
        textHomePage.setTextAlignment(TextAlignment.CENTER);
        textHomePage.setFont(Font.font("ITALIC", 40));


        MenuBar menuBar = new MenuBar();

        Menu profile = new Menu("Profile");
        Menu rechner = new Menu("Rechner");
        Menu spiele = new Menu("Spiele");
        Menu media = new Menu("Media");
        Menu hilfe = new Menu("Hilfe");

        //Profile
        MenuItem einstellung = new MenuItem("Einstellung");
        MenuItem abmelden = new MenuItem("Abmelden");
        MenuItem beenden = new MenuItem("Beenden");

        //Rechner
        MenuItem conversion = new MenuItem("Konversion Calc");

        //Spiele
        MenuItem spiel1 = new MenuItem("Spiel1");

        //Weather
        MenuItem weather = new MenuItem("Weather");

        //Hilfe
        MenuItem app = new MenuItem("über App22");

        Label label=new Label("Home");
        label.setOnMouseClicked(event -> root.setCenter(textHomePage));

        Menu home=new Menu("",label);

        //Add
        menuBar.getMenus().addAll(home,profile, rechner, spiele, media, hilfe);

        profile.getItems().addAll(einstellung, abmelden, beenden);
        rechner.getItems().addAll(conversion);
        media.getItems().add(weather);
        hilfe.getItems().addAll(app);
        spiele.getItems().addAll(spiel1);

        root = new BorderPane();
        root.setStyle(
                "-fx-background-image: url(" +
                        "'/images/b.png'" + "); "
                        + "-fx-background-size: cover;");

        //root.getChildren().addAll(menuBar);
        scene = new Scene(root, 600.0, 500.0);

        root.setTop(menuBar);
        root.setCenter(textHomePage);

        //root.setAlignment(Pos.TOP_CENTER);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        ConversionMachine cm = new ConversionMachine();

        conversion.setOnAction(event -> root.setCenter(cm.spielStart()));
        spiel1.setOnAction(event -> {
            Spiel1  a = new  Spiel1();
            root.getChildren().remove(cm.spielStart());
            root.setCenter(a.start());

        });
        weather.setOnAction(event -> {
            WeatherApp w = new WeatherApp();
            try {
                //w.start(stage);
                root.setCenter(w. start(stage));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            root.getChildren().remove(cm.spielStart());
            //root.setCenter(w.show());

        });
        Main main = new Main();
        abmelden.setOnAction(event -> {
            Stage stagee = (Stage) root.getScene().getWindow();
            stagee.close();
            Stage stage=new Stage();
            main.start(stage);

        });

        beenden.setOnAction(event -> System.exit(0));

    }

}
