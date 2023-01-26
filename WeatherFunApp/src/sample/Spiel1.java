package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Optional;
import java.util.Random;


public class Spiel1 {
    int scorePlayer=0;
    int scoreComputer=0;
    ImageView selectPlayer = new ImageView();
    ImageView selectComputer = new ImageView();

    BorderPane bp;

    String scoreP=Integer.toString(scorePlayer);
    String scoreC=Integer.toString(scoreComputer);

    Label lblPlayerResult = new Label(scoreP);
    Label lblComputerResult = new Label(scoreC);
    Label lblplayer = new Label("Player " + scoreP + " - " + scoreC + " Computer ");

    Label lblResult = new Label(" ");
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);


    public BorderPane start(){
        bp = new BorderPane();
        bp.setPadding(new Insets(10,50,50,50));
        bp.setStyle(
                "-fx-background-image: url(" +
                        "'/images/spiel1.jpg'" + "); "
                        + "-fx-background-position: center;"
                        + "-fx-background-size:100% 100%;");

        Text welcomeMessage = new Text("Welcome to Rock Paper Scissors...");
        welcomeMessage.setFont(Font.font("ITALIC", 20));
        Text rulesMessage = new Text(
                "Remember that Rock beats Scissors, Paper beats Rock and Scissors beats Paper.");

        lblplayer.setTextFill(Color.BLACK);
        lblplayer.setFont(new Font("Arial", 40));


        VBox vBox = new VBox();
        vBox.getChildren().addAll(welcomeMessage,rulesMessage,lblplayer);

        //Image imagetest = new Image("images/rock.png");
        //ImageView selectPlayer = new ImageView();
        selectPlayer.setFitHeight(75.0);
        selectPlayer.setFitWidth(75.0);
        lblResult.setTextFill(Color.BLACK);
        lblResult.setFont(new Font("Arial", 30));

        selectComputer.setFitHeight(75.0);
        selectComputer.setFitWidth(75.0);
        HBox hBox = new HBox(selectPlayer,lblResult,selectComputer);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10.0);
        gridPane.setVgap(10.0);
        //Text startMessage = new Text("Please make your selection below:");
        //startMessage.setFont(Font.font("ITALIC", 16));
        Image image = new Image("images/rock.png");
        ImageView rock = new ImageView(image);

        rock.setFitHeight(75.0);
        rock.setFitWidth(75.0);

        //gridPane.getChildren().add(startMessage);
        gridPane.add(rock,0,1);
        Text text = new Text("Rock");
        text.setFont(Font.font("Arial", 20));
        gridPane.add(text,0,2);

        Image image1 = new Image("images/paper.png");
        ImageView paper = new ImageView(image1);
        paper.setFitHeight(75.0);
        paper.setFitWidth(75.0);
        gridPane.add(paper,3,1);
        Text text1 = new Text("Paper");
        text1.setFont(Font.font("Arial", 20));
        gridPane.add(text1,3,2);

        Image image2 = new Image("images/scissors.png");
        ImageView scissors = new ImageView(image2);
        scissors.setFitHeight(75.0);
        scissors.setFitWidth(75.0);
        gridPane.add(scissors,6,1);
        Text text2 = new Text("Scissors");
        text2.setFont(Font.font("Arial", 20));
        gridPane.add(text2,6,2);

        rock.addEventHandler(MouseEvent.MOUSE_CLICKED, event->{

            selectPlayer.setImage(image);
            int compNumber=getRandomNumber();
            if(compNumber==1){
                selectComputer.setImage(image);
            }
            else if(compNumber==2){
                selectComputer.setImage(image1);
            }
            else{
                selectComputer.setImage(image2);
            }
            runGame(compNumber,1);

        });

        paper.addEventHandler(MouseEvent.MOUSE_CLICKED, event->{

            selectPlayer.setImage(image1);
            int compNumber=getRandomNumber();
            if(compNumber==1){
                selectComputer.setImage(image);
            }
            else if(compNumber==2){
                selectComputer.setImage(image1);
            }
            else{
                selectComputer.setImage(image2);
            }
            runGame(compNumber,2);

        });

        scissors.addEventHandler(MouseEvent.MOUSE_CLICKED, event->{

            selectPlayer.setImage(image2);

            int compNumber=getRandomNumber();
            if(compNumber==1){
                selectComputer.setImage(image);
            }
            else if(compNumber==2){
                selectComputer.setImage(image1);
            }
            else{
                selectComputer.setImage(image2);
            }
            runGame(compNumber,3);
        });

        bp.setTop(vBox);
        vBox.setAlignment(Pos.CENTER);
        bp.setBottom(gridPane);
        gridPane.setAlignment(Pos.CENTER);
        bp.setCenter(hBox);
        hBox.setAlignment(Pos.CENTER);

        return bp;

    }
    public int getRandomNumber(){
        Random random=new Random();
        int compNumber=random.nextInt(3)+1;
        return compNumber;

    }
    public void runGame(int compSelect,int userSelect){
        Menubar mb = new Menubar();

        if((userSelect==1 && compSelect ==3) || (userSelect==2&&compSelect==1) || (userSelect==3&&compSelect==2)){
             lblResult.setText("You win");
            scorePlayer=scorePlayer+1;
            String scoreC=Integer.toString(scoreComputer);
            String scoreP=Integer.toString(scorePlayer);
            if(scorePlayer==3){

                alert.setHeaderText("You won the game: "+ scorePlayer + " - " + scoreComputer );
                alert.setContentText("Play again");
                scoreComputer=0;
                scorePlayer=0;
                lblResult.setText("Result");
                Optional<ButtonType> result= alert.showAndWait();
                if(!result.isPresent()){

                }
                else if(result.get()==ButtonType.OK){
                    lblplayer.setText("Player " + 0 + " - " + 0 + " Computer ");
                    selectPlayer.setImage(null);
                    selectComputer.setImage(null);
                    lblResult.setText(null);
                }
                else if(result.get() == ButtonType.CANCEL){
                    Stage stagee = (Stage) bp.getScene().getWindow();
                    stagee.close();
                    mb.LoginMenuBar();
                }
            }
            else{
                lblplayer.setText("Player " + scoreP + " - " + scoreC + " Computer ");
                //lblPlayerResult.setText(scoreP);
            }

        }
        else if((userSelect==3 && compSelect ==3) || (userSelect==2&&compSelect==2) || (userSelect==1&&compSelect==1)){
            lblResult.setText("Draw");

        }
        else{
            lblResult.setText("You lose");
            scoreComputer=scoreComputer+1;
            String scoreC=Integer.toString(scoreComputer);
            String scoreP=Integer.toString(scorePlayer);

            if(scoreComputer==3){
                alert.setHeaderText("You lost the game: "+ scoreComputer + " - "  + scorePlayer);
                alert.setContentText("Try Again!");
                scoreComputer=0;
                scorePlayer=0;
                lblResult.setText("Result");
                Optional<ButtonType> result= alert.showAndWait();
                if(!result.isPresent()){

                }
                else if(result.get()==ButtonType.OK){
                    //lblComputerResult.setText("0");
                    //lblPlayerResult.setText("0");
                    lblplayer.setText("Player " + 0 + " - " + 0 + " Computer ");

                    selectPlayer.setImage(null);
                    selectComputer.setImage(null);
                    lblResult.setText(null);

                }
                else if(result.get() == ButtonType.CANCEL){
                    Stage stagee = (Stage) bp.getScene().getWindow();
                    stagee.close();
                    mb.LoginMenuBar();

                    //System.out.println("HomePage");
                }
            }
            else{
                lblplayer.setText("Player " + scoreP + " - " + scoreC + " Computer ");

                //lblComputerResult.setText(scoreC);
            }
        }
    }
}
