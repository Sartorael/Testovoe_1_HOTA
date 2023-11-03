    package decision.services;

    import org.springframework.stereotype.Service;
    import java.util.*;

    @Service
    public class CharCounterService {

        public List<Map<Character, Integer>> calculateCharacterFrequency(String input) {
            Map<Character, Integer> frequencyMap = new HashMap<>();
            List<Map<Character, Integer>> resultList = new ArrayList<>();
            for (char c : input.toLowerCase(Locale.ROOT).toCharArray()) {
                    frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
                Map<Character, Integer> resultMap = new HashMap<>();
                resultMap.put(entry.getKey(), entry.getValue());
                resultList.add(resultMap);
            }
            resultList.sort((m1, m2) -> {
                int freq1 = m1.values().iterator().next();
                int freq2 = m2.values().iterator().next();

                if (freq1 == freq2) {
                    char char1 = m1.keySet().iterator().next();
                    char char2 = m2.keySet().iterator().next();
                    return Character.compare(char1, char2);
                } else {
                    return Integer.compare(freq2, freq1);
                }
            });
            return resultList;
        }
    }