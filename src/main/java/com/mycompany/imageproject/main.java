package com.mycompany.imageproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class main extends Application {
    //Variable declaration of Imageview, count, text and vbox
    ImageView imgview;VBox vbox;
    int count=0;
    Text t;
    //start method of the program
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
       
        BorderPane root = new BorderPane();
        Button one,two;
        t=new Text("Count = "+count);
        HBox hBox = new HBox();

        Image img1 = new Image(new FileInputStream("demo1.png"));
        Image img2 = new Image(new FileInputStream("demo2.png"));
       
        one=new Button("Image 1");
        two=new Button("Image 2 ");
        
        imgview = new ImageView(img1);
       
        hBox.setSpacing(10);
        
        hBox.setAlignment(Pos.CENTER);
       
        vbox = new VBox(imgview);
       
        one.setOnMouseClicked((MouseEvent mouseEvent) -> {
            
            imgview.setImage(img1);
            
            count++;
            
            t.setText("Count = "+count);
        });
        
        two.setOnMouseClicked((MouseEvent mouseEvent) -> {
           
            imgview.setImage(img2);
            
            count++;
            
            t.setText("Count = "+count);
        });
        
        
        imgview.setViewport(new Rectangle2D(0, 0, 125,200));
       
        hBox.getChildren().addAll(one,two,t);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);
        root.setCenter(vbox);
        root.setBottom(hBox);
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Image Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //Main method
    public static void main(String[] args) {
        launch(args);
    }   
}