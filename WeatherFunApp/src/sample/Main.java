package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public Text message = new Text("");

    public GridPane Gridpane() {
        GridPane root = new GridPane();
        root.setStyle(
                    "-fx-background-image: url(" +
                            "'/images/pexels-pixabay-36717.jpg'" + "); "
                            + "-fx-background-position: center;"
                            + "-fx-background-size:100% 100%;");
        root.setPrefSize(300, 300);
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));
        return root;
    }

    @Override
    public void start(Stage primaryStage) {
        FlowPane flowPane = new FlowPane();
        flowPane.setHgap(5);
        flowPane.setVgap(5);
        Scene scene = new Scene(flowPane,400,450, Color.LIGHTBLUE);

        BorderPane meinPane = new BorderPane();
        TabPane tabPane = new TabPane();
        Tab tabA = new Tab();
        tabA.setText("Login");
        GridPane root = Gridpane();
        LoginFormPage lfp = new LoginFormPage();
        lfp.Loginform(root);
        tabA.setContent(root);
        tabA.setClosable(false);

        Tab tabB = new Tab();
        tabB.setText("Registration");
        RegisterFormPage rfp = new RegisterFormPage();
        GridPane root1 = Gridpane();
        rfp.Register(root1);
        tabB.setContent(root1);
        tabB.setClosable(false);

        Circle circle = new Circle(40,40,10);
        circle.setFill(Color.RED);
        Datenbank dt = new Datenbank();

        if (dt.DBConnect()){
            tabPane.setDisable(false);
            circle.setFill(Color.GREEN);
            message.setText("Database Connected");
            message.setFill(Color.GREEN);
        }
        else{
            tabPane.setDisable(true);
            circle.setFill(Color.RED);
            message.setText("Database Disconnected");
            message.setFill(Color.RED);
        }
        tabPane.getTabs().addAll(tabA,tabB);

        meinPane.setCenter(tabPane);
        meinPane.prefHeightProperty().bind(scene.heightProperty());
        meinPane.prefWidthProperty().bind(scene.widthProperty());
        flowPane.getChildren().addAll(circle,message,meinPane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
