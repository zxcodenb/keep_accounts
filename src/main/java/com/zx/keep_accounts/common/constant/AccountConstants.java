package com.zx.keep_accounts.common.constant;

/**
 * 账户记录相关常量类
 * 包含消费分类和收入类型常量
 */
public class AccountConstants {

    /**
     * 消费分类常量
     */
    public static final String CATEGORY_FOOD = "餐饮";
    public static final String CATEGORY_TRANSPORT = "交通";
    public static final String CATEGORY_SHOPPING = "购物";
    public static final String CATEGORY_ENTERTAINMENT = "娱乐";
    public static final String CATEGORY_MEDICAL = "医疗";
    public static final String CATEGORY_EDUCATION = "教育";
    public static final String CATEGORY_HOUSING = "住房";
    public static final String CATEGORY_UTILITIES = "水电";
    public static final String CATEGORY_COMMUNICATION = "通讯";
    public static final String CATEGORY_FINANCE = "金融";
    public static final String CATEGORY_OTHER = "其他";

    /**
     * 收入类型常量
     */
    public static final String INCOME_SALARY = "工资";
    public static final String INCOME_BONUS = "奖金";
    public static final String INCOME_INVESTMENT = "投资收益";
    public static final String INCOME_PART_TIME = "兼职";
    public static final String INCOME_OTHER = "其他";

    /**
     * 账户记录类型
     */
    public static final String RECORD_TYPE_EXPENSE = "0"; // 支出
    public static final String RECORD_TYPE_INCOME = "1";  // 收入
}