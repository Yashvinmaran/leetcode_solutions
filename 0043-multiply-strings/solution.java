import java.math.BigInteger;
class Solution {
    public String multiply(String num1, String num2) {
      BigInteger bigInt1 = new BigInteger(num1);
      BigInteger bigInt2 = new BigInteger(num2);
      BigInteger mul = bigInt1.multiply(bigInt2);
      String output = mul.toString();
      return output; 
    }
}
