class Solution {

    String[] ones = {
        "", "One", "Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen",
        "Fourteen", "Fifteen", "Sixteen",
        "Seventeen", "Eighteen", "Nineteen"
    };

    String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }

        return helper(num);
    }

    private String helper(int num) {

        StringBuilder sb = new StringBuilder();

        if (num >= 1000000000) {
            sb.append(helper(num / 1000000000));
            sb.append(" Billion");
            num %= 1000000000;

            if (num > 0) {
                sb.append(" ");
            }
        }

        if (num >= 1000000) {
            sb.append(helper(num / 1000000));
            sb.append(" Million");
            num %= 1000000;

            if (num > 0) {
                sb.append(" ");
            }
        }

        if (num >= 1000) {
            sb.append(helper(num / 1000));
            sb.append(" Thousand");
            num %= 1000;

            if (num > 0) {
                sb.append(" ");
            }
        }

        if (num >= 100) {
            sb.append(ones[num / 100]);
            sb.append(" Hundred");
            num %= 100;

            if (num > 0) {
                sb.append(" ");
            }
        }

        if (num >= 20) {
            sb.append(tens[num / 10]);
            num %= 10;

            if (num > 0) {
                sb.append(" ");
            }
        }

        if (num > 0) {
            sb.append(ones[num]);
        }

        return sb.toString();
    }
}