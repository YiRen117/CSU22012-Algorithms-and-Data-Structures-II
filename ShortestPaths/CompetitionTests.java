import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompetitionTests {

	@Test
	public void testDijkstraConstructor() {

		String fileName = "tinyEWD.txt";
		int sA = 50;
		int sB = 80;
		int sC = 60;
		CompetitionDijkstra map = new CompetitionDijkstra(fileName, sA, sB, sC);
		assertEquals(38, map.timeRequiredforCompetition());
	}

	@Test
	public void testFWConstructor() {
		String fileName = "tinyEWD.txt";
		int sA = 50;
		int sB = 80;
		int sC = 60;
		CompetitionFloydWarshall map = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		assertEquals(38, map.timeRequiredforCompetition());
	}

	@Test
	public void testInvalidFileName() {
		String fileName = null;
		int sA = 50;
		int sB = 80;
		int sC = 60;
		CompetitionDijkstra DijkstraMap = new CompetitionDijkstra(fileName, sA, sB, sC);
		CompetitionFloydWarshall FloydWarshallMap = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		fileName = "numbers";
		sA = 50;
		sB = 80;
		sC = 60;
		DijkstraMap = new CompetitionDijkstra(fileName, sA, sB, sC);
		FloydWarshallMap = new CompetitionFloydWarshall(fileName, sA, sB, sC);
	}

	@Test
	public void testNegativeSpeed() {
		String fileName = "tinyEWD.txt";
		int sA = 0;
		int sB = 80;
		int sC = 60;
		CompetitionDijkstra DijkstraMap = new CompetitionDijkstra(fileName, sA, sB, sC);
		assertEquals(-1, DijkstraMap.timeRequiredforCompetition());
		CompetitionFloydWarshall FloydWarshallMap = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		assertEquals(-1, FloydWarshallMap.timeRequiredforCompetition());
		sA = -5;
		sB = -8;
		sC = -6;
		DijkstraMap = new CompetitionDijkstra(fileName, sA, sB, sC);
		assertEquals(-1, DijkstraMap.timeRequiredforCompetition());
		FloydWarshallMap = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		assertEquals(-1, FloydWarshallMap.timeRequiredforCompetition());
	}

	@Test
	public void testSpeedA() {
		CompetitionDijkstra DijkstraMap;
		CompetitionFloydWarshall FloydWarshallMap;
		String fileName = "tinyEWD.txt";
		int sA = 30;	//speedA under 50
		int sB = 60;
		int sC = 80;
		DijkstraMap = new CompetitionDijkstra(fileName, sA, sB, sC);
		FloydWarshallMap = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		assertEquals(-1, DijkstraMap.timeRequiredforCompetition());
		assertEquals(-1, FloydWarshallMap.timeRequiredforCompetition());
		sA = 120;	//speedA over 100
		DijkstraMap = new CompetitionDijkstra(fileName, sA, sB, sC);
		FloydWarshallMap = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		assertEquals(-1, DijkstraMap.timeRequiredforCompetition());
		assertEquals(-1, FloydWarshallMap.timeRequiredforCompetition());
	}

	@Test
	public void testSpeedB() {
		CompetitionDijkstra DijkstraMap;
		CompetitionFloydWarshall FloydWarshallMap;
		String fileName = "tinyEWD.txt";
		int sA = 50;
		int sB = 30;	//speedA under 50
		int sC = 80;
		DijkstraMap = new CompetitionDijkstra(fileName, sA, sB, sC);
		FloydWarshallMap = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		assertEquals(-1, DijkstraMap.timeRequiredforCompetition());
		assertEquals(-1, FloydWarshallMap.timeRequiredforCompetition());
		sB = 120;	//speedA over 100
		DijkstraMap = new CompetitionDijkstra(fileName, sA, sB, sC);
		FloydWarshallMap = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		assertEquals(-1, DijkstraMap.timeRequiredforCompetition());
		assertEquals(-1, FloydWarshallMap.timeRequiredforCompetition());
	}
	
	@Test
	public void testSpeedC() {
		CompetitionDijkstra DijkstraMap;
		CompetitionFloydWarshall FloydWarshallMap;
		String fileName = "tinyEWD.txt";
		int sA = 50;
		int sB = 60;
		int sC = 30;	//speedA under 50
		DijkstraMap = new CompetitionDijkstra(fileName, sA, sB, sC);
		FloydWarshallMap = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		assertEquals(-1, DijkstraMap.timeRequiredforCompetition());
		assertEquals(-1, FloydWarshallMap.timeRequiredforCompetition());
		sC = 120;	//speedA over 100
		DijkstraMap = new CompetitionDijkstra(fileName, sA, sB, sC);
		FloydWarshallMap = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		assertEquals(-1, DijkstraMap.timeRequiredforCompetition());
		assertEquals(-1, FloydWarshallMap.timeRequiredforCompetition());
	}

	@Test
	public void testInputA() {
		String fileName = "input-A.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		CompetitionDijkstra DijkstraMap = new CompetitionDijkstra(fileName, sA, sB, sC);
		CompetitionFloydWarshall FloydWarshallMap = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		int timeD = DijkstraMap.timeRequiredforCompetition();
		int timeDW = FloydWarshallMap.timeRequiredforCompetition();
	}
	
	@Test
	public void testInputB() {
		String fileName = "input-B.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		CompetitionDijkstra DijkstraMap = new CompetitionDijkstra(fileName, sA, sB, sC);
		CompetitionFloydWarshall FloydWarshallMap = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		int timeD = DijkstraMap.timeRequiredforCompetition();
		int timeDW = FloydWarshallMap.timeRequiredforCompetition();
	}

	@Test
	public void testInputC() {
		String fileName = "input-C.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		CompetitionDijkstra DijkstraMap = new CompetitionDijkstra(fileName, sA, sB, sC);
		CompetitionFloydWarshall FloydWarshallMap = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		int timeD = DijkstraMap.timeRequiredforCompetition();
		int timeDW = FloydWarshallMap.timeRequiredforCompetition();
	}

	@Test
	public void testInputD() {
		String fileName = "input-D.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		CompetitionDijkstra DijkstraMap = new CompetitionDijkstra(fileName, sA, sB, sC);
		CompetitionFloydWarshall FloydWarshallMap = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		int timeD = DijkstraMap.timeRequiredforCompetition();
		int timeDW = FloydWarshallMap.timeRequiredforCompetition();
	}

	@Test
	public void testInputF() {
		String fileName = "input-F.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		CompetitionDijkstra DijkstraMap = new CompetitionDijkstra(fileName, sA, sB, sC);
		CompetitionFloydWarshall FloydWarshallMap = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		int timeD = DijkstraMap.timeRequiredforCompetition();
		int timeDW = FloydWarshallMap.timeRequiredforCompetition();
	}

	@Test
	public void testInputG() {
		String fileName = "input-G.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		CompetitionDijkstra DijkstraMap = new CompetitionDijkstra(fileName, sA, sB, sC);
		CompetitionFloydWarshall FloydWarshallMap = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		int timeD = DijkstraMap.timeRequiredforCompetition();
		int timeDW = FloydWarshallMap.timeRequiredforCompetition();
	}

	@Test
	public void testInputI() {
		String fileName = "input-I.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		CompetitionDijkstra DijkstraMap = new CompetitionDijkstra(fileName, sA, sB, sC);
		CompetitionFloydWarshall FloydWarshallMap = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		int timeD = DijkstraMap.timeRequiredforCompetition();
		int timeDW = FloydWarshallMap.timeRequiredforCompetition();
	}

	@Test
	public void testInputJ() {
		String fileName = "input-J.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		CompetitionDijkstra DijkstraMap = new CompetitionDijkstra(fileName, sA, sB, sC);
		CompetitionFloydWarshall FloydWarshallMap = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		int timeD = DijkstraMap.timeRequiredforCompetition();
		int timeDW = FloydWarshallMap.timeRequiredforCompetition();
	}

	@Test
	public void testInputK() {
		String fileName = "input-K.txt";
		int sA = 51;
		int sB = 70;
		int sC = 88;
		CompetitionDijkstra DijkstraMap = new CompetitionDijkstra(fileName, sA, sB, sC);
		CompetitionFloydWarshall FloydWarshallMap = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		assertEquals(314, DijkstraMap.timeRequiredforCompetition());
		assertEquals(314, FloydWarshallMap.timeRequiredforCompetition());
	}

	@Test
	public void testInputL() {
		String fileName = "input-L.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		CompetitionDijkstra DijkstraMap = new CompetitionDijkstra(fileName, sA, sB, sC);
		CompetitionFloydWarshall FloydWarshallMap = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		int timeD = DijkstraMap.timeRequiredforCompetition();
		int timeDW = FloydWarshallMap.timeRequiredforCompetition();
	}

	@Test
	public void testInputM() {
		String fileName = "input-M.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		CompetitionDijkstra DijkstraMap = new CompetitionDijkstra(fileName, sA, sB, sC);
		CompetitionFloydWarshall FloydWarshallMap = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		int timeD = DijkstraMap.timeRequiredforCompetition();
		int timeDW = FloydWarshallMap.timeRequiredforCompetition();
	}

	@Test
	public void testInputN() {
		String fileName = "input-N.txt";
		int sA = 50;
		int sB = 60;
		int sC = 80;
		CompetitionDijkstra DijkstraMap = new CompetitionDijkstra(fileName, sA, sB, sC);
		CompetitionFloydWarshall FloydWarshallMap = new CompetitionFloydWarshall(fileName, sA, sB, sC);
		int timeD = DijkstraMap.timeRequiredforCompetition();
		int timeDW = FloydWarshallMap.timeRequiredforCompetition();
	}
}
