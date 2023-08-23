class Solution {
    public int singleNumber(int[] nums) {

       int uniq=0;
       for(int i: nums){
           uniq= uniq^i;
       }    
       return uniq;
    }
}