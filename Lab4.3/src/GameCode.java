

import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class GameCode extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    
    private int score = 0;
    private boolean scoring = true;
    private long timeStep;

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Button Clicker");
        Button btn = new Button();
        btn.setText("Clicker");
        Text txt = new Text(10, 0, "Click Score:");
        Button showScore = new Button();
        showScore.setText("Show Score");
        Button start = new Button();
        start.setText("Start");
        showScore.setOnAction(new EventHandler<ActionEvent>() 
        {
        	public void handle(ActionEvent event)
        	{
        		BackEnd.getHighScores();
        	}
        });
        
        start.setOnAction(new EventHandler<ActionEvent>() 
        {
        	public void handle(ActionEvent event)
        	{
        		scoring=true;
        		
        	}
        });
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	if(scoring)
            	{
            		score++;
            		BackEnd.writer(score);
            	}
            }
        });
        
        timeStep = System.nanoTime() + 10000000000L;
        
        new AnimationTimer()
        {
        	public void handle(long now)
        	{
        		if (now > timeStep)
        		{
        			timeStep = now + 10000000000L;
        			scoring = !scoring;
        		}
        		if (!scoring)
        		{
        			btn.setText("Times Up!!!");
        			
        			score = 0;
        		}
        		else
        		{
        			btn.setText("Click!");
        		}
        		txt.setText("Score: " + Integer.toString(score));
        	}
        }.start();
        
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(txt);
        root.getChildren().add(showScore);
        root.getChildren().add(start);
        StackPane.setAlignment(start,Pos.CENTER_LEFT);
        StackPane.setAlignment(showScore, Pos.TOP_LEFT);
        StackPane.setAlignment(txt,Pos.TOP_RIGHT);
        primaryStage.setScene(new Scene(root, 1080, 720));
        primaryStage.show();
    
    }
}