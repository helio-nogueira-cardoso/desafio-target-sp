package br.com.helio.target;

import br.com.helio.target.model.ProfitData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionNumber4 {
    public static void main(String[] args) {
        /*
            •	SP – R$67.836,43
            •	RJ – R$36.678,66
            •	MG – R$29.229,88
            •	ES – R$27.165,48
            •	Outros – R$19.849,53
        */

        List<ProfitData> profits = new ArrayList<>(Arrays.asList(
                new ProfitData("SP", 67836.43),
                new ProfitData("RJ", 36678.66),
                new ProfitData("MG", 29229.88),
                new ProfitData("ES", 27165.48),
                new ProfitData("Outros", 19849.53)
        ));

        double totalProfit = profits.stream().map(ProfitData::profit).reduce(0.0, Double::sum);

        System.out.printf("O faturamento total do mês foi de R$%.2f;%n", totalProfit);

        profits.forEach(p -> System.out.printf("""
                %s faturou %.2f%% deste total;
                """, p.source(), 100.0 * p.profit() / totalProfit));
    }

}
