package com.zx.keep_accounts.tools;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zx.keep_accounts.entity.AccountRecord;
import com.zx.keep_accounts.service.AccountRecordService;
import dev.langchain4j.agent.tool.Tool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class AccountsTool {

    private final AccountRecordService acService;

    public AccountsTool(AccountRecordService acService) {
        this.acService = acService;
    }

    @Tool(name = "添加账单记录" , value = "根据用户的描述，添加一条账单记录")
    public void add(AccountRecord ac){
        log.info("添加账单记录: {}", ac);
        acService.save(ac);
    }

    @Tool("用户查询账单记录")
    public List<AccountRecord> list(AccountRecord ac){

        QueryWrapper<AccountRecord> queryWrapper = new QueryWrapper<>();
        if (ac != null) {
            if (ac.getType() != null && !ac.getType().isEmpty()) {
                queryWrapper.eq("type", ac.getType());
            }
            if (ac.getCategory() != null && !ac.getCategory().isEmpty()) {
                queryWrapper.like("category", ac.getCategory());
            }
        }

        return acService.list();
    }

}
