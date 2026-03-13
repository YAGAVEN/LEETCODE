class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes)
    {
        long l = 1;
        long r = (long)1e18;
        long ans = r;

        while(l <= r)
        {
            long mid = l + (r - l) / 2;

            if(canFind(mid, workerTimes, mountainHeight))
            {
                ans = mid;
                r = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
        }

        return ans;
    }

    public boolean canFind(long m, int arr[], int mh)
    {
        long tot = 0;

        for(int a : arr)
        {
            long k = (long)((Math.sqrt(1 + (8.0 * m) / a) - 1) / 2);

            tot += k;

            if(tot >= mh)
            {
                return true;
            }
        }

        return false;
    }
}