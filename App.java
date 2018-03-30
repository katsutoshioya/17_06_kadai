import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.Random;


public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String[] numbers_array = {"1","2"/*,"3","4","5","6","7","8","9"*/};
        //String hoge = "1";
        //String[] hoge_array = {new String("1"), new String("2")}

        // Labelの作成
        Label label01 = new Label("1");
        Label label02 = new Label("1");
        Label label03 = new Label("1");

        Random rand = new Random();
        Timeline timer01 = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            // 0~配列の大きさの乱数を生成
            int randomNumbers = rand.nextInt(numbers_array.length);
            // numbers_arrayから乱数を元に配列の値を取得 numbers_array[0] -> 0番目の要素を取得
            label01.setText(numbers_array[randomNumbers]);
        }));
        Timeline timer02 = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            // 0~配列の大きさの乱数を生成
            int randomNumbers = rand.nextInt(numbers_array.length);
            // numbers_arrayから乱数を元に配列の値を取得 numbers_array[0] -> 0番目の要素を取得
            label02.setText(numbers_array[randomNumbers]);
        }));
        Timeline timer03 = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            // 0~配列の大きさの乱数を生成
            int randomNumbers = rand.nextInt(numbers_array.length);
            // numbers_arrayから乱数を元に配列の値を取得 numbers_array[0] -> 0番目の要素を取得
            label03.setText(numbers_array[randomNumbers]);
        }));


        Button start_button = new Button("Start");
        start_button.setPrefSize(100,50);
        start_button.setOnAction(event -> {
            timer01.setCycleCount(Timeline.INDEFINITE );
            timer01.play();
            timer02.setCycleCount(Timeline.INDEFINITE );
            timer02.play();
            timer03.setCycleCount(Timeline.INDEFINITE );
            timer03.play();

        });

        Button stop_button = new Button("Stop");
        stop_button.setPrefSize(100,50);
        stop_button.setOnAction(event ->{
            timer01.stop();
            timer02.stop();
            timer03.stop();
            if (label01==label02 && label01==label03) {
                Stage newStage = new Stage();
                newStage.initModality(Modality.APPLICATION_MODAL);
                newStage.initOwner(stage);

                HBox hBox = new HBox();
                Label label = new Label("おめでとう！");
                hBox.getChildren().add(label);

                newStage.setScene(new Scene(hBox));
                newStage.show();
            }
        });

        HBox hBox01 = new HBox(20d);
        hBox01.setAlignment(Pos.CENTER);
        //hBox01.setBorder();
        hBox01.getChildren().add(label01);
        hBox01.getChildren().add(label02);
        hBox01.getChildren().add(label03);

        HBox hBox02 = new HBox(20d);
        hBox02.setAlignment(Pos.CENTER);
        hBox02.getChildren().add(start_button);
        hBox02.getChildren().add(stop_button);

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(30,10,10,10));
        borderPane.setTop(hBox01);
        borderPane.setCenter(hBox02);

        Scene scene = new Scene(borderPane,400,400);
        stage.setScene(scene);
        stage.show();

    }
}

