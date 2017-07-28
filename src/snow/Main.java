package snow;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 * Created by 1 on 28.07.2017.
 */

public class Main extends Application {
    public static final int WIDTH_SCREEN = 600;
    public static final int HEIGHT_SCREEN = 700;
    private Snowman1 snowman1;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Введите количество кругов");
        int count = sc.nextInt();
        System.out.println("Введите минимальный радиус");
        double minRad = sc.nextDouble();
        System.out.println("Введите максимальный радиус");
        double maxRad = sc.nextDouble();
        snowman1 = new Snowman1(minRad,maxRad);


        primaryStage.setWidth(WIDTH_SCREEN);
        primaryStage.setHeight(HEIGHT_SCREEN);
        primaryStage.setTitle("SnowManAlien");

        Pane root = new Pane();
        root.getChildren().addAll(snowman1.generateMan(count));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);


        primaryStage.show();


    }
    public static void main(String[] args) {
        launch(args);
    }


}
