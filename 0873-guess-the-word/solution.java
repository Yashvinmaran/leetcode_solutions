/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] words, Master master) {
        int allowedGuesses = 10; // assume 10 allowed guesses for this example
        int guessesLeft = allowedGuesses;
        
        while (guessesLeft > 0) {
            String guess = getGuess(words);
            int result = master.guess(guess);
            if (result == -1) {
                // word is not from words, try another one
                continue;
            } else if (result == 6) {
                // we found the secret word!
                System.out.println("You guessed the secret word correctly.");
                return;
            } else {
                // update the list of words based on the result
                words = updateWords(words, guess, result);
            }
            guessesLeft--;
        }
        
        System.out.println("Either you took too many guesses, or you did not find the secret word.");
    }
    
    private String getGuess(String[] words) {
        // simple random guess for this example
        return words[(int) (Math.random() * words.length)];
    }
    
    private String[] updateWords(String[] words, String guess, int result) {
        List<String> newWords = new ArrayList<>();
        for (String word : words) {
            int matches = 0;
            for (int i = 0; i < 6; i++) {
                if (word.charAt(i) == guess.charAt(i)) {
                    matches++;
                }
            }
            if (matches == result) {
                newWords.add(word);
            }
        }
        return newWords.toArray(new String[0]);
    }
}
