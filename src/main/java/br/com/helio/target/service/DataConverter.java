package br.com.helio.target.service;

import br.com.helio.target.model.ValueData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DataConverter {

    private static final ObjectMapper jsonMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static <T> T getDataFromJson(File jsonFile, TypeReference<T> typeReference) {
        try {
            return jsonMapper.readValue(jsonFile, typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T getDataFromXml(File xmlFile, TypeReference<T> typeReference) {
        try {
            return xmlMapper.readValue(xmlFile, typeReference);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao processar XML", e);
        }
    }
}
