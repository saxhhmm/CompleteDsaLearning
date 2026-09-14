class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // Check if the overlapping width is strictly positive
        boolean xOverlap = Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]);
        
        // Check if the overlapping height is strictly positive
        boolean yOverlap = Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]);
        
        // Both projections must overlap for the rectangles to intersect
        return xOverlap && yOverlap;
    }
}