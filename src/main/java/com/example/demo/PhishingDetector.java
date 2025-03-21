package com.example.demo;

import java.util.List;

public class PhishingDetector {

    private String [] phishingLinks = {
            "https://comunicacionessuraa.shop/",
            "https://kdiytws.typedream.app/untitled",
            "https://check-pepeunchained.com",
            "https://www-hyperliquid.com",
            "https://natura.pezrabioso.cl/",
            "https://webchat.natura-br-cf.data2.app/",
            "https://revendedora-avon6.webnode.page/",
            "https://www.kakarnetzwerk.cfd"
    };

    private String [] urgentWords = {
            "urgent", "account will be locked", "verify",
            "login now", "claim your prize", "secure your account",
            "act fast", "password", "login"
    };

    private String [] redirectKeywords = {
            "redir", "goto", "url=", "next=", "continue=", "location="
    };


    public boolean isLinkReportedAsPhishing (List<String> links) {

            for (String phishingLink : phishingLinks) {
                if (links.contains(phishingLink)) {
                    return true;
                }
            }


        return false;
    }

    public boolean checkUrgentWords (String body) {
        for (String word : urgentWords) {
            if (body.toLowerCase().contains(word)) {
                return true;
            }
        }

        return false;
    }

    public boolean isRedirect (List<String> links) {

            for (String redirectKeyword : redirectKeywords) {
                if (links.contains(redirectKeyword)) {
                    return true;
                }
            }


        return false;
    }

    public boolean domainContainsNumber (String email) {
        return email.matches(".*@[^\\s]+\\d+\\..*");
    }

    public boolean isHttp (List<String> links) {

        return !links.stream()
                .filter(el -> el.startsWith("http:"))
                .toList()
                .isEmpty();
    }


}
