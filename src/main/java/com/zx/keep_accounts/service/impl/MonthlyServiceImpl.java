package com.zx.keep_accounts.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zx.keep_accounts.common.BusinessException;
import com.zx.keep_accounts.entity.MonthlyInfo;
import com.zx.keep_accounts.mapper.MonthlyInfoMapper;
import com.zx.keep_accounts.service.AccountRecordService;
import com.zx.keep_accounts.service.MonthlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class MonthlyServiceImpl extends ServiceImpl<MonthlyInfoMapper, MonthlyInfo> implements MonthlyService {

    @Autowired
    private AccountRecordService accountRecordService;

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
//            throw new BusinessException("该月份的记录已存在");
        }
        monthlyInfo.setUpdateTime(DateUtil.date());
        monthlyInfo.setMonthlyBalance(monthlyInfo.getMonthBudget());
        this.save(monthlyInfo);
    }

    @Override
    public MonthlyInfo getMonthlySummary(int year, int month) {
        QueryWrapper<MonthlyInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply("YEAR(create_time) = {0}", year)
                .apply("MONTH(create_time) = {0}", month);
        MonthlyInfo monthlyInfo = this.getOne(queryWrapper);

        if (monthlyInfo != null) {
            BigDecimal totalExpenditure = accountRecordService.calculateTotalExpenditureByMonth(year, month);
            monthlyInfo.setTotalExpenditure(totalExpenditure);
        }

        return monthlyInfo;
    }
}