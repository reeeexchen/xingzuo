package sample;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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
	Label desc = new Label();
	ImageView imageView = new ImageView();
	Image image;

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
		//DatePicker
		VBox vBox = new VBox(20);
		vBox.setStyle("-fx-padding: 10;");
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

		//UI
		Label birthday = new Label("您的生日是(选择/手动输入):");
		Button submit = new Button();
		submit.setText("查询");
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);


		HBox hBox = new HBox();
		hBox.getChildren().addAll(birthday,checkInDatePicker,submit);
		hBox.setAlignment(Pos.CENTER);
		hBox.setSpacing(10);
		gridPane.add(hBox,0,0);
		birthday.requestFocus();

		gridPane.add(desc,0,4);
		gridPane.add(imageView,1,4);

		submit.setOnAction(event -> {
			GridPane showPane = new GridPane();
			LocalDate date = checkInDatePicker.getValue();
			String string = date.toString();
//			System.out.println(string);
			String[] strings = string.split("-");
			Integer month = Integer.valueOf(strings[1]);
			Integer day = Integer.valueOf(strings[2]);

			XingzuoInfo Info = new XingzuoInfo(month,day);
//			desc = new Label();
			desc.setText(Info.getDesc());
			desc.setWrapText(true);
			desc.setFont(new Font("Cambria",16));
			image = new Image(Info.getUrl());
//			ImageView imageView = new ImageView();
			imageView.setFitHeight(200);
			imageView.setFitWidth(200);
			imageView.setImage(image);
		});
		gridPane.setMaxSize(450,450);
		return gridPane;
	}

}
