package com.jb.couponsystemp3.beans;

import com.jb.couponsystemp3.security.ClientType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginParams {

    private String email;
    private String password;
    private ClientType clientType;
}
