package star;

/**
 * Created by 1 on 27.07.2017.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {
    public static final int WIDTH_SCREEN = 800;
    public static final int HEIGHT_SCREEN = 800;
    private Star star;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(WIDTH_SCREEN);
        primaryStage.setHeight(HEIGHT_SCREEN);
        primaryStage.setTitle("Звезда");

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите координаты Х");
        int x = sc.nextInt();
        System.out.println("Введите координаты У");
        int y = sc.nextInt();
        System.out.println("Введите радиус");
        int rad = sc.nextInt();
        star = new Star(x,y,rad);

        Pane root = new Pane();
        root.getChildren().addAll(star.drawStar());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);



        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
