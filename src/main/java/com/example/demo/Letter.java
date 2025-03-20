package com.example.demo;

import java.util.List;
import java.util.Map;

public class Letter {
    private String subject;
    private String from;
    private String plainBody;
    private List<String> links;
    private Map<String, String> headers;

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }

    public String getPlainBody() { return plainBody; }
    public void setPlain_body(String plain_body) { this.plainBody = plain_body; }

    public List<String> getLinks() { return links; }
    public void setLinks(List<String> links) { this.links = links; }

    public Map<String, String> getHeaders() { return headers; }
    public void setHeaders(Map<String, String> headers) { this.headers = headers; }

}

