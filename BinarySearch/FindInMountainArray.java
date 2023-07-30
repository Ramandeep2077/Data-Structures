class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {

      int temp=peakIndexMountainArray(mountainArr);
      int answer= binarySearch(mountainArr,  target, 0, temp, true );
      if(answer!=-1){
          return answer;
      }

      return binarySearch(mountainArr,target,temp, mountainArr.length()-1, false);
    }
      

      public int peakIndexMountainArray(MountainArray mountainArr){
          int start=0;
          int end=mountainArr.length()-1;
           

           while(start<end){
               int mid= start + (end-start)/2;

               if(mountainArr.get(mid)> mountainArr.get(mid+1)){
                   end=mid;
               }else{
                   start=mid+1;
               }
           }
         return start;
      }

      public int binarySearch(MountainArray mountainArr, int target, int start, int end, boolean isAsc ){

          while(start<=end){
              int mid= start + (end-start)/2;

              if(mountainArr.get(mid) ==target){
                  return mid;
              } else{
                  if(isAsc){
                      if(mountainArr.get(mid)>target){
                           end=mid-1;
                      }else{
                          start=mid+1;
                      }
                  }else{
                      if(mountainArr.get(mid)<target){
                          end=mid-1;
                      }else{
                        start=mid+1;
                      }
                      
                  }
              }

          }
        return -1;
      }

}
}