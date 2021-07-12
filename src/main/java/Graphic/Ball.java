package Graphic;

import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Ball extends Circle {
    public static ArrayList<Ball> Allball=new ArrayList<>();
    ArrayList<String> Actions=new ArrayList<>();
    String Name;
    double Vx;
    double Vy;
    double mass;
    public Ball(String Name,double centerX, double centerY, double radius,double Vx,double Vy,double mass ) {
        super(centerX, centerY, radius);
        this.Name=Name;
        this.Vx=Vx;
        this.Vy=Vy;
        this.mass=mass;
        Allball.add(this);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public static ArrayList<Ball> getAllball() {
        return Allball;
    }

    public static void setAllball(ArrayList<Ball> allball) {
        Allball = allball;
    }


    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getVx() {
        return Vx;
    }

    public void setVx(double vx) {
        Vx = vx;
    }

    public double getVy() {
        return Vy;
    }

    public void setVy(double vy) {
        Vy = vy;
    }

    public void Move(double dx, double dy){
        this.setCenterX(this.getCenterX()+dx);
        this.setCenterY(this.getCenterY()+dy);
    }
    public boolean hitT(){
        return this.getCenterY()-this.getRadius()<=0;
    }
    public boolean hitL(){
        return this.getCenterX()-this.getRadius()<=0;
    }
    public boolean hitR(){
        return this.getCenterX()+this.getRadius()>=1000;
    }
    public boolean hitB(){
        return this.getCenterY()+this.getRadius()>=600;
    }
public void collision(){
        for(int i=0;i<Allball.size();i++){
            if(this.getCenterY()==Allball.get(i).getCenterY()&&this.getCenterX()==Allball.get(i).getCenterX()){
                continue;
            }
          else  if(this.getBoundsInParent().intersects(Allball.get(i).getLayoutBounds())){

                Vector v_n=new Vector(this.getCenterX()-Allball.get(i).getCenterX(),this.getCenterY()-Allball.get(i).getCenterY());
            Vector v_un=new Vector(v_n.getX()/Math.sqrt(v_n.getX()*v_n.getX()+v_n.getY()*v_n.getY()),v_n.getY()/Math.sqrt(v_n.getX()*v_n.getX()+v_n.getY()*v_n.getY()) );
              Vector v_ut=new Vector(-v_un.getY(), v_un.getX());
                double v1n =  v_un.getX()*this.getVx()+ v_un.getY()*this.getVy();
                double v1t = v_ut.getX()*this.getVx()+ v_ut.getY()*this.getVy();
                double v2n =   v_un.getX()*Allball.get(i).getVx()+ v_un.getY()*Allball.get(i).getVy();
                double v2t = v_ut.getX()*Allball.get(i).getVx()+ v_ut.getY()*Allball.get(i).getVy();
                double v1tPrime = v1t;
                double v2tPrime = v2t;
                double v1nPrime=(v1n*(this.getMass()-Allball.get(i).getMass())+2*Allball.get(i).getMass()*v2n)/(this.getMass()+Allball.get(i).getMass());
                double v2nPrime=(v2n*(Allball.get(i).getMass()-this.getMass())+2*this.getMass()*v1n)/(this.getMass()+Allball.get(i).getMass());
Vector v_v1nPrime=new Vector(v_un.getX()*v1nPrime,v_un.getY()*v1nPrime);
Vector v_v1tPrime=new Vector(v_ut.getX()*v1tPrime,v_ut.getY()*v1tPrime);
Vector v_v2nPrime=new Vector(v_un.getX()*v2nPrime,v_un.getY()*v2nPrime);
Vector v_v2tPrime=new Vector(v_ut.getX()*v2tPrime,v_ut.getY()*v2tPrime);
                this.setVx(v_v1nPrime.getX()+v_v1tPrime.getX());
                this.setVy(v_v1nPrime.getY()+v_v1tPrime.getY());
               Allball.get(i).setVx(v_v2nPrime.getX()+v_v2tPrime.getX());
                Allball.get(i).setVy(v_v2nPrime.getY()+v_v2tPrime.getY());
            }
        }
}
}
