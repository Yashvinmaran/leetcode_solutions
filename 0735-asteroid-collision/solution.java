class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int x : asteroids) list.add(x);

        int i = 1;

        while (i < list.size()) {

            int prev = list.get(i - 1);
            int curr = list.get(i);

            if (prev > 0 && curr < 0) {

                if (Math.abs(prev) > Math.abs(curr)) {
                    list.remove(i);        
                }
                else if (Math.abs(prev) < Math.abs(curr)) {
                    list.remove(i - 1);   
                    i--;                  
                }
                else { 
                    list.remove(i);        
                    list.remove(i - 1);    
                    i--;                 
                }

                if (i < 1) i = 1;
            }
            else {
                i++;
            }
        }

        int[] result = new int[list.size()];
        for (int k = 0; k < list.size(); k++) result[k] = list.get(k);

        return result;
    }
}

