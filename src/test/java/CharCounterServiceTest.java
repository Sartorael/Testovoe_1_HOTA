    import org.junit.jupiter.api.Assertions;
    import org.junit.jupiter.api.Test;

    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;
    import decision.services.CharCounterService;

    public class CharCounterServiceTest {

        private final CharCounterService charCounterService = new CharCounterService();

        @Test
        public void testCalculateCharacterFrequency_SingleCharacter() {
            String input = "a";
            List<Map<Character, Integer>> actualResults = charCounterService.calculateCharacterFrequency(input);
            String expectedOutput = "\"a\": 1";

            Assertions.assertEquals(1, actualResults.size());
            Assertions.assertEquals(expectedOutput, formatResult(actualResults.get(0)));
        }

        @Test
        public void testCalculateCharacterFrequency_SingleCharacterWithDuplicates() {
            String input = "aaa";
            List<Map<Character, Integer>> actualResults = charCounterService.calculateCharacterFrequency(input);
            String expectedOutput = "\"a\": 3";

            Assertions.assertEquals(1, actualResults.size());
            Assertions.assertEquals(expectedOutput, formatResult(actualResults.get(0)));
        }

        @Test
        public void testCalculateCharacterFrequency_MultipleCharacters() {
            String input = "abacaba";
            List<Map<Character, Integer>> actualResults = charCounterService.calculateCharacterFrequency(input);

            Assertions.assertEquals(3, actualResults.size());
            Assertions.assertEquals("\"a\": 4", formatResult(actualResults.get(0)));
            Assertions.assertEquals("\"b\": 2", formatResult(actualResults.get(1)));
            Assertions.assertEquals("\"c\": 1", formatResult(actualResults.get(2)));
        }
        @Test
        public void testCalculateCharacterFrequency_SimpleInput() {
            String input = "Привет,  мир!!!\"\"";
            List<Map<Character, Integer>> actualResults = charCounterService.calculateCharacterFrequency(input);
            Assertions.assertEquals(2, actualResults.get(0).getOrDefault(' ', 2));
            Assertions.assertEquals(2, actualResults.get(0).getOrDefault('"', 2));
            Assertions.assertEquals(3, actualResults.get(0).getOrDefault('!', 3));
        }
        private String formatResult(Map<Character, Integer> result) {
            char character = result.keySet().iterator().next();
            int frequency = result.get(character);
            return String.format("\"%s\": %d", character, frequency);
        }

    }
