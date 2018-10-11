class Solution {
    // O(N) time, O(N) space
    public int numFriendRequests(int[] ages) {
        int count = 0;
        int[] count_ages = new int[121];
        int[] count_no_more_than_ages = new int[121];

        for(int age: ages)
            count_ages[age]++;

        for(int ageA = 15; ageA<=120; ageA++){
            //only older can sent request to younger or peer         
            count_no_more_than_ages[ageA] = count_ages[ageA] + count_no_more_than_ages[ageA - 1];
            if(count_ages[ageA] == 0) continue;
            //count_no_more_than_ages[ageA] - count_no_more_than_ages[ageA/2+7] is the number of younger or peer <= ageA
            //-1 means people can't sent request to himself
            count += count_ages[ageA] * (count_no_more_than_ages[ageA] - count_no_more_than_ages[ageA/2+7] - 1);
        }
        return count;
    }

    // Bruteforce TLE
    public int numFriendRequests(int[] ages) {
        if(ages == null || ages.length == 0)
            return 0;
        int cnt = 0;
        for(int i = 0; i < ages.length; i++){
            for(int j = i + 1; j < ages.length; j++){
                if(freindRequest(ages, i, j))
                    cnt++;
                if(freindRequest(ages, j, i))
                    cnt++;
            }
        }
        return cnt;
    }
    
    private boolean freindRequest(int[] ages, int a, int b){
        if(ages[a] > ages[b] * 0.5 + 7 && ages[a] <= ages[b])
            return true;
        return false;
    }
}