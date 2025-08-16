package string;

import java.util.List;

public class L824_GoatLatin {
    public String toGoatLatin(String sentence) {
        String[] split = sentence.split(" ");
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'A',
                'E', 'I', 'O', 'U');

        for (int i = 0; i < split.length; i++) {
            String word = split[i];
            StringBuilder sb = new StringBuilder();
            if (vowels.contains(word.charAt(0))) {
                sb.append(word);
            } else {
                sb.append(word.substring(1, word.length()));
                sb.append(word.charAt(0));

            }
            sb.append("ma");
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            split[i] = sb.toString();
        }
        return String.join(" ", split);
    }
}
