package Graphic;

import javafx.animation.Transition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;

public class BallAnimation extends Transition {
    public Ball ball;
    ImageView imageView=new ImageView();
    static ArrayList<BallAnimation> BallAn=new ArrayList<>();
    public BallAnimation( ImageView imageView,Ball ball) {
this.imageView=imageView;
        this.ball = ball;
        this.setCycleDuration(Duration.millis(1000000));
        this.setCycleCount(1);
        BallAn.add(this);
    }

    @Override
    protected void interpolate(double v) {
        double dx=this.ball.getVx();
        double dy=-this.ball.getVy();
        this.ball.Move(dx,dy);
        this.ball.collision(v);
        if(this.ball.hitT()){
            this.ball.setVy(-this.ball.getVy());
            this.ball.Actions.add("t = "+v+"s: "+this.ball.getName()+"(x,y)=("+this.ball.getCenterX()+","+this.ball.getCenterY()+"), wall");
            Ball.AllActions.add("t = "+v+"s: "+this.ball.getName()+"(x,y)=("+this.ball.getCenterX()+","+this.ball.getCenterY()+"), wall");
        }
        if(this.ball.hitR()||this.ball.hitL()){
            this.ball.setVx(-this.ball.getVx());
            this.ball.Actions.add("t = "+v+"s: "+this.ball.getName()+"(x,y)=("+this.ball.getCenterX()+","+this.ball.getCenterY()+"), wall");
            Ball.AllActions.add("t = "+v+"s: "+this.ball.getName()+"(x,y)=("+this.ball.getCenterX()+","+this.ball.getCenterY()+"), wall");
        }
        if(this.ball.hitB()){
            this.ball.setVy(-this.ball.getVy());
            this.ball.Actions.add("t = "+v+"s: "+this.ball.getName()+"(x,y)=("+this.ball.getCenterX()+","+this.ball.getCenterY()+"), wall");
            Ball.AllActions.add("t = "+v+"s: "+this.ball.getName()+"(x,y)=("+this.ball.getCenterX()+","+this.ball.getCenterY()+"), wall");
        }
        this.imageView.setX(this.ball.getCenterX()-this.ball.getRadius());
        this.imageView.setY(this.ball.getCenterY()-this.ball.getRadius());
    }
}
