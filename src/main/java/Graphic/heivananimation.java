package Graphic;

import javafx.animation.Transition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class heivananimation extends Transition {
    heivan h;
    ImageView imageview;
    public heivananimation(ImageView imageview,heivan h) {
        this.imageview=imageview;
        this.setCycleDuration(Duration.millis(1000));
        this.setCycleCount(-1);
        this.h=h;
    }
    @Override
    protected void interpolate(double frac) {
        this.h.setX(this.h.getX()+1);
        this.h.setY(this.h.getY()+1);
        this.imageview.setX(this.h.getX());
        this.imageview.setY(this.h.getY());
    }
}
