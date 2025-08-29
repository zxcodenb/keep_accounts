package com.zx.keep_accounts.controller.aiController;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.spring.AiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class LowlevelController {

    private final ChatModel chatModel;

    public LowlevelController(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/model")
    public String model(@RequestParam(value = "message", defaultValue = "Hello") String message) {

        return chatModel.chat(message);
    }
}
