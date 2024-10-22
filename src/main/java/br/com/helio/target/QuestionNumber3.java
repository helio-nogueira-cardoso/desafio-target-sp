package br.com.helio.target;

import br.com.helio.target.model.ValueData;
import br.com.helio.target.service.DataConverter;
import br.com.helio.target.service.ValueDataProcessor;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.util.ArrayList;

public class QuestionNumber3 {
    public static void main(String[] args) {
        File jsonFile = new File("dados.json");
        var dataListType = new TypeReference<ArrayList<ValueData>>() {};
        ArrayList<ValueData> valueDataList = DataConverter.getDataFromJson(jsonFile, dataListType);
        var valueDataProcessor = new ValueDataProcessor(valueDataList);

        ValueData minValueData = valueDataProcessor.minValueData();
        ValueData maxValueData = valueDataProcessor.maxValueData();

        System.out.printf("""
                O menor valor de faturamento do mês foi de R$%.2f e ocorreu no dia %d;
                O maior valor de faturamento do mês foi de R$%.2f e ocorreu no dia %d;
                A média mensal de faturamento foi de R$%.2f;
                O faturamento diário foi acima da média mensal em %d dias do mês.
                
                Obs.: Dias sem faturamento não foram considerados no cálculo.
                """,
                minValueData.value(), minValueData.day(),
                maxValueData.value(), maxValueData.day(),
                valueDataProcessor.average(),
                valueDataProcessor.numberOfdaysAboveAverage()
        );

    }
}