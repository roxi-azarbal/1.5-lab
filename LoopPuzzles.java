public class LoopPuzzles {

    // Read REQ 02
    public int stepsToOne(int start) {
        if (start <= 0) {
            return -1;
        }
        int steps = 0;
        while (start != 1) {
            if (start % 2 == 0) {
                start /= 2;
            } else if (start % 2 != 0) {
                start = 3 * start + 1;
            }
            steps++;
        }
        return steps;
    }

    // Read REQ 03
    public int sumDigits(int n) {
        if (n < 0) {
            n *= -1;
        }

        int total = 0;
        while (n > 0) {
            total += n % 10;
            n /= 10;
        }

        return total;
    }

    // Read REQ 04
    public int reverseDigits(int n) {
        if (n < 0) {
            n *= -1;
        }

        int reversed = 0;

        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return reversed;
    }

    // Read REQ 05
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        if (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    // Read REQ 06
    public int firstRunningTotalAbove(int limit) {
        int total = 0;
        int i = 1;

        if (limit < 0) {// need or already does?
            return 0;
        }

        while (total <= limit) {
            total += i;
            i++;
        }
        return total;
    }

    // Read REQ 07
    public String readUntilSentinel(String csv, String sentinel) {
        String unread = csv;
        String result = "";

        while (!unread.equals("")) {
            int commaIndex = unread.indexOf(",");
            String token;

            if (commaIndex == -1) {
                token = unread;
                unread = "";
            } else {
                token = unread.substring(0, commaIndex);
                unread = unread.substring(commaIndex + 1);
            }

            if (token.equals(sentinel)) {
                return result;
            }

            if (!result.equals("")) {
                result += " ";
            }

            result += token;
        }
        return result;
    }

    public int countDigits(int n) {
        if (n < 0) {
            n *= -1;
        }

        int count = 0;

        do {
            count++;
            n /= 10;
        } while (n > 0);
        return count;
    }

    public int startWithMostSteps(int limit) {
        int mostSteps = -1;
        int bestStart = 1;
        int current = 1;

        while (current <= limit) {
            int steps = stepsToOne(current);

            if (steps > mostSteps) {
                mostSteps = steps;
                bestStart = current;
            }
            current++;
        }
        return bestStart;
    }
}
