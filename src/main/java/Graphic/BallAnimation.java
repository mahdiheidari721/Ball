package Graphic;

import javafx.animation.Transition;
import javafx.util.Duration;

public class BallAnimation extends Transition {
    public Ball ball;
    public BallAnimation( Ball ball) {

        this.ball = ball;
        this.setCycleDuration(Duration.millis(1000));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double v) {
       double dx=this.ball.getVx();
       double dy=-this.ball.getVy();
       this.ball.Move(dx,dy);
       this.ball.collision();
       if(this.ball.hitT()){
           this.ball.setVy(-this.ball.getVy());
       }
        if(this.ball.hitR()||this.ball.hitL()){
            this.ball.setVx(-this.ball.getVx());
        }
        if(this.ball.hitB()){
            this.ball.setVy(-this.ball.getVy());
        }
    }
}
