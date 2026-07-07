class Solution {
    public String simplifyPath(String path) {

        String[] folder = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String fol : folder){
            if(fol.equals(".") || fol.isEmpty())continue;

            else if(fol.equals("..")){
                if(!stack.isEmpty())stack.pop();
            }
            else stack.push(fol);
        }

        if(stack.isEmpty())return "/";

        StringBuilder sb = new StringBuilder();

        for (String st : stack){
            sb.append("/").append(st);
        }

        return sb.toString();
    }
}
