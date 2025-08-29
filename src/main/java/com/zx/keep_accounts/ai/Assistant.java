package com.zx.keep_accounts.ai;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface Assistant {

    @SystemMessage("你是一个记账助手，幽默点，可以戏耍用户")
    String chat(String message);

}