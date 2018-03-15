package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {

	public int [][]pairCheck = new int [][]
					{{74,77,43,97,70,80,59,92,51,85,64,88},
					{87,60,72,41,91,58,78,64,96,51,82,69},
					{69,88,71,78,46,93,61,65,74,99,54,82},
					{88,79,90,75,82,47,94,65,85,70,99,58},
					{66,81,68,88,72,75,45,97,56,78,61,93},
					{99,48,79,76,89,71,81,57,93,69,86,64},
					{74,97,52,82,78,89,61,84,66,92,70,87},
					{84,62,97,56,79,69,87,72,81,45,92,77},
					{55,84,61,91,76,88,66,89,49,81,72,95},
					{95,64,85,74,98,58,88,77,90,71,80,47},
					{57,92,60,80,68,97,65,84,73,87,47,76},
					{78,44,92,70,81,65,98,58,86,68,89,75}};

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("占星游戏");
        BorderPane borderPane = new BorderPane();

        XingzuoQuery girl = new XingzuoQuery();
        XingzuoQuery boy = new XingzuoQuery();
        GridPane gridPane1 = girl.initUI();
        GridPane gridPane2 = boy.initUI();
        Label title = new Label("占星游戏");
        title.setTextFill(Color.BLACK);
        title.setFont(Font.font(50));

		VBox vBox = new VBox();
		Label score = new Label();
		score.setFont(Font.font(30));
		score.setTextFill(Color.web("#0076a3"));
        Button pair = new Button();
		pair.setText("星座配对");
        vBox.getChildren().addAll(pair,score);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(5);

        pair.setOnAction(event -> {
            int a = girl.getNumber() - 1;
            int b = boy.getNumber() - 1;
            int c = pairCheck[a][b];
			score.setText(String.valueOf(c));
        });

//        girdPane属性设置
//        gridPane.setAlignment(Pos.CENTER);
//        gridPane.setHgap(30);
//        gridPane.setVgap(10);
//
//        girdPane添加
//		gridPane.add(title,1,0);
//        gridPane.add(gridPane1,0,1);
//        gridPane.add(vBox,1,1);
//        gridPane.add(gridPane2,2,1);


		borderPane.setTop(title);
		borderPane.setLeft(gridPane1);
		borderPane.setRight(gridPane2);
		borderPane.setCenter(vBox);

        Scene scene = new Scene(borderPane, 1200, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
