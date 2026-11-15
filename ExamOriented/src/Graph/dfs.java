package Graph;

import java.util.ArrayList;

public class dfs {
    //depth first search in undirected and directed graph
    public ArrayList<Integer> depthFirstSearch(int[][] isConnected) {
        boolean[] isVisited = new boolean[isConnected.length];
        ArrayList<Integer> dfsList = new ArrayList<>();
        isVisited[0] = true;
        dfsList.add(0);
        dfsFunction(isConnected,isVisited,dfsList,0);

        return dfsList;
    }
    public static void dfsFunction(int[][] isConnected, boolean[] isVisited, ArrayList<Integer> dfsList,int start){
        for(int i = 0;i<isConnected[start].length;i++){
            if(isConnected[start][i]!=0 && !isVisited[i]){
                isVisited[i] = true;
                dfsList.add(i);
                dfsFunction(isConnected,isVisited,dfsList,i);
            }
        }
    }

    public static void main(String[] args) {

    }
}
