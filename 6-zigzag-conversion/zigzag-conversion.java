class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows)
            return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++)
            rows[i] = new StringBuilder();
        int curRow = 0, dir = -1;
        for (char c : s.toCharArray()) {
            rows[curRow].append(c);
            if (curRow == 0 || curRow == numRows - 1)
                dir *= -1;
            curRow += dir;
        }
        StringBuilder result = new StringBuilder(s.length());
        for (StringBuilder row : rows)
            result.append(row);
        return result.toString();
    }
}