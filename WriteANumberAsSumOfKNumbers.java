package Personal;

public class WriteANumberAsSumOfKNumbers {
public static void main(String[] args) throws Exception {
    int S = 10, K = 4;
    System.out.println("S=" + S + "   K=" + K);
    System.out.println(PartionwithZero(S, K));
    System.out.println(PartionwithoutZero(S, K));
    System.out.println(PartionwithZeroUnique(S, K));
}

/* Divide S in K parts 0 may be present */
public static long PartionwithZero(int S, int K) {
    long DP_Table[][] = new long[K][];
    for (int i = 0; i < K; i++)
        DP_Table[i] = new long[S + 1];
    for (int i = 0; i < S + 1; i++)
        DP_Table[0][i] = 1;
    for (int i = 0; i < K; i++)
        DP_Table[i][0] = 1;

    for (int i = 1; i < K; i++) {
        for (int j = 1; j < S + 1; j++)
            DP_Table[i][j] = DP_Table[i - 1][j] + DP_Table[i][j - 1];
    }


    for(int i=0;i<K;i++) 
    { 
    	for(int j=0;j<S+1;j++)
    		System.out.print(DP_Table[i][j]+" "); 
    	System.out.println(); 
    }
     
    return DP_Table[K - 1][S];
}

/* Divide S in K parts 0 should not be present */
public static long PartionwithoutZero(int S, int K) {
    long DP_Table[][] = new long[K][S];
    for (int i = 0; i < S; i++)
        DP_Table[0][i] = 1;
    for (int i = 1; i < K; i++)
        DP_Table[i][0] = 0;

    for (int i = 1; i < K; i++) {
        for (int j = 1; j < S; j++)
            DP_Table[i][j] = DP_Table[i - 1][j - 1] + DP_Table[i][j - 1];
    }

    /*
     * for(long i=0;i<K;i++) { for(long j=0;j<S;j++)
     * System.out.print(DP_Table[i][j]+" "); System.out.println(); }
     */
    return DP_Table[K - 1][S - 1];
}

/* Divide S in K parts 0 may be present */
public static long PartionwithZeroUnique(int S, int K) {
    long DP_Table[][][] = new long[K][S + 1][S + 1]; // DP_Table[no of
                                                        // partition][Sum][Maximum
                                                        // value in the
                                                        // partition]

    for (int i = 0; i < K; i++)
        DP_Table[i][0][0] = 1;
    for (int i = 1; i < S + 1; i++) {
        DP_Table[0][i][0] = 0;
        DP_Table[0][i][i] = 1;
    }
    for (int i = 1; i < S + 1; i++)
        DP_Table[0][0][i] = 0;

    for (int i = 0; i < S + 1; i++)
        for (int j = 0; j < i; j++)
            DP_Table[0][i][j] = 1;

    for (int i = 1; i < K; i++) {
        for (int j = 1; j < S + 1; j++)
            for (int k = 1; k < S + 1; k++) {
                // System.out.println(i+" "+j+" "+k);
                DP_Table[i][j][k] = (k - j) >= 0 ? DP_Table[i - 1][j][k - j]
                        : 0;
            }
        for (int k = 0; k < S + 1; k++) {
            long sum = 0;
            for (int j = 0; j < S + 1; j++) {
                DP_Table[i][j][k] += sum;
                sum = DP_Table[i][j][k];
            }
        }
    }

    /*
     * for(int i=0;i<K;i++) { System.out.println("K ="+i); for(int
     * j=0;j<S+1;j++) { for(int k=0;k<S+1;k++)
     * System.out.print(DP_Table[i][j][k]+" "); System.out.println(); }
     * System.out.println(); System.out.println(); }
     */
    return DP_Table[K - 1][S][S];
}
}
