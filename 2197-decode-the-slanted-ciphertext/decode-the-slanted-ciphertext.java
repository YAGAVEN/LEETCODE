class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1 || encodedText.isEmpty()) {
            return encodedText;
        }
        int cols = encodedText.length() / rows;
        StringBuilder result = new StringBuilder(encodedText.length());
        for (int startCol = 0; startCol < cols; startCol++) {
            int r = 0;
            int c = startCol;
            while (r < rows && c < cols) {
                result.append(encodedText.charAt(r * cols + c));
                r++;
                c++;
            }
        }
        int end = result.length() - 1;
        while (end >= 0 && result.charAt(end) == ' ') {
            end--;
        }
        return result.substring(0, end + 1);
    }
}