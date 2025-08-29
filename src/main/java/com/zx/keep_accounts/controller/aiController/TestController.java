package com.zx.keep_accounts.controller.aiController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    private final ChatClient chatClient;

    public TestController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "msg", defaultValue = "讲一个笑话") String msg) {
        log.info("msg: {}", msg);
        String content = chatClient.prompt(msg).call().content();
        log.info("content: {}", content);
        return content;

    }

}
