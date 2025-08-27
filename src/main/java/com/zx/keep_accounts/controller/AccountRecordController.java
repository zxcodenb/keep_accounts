package com.zx.keep_accounts.controller;

import com.zx.keep_accounts.common.core.controller.BaseController;
import com.zx.keep_accounts.common.core.domain.AjaxResult;
import com.zx.keep_accounts.common.core.page.TableDataInfo;
import com.zx.keep_accounts.entity.AccountRecord;
import com.zx.keep_accounts.service.AccountRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account_records")
public class AccountRecordController extends BaseController {



    @Autowired
    private AccountRecordService accountRecordService;

    /**
     * 添加支出/收入记录
     * @param accountRecord
     * @return
     */
    @PostMapping
    public AjaxResult add( @Validated @RequestBody AccountRecord accountRecord) {
        return accountRecordService.save(accountRecord) ? AjaxResult.success() : AjaxResult.error();
    }


    /**
     * 修改支出/收入记录
     * @param accountRecord
     * @return
     */
    @PutMapping
    public AjaxResult update(@RequestBody AccountRecord accountRecord) {
        return accountRecordService.updateById(accountRecord) ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 查询支出/收入记录列表
     * @param accountRecord
     * @return
     */
    @GetMapping("/list")
    public TableDataInfo list(AccountRecord accountRecord) {
        startPage();
        List<AccountRecord> list = accountRecordService.selectAccountRecordList(accountRecord);
        return getDataTable(list);
    }

    /**
     * 根据id查询支出/收入记录
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public AjaxResult getById(@PathVariable Long id) {
        return AjaxResult.success(accountRecordService.getById(id));
    }


}