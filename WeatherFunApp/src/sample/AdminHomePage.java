package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AdminHomePage {

    Stage primaryStage = new Stage();

    public void AdminHome() throws SQLException {
        Group root = new Group();
        Scene scene = new Scene(root, 430.0, 450.0);
        Label lbl = new Label("Personen");
        lbl.setFont(new Font(20.0));

        //TableView
        TableView<Person> tableView = new TableView<>();
        //TableColumn
        TableColumn<Person, String> idCol = new TableColumn<>("Id");
        idCol.setMinWidth(100.0);
        idCol.setMaxWidth(150.0);

        TableColumn<Person, String> usernameCol = new TableColumn<>("Username");
        usernameCol.setMinWidth(100.0);
        usernameCol.setMaxWidth(150.0);

        TableColumn<Person, String> eMailCol = new TableColumn<Person, String>("E-mail Adresse");
        eMailCol.setMinWidth(100.0);
        eMailCol.setMaxWidth(150.0);

        TableColumn<Person, String> telefonnummerCol = new TableColumn<Person, String>("Telefonnummer");
        telefonnummerCol.setMinWidth(100.0);
        telefonnummerCol.setMaxWidth(150.0);

        tableView.getColumns().addAll(idCol, usernameCol,eMailCol,telefonnummerCol);

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        eMailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        telefonnummerCol.setCellValueFactory(new PropertyValueFactory<>("Telefonnummer"));

        ObservableList<Person> list = getUserList();
        tableView.setItems(list);
        tableView.setEditable(true);

        idCol.setEditable(true);
        idCol.setCellFactory(TextFieldTableCell.forTableColumn());//TextFieldTableCell.<Person>forTableColumn()

        idCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> event) {
                String newValue = event.getNewValue();
                TablePosition<Person, String> position = event.getTablePosition();
                System.out.println("Neuer Wert: " + newValue +
                        " Spalte: " + position.getColumn() +
                        " Zeile: " + position.getRow());
                Person person = event.getTableView().getItems().get(position.getRow());
                person.setUserName(newValue);
            }
        });

        VBox vBox = new VBox(10.0);
        vBox.setPadding(new Insets(10.0, 0.0, 0.0, 10.0));
        vBox.getChildren().addAll(lbl, tableView);
        vBox.setAlignment(Pos.CENTER);
        root.getChildren().add(vBox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ObservableList<Person> getUserList() throws SQLException {
        Datenbank db = new Datenbank();
        ObservableList<Person> list = FXCollections.observableArrayList(db.getPersonList());
        return list;
    }



}
