package com.zx.keep_accounts.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("account_record")
public class AccountRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 金额
     */
    @NotNull(message = "金额不能为空")
    @TableField(value = "amount")
    private BigDecimal amount;

    /**
     * 0:支出 1:收入
     */
    @NotNull(message = "类型不能为空")
    @TableField(value = "type")
    private String type;

    /**
     * 分类
     */
    @NotNull(message = "分类不能为空")
    @TableField(value = "category")
    private String category;

    /**
     * 支出描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 支出/收入时间
     */
    @NotNull(message = "时间不能为空")
    @TableField(value = "record_date")
    private LocalDateTime recordDate;

    /**
     * 删除标识
     */
    @TableLogic
    @TableField(value = "deleted")
    private String deleted;
}