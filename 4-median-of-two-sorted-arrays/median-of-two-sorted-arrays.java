class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] cum = new int[nums1.length+nums2.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]){
                cum[k++]=nums1[i++];
            }else{
                cum[k++]=nums2[j++];
            }
        }
        while(i<nums1.length){
            cum[k++]=nums1[i++];
        }
        while(j<nums2.length){
            cum[k++]=nums2[j++];
        }
        if(cum.length%2==1){
            return (double)cum[cum.length/2];
        }else{
            return (double)(cum[cum.length/2] + cum[cum.length/2 - 1])/2;
        }
        
    }
}