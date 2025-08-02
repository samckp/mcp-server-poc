package org.sam.mcp.service;

import jakarta.annotation.PostConstruct;
import org.sam.mcp.model.Stocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    private static final Logger log = LoggerFactory.getLogger(StockService.class);
    private final List<Stocks> stocks = new ArrayList<>();


    @Tool(name = "get_stocks", description = "Get a list of stocks from List")
    public List<Stocks> getCourses() {
        System.out.println("get_stocks : "+ stocks);
        return stocks;
    }


    @PostConstruct
    public void init() {
        stocks.addAll(List.of(
                new Stocks("AAPL", "Apple Inc.", "NASDAQ", 150.00),
                new Stocks("GOOGL", "Alphabet Inc.", "NASDAQ", 2800.00),
                new Stocks("AMZN", "Amazon.com Inc.", "NASDAQ", 3400.00),
                new Stocks("MSFT", "Microsoft Corporation", "NASDAQ", 299.00),
                new Stocks("TSLA", "Tesla Inc.", "NASDAQ", 700.00),
                new Stocks("FB", "Facebook Inc.", "NASDAQ", 300.00),
                new Stocks("NVDA", "Nvidia Corporation", "NASDAQ", 600.00),
                new Stocks("JPM", "JPMorgan Chase & Co.", "NASDAQ", 150.00),
                new Stocks("BRK.B", "Berkshire Hathaway Inc.", "NASDAQ", 300.00),
                new Stocks("MA", "Mastercard Incorporated", "NASDAQ", 300.00),
                new Stocks("V", "Visa Inc.", "NASDAQ", 300.00)
        ));
    }
}
