package com.fq.controller;

import com.fq.constant.ClientExceptionConstant;
import com.fq.dto.in.AdministratorLoginInDTO;
import com.fq.dto.out.AdministratorLoginOutDTO;
import com.fq.pojo.Administrator;
import com.fq.service.AdministratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
