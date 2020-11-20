package denilai.rtu;
//import javafx.util.Pair;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class FunctionalStuff {

    public static Double sumOfCollection(Collection<Double> a){
        Double[] value = new Double[1];
        value[0] = 0.0;
        a.forEach(el->value[0] = value[0] + el);
        return value[0];
    }

//    public static <F, T> List<T> map(Function<? super F,? extends T> transformer, Collection<F> from) {
//        ArrayList<T> result = new ArrayList<>();
//        for (F element : from)
//            result.add(transformer.apply(element));
//        return result;
//    }



    public static final Function<
            List<BankingUnit>,
            Function<
                    String, AbstractMap.SimpleEntry<String,List<BankingUnit> >>> filterByCompany =
            list -> comp -> {
                List<BankingUnit> filtered = new ArrayList<>();
                list.forEach(el -> {
                    if(el.getOrganization().equals(comp)) {
                        filtered.add(el);
                    }
                });
                return new AbstractMap.SimpleEntry<>(comp, filtered);
            };



}
