class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

      int i = m-1;
      int j = n-1;
      int k = m+n-1;

      while(i>=0 && j>=0) {
        if(nums1[i] > nums2[j]) {
            nums1[k] = nums1[i];
            i--;
        } else {
            nums1[k] = nums2[j];
            j--;
        }
        k--;
      }

      while(j>=0) {
        nums1[k] = nums2[k];
        j--;
        k--;
      }

    }

}

/*
nums1 = [10,20,30,40,0,0]
nums2 = [1,]2\
temp [10,20,30,40,1,2]

nums pointer at end <- insertion point
nums1 pointer at last valid element (m-1)
nums2 pointer at last valid element (n-1)

        int[] temp = new int[m+n];

        int index = 0;

        for(int i=0;i<m;i++) {
            temp[index] = nums1[i];
            index++;
        }

        for(int i=0;i<n;i++) {
            temp[index] = nums2[i];
            index++;
        }

        for(int i = 0; i<temp.length-1; i++) {
            for(int j = 0; j<temp.length-1-i; j++) {
                if(temp[j] > temp[j+1]) {
                    int tempVal = temp[j];
                    temp[j] = temp[j+1];
                    temp[j+1] = tempVal;
                }
            }
        }

        for(int i = 0; i<temp.length;i++) {
            nums1[i] = temp[i];
        }


*/