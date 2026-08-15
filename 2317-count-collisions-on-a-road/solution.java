class Solution { 
    public int countCollisions(String directions) { 
        int collide = 0; 
        int left = 0; 
        boolean flag = false; 
        Stack<Character> st = new Stack<>(); 
        
        for (char c : directions.toCharArray()){ 
            if(c == 'R') {
                st.add(c); 
            } else if(c == 'L'){ 
                left = flag ? left + 1 : left; 
                if(!st.isEmpty()){ 
                    collide += st.size() + 1; 
                    left = flag ? left - 1 : left; 
                    st.clear(); 
                    flag = true; 
                } 
            } else { 
                flag = true; 
                if(!st.isEmpty()){ 
                    collide += st.size(); 
                    st.clear(); 
                } 
            } 
        } 
        return collide + left; 
    } 
}

