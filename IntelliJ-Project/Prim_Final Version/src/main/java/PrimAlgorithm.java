/**
 * Created by Mr Minh on 11/12/2016.
 * Fixed and merged with GUI by nhatl.
 */
public class PrimAlgorithm extends Graph {
    //List of visited vertices
    protected int[] listx = new int[1000], listy = new int[1000];
    protected boolean[] visited = new boolean[1000];

    //Find the min weight of all possible edges
    public int findMin(int vertex) {
        int min, min_index = 0;
        min = 2000000000;
        for (int i = 0; i < n; ++i) {
            //If the weight !=0, has not been visited and < min
            if (g[vertex][i] < min && g[vertex][i] != 0 && visited[i] == false) {
                min = g[vertex][i];
                min_index = i;
            }
        }
        //Return index of the min
        return min_index;
    }

    public String getoutput() {
        String tmp = "Edges: \n";
        for (int i = 0; i < n; i++) {
            if (listy[i] != listx[i])
            tmp += (String) ((listx[i]+1) + ", " + (listy[i]+1) + "\n");
        }
        return tmp;
    }

    @Override
    public void Prim() {
        int min, min_index = 0, temp, back_index = 0;
        //Initialize the check listy and listy of vertices
        for (int i = 0; i < n; i++) {
            visited[i] = false;
            listx[i] = 0 ;
            listy[i] = 0;
        }
        //Start at the first vertex so this vertices 'visited' value is true and take that vertex into listy
        visited[0] = true;
        listy[0] = 0;
        for (int i = 0; i < n; i++) {

            int j = 0;
            min = 2000000000;
            // j to access the 'listy' from 0 to the last element of 'listy' which is 0
            // The 1st element in 'listy' is 0 when j==0, others are different from 0
            while ((listy[j] == 0 && j == 0) || listy[j] != 0) {
                //Find the index of the min weight of edges of vertex listy[j]
                temp = findMin(listy[j]);
                if (temp != 0) {
                    //Find the min weight in all the possible edges of the graph
                    if (g[listy[j]][temp] < min) {
                        min = g[listy[j]][temp];
                        min_index = temp;
                        back_index = listy[j];
                    }
                }
                ++j;
            }

            if (min_index != 0) {
                //Take the index of the min to 'listy'
                listy[i + 1] = min_index;
                listx[i + 1] = back_index;
                //Declare that vertex has been visited
                visited[min_index] = true;
            }
            else break;

        }
    }

}