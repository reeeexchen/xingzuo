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
	int number = 0;

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		stage.setTitle("星座查询器");
		initUI("");
		stage.show();
	}

	public GridPane initUI(String gender) {
		//DatePicker
		VBox vBox = new VBox(5);
		vBox.setStyle("-fx-padding: 10;");
		checkInDatePicker = new DatePicker();
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
		Label birthday = new Label(gender + "的生日是(选择/手动输入):");
		Button submit = new Button();
		Button pair = new Button();
		submit.setText("查询");
		pair.setText("星座配对");
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);

		vBox.getChildren().addAll(birthday,checkInDatePicker,submit);
		vBox.setAlignment(Pos.CENTER);
		vBox.setSpacing(10);
		gridPane.add(vBox,0,0);
		birthday.requestFocus();

		gridPane.add(desc,0,1);
		gridPane.add(imageView,1,1);

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
			number = Info.getNumber();
			System.out.println(number);
			desc.setText(Info.getDesc());
			desc.setWrapText(true);
			desc.setFont(new Font("Tahoma",14));
			image = new Image(Info.getUrl());
//			ImageView imageView = new ImageView();
			imageView.setFitHeight(200);
			imageView.setFitWidth(200);
			imageView.setImage(image);
		});
		gridPane.setMaxSize(400,400);
		return gridPane;
	}

	public int getNumber(){
		return number;
	}

	public String getName(int idx){
		String []astro = {"水瓶","双鱼","白羊","金牛","双子","巨蟹","狮子","处女","天秤","天蝎","射手","摩羯"};
		return astro[idx];
	}

}
