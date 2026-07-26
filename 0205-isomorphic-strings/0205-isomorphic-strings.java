class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Do arrays banayenge ASCII characters track karne ke liye (size 256)
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            
            // Agar dono characters ka pichla dekha hua index match nahi karta
            if (mapS[charS] != mapT[charT]) {
                return false;
            }
            
            // Dono ki position ko update kar do (i + 1 karte hain taaki 0 default se alag rahe)
            mapS[charS] = i + 1;
            mapT[charT] = i + 1;
        }
        
        return true;
    }
}