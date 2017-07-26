package snow;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import java.lang.Object;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;

/**
 * Created by 1 on 25.07.2017.
 */
public class Snowman extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Введите количество кругов");
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        if(count < 4){
            System.out.println("Невозможно нарисовать снеговика");
        }
        Random r = new Random();
        primaryStage.setWidth(600);
        primaryStage.setHeight(700);
        primaryStage.setTitle("SnowManAlien");

        Pane root = new Pane();
        root.getChildren().addAll(generateCircle(count));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private Circle[] generateCircle(int a){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите минимальный радиус");
        int radiusMin = sc.nextInt();
        int minRad = radiusMin;
        System.out.println("Введите максимальный радиус");
        int radiusMax = sc.nextInt();
        int maxRad = radiusMax;
        Circle circle[] = new Circle[a];
        int centY = 600;
        Random random = new Random();
        for(int i = 0; i < circle.length; i++){
            Color color = Color.color(random.nextDouble(),random.nextDouble(),random.nextDouble(),0.7f);
            int rad = (minRad) + (int)(Math.random() * (maxRad));
            centY -= rad;
            circle[i] = new Circle(300,centY,rad,color);
            centY -= rad;
            if(i==circle.length - 3){
                circle[i] = new Circle(300 - circle[circle.length - 4].getRadius()/2,
                        circle[circle.length - 4].getCenterY() - circle[circle.length - 4].getRadius()/3 ,
                        circle[circle.length - 4].getRadius()/6,
                        color);
            }if(i==circle.length - 2){
                circle[i] = new Circle(300 + circle[circle.length - 4].getRadius()/2,
                        circle[circle.length - 4].getCenterY() - circle[circle.length - 4].getRadius()/3 ,
                        circle[circle.length - 4].getRadius()/6,
                        color);
            }if(i==circle.length - 1){
                circle[i] = new Circle(300,
                        circle[circle.length - 4].getCenterY() + circle[circle.length - 4].getRadius()/3,
                        circle[circle.length - 4].getRadius()/4,color);
            }
        }return circle;
    }
}
