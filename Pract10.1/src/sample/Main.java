package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.util.Vector;

public class Main extends Application{




    private static int sizeOfCells =30;

    public static void main(String[] args) {

        double a,b,c;

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {


        Label firstLabel = new Label("Первый аргумент");
        Label secondLabel = new Label("Второй аргумент");
        Label resultLabel = new Label("Результат");

        TextField firstValue = new TextField();
        firstValue.setPrefSize(150,30);
        firstValue.setMinSize(100,20);




        TextField secondValue = new TextField();
        secondValue.setPrefSize(150,30);
        firstValue.setMinSize(100,20);

        TextField resultValue = new TextField();
        resultValue.setPrefSize(150,30);
        resultValue.setMinSize(100,20);
        resultValue.setEditable(false);

        Button plus = new Button("+");
        Button minus = new Button("-");
        Button product = new Button("*");
        Button divide = new Button("/");

        Vector<Button> buttons = new Vector<>();
        buttons.add(plus);
        buttons.add(minus);
        buttons.add(product);
        buttons.add(divide);

        buttons.forEach(but->{
            but.setPrefSize(sizeOfCells,sizeOfCells);
            but.setMinSize(30,30);
        });

//        Button one = new Button();
//        Button two = new Button();
//        Button tree = new Button();
//        Button four = new Button();
//        Button five = new Button();
//        Button six = new Button();
//        Button seven = new Button();
//        Button eight = new Button();
//        Button nine = new Button();
//        Button zero = new Button();
//        Button doubleZero = new Button();
//        Button dot = new Button();
//        Button plus = new Button();
//        Button minus = new Button();
//        Button product = new Button();
//        Button divide = new Button();
//
//
//        Vector<Button> buttons = new Vector<>();
//        buttons.add(seven);
//        buttons.add(eight);
//        buttons.add(nine);
//        buttons.add(four);
//        buttons.add(five);
//        buttons.add(six);
//        buttons.add(one);
//        buttons.add(two);
//        buttons.add(tree);
//        buttons.add(zero);
//        buttons.add(doubleZero);
//        buttons.add(dot);
//
//        Vector<String>vec = new Vector<>();
//
//        vec.add("7");
//        vec.add("8");
//        vec.add("9");
//        vec.add("4");
//        vec.add("5");
//        vec.add("6");
//        vec.add("1");
//        vec.add("2");
//        vec.add("3");
//        vec.add("0");
//        vec.add("00");
//        vec.add(".");
//
//        for(int i=0;i<12;i++){
//            buttons.get(i).setText(vec.get(i));
//            buttons.get(i).setPrefSize(50,50);
//        }

//        GridPane panel = new GridPane();
//
//        ColumnConstraints column1 = new ColumnConstraints(sizeOfCells);
//        column1.setHgrow(Priority.NEVER);
//        panel.getColumnConstraints().add(column1);
//
//        panel.getRowConstraints().add( new RowConstraints(sizeOfCells));
//        panel.getRowConstraints().add( new RowConstraints(sizeOfCells));
//        panel.getRowConstraints().add( new RowConstraints(sizeOfCells));
//        panel.getRowConstraints().add( new RowConstraints(sizeOfCells));
//
//
//        ColumnConstraints column2 = new ColumnConstraints(sizeOfCells);
//        column2.setHgrow(Priority.NEVER);
//        panel.getColumnConstraints().add(column2);
//
//        ColumnConstraints column3 = new ColumnConstraints(sizeOfCells);
//        column3.setHgrow(Priority.NEVER);
//        panel.getColumnConstraints().add(column3);
//
//        int k=0;
//        for(int i=0;i<4;i++)
//            for(int j=0;j<3;j++,k++)
//                panel.add(buttons.get(k),j,i);
        VBox first = new VBox(5);
        first.getChildren().addAll(firstLabel,firstValue);

        VBox second = new VBox(5);
        second.getChildren().addAll(secondLabel,secondValue);

        VBox result = new VBox(5);
        second.getChildren().addAll(resultLabel,resultValue);

        VBox vbox = new VBox(20);
        HBox operations = new HBox(15);

        operations.getChildren().addAll(buttons);
        operations.setAlignment(Pos.BASELINE_CENTER);

        buttons.forEach(but-> {
            operations.setHgrow(but,Priority.NEVER);
        });

        vbox.getChildren().addAll(first,operations,second,result);

        vbox.setMargin(first,new Insets(10,5,5,10));
        vbox.setMargin(operations,new Insets(10,5,5,10));
        vbox.setMargin(second,new Insets(10,5,5,10));
        vbox.setMargin(result,new Insets(10,5,5,10));


        Scene scene = new Scene(vbox, 250, 300);
        stage.setScene(scene);
        stage.setResizable(false);

        stage.setTitle("Calculator");
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("calc.png")));

        stage.show();

        plus.setOnAction(e-> {
            if (!(validInput(firstValue.getText()) && validInput(secondValue.getText())))
                resultValue.setText("Неверный ввод");
            else {
                resultValue.setText(String.valueOf(
                        Double.parseDouble(firstValue.getText())+
                                Double.parseDouble(secondValue.getText())));
            }
        });


        minus.setOnAction(e-> {
            if (!(validInput(firstValue.getText()) && validInput(secondValue.getText())))
                resultValue.setText("Неверный ввод");
            else {
                resultValue.setText(String.valueOf(
                        Double.parseDouble(firstValue.getText())-
                                Double.parseDouble(secondValue.getText())));
            }
        });

        divide.setOnAction(e-> {
            if (!(validInput(firstValue.getText()) && validInput(secondValue.getText())))
                resultValue.setText("Неверный ввод");
            else {
                resultValue.setText(String.valueOf(
                        Double.parseDouble(firstValue.getText())/
                                Double.parseDouble(secondValue.getText())));
            }
        });

        product.setOnAction(e-> {
            if (!(validInput(firstValue.getText()) && validInput(secondValue.getText())))
                resultValue.setText("Неверный ввод");
            else {
                resultValue.setText(String.valueOf(
                        Double.parseDouble(firstValue.getText())*
                                Double.parseDouble(secondValue.getText())));
            }
        });



    }

    boolean validInput(String a){
        for(int i=0;i!=a.length();i++){
            if (!isNum(a.toCharArray()[i]))
                return  false;
        }
        return true;

    }
    boolean isNum(char ch){
        return (ch>='0'&&ch<='9');
    }
}




