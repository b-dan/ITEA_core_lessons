package application;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main extends Application {

    // size of frame
    private static final double WIDTH = 1920;
    private static final double HEIGHT = 1080;

    // root
    private static Pane root = new Pane();
    private static Parent createContent(){
        root.setPrefSize(WIDTH, HEIGHT);
        return root;
    }

    private static void background(Rectangle rectangle){
        rectangle.setFill(Color.rgb(184, 46, 138));
        rectangle.setArcHeight(30);
        rectangle.setArcWidth(30);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(3.5);
        root.getChildren().add(rectangle);
    }

    private static Semaphore sem1 = new Semaphore(8);
    private static Semaphore sem2 = new Semaphore(2);
    private static Semaphore sem3 = new Semaphore(1);

    private static double place1 = HEIGHT / 2 - 100;
    private static double place2 = HEIGHT / 2 - 35;
    private static double place3 = HEIGHT / 2 + 35;
    private static double place4 = HEIGHT / 2 + 100;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent());
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        Rectangle rectangle = new Rectangle(WIDTH / 2 - 50, HEIGHT / 2 - 150,200,300);
        background(rectangle);

        Rectangle rectangle1 = new Rectangle(50,150,380,730);
        background(rectangle1);

        Rectangle rectangle2 = new Rectangle(WIDTH / 2 + 650,HEIGHT / 2 - 150 ,100,100);
        background(rectangle2);
        
        Rectangle rectangle3 = new Rectangle(WIDTH / 2 + 650,HEIGHT / 2 + 50 ,100,100);
        background(rectangle3);
        

        Button btn = new Button("PUSH ME");
        btn.setTranslateX(50);
        btn.setTranslateY(80);
        root.getChildren().add(btn);


        boolean[] flag = {true, true, true, true, true, true, true, true};

        List<Circle> circles = new ArrayList<Circle>();
        for (int i = 100; i < 450; i += 70) {
            for (int j = 200; j < 900; j += 70) {
                Circle circle = new Circle(i,j,30);
                circles.add(circle);
            }
        }
        int index = 0;
        int a = 0;
        for (Circle c: circles) {
        	a = (int) ( Math.random() * 3 );
            //if (index % 2 == 0){
        	if(a==2){
                c.setFill(Color.rgb(0,255,0));
                c.setEffect(new DropShadow(3,Color.BLACK));
            }
            else{
                c.setFill(Color.rgb(255,0,0));
                c.setEffect(new DropShadow(3, Color.BLACK));
            }

            root.getChildren().add(c);
            index++;
        }


        btn.setOnAction(event -> {
            for (Circle circle: circles) {
                new Thread(new Task<Void>() {
                    Line line = null;
                    Line line1 = null;
                    Semaphore thisFinish = new Semaphore(0);
                    int index = 0;
                    @Override
                    protected Void call() throws Exception {
                        sem1.acquire();
                        sem3.acquire();
                        if(flag[0]){
                            line = new Line(circle.getCenterX(), circle.getCenterY(), WIDTH / 2, place1);
                            if(circle.getFill().equals(Color.rgb(0,255,0))) {
                            	line1 = new Line(WIDTH / 2, place1, WIDTH / 2 + 700, HEIGHT / 2-100);
                            }
                            else if(circle.getFill().equals(Color.rgb(255,0,0))){
                            	line1 = new Line(WIDTH / 2, place1, WIDTH / 2 + 700, HEIGHT / 2+100);
                            	
                            }
                            index = 0;
                            flag[index] = false;
                        } else if (flag[1]){
                            line = new Line(circle.getCenterX(), circle.getCenterY(), WIDTH / 2, place2);
                            if(circle.getFill().equals(Color.rgb(0,255,0))) {
                            line1 = new Line(WIDTH / 2, place2, WIDTH / 2 + 700, HEIGHT / 2-100);
                            }
                            else if(circle.getFill().equals(Color.rgb(255,0,0))){
                            	line1 = new Line(WIDTH / 2, place2, WIDTH / 2 + 700, HEIGHT / 2+100);
                            }
                            index = 1;
                            flag[index] = false;
                        } else if (flag[2]){
                            line = new Line(circle.getCenterX(), circle.getCenterY(), WIDTH / 2, place3);
                            if(circle.getFill().equals(Color.rgb(0,255,0))) {
                            line1 = new Line(WIDTH / 2, place3, WIDTH / 2 + 700, HEIGHT / 2-100);
                            }
                            else if(circle.getFill().equals(Color.rgb(255,0,0))){
                            	line1 = new Line(WIDTH / 2, place3, WIDTH / 2 + 700, HEIGHT / 2+100);
                            }
                            index = 2;
                            flag[index] = false;
                        } else if (flag[3]){
                            line = new Line(circle.getCenterX(), circle.getCenterY(), WIDTH / 2, place4);
                            if(circle.getFill().equals(Color.rgb(0,255,0))) {
                            line1 = new Line(WIDTH / 2, place4, WIDTH / 2 + 700, HEIGHT / 2-100);
                            }
                            else if(circle.getFill().equals(Color.rgb(255,0,0))){
                            	line1 = new Line(WIDTH / 2, place4, WIDTH / 2 + 700, HEIGHT / 2+100);
                            }
                            index = 3;
                            flag[index] = false;
                        } else if (flag[4]){
                            line = new Line(circle.getCenterX(), circle.getCenterY(), WIDTH / 2+100, place1);
                            if(circle.getFill().equals(Color.rgb(0,255,0))) {
                            line1 = new Line(WIDTH / 2+100, place1, WIDTH / 2 + 700, HEIGHT / 2-100);
                            }
                            else if(circle.getFill().equals(Color.rgb(255,0,0))){
                            	line1 = new Line(WIDTH / 2+100, place1, WIDTH / 2 + 700, HEIGHT / 2+100);
                            }
                            index = 4;
                            flag[index] = false;
                        } else if (flag[5]){
                            line = new Line(circle.getCenterX(), circle.getCenterY(), WIDTH / 2+100, place2);
                            if(circle.getFill().equals(Color.rgb(0,255,0))) {
                            line1 = new Line(WIDTH / 2+100, place2, WIDTH / 2 + 700, HEIGHT / 2-100);
                            }
                            else if(circle.getFill().equals(Color.rgb(255,0,0))){
                            	line1 = new Line(WIDTH / 2+100, place2, WIDTH / 2 + 700, HEIGHT / 2+100);
                            }
                            index = 5;
                            flag[index] = false;
                        } else if (flag[6]){
                            line = new Line(circle.getCenterX(), circle.getCenterY(), WIDTH / 2+100,place3);
                            if(circle.getFill().equals(Color.rgb(0,255,0))) {
                            line1 = new Line(WIDTH / 2+100, place3, WIDTH / 2 + 700, HEIGHT / 2-100);
                            }
                            else if(circle.getFill().equals(Color.rgb(255,0,0))){
                            	line1 = new Line(WIDTH / 2+100, place3, WIDTH / 2 + 700, HEIGHT / 2+100);
                            }
                            index = 6;
                            flag[index] = false;
                        } else if (flag[7]){
                            line = new Line(circle.getCenterX(), circle.getCenterY(), WIDTH / 2+100, place4);
                            if(circle.getFill().equals(Color.rgb(0,255,0))) {
                            line1 = new Line(WIDTH / 2+100, place4, WIDTH / 2 + 700, HEIGHT / 2-100);
                            }
                            else if(circle.getFill().equals(Color.rgb(255,0,0))){
                            	line1 = new Line(WIDTH / 2+100, place4, WIDTH / 2 + 700, HEIGHT / 2+100);
                            }
                            index = 7;
                            flag[index] = false;
                        }
                        
                        PathTransition pt = new PathTransition(Duration.seconds(3), line, circle);
                        PathTransition pt1 = new PathTransition(Duration.seconds(3), line1, circle);
                        sem3.release();
                        pt.setOnFinished(event1 -> thisFinish.release());
                        Platform.runLater(pt::play);
                        thisFinish.acquire();
                        sem2.acquire();
                        pt1.setOnFinished(event1 -> sem2.release());
                        Platform.runLater(pt1::play);
                        flag[index] = true;
                        sem1.release();
                        return null;
                    }
                }).start();
            }
        });

        
        primaryStage.setTitle("Semaphore emulation and sort by color");
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
