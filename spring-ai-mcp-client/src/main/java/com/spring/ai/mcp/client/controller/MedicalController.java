package com.spring.ai.mcp.client.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicalController {
    private final ChatClient chatClient;


    public MedicalController(ChatClient.Builder chat, ToolCallbackProvider toolCallbackProvider) {
        this.chatClient = chat.defaultTools(toolCallbackProvider)
                .build();
    }


    @GetMapping("/patient")
    public String getPatientInfo(@RequestParam("q") String name) {
        PromptTemplate pt = new PromptTemplate(name);
        return this.chatClient.prompt(pt.create())
                .call()
                .content();
    }

/*    @GetMapping("/patient")
    public CompletableFuture<String> getPatientInfo(@RequestParam("q") String name) {
        return CompletableFuture.supplyAsync(() -> {
            PromptTemplate pt = new PromptTemplate(name);
            return this.chatClient.prompt(pt.create())
                    .call()
                    .content();
        });
    }*/
}
