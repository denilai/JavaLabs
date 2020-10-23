package sample;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Priority;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;

import javax.imageio.ImageWriter;
import java.util.Vector;


public class Main extends Application {

    private static int sizeOfCells = 60;
    private static int sizeOfImage = sizeOfCells-2;

    int sizeOfCanvas=3;

    Label move = new Label();
    Label score = new Label();

    TicTacGame game;

    GridPane grid;

    VBox content;

    VBox scoreBox;

    Button btnNew;

    @Override
    public void start(Stage primaryStage) throws Exception{

        game = new TicTacGame(sizeOfCanvas,sizeOfCells,move,score);

        buildGridPane();

        btnNew = new Button("Новая игра");
        btnNew.setPrefSize(200,30);

        scoreBox = new VBox(3);
        scoreBox.getChildren().addAll(score,move);
        scoreBox.setAlignment(Pos.CENTER);

        content =  new VBox(10);

        content.setAlignment(Pos.CENTER);
        content.setMargin(grid,new Insets(0,20,10,20));
        content.setMargin(btnNew,new Insets(10,20,20,20));
        content.getChildren().addAll(scoreBox, grid,btnNew);

        primaryStage.setTitle("X and O");
        primaryStage.setScene(new Scene(content, 40+3*sizeOfCells,150+3*sizeOfCells));
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("xo.png")));
        primaryStage.show();

        primaryStage.setResizable(false);

        btnNew.setOnAction(ev->{
            game.newGame();
        });
    }


    private void buildGridPane(){

        Vector<ColumnConstraints> columns = new Vector<>();

        grid = new GridPane();

        for (int i = 0; i < sizeOfCanvas; i++) {
            grid.getColumnConstraints().add(
                    new ColumnConstraints(
                            sizeOfCells,
                            sizeOfCells,
                            sizeOfCells,
                            Priority.NEVER,
                            HPos.CENTER,
                            true)
            );
        }

        Vector<RowConstraints> rows = new Vector<>();

        for (int i = 0; i < sizeOfCanvas; i++) {
            grid.getRowConstraints().add(
                    new RowConstraints(
                            sizeOfCells,
                            sizeOfCells,
                            sizeOfCells,
                            Priority.NEVER,
                            VPos.CENTER,
                            true)
            );
        }

        int i[] = new int[1];
        i[0] = 0;
        game.getCanvas().forEach(cell->{
            grid.add(cell.image,i[0]%sizeOfCanvas,i[0]/sizeOfCanvas);
            i[0]++;
        });

        grid.setAlignment(Pos.CENTER);
        grid.setGridLinesVisible(true);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
