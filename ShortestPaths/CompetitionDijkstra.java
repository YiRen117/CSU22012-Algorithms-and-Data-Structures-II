import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants
 * at three random city intersections. In order to win, the three contestants
 * need all to meet at any intersection of the city as fast as possible. It
 * should be clear that the contestants may arrive at the intersections at
 * different times, in which case, the first to arrive can wait until the others
 * arrive. From an estimated walking speed for each one of the three
 * contestants, ACM wants to determine the minimum time that a live TV broadcast
 * should last to cover their journey regardless of the contestants’ initial
 * positions and the intersection they finally meet. You are hired to help ACM
 * answer this question. You may assume the following:  Each contestant walks
 * at a given estimated speed.  The city is a collection of intersections in
 * which some pairs are connected by one-way streets that the contestants can
 * use to traverse the city.
 *
 * @author Yi Ren
 *
 *         This class implements the competition using Dijkstra's algorithm
 **/

public class CompetitionDijkstra {

	public String fileName;
	public int speedA;
	public int speedB;
	public int speedC;
	public double[][] distTo;
	public int[][] edgeTo;
	public int edgeCount;

	/**
	 * @param filename: A filename containing the details of the city road network
	 * @param sA,       sB, sC: speeds for 3 contestants
	 */
	CompetitionDijkstra(String filename, int sA, int sB, int sC) {

		this.speedA = sA;
		this.speedB = sB;
		this.speedC = sC;
		
		try{
			if(filename == null) {
				return;
			}
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean endOfFile = false;
            int index = 0;
            while(!endOfFile){
                String data = bufferedReader.readLine();
                if (data != null){
                	if (index == 0) {
                		edgeTo = new int[Integer.parseInt(data)][Integer.parseInt(data)];
                		distTo = new double[Integer.parseInt(data)][Integer.parseInt(data)];
                		for (int i = 0; i < distTo.length; i++) {
    						for (int j = 0; j < distTo[i].length; j++) {
    							if (i == j) {
    								distTo[i][j] = 0;
    							}
    							else {
    								distTo[i][j] = Integer.MAX_VALUE;
    							}
    						}
    					}
                	}
                	else if (index == 1) {
                		edgeCount = Integer.parseInt(data);
                	}
                	else {
                		String[] dataArray = data.trim().split("\\s+");
                		edgeTo[Integer.parseInt(dataArray[0])][Integer.parseInt(dataArray[1])] = Integer.parseInt(dataArray[0]);
                		distTo[Integer.parseInt(dataArray[0])][Integer.parseInt(dataArray[1])] = Double.parseDouble(dataArray[2]);
                	}
                	index++;
                }
                else{
                    endOfFile = true;
                }
            }
            bufferedReader.close();
            fileReader.close();
        }
        catch (FileNotFoundException e){
        	e.printStackTrace();
        }
        catch (IOException e){
        	e.printStackTrace();
        }
	}
	
	private void dijkstraAlgorithm(int start) {
		boolean shortest[] = new boolean[edgeTo.length];
		shortest[start] = true;
		boolean exit = false;
		while(!exit) {
			int vertex = -1;
			for(int i = 0; i < distTo.length; i++) {
				if((shortest[i] == false) && (distTo[start][i] != Integer.MAX_VALUE)){
					vertex = i;
					shortest[vertex] = true;
					for (int j = 0; j < distTo.length; j++) {
						if (distTo[start][vertex] + distTo[vertex][j] < distTo[start][j]) {
							distTo[start][j] = distTo[start][vertex] + distTo[vertex][j];
							shortest[j] = false;
							edgeTo[start][j] = start;
						}
					}
				}
			}
			if(vertex == -1) {
				exit = true;
			}
		}
		return;
	}

	/**
	 * @return int: minimum minutes that will pass before the three contestants can
	 *         meet
	 */
	public int timeRequiredforCompetition() {

		if ((speedA < 50 || speedA > 100) || (speedB < 50 || speedB > 100) || (speedC < 50 || speedC > 100)) {
			return -1;
		}
		else {
			int minSpeed = Math.min(speedC, Math.min(speedA, speedB));
			double maxDistance = 0.0;
			for(int i = 0; i < distTo.length; i++) {
				dijkstraAlgorithm(i);
			}

			for (int i = 0; i < distTo.length; i++) {
				for (int j = 0; j < distTo[i].length; j++) {
					if (distTo[i][j] == Integer.MAX_VALUE) {
						return -1;
					}
					else if(distTo[i][j] > maxDistance) {
						maxDistance = distTo[i][j];
					}
				}
			}
			if (maxDistance == 0) {
				return -1;
			}
			else {
				int maxTime = (int)Math.ceil((maxDistance * 1000) / minSpeed);
				return maxTime;
			}
		}
	}

}