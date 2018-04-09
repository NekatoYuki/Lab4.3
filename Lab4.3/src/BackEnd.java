
import java.io.BufferedReader; 
import java.io.IOException; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.ArrayList; 
import java.util.List; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;


public class BackEnd {
	String fileName = "HighScores.txt";
	public static void getHighScores() 
	{
		List<HighScore> highScore = readHighScoresFromCSV("HighScores.txt");
		for (HighScore x : highScore)
		{
			System.out.println(x);
		}

	}
	
	private static List<HighScore> readHighScoresFromCSV(String fileName)
	{
		List<HighScore> list1 = new ArrayList<>();
		Path pathToFile = Paths.get(fileName);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII))
		{
			String line = br.readLine();
		
		while (line !=null)
		{
			String[] attributes = line.split(",");
			
			int score = Integer.parseInt(attributes[0]);
		
			HighScore yourScore = new HighScore (score);
			list1.add(yourScore);
			line = br.readLine();
		
		}
	}
		catch (IOException ioe) 
		{
            ioe.printStackTrace();
        }
		return list1;
	}
	
	public void writer(int score) 
	{
		PrintWriter writer = null;
		int counter = 0;
		
		try 
		{
			writer = new PrintWriter(fileName);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		writer.println(score);
		writer.close();
	}
	public static class HighScore
	{
		private static int yourScore;

		public HighScore(int yourScore)
		{
			this.yourScore = yourScore;
		}
		public static int getYourScore() 
		{
			return yourScore;
		}

		public static void setYourScore(int yourScore) {
			HighScore.yourScore = yourScore;
		}
		
		public String toString() {
			return "HighScore [ " + HighScore.getYourScore() + " ]";
		}
		
	}
}