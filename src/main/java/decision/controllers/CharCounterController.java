    package decision.controllers;

    import decision.services.CharCounterService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Map;

    @Controller
    public class CharCounterController {
        @Autowired
        private CharCounterService charCounterService;

        @GetMapping("/")
        public String index(Model model) {
            model.addAttribute("results", new ArrayList<Map<Character, Integer>>());
            return "index";
        }

        @PostMapping("/calculate")
        public String calculateCharacterFrequency(@RequestParam("inputText") String inputText, Model model) {
            List<Map<Character, Integer>> results = charCounterService.calculateCharacterFrequency(inputText);
            model.addAttribute("results", results);
            return "index";
        }
    }