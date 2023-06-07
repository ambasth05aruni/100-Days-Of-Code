class Solution {
    public int minFlips(int a, int b, int c) {
        int [] bin_a = intToBinary(a);
        int [] bin_b = intToBinary(b);
        int [] bin_c = intToBinary(c);

        // expected behavior a or b == c
        // check for every bit in c, it can be 0 or 1
        // if its 1, then possible combination (1,1),(1,0),(0,1) will give 1 and no need to flip, but if its (0,0) then need to flip 1 bit
        // if its 0, then possible combination (0,0) no need to flip bit, otherwise for (1,0) or (0,1) flip 1 bit, for (1,1) need to flip 2 bits
        int count = 0;
        for(int i=31; i>=0; i--) {
            if(bin_c[i] == 1) {
                if(bin_a[i] == 0 && bin_b[i] == 0) {
                    // need to flip any 1 bit
                    count++;
                }
            } else {
                if(bin_a[i] == 1 && bin_b[i] == 1) {
                    // need to flip any both bits
                    count = count+2;
                } else if(!(bin_a[i] == 0 && bin_b[i] ==0)) {
                    // need to flip any 1 bit
                    count++;
                }
            }
        }
        return count;
    }

    private int [] intToBinary(int num) {
        int [] result = new int[32];
        int i = 31;
        while(num > 0) {
            result[i] = num%2;
            num = num/2;
            i--;
        }
        return result;
    }
}