class Solution { 
    public String processStr(String s) { 
        StringBuilder sb = new StringBuilder(); 
        
        for (int i = 0; i < s.length(); i++) { 
            char current = s.charAt(i);
            
            if (current == '*') { 
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1); 
                }
            } else if (current == '#') { 
                if (sb.length() > 0) {
                    sb.append(sb.substring(0)); 
                }
            } else if (current == '%') { 
                sb.reverse(); 
            } else {
                sb.append(current); 
            }
        } 
        return sb.toString(); 
    } 
}

