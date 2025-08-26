package com.zx.keep_accounts.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@TableName("monthly_info")
@Data
public class MonthlyInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private BigDecimal monthBudget;

    private BigDecimal monthlyBalance;

    private Date createTime;

    private Date updateTime;

    private String remark;

    @TableField(exist = false)
    private BigDecimal totalExpenditure;

}