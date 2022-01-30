package com.adnan.user.ValueObject;

import com.adnan.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateVo {
    private User user;
    private Department department;
}
