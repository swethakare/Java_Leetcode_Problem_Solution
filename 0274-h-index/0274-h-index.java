// class Solution {
//     public int hIndex(int[] citations) {
//     if(citations.length == 1){
//         return 1;
//     }
//     Arrays.sort(citations);
//     int mid = citations.length/2;
//     int[] count = new int[citations[citations.length-1]+1]; 
//     int cnt = 0;
    
//     for(int i = citations.length-1; i>=mid; i--){
//         // check elements towards right;
//         count[citations[i]]++;
//         if(i < citations.length - 1){
//             cnt++;
//             count[citations[i]] = count[citations[i]] + cnt;
//         }
//         if(count[citations[i]] >= citations[i]){
//             return citations[i];
//         }
//     }
//     return -1;
  
//     }
// }
public class Solution {
public int hIndex(int[] citations) {
    int[] arr = new int[citations.length + 1];
    for(int i = 0 ;i < citations.length; i++){
        if(citations[i] >= arr.length){
            arr[arr.length-1]++;
        }else{
            arr[citations[i]]++;
        }
    }
    int tot = 0;
    for(int i = arr.length-1; i >= 0; i--){
        tot = tot + arr[i];
        if(tot >= i){
            return i;
        }
    }
    return -1;
}
}
    