package GameCode;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameCode extends Application{
private static int score;
private static boolean scoring;

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Button Clicker");
        Button btn = new Button();
        btn.setText("Clicker");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	if(scoring)
            	{
            		int score = 1;
            		score++;
            	}
            	else
            	{
            		score--;
            	}
            }
        });
        
        timeStep = System.nanoTime() + 1000000000L;
        new AnimationTimer()
        {
        	public void handle(long now)
        	{
        		if (now > timeStep)
        		{
        			timeStep = now + 1000000000L;
        			scoring = !scoring;
        		}
        		else if (!scoring)
        		{
        			btn.setText("Do Not Click");
        		}
        		else
        		{
        			btn.setText("Click!");
        		}
        		txt.setTest("Score: " + Integer.toString(score));
        	}
        }.start();
        
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 1920, 1080));
        primaryStage.show();
    
    }
}