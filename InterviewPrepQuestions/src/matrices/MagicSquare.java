package matrices;

public class MagicSquare {
	static int formingMagicSquare(int[][] s) {
        int[][][] matrices=new int[8][3][3];
        matrices[0]=new int[][]{{8,1,6},{3,5,7},{4,9,2}};
        matrices[1]=new int[][]{{6,1,8},{7,5,3},{2,9,4}};
        matrices[2]=new int[][]{{4,9,2},{3,5,7},{8,1,6}};
        matrices[3]=new int[][]{{2,9,4},{7,5,3},{6,1,8}};
        matrices[4]=new int[][]{{8,3,4},{1,5,9},{6,7,2}};
        matrices[5]=new int[][]{{4,3,8},{9,5,1},{2,7,6}};
        matrices[6]=new int[][]{{6,7,2},{1,5,9},{8,3,4}};
        matrices[7]=new int[][]{{2,7,6},{9,5,1},{4,3,8}};

        int globalChangeSum=Integer.MAX_VALUE;
        for(int k=0;k<8;k++){
            int changeSum=0;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    changeSum+=Math.abs(matrices[k][i][j]-s[i][j]);
                }
            }

            globalChangesSum=Math.min(globalChangesSum,changeSum);
        }

        return globalChangesSum;

    }

}
