 /*
 public class Solution {
        public double myPow(double x, int m) {
            double temp=x;
            if(m==0)
            return 1;
            temp=myPow(x,m/2);
            if(m%2==0)
            return temp*temp;
            else 
            {
            if(m > 0)
                return x*temp*temp;
            else
                return (temp*temp)/x;
            }
          
    }
 }
 */
 
public class Solution {
    public double myPow(double x, int n) {
        if(x==1 || n == 0) {
            return 1;
        }
        if(n<0) {
            if(n==Integer.MIN_VALUE) {
                n += 1;
                return -1*(1/myPow(x,-n));
            }
            return 1/myPow(x,-n);
        }
        double res = 1;
        res = myPow(x,n/2);
        if(n%2 == 1)
            return x*res*res;
        else
            return res * res;
    }
}

/*
Lets calculate 2^11

Here x=2, n=11
myPow(2,5) -> myPow(2,2) -> myPow(2,1) -> myPow(2,0)

*/
