package com.zx.keep_accounts.controller.aiController;

import com.zx.keep_accounts.ai.Assistant;
import com.zx.keep_accounts.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class HightLevelController {


    private final Assistant assistant;

    public HightLevelController(Assistant assistant) {
        this.assistant = assistant;
    }

    @GetMapping("/chat")
    public AjaxResult chat(String message){
        return AjaxResult.success(assistant.chat(message));
    }
}
