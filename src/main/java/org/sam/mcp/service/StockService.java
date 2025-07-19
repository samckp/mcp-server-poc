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
        return stocks;
    }


    @PostConstruct
    public void init() {
        stocks.addAll(List.of(
                new Stocks("AAPL", "Apple Inc.", "NASDAQ", 150.00),
                new Stocks("GOOGL", "Alphabet Inc.", "NASDAQ", 2800.00),
                new Stocks("AMZN", "Amazon.com Inc.", "NASDAQ", 3400.00),
                new Stocks("MSFT", "Microsoft Corporation", "NASDAQ", 299.00),
                new Stocks("TSLA", "Tesla Inc.", "NASDAQ", 700.00)
        ));
    }

}
