class Solution {
    public List<List<Integer>> generate(int numRows) {
        // Main list jo saari rows ko hold karegi
        List<List<Integer>> triangle = new ArrayList<>();
        
        // Agar rows hi 0 hain, toh khali triangle return kar do
        if (numRows <= 0) {
            return triangle;
        }
        
        // Har ek row ke liye loop chalayenge
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            
            // Har row ki shuruat hamesha 1 se hoti hai
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1); // Pehla aur aakhri element 1 hoga
                } else {
                    // Beech ke elements pichli row ke do numbers ka sum honge
                    List<Integer> prevRow = triangle.get(i - 1);
                    int sum = prevRow.get(j - 1) + prevRow.get(j);
                    row.add(sum);
                }
            }
            
            // Bani hui row ko main triangle me add kar do
            triangle.add(row);
        }
        
        return triangle;
    }
}