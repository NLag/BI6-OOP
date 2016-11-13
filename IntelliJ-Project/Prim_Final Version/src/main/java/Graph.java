/**
 * Created by Mr Minh on 11/11/2016.
 * Fixed and merged with GUI by nhatl
 */
import java.util.Random;
import java.util.Scanner;

public abstract class Graph {
    protected int n; //number of vertices
    protected int[][] g; //graph

    //get new graph from keyboard
    public void getGraph(){
        Scanner sc=new Scanner(System.in);
        //Enter number of vertices
        System.out.println("Enter number of the vertices in graph: ");
        n=sc.nextInt();
        //create 2 array for the graph
        g=new int[n][n];
        //Enter weight of each edge
        //System.out.println("Enter the weight of each edge in the graph: ");
        Random rand = new Random();
        for(int i=0; i<n; ++i) {
            for (int j = i; j < n; ++j) {
                if (i == j) {
                    //Create no self loop
                    g[i][j] = 0;
                } else {
                    //Create weight for edge of (i, j) and (j. i) (the same)
                    //System.out.println("Weight for ("+(i+1)+", "+(j+1)+"): ");
                    g[i][j] = rand.nextInt(50) + 1;
                    g[j][i] = g[i][j];
                }
            }
        }
    }

    //get new graph from data input from GUI
    public void getGraph(String strInput){
        Scanner sc=new Scanner(strInput);
        //Get number of vertices
        n=sc.nextInt();
        //create 2 array for the graph
        g=new int[1000][1000];
        //Enter weight of each edge
        for(int i=0; i<n; ++i) {
            for (int j = 0; j < n; ++j) {
                g[i][j] = sc.nextInt();
            }
        }
    }

    public void printGraph(){
        //Print the listy of vertices by row
        System.out.print("\t\t\t");
        for(int i=0; i<n; ++i)
        {
            System.out.print(i+"\t\t\t");
        }
        System.out.print("\n");
        //Print vertices and weight by row
        for(int i=0; i<n; ++i)
        {
            System.out.print(i+"\t\t\t");
            for(int j=0; j<n;++j)
            {
                System.out.print(g[i][j]+"\t\t\t");
            }
            System.out.print("\n");
        }
    }

    public abstract String getoutput();

    //Create abstract Prim's algorithm method
    public abstract void Prim();
}
