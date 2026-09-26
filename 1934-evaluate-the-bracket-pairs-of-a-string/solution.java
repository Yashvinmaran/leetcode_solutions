class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        Map<String, String> map = new HashMap<>();

        for (var k : knowledge){
            map.put(k.get(0), k.get(1));
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean keyStart = false;
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                keyStart = true;
                continue;
            }
            else if(s.charAt(i) == ')'){
                keyStart = false;
                sb.append(map.getOrDefault(key.toString(), "?"));
                key = new StringBuilder();
                continue;
            }
            else if(keyStart){
                key.append(s.charAt(i));
            }else{
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
