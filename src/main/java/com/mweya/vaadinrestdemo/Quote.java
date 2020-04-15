package com.mweya.vaadinrestdemo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Quote {

    private String quote;

    public Quote() {
    }

    /**
     * @return the Kanye quote
     */
    public String getQuote() {
        return this.quote;
    }

    /**
     * @param quote the quote to set
     */
    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "\"" + quote + "\" - Kanye";
    }
}