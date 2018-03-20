package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("占星游戏");
        BorderPane borderPane = new BorderPane();

        XingzuoQuery girl = new XingzuoQuery();
        XingzuoQuery boy = new XingzuoQuery();
        GridPane gridPane1 = girl.initUI("女生");
        GridPane gridPane2 = boy.initUI("男生");
        Label title = new Label("占星游戏");
        title.setTextFill(Color.NAVY);
        title.setFont(Font.font("Tahoma", 80));
        Label pairDesc = new Label();
        pairDesc.setWrapText(true);
        pairDesc.setFont(Font.font("Tahoma"));

        VBox vBox = new VBox();
        Label score = new Label();
        score.setFont(Font.font(16));
        score.setTextFill(Color.web("#0076a3"));
        Button pair = new Button();
        pair.setText("星座配对");
        vBox.getChildren().addAll(pair, score, pairDesc);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(5);
        vBox.setMaxSize(200,500);

        XingzuoPair xingzuoPair = new XingzuoPair();

        pair.setOnAction(event -> {
            int a = girl.getNumber() - 1;
            int b = boy.getNumber() - 1;
            int c = xingzuoPair.getPairCheck(a, b);
            score.setText(girl.getName(a) + "女 | " + String.valueOf(c) +  " | " + boy.getName(b) + "男");
            pairDesc.setText(new XingzuoPair().getPairDesc(a, b));
        });

        borderPane.setTop(title);
        borderPane.setAlignment(title, Pos.CENTER);
        borderPane.setLeft(gridPane1);
        borderPane.setAlignment(gridPane1, Pos.CENTER);
        borderPane.setRight(gridPane2);
        borderPane.setAlignment(gridPane2, Pos.CENTER);
        borderPane.setCenter(vBox);
        borderPane.setAlignment(vBox, Pos.CENTER);

        Scene scene = new Scene(borderPane, 1200, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
