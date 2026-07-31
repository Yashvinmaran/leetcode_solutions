// class Pair{
//     char key;
//     int value;

//     Pair(char key, int value){
//         this.key = key;
//         this.value = value; 
//     }
// }

// class Solution {

//     public int minimumPushes(String word) {
//         int pushes = 0;

//         int[] freq = new int[26];
        
//          for (char c : word.toCharArray()){
//             freq[c - 'a']++;
//         }

//         List<Pair> list = new ArrayList<>();

//         for (int i = 0; i < 26; i++){
//             if(freq[i] != 0){
//                 list.add(new Pair((char)(i + 'a'), freq[i]));
//             }
//         }

//         Collections.sort(list, (a, b) -> Integer.compare(b.value, a.value));


//         for (int i = 0; i < list.size(); i++){
//             if(i < 8) pushes += list.get(i).value;
//             else if(i >= 8 && i < 16) pushes += list.get(i).value * 2;
//             else if(i >= 16 && i < 24) pushes += list.get(i).value * 3;
//             else pushes += list.get(i).value * 4;
//         } 

//         return pushes;       
//     }
// }


class Solution {
    public int minimumPushes(String word) {
        // 1. Fixed-size array allocated on stack
        int[] freq = new int[26];
        int len = word.length();
        
        // 2. Avoid .toCharArray() to save O(N) memory overhead
        for (int i = 0; i < len; i++) {
            freq[word.charAt(i) - 'a']++;
        }

        // 3. Counting sort / Direct sort for 26 elements (O(1) constant time)
        // Manual bubble/selection sort on 26 items is faster than generic dual-pivot Quicksort overhead
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                if (freq[i] < freq[j]) {
                    int temp = freq[i];
                    freq[i] = freq[j];
                    freq[j] = temp;
                }
            }
        }

        // 4. Calculate total keypresses mathematically
        int pushes = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) break; 
            pushes += freq[i] * ((i / 8) + 1);
        }

        return pushes;       
    }
}

