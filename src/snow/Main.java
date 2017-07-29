package snow;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
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
        primaryStage.setWidth(WIDTH_SCREEN);
        primaryStage.setHeight(HEIGHT_SCREEN);

        Pane root = new Pane();

        TextField text = new TextField();
        TextField text1 = new TextField();
        TextField text2 = new TextField();
        text.setTranslateX(10);
        text.setTranslateY(30);
        text.setText("10");
        text1.setTranslateX(10);
        text1.setTranslateY(80);
        text1.setText("30");
        text2.setTranslateX(10);
        text2.setTranslateY(130);
        text2.setText("5");

        Text text3 = new Text();
        Text text4 = new Text();
        Text text5 = new Text();
        text3.setTranslateX(10);
        text3.setTranslateY(20);
        text3.setText("Введите минимальный радиус элементов снеговика");
        text4.setTranslateX(10);
        text4.setTranslateY(70);
        text4.setText("Введите максимальный радиус элементов снеговика");
        text5.setTranslateX(10);
        text5.setTranslateY(120);
        text5.setText("Введите количество элементов снеговика");

        Button button = new Button();
        button.setTranslateX(10);
        button.setTranslateY(155);
        button.setText("Generate Snowman");

        Button buttonRed = new Button();
        buttonRed.setTranslateX(10);
        buttonRed.setTranslateY(190);
        buttonRed.setText("Закрасить снеговика в крассный");

        root.getChildren().addAll(text, text1, text2,
                text3, text4, text5, button, buttonRed);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("SnowManAlien");
        primaryStage.show();

        buttonRed.setOnMouseClicked(event -> {
            snowman1.paintRed();});

        button.setOnMouseClicked(event -> {


            int counter = Integer.parseInt(text.getText());
            int counter1 = Integer.parseInt(text1.getText());
            int counter2 = Integer.parseInt(text2.getText());
            snowman1 = new Snowman1(counter,counter1,counter2);

            root.getChildren().clear();

            root.getChildren().addAll(snowman1.generateMan());

            text3.setText(String.valueOf(counter));
            text4.setText(String.valueOf(counter1));
            text5.setText(String.valueOf(counter2));
            root.getChildren().addAll(text, text1, text2,
                    text3, text4, text5, button, buttonRed);

            });


    }
    public static void main(String[] args) {
        launch(args);
    }


}
