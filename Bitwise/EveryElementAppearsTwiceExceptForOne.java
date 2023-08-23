class Solution {

    public int singleNumber(int[] nums) {
//   nums= { 2,2,1 };
       int uniq=0;
       for(int i: nums){
           uniq= uniq^i;
       }    
       return uniq;
    }
}