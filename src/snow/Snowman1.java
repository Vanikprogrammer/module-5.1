package snow;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.TriangleMesh;
import javafx.stage.Stage;

import java.util.Random;
import java.util.Scanner;
import java.lang.Object;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;

/**
 * Created by 1 on 25.07.2017.
 */
public class Snowman1 {
    private double minRad;
    private double maxRad;
    private double centY = Main.WIDTH_SCREEN;

    public Snowman1(double minRad,double maxRad){
        this.minRad = minRad;
        this.maxRad = maxRad;
    }

    public Circle[] generateMan(int count){
        Circle circle[] = new Circle[count+3];
        Random random = new Random();

        for(int i = 0; i < circle.length; i++){

            Color color = Color.color(random.nextDouble(),random.nextDouble(),random.nextDouble(),0.7f);
            double rad = (minRad) + (double) (Math.random() * (maxRad));
            centY -= rad;
            circle[i] = new Circle(Main.WIDTH_SCREEN/2,centY,rad,color);
            centY -= rad;

            if(i==circle.length - 3){
                circle[i] = new Circle(Main.WIDTH_SCREEN/2 - circle[circle.length - 4].getRadius()/2,
                        circle[circle.length - 4].getCenterY() - circle[circle.length - 4].getRadius()/3 ,
                        circle[circle.length - 4].getRadius()/6,
                        color);
            }if(i==circle.length - 2){
                circle[i] = new Circle(Main.WIDTH_SCREEN/2 + circle[circle.length - 4].getRadius()/2,
                        circle[circle.length - 4].getCenterY() - circle[circle.length - 4].getRadius()/3 ,
                        circle[circle.length - 4].getRadius()/6,
                        color);
            }if(i==circle.length - 1){
                circle[i] = new Circle(Main.WIDTH_SCREEN/2,
                        circle[circle.length - 4].getCenterY() + circle[circle.length - 4].getRadius()/3,
                        circle[circle.length - 4].getRadius()/4,color);
            }
        }return circle;
    }
}
