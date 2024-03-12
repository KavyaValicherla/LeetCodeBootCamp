class Solution {
    public int videoStitching(int[][] clips, int time) {
        int counter = 0;
        int currEnd = 0, nextEnd = 0;
        int i = 0;

        while (currEnd < time) {
            for (int j = 0; j < clips.length; j++) {
                if (clips[j][0] <= currEnd) {
                    nextEnd = Math.max(nextEnd, clips[j][1]);
                }
            }

            if (currEnd == nextEnd) {
                return -1;
            }

            currEnd = nextEnd;
            counter++;

            // If current end is already beyond or equal to time, break out of the loop
            if (currEnd >= time) {
                break;
            }
        }

        return counter;
    }    
    
}