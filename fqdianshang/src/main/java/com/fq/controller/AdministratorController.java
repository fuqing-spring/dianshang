package com.fq.controller;

import com.fq.constant.ClientExceptionConstant;
import com.fq.dto.in.AdministratorLoginInDTO;
import com.fq.dto.in.AdministratorUpdateProfileInDTO;
import com.fq.dto.out.AdministratorGetProfileOutDTO;
import com.fq.dto.out.AdministratorListOutDTO;
import com.fq.dto.out.AdministratorLoginOutDTO;
import com.fq.dto.out.PageOut;
import com.fq.pojo.Administrator;
import com.fq.service.AdministratorService;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/administratorController")
public class AdministratorController {
    @Autowired
    AdministratorService administratorService;

    @GetMapping("/login")
    public AdministratorLoginOutDTO login(AdministratorLoginOutDTO administratorLoginOutDTO) throws ClientException{
        Administrator administrator=administratorService.getByUsername(administratorLoginOutDTO.getUsername);
        if (administrator==null){
            throw new ClientException(ClientExceptionConstant.ADMINISTRATOR_USERNAME_NOT_EXIST_ERRCODE,ClientExceptionConstant.ADMINISTRATOR_USERNAME_NOT_EXIST_ERRMSG);

        }
        String encPwdDB=administrator.getEncryptedPassword();
        BCrypt.Result result=BCrypt.verifyer().verify(AdministratorLoginInDTO.getPassword().toCharArray(), encPwdDB);
        if (result.verified){
            AdministratorLoginOutDTO administratorLoginOutDTO1=jwtUtil.issueToken(administrator);

        }else {
            throw new ClientException(ClientExceptionConstant.ADNINISTRATOR_PASSWORD_INVALID_ERRCODE,ClientExceptionConstant.ADNINISTRATOR_PASSWORD_INVALID_ERRMSG);
        }
        return administratorLoginOutDTO;
    }
    @GetMapping("/getProfile")
    public AdministratorGetProfileOutDTO getProfile(@RequestParam(required = false) Integer administratorId){
        Administrator administrator=administratorService.getById(administratorId);
        AdministratorGetProfileOutDTO administratorGetProfileOutDTO = new AdministratorGetProfileOutDTO();
        administratorGetProfileOutDTO.setAdministratorId(administrator.getAdministratorId());
        administratorGetProfileOutDTO.setUsername(administrator.getUserName());
        administratorGetProfileOutDTO.setRealName(administrator.getRealName());
        administratorGetProfileOutDTO.setEmail(administrator.getEmail());
        administratorGetProfileOutDTO.setAvatarUrl(administrator.getAvatarUrl());
        administratorGetProfileOutDTO.setCreateTimestamp(administrator.getCreateTime().getTime());
        return administratorGetProfileOutDTO;

    }
    @PostMapping("/updateProfile")
    public void updateProfile(@RequestAttribute Integer administratorId, @RequestBody AdministratorUpdateProfileInDTO administratorUpdateProfileInDTO){
        Administrator administrator=new Administrator();
        administrator.setAdministratorId(administratorId);
        administrator.setRealName(administratorUpdateProfileInDTO.getRealName());
        administrator.setEmail(administratorUpdateProfileInDTO.getEmail());
        administrator.setAvatarUrl(administratorUpdateProfileInDTO.getAvatarUrl());
        administratorService.update(administrator);
    }

    @GetMapping("/getList")
    public PageOut<AdministratorListOutDTO> getList(@RequestParam(required = false,defaultValue = "1")Integer pageNum){
        Page<Administrator> page=administratorService.getList(pageNum);
        List<AdministratorListOutDTO> administratorListOutDTOS=page.stream().map(administrator -> {
            AdministratorListOutDTO administratorListOutDTO=new AdministratorListOutDTO();
            administratorListOutDTO.setAdministratorId(administrator.getAdministratorId());
            administratorListOutDTO.setUsername(administrator.getUserName());
            administratorListOutDTO.setRealName(administrator.getRealName());
            administratorListOutDTO.setStatus(administrator.getStatus());
            administratorListOutDTO.setCreateTimestamp(administrator.getCreateTime().getTime());
            return administratorListOutDTO;
        }).collect(Collectors.toList());
        PageOut<AdministratorListOutDTO> pageOut=new PageOut<>();
        pageOut.setTotal((int) page.getTotal());
        pageOut.setPageSize(page.getPageSize());
        pageOut.setPageNum(page.getPageNum());
        pageOut.setList(administratorListOutDTOS);
        return pageOut;
    }


}
