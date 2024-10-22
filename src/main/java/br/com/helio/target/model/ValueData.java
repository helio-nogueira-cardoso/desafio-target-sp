package br.com.helio.target.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public record ValueData(
        @JacksonXmlProperty(localName = "dia")
        @JsonProperty("dia")
        int day,
        @JacksonXmlProperty(localName = "valor")
        @JsonProperty("valor")
        double value
) {
    @Override
    public String toString() {
        return "ValueData{" +
                "day=" + day +
                ", value=" + value +
                '}';
    }
}
