package com.zx.keep_accounts.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zx.keep_accounts.entity.AccountRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Date;

@Mapper
public interface AccountRecordMapper extends BaseMapper<AccountRecord> {
    BigDecimal calculateTotalExpenditureByMonth(@Param("year") int year, @Param("month") int month);
}
