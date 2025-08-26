package com.zx.keep_accounts.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zx.keep_accounts.entity.AccountRecord;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRecordService extends IService<AccountRecord> {
    Boolean setMonthBudget(BigDecimal monthBudget);

    List<AccountRecord> selectAccountRecordList(AccountRecord accountRecord);
}
