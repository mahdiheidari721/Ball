package Graphic;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import com.sun.javafx.fxml.builder.JavaFXSceneBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application implements EventHandler<ActionEvent>{
  static  ArrayList<Ball> balls=new ArrayList();
static ArrayList<BallAnimation> ballAnimations=new ArrayList<>();
    public static void main(String[] args) {
        launch(args);


    }
    Button b = new Button("Submit");
    TextField tf1=new TextField();
    int t=0;
    @Override
    public void start(Stage primaryStage) throws Exception {
      //  creating the image object
        InputStream stream = new FileInputStream("D:\\images\\Ball.png");
       // InputStream stream1 = new FileInputStream("D:\\images\\hen.jpg");
        Image image = new Image(stream);
      //  Image image1 = new Image(stream1);
        //Creating the image view
        ImageView imageView = new ImageView();
        ImageView imageView1 = new ImageView();
        ImageView imageView2 = new ImageView();
        //Setting image to the image view
        imageView.setImage(image);
       // imageView1.setImage(image1);
     //   imageView2.setImage(image1);
        //Setting the image view parameters
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(150);
        imageView.setPreserveRatio(true);
        imageView.setPickOnBounds(true);//it i important to click on images
/////
        imageView1.setX(100);
        imageView1.setY(100);
        imageView1.setFitWidth(40);
        imageView1.setFitHeight(40);
        imageView1.setPreserveRatio(true);
        imageView1.setPickOnBounds(true);//it i important to click on images
//////
        imageView2.setX(40);
        imageView2.setY(40);
        imageView2.setFitWidth(40);
        imageView2.setFitHeight(40);
        imageView2.setPreserveRatio(true);
        imageView2.setPickOnBounds(true);//it i important to click on images

        ImageAnimation q=new ImageAnimation(imageView);// the transition for images
q.play();

heivan h=new heivan(100,100);
heivananimation oo=new heivananimation(imageView1,h);
oo.play();
        heivan h2=new heivan(40,40);
        heivananimation ooo=new heivananimation(imageView2,h2);
        ooo.play();


       Ball ball=new Ball("ball2",200,300,20,2,2,90);
       Ball ball1=new Ball("ball3",250,350,20,2,2,90);
        Ball ball2=new Ball("ball4",350,350,20,2,2,90);
        balls.add(ball);
        balls.add(ball1);
        balls.add(ball2);
        b.setLayoutY(25);
      //  b.setOnAction(e->System.out.println("You entered: User_ID: "+tf1.getText()+""+"Password: "+tf2.getText()));
        b.setOnAction(this);
        for(int i=0;i<balls.size();i++){
            BallAnimation p=new BallAnimation(balls.get(i));
            ballAnimations.add(p);
            p.play();
        }

        Text text = new Text();

        //Setting the text to be added.
        text.setText("Hello how are you");

        //setting the position of the text
        text.setX(150);
        text.setY(150);
        imageView.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                t++;
                text.setText(String.valueOf(t));
//                Alert a = new Alert(Alert.AlertType.INFORMATION);
//                a.setContentText("This is checkmark");
//                a.show();
                if(t%2==1) {
                    q.pause();
for(int i=0;i<ballAnimations.size();i++){
    ballAnimations.get(i).pause();
}
                }
                if(t%2==0){
                    q.play();
                    for(int i=0;i<ballAnimations.size();i++){
                        ballAnimations.get(i).play();
                    }
                }
              // q.duration(1);
              // q.setInterpolator();
                q.play();// we can set the duration of q
            }
        });
        //we know the finishing of an event
q.setOnFinished(new EventHandler() {
    @Override
    public void handle(Event event) {
        t++;
//        Alert a = new Alert(Alert.AlertType.INFORMATION);    //important to show a message on the screen
//        a.setContentText("time is up");
//        a.show();
                if(t%2==1) {
                    q.pause();
for(int i=0;i<ballAnimations.size();i++){
    ballAnimations.get(i).pause();
}
                }
                if(t%2==0){
                    q.play();
                    for(int i=0;i<ballAnimations.size();i++){
                        ballAnimations.get(i).play();
                    }
                }

    }
});


        MainView.getMV().setMainStage(primaryStage);
primaryStage.setResizable(false);
MainView.getMV().setScene("Start.fxml");
        for(int i=0;i<balls.size();i++){
            MainView.pane.getChildren().add(balls.get(i));
        }
        String path = "D:\\images\\noon.mp3";

        //Instantiating Media class
        Media media = new Media(new File(path).toURI().toString());

        //Instantiating MediaPlayer class
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        //by setting this property to true, the audio will be played
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(-1);
        MediaView mediaView = new MediaView(mediaPlayer);

        MainView.pane.getChildren().add(mediaView);
        MainView.pane.getChildren().add(text);
        MainView.pane.getChildren().add(imageView);
      //  imageView.setVisible(false);
        //MainView.pane.getChildren().add(imageView1);
       // MainView.pane.getChildren().add(imageView2);
        MainView.pane.getChildren().add(tf1);
        MainView.pane.getChildren().add(b);
        Scene scene =new Scene(MainView.pane);
        MainView.pane.setOnMouseClicked(e -> System.out.println(e.getX()) ); //for get the location of mouseclick
        MainView.getMV().getMainStage().setScene(scene);
primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
     if(event.getSource()==b){
        String[] split=tf1.getText().split("\\s");
         Ball ball=new Ball(split[0],Double.parseDouble(split[1]),Double.parseDouble(split[2]),Double.parseDouble(split[3]),Double.parseDouble(split[4]),Double.parseDouble(split[5]),Double.parseDouble(split[6]));
         balls.add(ball);
         BallAnimation a=new BallAnimation(ball);
         a.play();
         MainView.pane.getChildren().add(ball);
     }

    }
}
