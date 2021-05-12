/*

Editorial solution
*/
class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;

    int total_tank = 0;
    int curr_tank = 0;
      
      
    int starting_station = 0;
      
    for (int i = 0; i < n; ++i) {
      total_tank += gas[i] - cost[i];
      curr_tank += gas[i] - cost[i];
      // If one couldn't get here,
      if (curr_tank < 0) {
        // Pick up the next station as the starting one.
        starting_station = i + 1;
        // Start with an empty tank.
        curr_tank = 0;
      }
    }
    return total_tank >= 0 ? starting_station : -1;
  }
}

/*

Dry run

Input: 
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

n = 5
curr_tank =0. starting_station = 0

We iterate over array, lets consider first entry as starting station
total tank here is 0 + (1-3) = -2, cuu tank here is 0 + (1-3) = -2
Since curr tank is less than 1, we know this station cannot be starting station, we make starting station as i+1 and curr tank as 0




*/
