package com.zx.keep_accounts.controller;

import com.zx.keep_accounts.common.core.controller.BaseController;
import com.zx.keep_accounts.common.core.domain.AjaxResult;
import com.zx.keep_accounts.entity.MonthlyInfo;
import com.zx.keep_accounts.service.MonthlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/monthly")
public class MonthlyController extends BaseController {

    @Autowired
    private MonthlyService monthlyService;

    /**
     *add
     */
    @PostMapping
    public AjaxResult add(@RequestBody MonthlyInfo monthlyInfo){
        monthlyService.add(monthlyInfo);
        return AjaxResult.success();
    }

}
