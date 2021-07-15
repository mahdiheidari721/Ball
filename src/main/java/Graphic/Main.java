package Graphic;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class Main extends Application {
    static ArrayList<Ball> balls=new ArrayList();
    static ArrayList<BallAnimation> ballAnimations=new ArrayList<>();
    static  ArrayList<String> Allcollision=new ArrayList<>();
    Button b = new Button("Submit");
    TextField tf1=new TextField();
    int t=0;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        InputStream stream = new FileInputStream("D:\\images\\Ball.png");
        Image image = new Image(stream);
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(10);
        imageView.setY(10);
        imageView.setFitWidth(150);
        imageView.setPreserveRatio(true);
        imageView.setPickOnBounds(true);//it i important to click on images
        b.setLayoutY(25);
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String s= tf1.getText();
                String[] split=s.split("\\s");
                if(s.startsWith("Add")){
                    if(split.length==7){
                        Ball ball =new Ball(split[2],Integer.parseInt(split[5]),Integer.parseInt(split[6]),Integer.parseInt(split[4]),0,0,Integer.parseInt(split[3]));
                        ImageView imageView = new ImageView();
                        imageView.setImage(image);
                        imageView.setX(10);
                        imageView.setY(10);
                        imageView.setFitWidth(50);
                        imageView.setFitHeight(50);
                        imageView.setPreserveRatio(true);
                        imageView.setPickOnBounds(true);//it i important to click on images
                        BallAnimation a=new BallAnimation(imageView,ball);
                        a.play(); MainView.pane.getChildren().add(imageView);
                    }
                    if(split.length==9){
                        Ball ball =new Ball(split[2],Integer.parseInt(split[5]),Integer.parseInt(split[6]),Integer.parseInt(split[4]),Integer.parseInt(split[7]),Integer.parseInt(split[8]),Integer.parseInt(split[3]));
                        ImageView imageView = new ImageView();
                        imageView.setImage(image);
                        imageView.setX(Integer.parseInt(split[5]));
                        imageView.setY(Integer.parseInt(split[6]));
                        imageView.setFitWidth(50);
                        imageView.setFitHeight(50);
                        imageView.setPreserveRatio(true);
                        imageView.setPickOnBounds(true);//it i important to click on images
                        BallAnimation a=new BallAnimation(imageView,ball);
                        a.play(); MainView.pane.getChildren().add(imageView);
                    }

                }
                if(split.length==3){
                    if(s.startsWith("locate")){
                        int t=0;
                        for(int i=0;i<Ball.Allball.size();i++){
                            if(Ball.Allball.get(i).getName().equalsIgnoreCase(split[2])){
                                t++;
                                System.out.println("(x,y)=("+Ball.Allball.get(i).getCenterX()+","+Ball.Allball.get(i).getCenterX()+")");
                            }
                        }
                        if(t==0){
                            System.out.println("the ball has not been found");
                        }
                    }
                    if(s.startsWith("remove")){
                        for(int i=0;i<Ball.Allball.size();i++){
                            if(Ball.Allball.get(i).getName().startsWith(split[2])){
                                Ball.Allball.remove(Ball.Allball.get(i));
                                break;
                            }
                        }
                    }
                    if(s.startsWith("print")){
                        for(int i=0;i<Ball.Allball.size();i++){
                            for(int j=0;j<Ball.Allball.get(i).Actions.size();j++){
                                System.out.println(Ball.Allball.get(i).Actions.get(j));
                            }
                        }
                    }

                }
                if(s.equalsIgnoreCase("end")){
                    for(int i=0;i<BallAnimation.BallAn.size();i++){
                        BallAnimation.BallAn.get(i).pause();
                        BallAnimation.BallAn.get(i).imageView.setVisible(false);
                    }
                }
                if(split.length==2){
                    for(int i=0;i<Ball.Allball.size();i++){
                        System.out.println(Ball.Allball.get(i).getName()+":"+"(x,y)=("+Ball.Allball.get(i).getCenterX()+","+Ball.Allball.get(i).getCenterX()+")");
                    }
                }
                if(split.length==4){
                    for(int i=0;i<Ball.Allball.size();i++){
                        if(Ball.Allball.get(i).getName().equalsIgnoreCase(split[3])){
                            for(int j=0;j<Ball.Allball.get(i).Actions.size();j++){
                                System.out.println(Ball.Allball.get(i).Actions.get(j));
                            }
                            break;
                        }
                    }
                }



            }
        });


















        MainView.getMV().setMainStage(primaryStage);
        primaryStage.setResizable(false);
        MainView.getMV().setScene("Start.fxml");
        MainView.pane.getChildren().add(tf1);
        MainView.pane.getChildren().add(b);
        Scene scene =new Scene(MainView.pane);

        MainView.getMV().getMainStage().setScene(scene);
        primaryStage.show();
    }


}
