package sample;

import WeatherApi.WeatherApi;
import WeatherApi.WeatherWeekly;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.sql.SQLException;

public class LoginFormPage {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    public void Loginform(GridPane root) {

        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10,50,50,50));
        bp.setStyle("-fx-background-color: #D3D3D3 ");

        Text text = new Text("Welcome");
        text.setFill(Color.WHITE);
        text.setTextAlignment(TextAlignment.CENTER);
        text.setFont(Font.font("Verdana", 20));

        root.add(text, 1, 0);
        Label username = new Label("Username");
        username.setTextFill(Color.WHITE);
        root.add(username, 0, 1);
        TextField ustext = new TextField();
        root.add(ustext, 1, 1);
        Label password = new Label("Password");
        password.setTextFill(Color.WHITE);
        root.add(password, 0, 3);
        PasswordField psw = new PasswordField();
        root.add(psw, 1, 3);

        Button btn = new Button("Login");
        /*HBox hbtn = new HBox(20.0);
        hbtn.setAlignment(Pos.CENTER);
        hbtn.getChildren().add(btn);*/
        root.add(btn, 1, 5);

        //Label lbl = new Label("Password Vergessen?");
        //lbl.setTextFill(Color.WHITE);

        //root.add(lbl, 1, 6);

        Datenbank dt = new Datenbank();
        Menubar mb = new Menubar();
        AdminHomePage admin = new AdminHomePage();

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String usname = ustext.getText();
                String paswd = psw.getText();
                try {

                    if (dt.checkLogin(usname,paswd)==true) {
                        boolean isAdmin= dt.checkAdmin(usname);
                        if(isAdmin){
                            admin.AdminHome();
                            Stage stage = (Stage) btn.getScene().getWindow();
                            stage.close();

                        }else{
                            mb.LoginMenuBar();
                            Stage stage = (Stage) btn.getScene().getWindow();
                            stage.close();
                        }

                    }else {
                        alert.setHeaderText("Username oder Pasword Falch");
                        alert.showAndWait();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        bp.setCenter(root);
    }

}
