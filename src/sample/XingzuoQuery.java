package sample;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;


/**
 * @Author:REX
 * @Date: Create in 21:50 2018/3/12
 */
public class XingzuoQuery extends Application {

	private Stage stage;
	private DatePicker checkInDatePicker;
	private final String dtf = "yyyy-MM-dd";

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		stage.setTitle("星座查询器");
		initUI();
		stage.show();
	}

	public GridPane initUI() {
		VBox vBox = new VBox(20);
		vBox.setStyle("-fx-padding: 10;");
		Scene scene = new Scene(vBox, 700, 600);
//		stage.setScene(scene);
		checkInDatePicker = new DatePicker(LocalDate.of(1990,01,01));
		checkInDatePicker.setShowWeekNumbers(false);
		StringConverter converter = new StringConverter<LocalDate>() {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dtf);
			@Override
			public String toString(LocalDate date) {
				if (date != null) {
					return dateFormatter.format(date);
				} else {
					return "";
				}
			}
			@Override
			public LocalDate fromString(String string) {
				if (string != null && !string.isEmpty()) {
					return LocalDate.parse(string, dateFormatter);
				} else {
					return null;
				}
			}
		};
		checkInDatePicker.setConverter(converter);
		checkInDatePicker.setPromptText(dtf.toLowerCase());
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		Label birthday = new Label("您的生日是(选择/手动输入):");
		Button submit = new Button();
		submit.setText("查询");

		HBox hBox = new HBox();
		hBox.getChildren().addAll(birthday,checkInDatePicker,submit);
		hBox.setAlignment(Pos.CENTER);
		hBox.setSpacing(10);
		gridPane.add(hBox,0,0);
//		gridPane.add(birthday,0,0);
//		gridPane.setHalignment(birthday, HPos.CENTER);
//		gridPane.add(checkInDatePicker,0,1);
//		gridPane.add(submit,1,1);

		vBox.getChildren().addAll(gridPane);
		birthday.requestFocus();

		submit.setOnAction(event -> {
			LocalDate date = checkInDatePicker.getValue();
			String string = date.toString();
//			System.out.println(string);
			String[] strings = string.split("-");
			Integer month = Integer.valueOf(strings[1]);
			Integer day = Integer.valueOf(strings[2]);
			GridPane showPane = showQuery(month,day);
			showPane.setMaxWidth(500);
			gridPane.add(showPane,0,4);
		});
		gridPane.setMaxSize(400,400);
		return gridPane;
	}

	public GridPane showQuery(Integer month,Integer day){
		GridPane gridPane = new GridPane();
		XingzuoInfo Info = new XingzuoInfo(month,day);

		Label desc = new Label();
		desc.setText(Info.getDesc());
		desc.setWrapText(true);
		Image image = new Image(Info.getUrl());
		ImageView imageView = new ImageView();
		imageView.setFitHeight(200);
		imageView.setFitWidth(200);
		imageView.setImage(image);
		//Image imageDecline = new Image(getClass().getResourceAsStream("not.png"));
		gridPane.add(desc,0,0);
		gridPane.add(imageView,1,0);
		return gridPane;
	}
}
