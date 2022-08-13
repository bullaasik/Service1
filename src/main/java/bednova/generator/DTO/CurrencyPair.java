package bednova.generator.DTO;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;


@Data
public class CurrencyPair {
    private CurrencyPairsChange title;
    private Queue<PriceValue> HistoryOfValues;

    public Queue<PriceValue> getHistoryOfValues() {
        return HistoryOfValues;
    }

    public void setHistoryOfValues(Queue<PriceValue> historyOfValues) {
        HistoryOfValues = historyOfValues;
    }

    public CurrencyPair(CurrencyPairsChange title) {
        this.title = title;
        HistoryOfValues = new LinkedList<>();
    }

    public void addValueIntoPriceHistory() {
        double price = title.getValueOfCurrencyPair();
        long id = title.getId();
        LocalDateTime date = LocalDateTime.now();

        if (HistoryOfValues.size() == 100) {
            HistoryOfValues.poll();
        }

        HistoryOfValues.add(new PriceValue(id, price, date));
    }

    @Data
    public class PriceValue {
        private long Id;
        private double Value;
        private LocalDateTime Date;

        public PriceValue(long id, double Value, LocalDateTime date) {
            this.Id = id;
            this.Value = Value;
            this.Date = date;
        }
    }
}
