package game.Prathyusha;

public class Game {

	private int[] rolls = new int[21];
	private int currentRoll;
	
	public void roll(int pins){
		rolls[currentRoll++] = pins;
	}
	
	
	public int score(){
		int score = 0;
		int index = 0;
		
		for(int frame =0; frame < 10;frame ++)
		{
			if(isStrike(index))
			{
				score += 10 + strikeBonus(index);
				index++;
			}
			
			else if(isSpare(index))
			{
				score += 10 + spareBonus(index);
				index += 2;
			}
			
			else {
				score += sumOfAllBalls(index);
				index +=2;
			}
			
			}
		
		return score;
		
	}
	
	

	private int sumOfAllBalls(int index) {
		return rolls[index] + rolls[index +1];
	}

	private int spareBonus(int index) {
		
		return rolls[index + 2];
	}

	private boolean isSpare(int index) {
		
		return rolls[index] + rolls[index +1]==10;
	}

	private int strikeBonus(int index) {
		
		return rolls[index +1 ] + rolls[index +2];
	}

	private boolean isStrike(int index) {
		
		return rolls[index]==10;
	}
	
}

