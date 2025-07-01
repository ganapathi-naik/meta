class Solution121 {
    int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minBuyingPrice = prices[0];
        for(int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minBuyingPrice);
            minBuyingPrice = Math.min(minBuyingPrice, prices[i]);
        }
        return maxProfit;
    }
}


/**
121. Best Time to Buy Flight
You are given two arrays departures and returns where departures [il and returns [i] are ticket prices for departing and returning flights on the ith day, respectively.
You want to minimize your cost by choosing a single day to buy a departure flight and choosing a different day in the future to buy a returning flight.
Return the minimum cost you can achieve from a single round-trip flight.
departures
2 3
4
Example 1:
Input: departures = [1,2,3,4], returns = [4,3,2,1]
Output: 2
Explanation: Buy a departure flight on day 0
(price = 1) and buy a return ticket on day 3
(price = 1), cost = 1+1 = 2.
 */

class Solution121 {
    int findCheapestTickets(int[] departurePrices, int[] returnPrices) {
        int minDeparturePrice = departurePrices[0];
        int minCost = Integer.MAX_VALUE;
        int n = returnPrices.length;

        for(int i = 1; i < n; i++) {
            minCost = Math.min(minCost, minDeparturePrice + returnPrices[i]);
            minDeparturePrice = Math.min(minDeparturePrice, departurePrices[i]);
        }
        return minCost;
    }
}
