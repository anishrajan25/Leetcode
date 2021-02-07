// https://leetcode.com/problems/stone-game-vi/

class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int[][] stones = new int[aliceValues.length][];
        for(int i = 0; i < aliceValues.length; i++) {
            stones[i] = new int[]{aliceValues[i], bobValues[i]};
        }
        Arrays.sort(stones, (s1, s2) -> s2[0] + s2[1] - s1[0] - s1[1]);
        // sort each stone in decreasing on the basis of it's worth
        // each player will remove a stone which helps them score more for themselves
        // as well as prevents the other player from scoring more
        // so a stone with a larger total value (i.e. value for alice + value for bob) is more worthy
        // and thus will be removed first
        
        int ac = 0, bc = 0, i = 0;
        boolean aliceTurn = true;
        while(i < stones.length) {
            if(aliceTurn) ac += stones[i++][0];
            else bc += stones[i++][1];
            aliceTurn = !aliceTurn;
        }
        
        return Integer.compare(ac, bc);
    }
}

// class Solution {
//     public int stoneGameVI(int[] aliceValues, int[] bobValues) {
//         PriorityQueue<Stone> q = new PriorityQueue<Stone>((a, b) -> b.alice + b.bob - a.alice - a.bob);
//         // sort each stone in decreasing on the basis of it's worth
//         // each player will remove a stone which helps them score more for themselves
//         // as well as prevents the other player from scoring more
//         // so a stone with a larger total value (i.e. value for alice + value for bob) is more worthy
//         // and thus will be removed first
        
//         for(int i = 0; i < aliceValues.length; i++) {
//             q.add(new Stone(aliceValues[i], bobValues[i]));
//         }
        
//         int ac = 0, bc = 0;
//         boolean aliceTurn = true;
//         while(!q.isEmpty()) {
//             if(aliceTurn) ac += q.poll().alice;
//             else bc += q.poll().bob;
//             aliceTurn = !aliceTurn;
//         }
        
//         return Integer.compare(ac, bc);
//     }
    
//     private static class Stone {
//         int alice, bob;
        
//         Stone(int a, int b) {
//             alice = a;
//             bob = b;
//         }
//     }
// }