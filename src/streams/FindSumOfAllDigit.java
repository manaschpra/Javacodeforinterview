package streams;

public class FindSumOfAllDigit {
    public static void main(String[] args) {
        String str="123456";

      int sums = str.chars()
                .map(Character::getNumericValue)
                .sum();
        System.out.println("Sum of all digits " + sums);
    }
}
