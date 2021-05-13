/*public class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        if (divisor == 0) return Integer.MAX_VALUE;
	    if ((dividend == 0) || (dividend < divisor))	return 0;
        int dividend_mod = Math.abs(dividend);
        long div_mod = (long)dividend_mod;
        System.out.println(div_mod);
        int divisor_mod  = Math.abs(divisor);
        long divsor_mod = (long)divisor_mod ;
        System.out.println(divisor_mod);
        long result = ldivide(div_mod, divisor_mod);
	
	    int ans = 0;
	    if (result > Integer.MAX_VALUE){ //Handle overflow.
		result = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
	    } else {
		ans = (int) (sign * result);
	    }
	return ans;
}
private long ldivide(long div_mod, long divsor_mod)
{
        if(divsor_mod > div_mod) {
            return 0;
        }
        long fix_divisor = divsor_mod;
        int quot = 1;
        while(divsor_mod + divsor_mod < div_mod) {
            divsor_mod += divsor_mod;
            System.out.println(divsor_mod);
            quot += 1;
        }
        return quot + ldivide(div_mod - divsor_mod, fix_divisor);
    }
        
        
}
*/
public class Solution {
 
    public int divide(int dividend, int divisor) {
	    //Reduce the problem to positive long integer to make it easier.
	    //Use long to avoid integer overflow cases.
	    int sign = 1;
	    if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
		    sign = -1;
	    long ldividend = Math.abs((long) dividend);
	    long ldivisor = Math.abs((long) divisor);
	
	    //Take care the edge cases.
	    if (ldivisor == 0)
            return Integer.MAX_VALUE;
	    if ((ldividend == 0) || (ldividend < ldivisor))
            return 0;
	
	    long lans = ldivide(ldividend, ldivisor);
	
	    int ans;
	    if (lans > Integer.MAX_VALUE){ //Handle overflow.
		    ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
	    } else {
		    ans = (int) (sign * lans);
	    }
	    return ans;
    }

    private long ldivide(long ldividend, long ldivisor) {
	    // Recursion exit condition
	    if (ldividend < ldivisor)
            return 0;
	
	    //  Find the largest multiple so that (divisor * multiple <= dividend), 
	    //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
	    //  Think this as a binary search.
	    long sum = ldivisor;
	    long multiple = 1;
	    while ((sum+sum) <= ldividend) {
		    sum += sum;
		    multiple += multiple;
	    }
	    //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
	    return multiple + ldivide(ldividend - sum, ldivisor);
    }
}
