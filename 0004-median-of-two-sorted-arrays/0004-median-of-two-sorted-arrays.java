class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int c[] = new int[m+n];
        int n1 = 0, n2 =0;
        double k = 0.0;
        for(int i =0;i<=c.length-1;i++){
            if(n1 >= m){
                c[i] = nums2[n2];
                n2++;
            }
            else if(n2 >= n){
                c[i] = nums1[n1];
                n1++;
            }
            else{
                if(nums1[n1]>nums2[n2]){
                    c[i] = nums2[n2];
                    n2++;
                }
                else if(nums1[n1]<nums2[n2]){
                    c[i] = nums1[n1];
                    n1++;
                }
                else if(nums1[n1] == nums2[n2]){
                    c[i] = nums1[n1];
                    c[i+1] = nums2[n2];
                    i++;
                    n1++;
                    n2++;
                }
            }
        }
        if((m+n-1)%2==0){
            k = c[(c.length-1)/2];
        }
        else{
            k = (c[(m+n-1)/2]+c[(m+n+1)/2])/2.0;
        }
        return k;
    }
}