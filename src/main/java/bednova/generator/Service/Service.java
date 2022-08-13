package bednova.generator.Service;

import org.springframework.scheduling.annotation.Scheduled;
import bednova.generator.DTO.CurrencyPair;
import bednova.generator.DTO.CurrencyPairsChange;

import java.util.LinkedList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private final List<CurrencyPair> Pairs = new LinkedList<>(){{
        add(new CurrencyPair(CurrencyPairsChange.USDRUB));
        add(new CurrencyPair(CurrencyPairsChange.EURRUB));
        add(new CurrencyPair(CurrencyPairsChange.EURUSD));
    }};

    @Scheduled(fixedDelay = 800)
    public void updateInfoAboutPrice() {
        Pairs.forEach(CurrencyPair::addValueIntoPriceHistory);
    }

    public CurrencyPair getPairByTitle(String title) {
        return Pairs.stream()
                .filter(pair -> pair.getTitle().equals(CurrencyPairsChange.valueOf(title.trim())))
                .findFirst()
                .orElseThrow();
    }
}
