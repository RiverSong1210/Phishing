package com.example.demo;

import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class LetterController {

    @PostMapping("/receive")
    public String receiveLetter(@RequestBody String json) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            Letter letter = objectMapper.readValue(json, Letter.class);


            PhishingDetector pd = new PhishingDetector();

            if (pd.isLinkReportedAsPhishing(letter.getLinks())) {
                return "Phishing";
            } else if (pd.domainContainsNumber(letter.getFrom())
                    || pd.isRedirect(letter.getLinks())
                    || pd.isHttp(letter.getLinks())
                    || pd.checkUrgentWords(letter.getPlainBody())) {
                return "Suspicious";
            } else {
                return "Safe";
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "Error parsing JSON!";
        }
    }
}
