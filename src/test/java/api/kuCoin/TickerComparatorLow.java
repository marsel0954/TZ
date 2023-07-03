package api.kuCoin;

import java.util.Comparator;

public class TickerComparatorLow implements Comparator<PojoTickerData> {

    @Override
    public int compare(PojoTickerData o1, PojoTickerData o2) {
        float result = Float.compare(Float.parseFloat(o1.getChangeRate()), Float.parseFloat(o2.getChangeRate()));
        return (int) result;
    }
}
