package algorithms.exercise10_bitManipulation.scenario2;

public class BinaryNumberOps {
    private String number;

    public BinaryNumberOps(String number) {
        this.number = number;
    }

    // My wrong version
    public void negate() {
        byte[] bytes = number.getBytes();

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) ~bytes[i];
        }
    }

    // Correct version
    public void negateCorrect() {
        int binaryInt = Integer.parseInt(number, 2);
        binaryInt = ~binaryInt;
        number = Integer.toBinaryString(binaryInt);
    }

    // AI Copied
    public String compress() {
        StringBuilder result = new StringBuilder();
        int count = 1;
        char prev = number.charAt(0);

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == prev) 
                count++;
            else {
                result.append(prev);
                result.append('(');
                result.append(count);
                result.append(')');
                prev = number.charAt(i);
                count = 1;
            }
        }
        result.append(prev);
        result.append('(');
        result.append(count);
        result.append(')');

        return result.toString();
    }

    // AI Copied
    public String reduce() {
        StringBuilder result = new StringBuilder();
        int count = 1;
        String patern = number.substring(0, 2);

        for (int i = 2; i < number.length(); i+= 2) {
            String current = number.substring(i, i + 2);
            if (current.equals(patern))
                count++;
            else {
                result.append(patern);
                result.append('(');
                result.append(count);
                result.append(')');
                patern = current;
                count = 1;
            }
        }
        result.append(patern);
        result.append('(');
        result.append(count);
        result.append(')');

        return result.toString();
    }
}