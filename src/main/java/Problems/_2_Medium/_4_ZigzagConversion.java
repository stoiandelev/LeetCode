package Problems._2_Medium;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 */

public class _4_ZigzagConversion {
    public static void main(String[] args) {

        String s = "PAYPALISHIRING";
        int numRows = 4;

        System.out.println(convert(s, numRows));

    }

    public static String convert(String s, int rowNum) {
        if (rowNum == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rowNum; i++) {
            int lastPosition = -1;

            for (int j = 0; true; j++) {
                int position = -1;

                if (i == 0) {
                    position = j * 2 * (rowNum - 1);
                } else if (i == rowNum - 1) {
                    position = (rowNum - 1) + j * 2 * (rowNum - 1);
                } else {
                    if (j == 0) {
                        position = i;
                        lastPosition = position;
                    } else if (j % 2 == 1) {
                        position = lastPosition + 2 * (rowNum - 1 - i);
                        lastPosition = position;
                    } else {
                        position = lastPosition + 2 * i;
                        lastPosition = position;
                    }
                }
                if (
                        position >= s.length()
                ) {
                    break;
                }
                sb.append(s.charAt(position));
            }
        }
        return sb.toString();
    }
}

