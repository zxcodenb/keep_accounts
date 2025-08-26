package com.zx.keep_accounts.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zx.keep_accounts.entity.MonthlyInfo;

public interface MonthlyService extends IService<MonthlyInfo> {
    void add(MonthlyInfo monthlyInfo);
}
