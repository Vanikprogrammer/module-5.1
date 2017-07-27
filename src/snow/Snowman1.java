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
public class Snowman1 extends Application {
    public static final int WIDTH_SCREEN = 600;
    public static final int HEIGHT_SCREEN = 700;
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Введите количество кругов");
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        primaryStage.setWidth(WIDTH_SCREEN);
        primaryStage.setHeight(HEIGHT_SCREEN);
        primaryStage.setTitle("SnowManAlien");

        Pane root = new Pane();
        root.getChildren().addAll(generateMan(count));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);



        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    private Circle[] generateMan(int count){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите минимальный радиус");
        double radiusMin = sc.nextDouble();
        double minRad = radiusMin;
        System.out.println("Введите максимальный радиус");
        double radiusMax = sc.nextDouble();
        double maxRad = radiusMax;
        Circle circle[] = new Circle[count+3];
        double centY = WIDTH_SCREEN;
        Random random = new Random();

        for(int i = 0; i < circle.length; i++){

            Color color = Color.color(random.nextDouble(),random.nextDouble(),random.nextDouble(),0.7f);
            double rad = (minRad) + (double) (Math.random() * (maxRad));
            centY -= rad;
            circle[i] = new Circle(WIDTH_SCREEN/2,centY,rad,color);
            centY -= rad;

            if(i==circle.length - 3){
                circle[i] = new Circle(WIDTH_SCREEN/2 - circle[circle.length - 4].getRadius()/2,
                        circle[circle.length - 4].getCenterY() - circle[circle.length - 4].getRadius()/3 ,
                        circle[circle.length - 4].getRadius()/6,
                        color);
            }if(i==circle.length - 2){
                circle[i] = new Circle(WIDTH_SCREEN/2 + circle[circle.length - 4].getRadius()/2,
                        circle[circle.length - 4].getCenterY() - circle[circle.length - 4].getRadius()/3 ,
                        circle[circle.length - 4].getRadius()/6,
                        color);
            }if(i==circle.length - 1){
                circle[i] = new Circle(WIDTH_SCREEN/2,
                        circle[circle.length - 4].getCenterY() + circle[circle.length - 4].getRadius()/3,
                        circle[circle.length - 4].getRadius()/4,color);
            }
        }return circle;
    }
}
