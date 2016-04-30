package game.Prathyusha;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	public Game game = new Game();
	
	@Test
	public void testforgutterGame() throws Exception{
		rollMultiple(20,0);
		assertEquals(0,game.score());
		
	}
	
	
	@Test
	public void testforAllOnes() throws Exception{
		rollMultiple(20,1);
		assertEquals(20,game.score());
		
	}
	
	
	@Test
	public void testforSpare() throws Exception{
		rollspare();
		game.roll(4);
		rollMultiple(17,0);
		assertEquals(18,game.score());
	}
	

	@Test
	public void testforStrike() throws Exception{
		rollStrike();
		game.roll(4);
		game.roll(5);
		rollMultiple(16,0);
		assertEquals(28,game.score());
	}
	
	
	@Test
	public void testforPerfectGame() throws Exception{
		rollMultiple(12,10);
		assertEquals(300,game.score());
	}
	
	
	private void rollStrike() {
		game.roll(10);
	}
	
	
	private void rollspare() {
		game.roll(3);
		game.roll(7);
	}

	
	private void rollMultiple(int n, int pins) {
		for(int i=0;i<n;i++)
		{
			game.roll(pins);
		}
		
	}
}
