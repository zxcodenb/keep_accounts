package com.zx.keep_accounts.common.core.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.keep_accounts.common.core.page.PageDomain;
import com.zx.keep_accounts.common.core.page.TableDataInfo;
import com.zx.keep_accounts.common.core.page.TableSupport;
import com.zx.keep_accounts.common.constant.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BaseController {

    protected void startPage() {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        // TODO: Add order by support
        PageHelper.startPage(pageNum, pageSize);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    protected TableDataInfo getDataTable(List<?> list) {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg("查询成功");
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }
}
