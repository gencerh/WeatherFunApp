package sample;

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

import java.sql.SQLException;

public class RegisterFormPage {
    public void Register(GridPane root) {
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10,50,50,50));
        bp.setStyle("-fx-background-color: #D3D3D3 ");

        Text text = new Text("Registration");
        text.setFill(Color.WHITE);
        text.setTextAlignment(TextAlignment.CENTER);
        text.setFont(Font.font("Verdana", 20));

        root.add(text, 1, 0);

        Label userName = new Label("Username");
        userName.setTextFill(Color.WHITE);
        final TextField username = new TextField();
        Label eMail = new Label("E-Mail Adresse");
        eMail.setTextFill(Color.WHITE);
        final TextField email = new TextField();
        Label tnummer = new Label("Telefonnummer");
        tnummer.setTextFill(Color.WHITE);
        final TextField tlfn = new TextField();
        Label lblPassword = new Label("Password");
        lblPassword.setTextFill(Color.WHITE);
        final PasswordField pswd = new PasswordField();
        Label lblPasswordWiederholen = new Label("Password Wiederholen");
        lblPasswordWiederholen.setTextFill(Color.WHITE);
        final PasswordField wpswd = new PasswordField();

        Button btnsubmit = new Button("Submit");

        root.add(userName, 0, 1);
        root.add(username, 1, 1);
        root.add(eMail, 0, 2);
        root.add(email,1,2);
        root.add(tnummer, 0, 3);
        root.add(tlfn,1,3);
        root.add(lblPassword,0,4);
        root.add(pswd,1,4);
        root.add(lblPasswordWiederholen,0,5);
        root.add(wpswd,1,5);

        root.add(btnsubmit,1,7);

        Datenbank dt = new Datenbank();
        Validations v = new Validations();

        Alert alert = new Alert(Alert.AlertType.WARNING);
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        btnsubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String usname = username.getText();
                try {

                    if (username.getText().isEmpty()) {
                        alert.setHeaderText("Username eingeben");
                        alert.showAndWait();

                    }
                    else if (dt.checkRegistiration(usname)==true) {
                        alert.setHeaderText("Biite geben Sie einen anderen username ein");
                        alert.showAndWait();
                    }
                    else if (email.getText().isEmpty()) {
                        alert.setHeaderText("E-Mail Adresse eingeben");
                        alert.showAndWait();

                    }
                    else if (v.emailCheck(email.getText())) {
                        alert.setHeaderText("ist keine gültige Email Adresse");
                        alert.showAndWait();

                    }
                    else if (tlfn.getText().isEmpty()) {
                        alert.setHeaderText("Telefonnumer eingeben");
                        alert.showAndWait();

                    }
                    else if (pswd.getText().isEmpty()) {
                        alert.setHeaderText("Password eingeben");
                        alert.showAndWait();

                    }else if (v.passwordCheck(pswd.getText())) {
                        alert.setHeaderText("Minimum 8 Zeichen, min. 1 Großbuchstaben,\n" +
                                "    min. 1 Kleinbuchstaben, min. 1 Zahl,\n" +
                                "    min. 1 Sonderzeichen");
                        alert.showAndWait();

                    }
                    else if (wpswd.getText().isEmpty()) {
                        alert.setHeaderText("Password wiederholen");
                        alert.showAndWait();

                    } else if (pswd.getText().equals(wpswd.getText())){
                        alert1.setHeaderText("Registieren Successful");
                        alert1.showAndWait();

                        String uname = username.getText();
                        String pwd = pswd.getText();
                        String mail = email.getText();
                        String tnum = tlfn.getText();

                        try {
                            dt.createInfo(uname,mail,tnum,pwd);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        username.clear();
                        email.clear(); tlfn.clear();
                        pswd.clear(); wpswd.clear();
                    }else {
                        alert.setHeaderText("Die eingegebenen Passwörter sind nicht gleich!!!!!");
                        alert.showAndWait();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        bp.setCenter(root);
    }
}
