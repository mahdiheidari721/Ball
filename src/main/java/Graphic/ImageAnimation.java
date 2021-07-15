package Graphic;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class ImageAnimation extends Transition {
    ImageView imageview;

    public ImageAnimation(ImageView imageview) {
        this.imageview=imageview;
        this.setCycleDuration(Duration.millis(1000));
        this.setCycleCount(1);
    }
    public  void duration(int t){

        this.setCycleDuration(Duration.millis(1000*t));
    }
    @Override
    protected void interpolate(double frac) {
        int frame= (int) Math.floor(frac*4);

//        if(frame>=2) {
//            System.out.println(frame);
//        }
        this.imageview.setX(this.imageview.getX()+1);
        this.imageview.setY(this.imageview.getY()+1);
    }

    public void setInterpolator() {
    }
}