// you can also use imports, for example:
 import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class LiveRampFinal {
    public static int solution(int[] A, int X, int D) {
        // write your code in Java SE 8
        
        //if there are no leaves and final position cannot be reached directly return -1
        if (A.length == 0 && X!=D)
            return -1;
        
        //if X can be reached in one hop or when the first leaf falls, return 0
        if (X <= D || ((A[0] <= D) && ((A[0]+D) >= X)))
            return 0;
        
        int distanceTravelled = 0, currPos = 0, k=0,index=-1;
        
        //temporary array to store leaves that are unreachable at the moment
        int[] visited = new int[A.length];

        for(int i=0; i<A.length; i++){
           
            if (currPos < A[i] && (A[i]-currPos) <= D){

                currPos = A[i];
                index = i;
                distanceTravelled = A[i];

                if(distanceTravelled+D >= X){
                    return index;
                }
            }
            else{

                visited[k++]=A[i];
            }
        }
        
        int reprocessCount = 1;

        //process the unreachable leaves from current position, iterate it again until there are no leaves or only unreachable leaves are left
        //reprocessCount will be updated when a reachable leaf is found, this will allow another iteration
        for (int l=0; l< reprocessCount;l++){
            
            for(k=0; k<visited.length; k++){
               
               if (currPos < visited[k] && (visited[k]-currPos) <= D){

                    distanceTravelled = visited[k];
                    currPos = visited[k];
                    visited[k] = 0;

                    if(distanceTravelled+D >= X){
                        return index;
                    }

                    reprocessCount++;
                }
            }
        }

        return -1;
    }

   public static void main(String[] args){

            int[] array={1,3,1,4,2,5};
            char s='1';
            int a=Integer.parseInt(s+"");
            System.out.println(a);
            System.out.println(solution(array, 6,1));
    }
}