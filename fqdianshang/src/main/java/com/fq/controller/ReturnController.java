package com.fq.controller;

import com.fq.dto.in.ReturnApplyInDTO;
import com.fq.dto.out.PageOut;
import com.fq.dto.out.ReturnHistoryListOutDTO;
import com.fq.dto.out.ReturnListOutDTO;
import com.fq.dto.out.ReturnShowOutDTO;
import com.fq.enumeration.ReturnStatus;
import com.fq.pojo.Return;
import com.fq.pojo.ReturnHistory;
import com.fq.service.ResturnHistoryService;
import com.fq.service.ResturnService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/return")
@CrossOrigin
public class ReturnController {
    @Autowired
    ResturnService resturnService;
    @Autowired
    ResturnHistoryService resturnHistoryService;

    @PostMapping("/apply")
    public Integer apply(@RequestBody ReturnApplyInDTO returnApplyInDTO,@RequestAttribute Integer customerId){
        Return aReturn=new Return();
        aReturn.setOrderId(returnApplyInDTO.getOrderId());
        aReturn.setOrderTime(new returnApplyInDTO.getOrderTimestamp());
        aReturn.setCustomerId(customerId);
        aReturn.setCustomerName(returnApplyInDTO.getCustomerName());
        aReturn.setMobile(returnApplyInDTO.getMobile());
        aReturn.setEmail(returnApplyInDTO.getEmail());
        aReturn.setStatus((byte) ReturnStatus.ToProcess.ordinal());
        aReturn.setProductCode(returnApplyInDTO.getProductCode());
        aReturn.setProductName(returnApplyInDTO.getProductName());
        aReturn.setQuantity(returnApplyInDTO.getQuantity());
        aReturn.setReason(returnApplyInDTO.getReason());
        aReturn.setOpened(returnApplyInDTO.getOpened());
        aReturn.setComment(returnApplyInDTO.getComment());

        Date now=new Date();
        aReturn.setCreateTime(now);
        aReturn.setUpdateTime(now);
        resturnService.create(aReturn);
        Integer returnId=aReturn.getReturnId();
        return returnId;

    }
    @GetMapping("/getList")
    public PageOut<ReturnListOutDTO> getList(@RequestAttribute Integer customerId,
                                             @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<Return> page=resturnService.getPageByCustomerId(customerId,pageNum);
        List<ReturnListOutDTO> returnListOutDTOS=page.stream().map(aReturn -> {
            ReturnListOutDTO returnListOutDTO=new ReturnListOutDTO();
            returnListOutDTO.setReturnId(aReturn.getReturnId());
            returnListOutDTO.setOrderId(aReturn.getOrderId());
            returnListOutDTO.setCustomerId(aReturn.getCustomerId());
            returnListOutDTO.setCustomerName(aReturn.getCustomerName());
            returnListOutDTO.setStatus(aReturn.getStatus());
            returnListOutDTO.setCreateTimestamp(aReturn.getCreateTime().getTime());
            return returnListOutDTO;
        }).collect(Collectors.toList());

        PageOut<ReturnListOutDTO> pageOut=new PageOut<>();
        pageOut.setTotal((int) page.getTotal());
        pageOut.setPageSize(page.getPageSize());
        pageOut.setPageNum(page.getPageNum());
        pageOut.setList(returnListOutDTOS);
        return pageOut;

    }
    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        Return aReturn=resturnService.getById(returnId);

        ReturnShowOutDTO returnShowOutDTO=new ReturnShowOutDTO();
        returnShowOutDTO.setReturnId(aReturn.getReturnId());
        returnShowOutDTO.setOrderId(aReturn.getOrderId());
        returnShowOutDTO.setOrderTimestamp(aReturn.getOrderTime().getTime());
        returnShowOutDTO.setCustomerName(aReturn.getCustomerName());
        returnShowOutDTO.setMobile(aReturn.getMobile());
        returnShowOutDTO.setEmail(aReturn.getEmail());
        returnShowOutDTO.setStatus(aReturn.getStatus());
        returnShowOutDTO.setAction(aReturn.getReturnAction());
        returnShowOutDTO.setProductCode(aReturn.getProductCode());
        returnShowOutDTO.setProductName(aReturn.getProductName());
        returnShowOutDTO.setQuantity(aReturn.getQuantity());
        returnShowOutDTO.setReason(aReturn.getReason());
        returnShowOutDTO.setComment(aReturn.getComment());
        returnShowOutDTO.setOpened(aReturn.getOpened());
        returnShowOutDTO.setCreateTimestamp(aReturn.getCreateTime().getTime());
        returnShowOutDTO.setUpdateTimestamp(aReturn.getUpdateTime().getTime());

        List<ReturnHistory> returnHistories=resturnHistoryService.getByReturnId(returnId);
        List<ReturnHistoryListOutDTO> returnHistoryListOutDTOS=returnHistories.stream().map(returnHistory -> {
            ReturnHistoryListOutDTO returnHistoryListOutDTO=new ReturnHistoryListOutDTO();
            returnHistoryListOutDTO.setTimestamp(returnHistory.getTime().getTime());
            returnHistoryListOutDTO.setReturnStatus(returnHistory.getReturnStatus());
            returnHistoryListOutDTO.setComment(returnHistory.getComment());
            return returnHistoryListOutDTO;
        }).collect(Collectors.toList());
        returnShowOutDTO.setReturnHistories(returnHistoryListOutDTOS);
        return returnShowOutDTO;
    }
    @PostMapping("/cancel")
    public void cancel(@RequestBody Integer returnId){

    }
}
