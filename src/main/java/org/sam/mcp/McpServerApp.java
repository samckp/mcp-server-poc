package org.sam.mcp;

import org.sam.mcp.service.StockService;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class McpServerApp {

	public static void main(String[] args) {
		SpringApplication.run(McpServerApp.class, args);
	}

	@Bean
	public List<ToolCallback> tools(StockService stockService) {
		return List.of(ToolCallbacks.from(stockService));
	}

}
