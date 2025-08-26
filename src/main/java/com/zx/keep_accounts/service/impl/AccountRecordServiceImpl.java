package com.zx.keep_accounts.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zx.keep_accounts.entity.AccountRecord;
import com.zx.keep_accounts.mapper.AccountRecordMapper;
import com.zx.keep_accounts.service.AccountRecordService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountRecordServiceImpl extends ServiceImpl<AccountRecordMapper, AccountRecord> implements AccountRecordService {

    @Override
    public Boolean setMonthBudget(BigDecimal monthBudget) {
        if (monthBudget != null && monthBudget.compareTo(BigDecimal.ZERO) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<AccountRecord> selectAccountRecordList(AccountRecord accountRecord) {
        QueryWrapper<AccountRecord> queryWrapper = new QueryWrapper<>();
        if (accountRecord != null) {
            if (StringUtils.hasText(accountRecord.getType())) {
                queryWrapper.eq("type", accountRecord.getType());
            }
            if (StringUtils.hasText(accountRecord.getCategory())) {
                queryWrapper.like("category", accountRecord.getCategory());
            }
        }
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public BigDecimal calculateTotalExpenditureByMonth(int year, int month) {
        return baseMapper.calculateTotalExpenditureByMonth(year, month);
    }
}
