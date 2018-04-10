
	public class HighScore
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
			return "Score(s): " + HighScore.getYourScore();
		}
		
	}

