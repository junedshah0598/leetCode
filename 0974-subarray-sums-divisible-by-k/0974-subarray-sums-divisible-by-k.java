class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        final int n = nums.length;
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int result = 0;
        for(int e: nums) {
            sum += e;
            int c = sum % k;
            if(map.containsKey(c)) {
                result += map.get(c);
            }
            if(c > 0) {
                result += map.getOrDefault(c - k, 0);
            } else {
                result += map.getOrDefault(c + k, 0);
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return result;
    }
}