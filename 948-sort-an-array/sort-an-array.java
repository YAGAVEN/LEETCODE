class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    public static void mergeSort(int[] arr , int left, int right){
        if(left>=right){
            return;
        }
        int mid = left +(right - left) / 2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }
public static void merge(int[] arr, int left, int mid, int right) {

    int[] temp = new int[right - left + 1];

    int i = left;     // pointer for left half
    int j = mid + 1;  // pointer for right half
    int k = 0;        // pointer for temp array

    // merge both halves into temp
    while(i <= mid && j <= right) {
        if(arr[i] <= arr[j]) {
            temp[k++] = arr[i++];
        } else {
            temp[k++] = arr[j++];
        }
    }

    // copy remaining left half
    while(i <= mid) {
        temp[k++] = arr[i++];
    }

    // copy remaining right half
    while(j <= right) {
        temp[k++] = arr[j++];
    }

    // copy temp back to original array
    for(int x = 0; x < temp.length; x++) {
        arr[left + x] = temp[x];
    }
}
}