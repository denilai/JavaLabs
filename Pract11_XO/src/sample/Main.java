package sample;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;

import java.util.Vector;


public class Main extends Application {

    private static int sizeOfCells = 60;

    @Override
    public void start(Stage primaryStage) throws Exception{

        GridPane grid = new GridPane();

        VBox vbox =  new VBox(10);

        Button btnNew = new Button("Новая игра");
        btnNew.setPrefSize(200,30);

        Vector<Button>buttons = new Vector<>();

        for (int i = 0; i < 9; i++)
            buttons.add(new Button());
        // Масштабирование таблицы кнопок
        ColumnConstraints col1 = new ColumnConstraints(
                sizeOfCells,
                sizeOfCells,
                sizeOfCells,
                Priority.NEVER,
                HPos.CENTER,
                true
        );
        //col1.setPercentWidth(100/3);
        grid.getColumnConstraints().add(col1);

        ColumnConstraints col2 = new ColumnConstraints(
                sizeOfCells,
                sizeOfCells,
                sizeOfCells,
                Priority.NEVER,
                HPos.CENTER,
                true
        );
        //col2.setPercentWidth(100/3);
        grid.getColumnConstraints().add(col2);

        ColumnConstraints col3 = new ColumnConstraints(
                sizeOfCells,
                sizeOfCells,
                sizeOfCells,
                Priority.NEVER,
                HPos.CENTER,
                true
        );
        //col3.setPercentWidth(100/3);
        grid.getColumnConstraints().add(col3);

        RowConstraints row1 = new RowConstraints(
                sizeOfCells,
                sizeOfCells,
                sizeOfCells,
                Priority.NEVER,
                VPos.CENTER,
                true
        );
        //row1.setPercentHeight(100/3);
        grid.getRowConstraints().add(row1);

        RowConstraints row2 = new RowConstraints(
                sizeOfCells,
                sizeOfCells,
                sizeOfCells,
                Priority.NEVER,
                VPos.CENTER,
                true
        );
        //row2.setPercentHeight(100/3);
        grid.getRowConstraints().add(row2);

        RowConstraints row3 = new RowConstraints(
                sizeOfCells,
                sizeOfCells,
                sizeOfCells,
                Priority.NEVER,
                VPos.CENTER,
                true
        );
        //row3.setPercentHeight(100/3);
        grid.getRowConstraints().add(row3);

        grid.setGridLinesVisible(true);

        // установка характеристик всех кнопок
        int[] i = new int[1];
        i[0]=0;
        buttons.forEach(button->{
            button.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
            GridPane.setHgrow(button,Priority.ALWAYS);
            GridPane.setVgrow(button,Priority.ALWAYS);
            grid.add(button,i[0]%3,i[0]/3);
            i[0]++;
        });


        vbox.setAlignment(Pos.CENTER);

        //BorderPane.setAlignment(grid,Pos.CENTER);
        vbox.setMargin(grid,new Insets(20,20,10,20));

        //BorderPane.setAlignment(btnNew, Pos.TOP_CENTER);
        vbox.setMargin(btnNew,new Insets(10,20,20,20));

        vbox.getChildren().addAll(grid,btnNew);


        //vbox.getChildren().addAll(grid,btnNew);
        //vbox.setAlignment()

        primaryStage.setTitle("X and O");
        primaryStage.setScene(new Scene(vbox, 40+3*sizeOfCells,100+3*sizeOfCells));

        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("xo.png")));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
