package com.zx.keep_accounts.controller;

import com.zx.keep_accounts.common.constant.AccountConstants;
import com.zx.keep_accounts.common.core.controller.BaseController;
import com.zx.keep_accounts.common.core.domain.AjaxResult;
import com.zx.keep_accounts.common.core.page.TableDataInfo;
import com.zx.keep_accounts.entity.AccountRecord;
import com.zx.keep_accounts.service.AccountRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/account_records")
public class AccountRecordController extends BaseController {



    @Autowired
    private AccountRecordService accountRecordService;

    @PostMapping
    public AjaxResult add( @Validated @RequestBody AccountRecord accountRecord) {
        return accountRecordService.save(accountRecord) ? AjaxResult.success() : AjaxResult.error();
    }


    @PutMapping
    public AjaxResult update(@RequestBody AccountRecord accountRecord) {
        return accountRecordService.updateById(accountRecord) ? AjaxResult.success() : AjaxResult.error();
    }

    @GetMapping("/list")
    public TableDataInfo list(AccountRecord accountRecord) {
        startPage();
        List<AccountRecord> list = accountRecordService.selectAccountRecordList(accountRecord);
        return getDataTable(list);
    }

    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        return AjaxResult.success(accountRecordService.getById(id));
    }


}