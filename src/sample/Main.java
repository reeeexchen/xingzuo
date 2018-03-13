package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("占星游戏");
        GridPane gridPane = new GridPane();

        XingzuoQuery girl = new XingzuoQuery();
        XingzuoQuery boy = new XingzuoQuery();
        GridPane gridPane1 = girl.initUI();
        GridPane gridPane2 = boy.initUI();

        Button pair = new Button();
        pair.setText("星座配对");

        //TODO

        //girdPane属性设置
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(30);
        gridPane.setVgap(10);

        //girdPane添加
        gridPane.add(gridPane1,0,0);
        gridPane.add(pair,1,0);
        gridPane.add(gridPane2,2,0);

        Scene scene = new Scene(gridPane, 1200, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
