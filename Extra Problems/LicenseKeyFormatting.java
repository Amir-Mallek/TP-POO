class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String res = "";
        int nbAl = 0;
        s = s.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '-') nbAl++;
        }
        int i;
        boolean firstDash =  nbAl % k != 0;
        for (i = 0; nbAl % k != 0; i++) {
            if (s.charAt(i) != '-') {
                res += s.charAt(i);
                nbAl--;
            }
        }
        for (int e = 0; e < (nbAl/k); e++) {
            if (firstDash || e > 0) res += '-';
            for (int j = 0; j < k;) {
                if (s.charAt(i) != '-') {
                    res += s.charAt(i);
                    j++;
                }
                i++;
            }
        }
        return res;
    }
}
