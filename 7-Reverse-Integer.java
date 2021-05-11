public class Solution {
    public int reverse(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10; //last digit
            int newResult = result * 10 + tail; // intermediate result
            if ((newResult - tail) / 10 != result) // "(newResult - tail) / 10" turns the "result * 10 + tail" back. If no overflow exists, "(newResult - tail) / 10" should be equal to "result". If overflow happens, they cannot be equal.
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
}
