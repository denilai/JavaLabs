package denilai.rtu;
//import javafx.util.Pair;

import java.io.*;
import java.util.*;
import java.util.function.Function;

public class CSVParser {

    private Double totalIncome;
    private Double totalExpense;
    //private List<Object> totalExpenseOfCompanies;
    private List<AbstractMap.SimpleEntry<String, Double>> totalExpenseOfCompanies;
    private ArrayList<BankingUnit> bankingUnits;


    public ArrayList<BankingUnit> getBankingUnits(){
        return bankingUnits;
    }

    CSVParser(String path){

        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(path), "windows-1251"));

            String line;
            bankingUnits = new ArrayList<>();
            reader.readLine();// пропускаем первую строку с заголовками
            while ((line = reader.readLine()) != null) {
                bankingUnits.add(new BankingUnit(line));
            }
        }
        catch (Exception a){
            System.out.println("File " + path + " not found");
        }
    }

    public void getReport(){

        calculateTotalExpense();
        calculateTotalIncome();
        calculateTotalExpenseOfCompanies();

        System.out.printf(
                "Сумма расходов: %.2f руб.\nСумма доходов: %.2f руб.%n%n",
                totalExpense,totalIncome);
        totalExpenseOfCompanies.forEach(
                el-> System.out.printf("%-30s %-10.2f руб.%n",
                       el.getKey(), el.getValue()));
    }

    private void calculateTotalExpense(){
        ArrayList<Double> expanses = new ArrayList<>();
        bankingUnits.forEach(el -> expanses.add(el.getExpense()));
        totalExpense = FunctionalStuff.sumOfCollection(expanses);
    }

    private void calculateTotalIncome(){
        ArrayList<Double> incomes = new ArrayList<>();
        bankingUnits.forEach(el -> incomes.add(el.getIncome()));
        totalIncome = FunctionalStuff.sumOfCollection(incomes);
    }



//    private final Function<
//            Function<? ,Object>,
//            Function<Collection<?>,Collection<? >>> map = f -> list -> {
//                Collection <?> answer = new ArrayList<>();
//                list.forEach(el -> answer.add(f.apply(el)));
//                return answer;
//            };




    private void calculateTotalExpenseOfCompanies(){
        ArrayList<String> companies =
                (ArrayList<String>) map.apply(unit->((BankingUnit)unit).getOrganization()).apply(bankingUnits);
        Set<String> set = new HashSet<>(companies); // удаляем повторения
        companies.clear();
        companies.addAll(set);

        List<AbstractMap.SimpleEntry<String,List<BankingUnit>>> listOfList =
                (List<AbstractMap.SimpleEntry<String,List<BankingUnit>>>)
                map.apply(comp->FunctionalStuff.filterByCompany.apply(bankingUnits).apply((String)comp)).apply(companies);


        totalExpenseOfCompanies =
                (List<AbstractMap.SimpleEntry<String,Double>>)
                    map.apply(
                        pair -> expenseOfCompany.apply((AbstractMap.SimpleEntry<String, List<BankingUnit>>) pair)
                    ).apply(listOfList);
    }




    public Function<
            Function <Object,Object>,
            Function<Collection<?>,Collection<?>>> map =
         f -> list ->{
            ArrayList<Object> result = new ArrayList<>();
            list.forEach(el -> result.add(f.apply(el)));
            return result;
        }
    ;

    public Function<
            AbstractMap.SimpleEntry<String, List<BankingUnit>>,
            AbstractMap.SimpleEntry<String, Double>> expenseOfCompany = pair -> new AbstractMap.SimpleEntry<>(
            pair.getKey(),
            FunctionalStuff.sumOfCollection(
                (List<Double>)map.apply(el ->((BankingUnit) el).getExpense()).apply(
                    pair.getValue()
                )
            )
    );

}
