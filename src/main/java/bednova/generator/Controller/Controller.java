package bednova.generator.Controller;

import bednova.generator.DTO.CurrencyPair;
import bednova.generator.Service.Service;
import bednova.generator.DTO.CurrencyPair.PriceValue;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Queue;

@RestController
@RequestMapping(value = "/")
public class Controller {
    private final String[] PairsUsed = {"USDRUB", "EURRUB", "EURUSD"};
    private Service service;

    @GetMapping(value = "/pair")
    public String[] getAvailablePairs() {
        return PairsUsed;
    }

    @GetMapping(value = "/pair/{pairTitle}")
    public CurrencyPair getCurrencyPairByTitle(@PathVariable String pairTitle) {
        return service.getPairByTitle(pairTitle);
    }

    @GetMapping(value = "/pair/HistoryOfValues")
    public Queue<CurrencyPair.PriceValue> HistoryOfValues(){
        return HistoryOfValues();
    }

    //@PostMapping(value = "/pair/")


    @Autowired
    public void setService(Service service) {
        this.service = service;
    }
}
