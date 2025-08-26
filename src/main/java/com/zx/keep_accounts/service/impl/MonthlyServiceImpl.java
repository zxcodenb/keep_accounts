package com.zx.keep_accounts.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.exceptions.ExceptionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zx.keep_accounts.entity.MonthlyInfo;
import com.zx.keep_accounts.mapper.MonthlyInfoMapper;
import com.zx.keep_accounts.service.MonthlyService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MonthlyServiceImpl extends ServiceImpl<MonthlyInfoMapper, MonthlyInfo> implements MonthlyService {

    @Override
    public void add(MonthlyInfo monthlyInfo) {
        Date dateToUse = monthlyInfo.getCreateTime();
        if (dateToUse == null) {
            dateToUse = DateUtil.date();
            monthlyInfo.setCreateTime(dateToUse);
        }

        int year = DateUtil.year(dateToUse);
        int month = DateUtil.month(dateToUse) + 1;

        QueryWrapper<MonthlyInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply("YEAR(create_time) = {0}", year)
                .apply("MONTH(create_time) = {0}", month);

        if (this.count(queryWrapper) > 0) {
            throw ExceptionUtil.wrapRuntime("已创建该月预算");
        }
        monthlyInfo.setUpdateTime(DateUtil.date());
        monthlyInfo.setMonthlyBalance(monthlyInfo.getMonthBudget());
        this.save(monthlyInfo);
    }
}