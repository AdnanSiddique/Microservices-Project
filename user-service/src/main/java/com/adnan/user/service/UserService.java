package com.adnan.user.service;

import com.adnan.user.ValueObject.Department;
import com.adnan.user.ValueObject.ResponseTemplateVo;
import com.adnan.user.entity.User;
import com.adnan.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("inside saveUser method of UserRepository");
        return userRepository.save(user);
    }

    public ResponseTemplateVo getUserWithDepartment(Long userId) {
        log.info("inside getUserWithDepartment method of UserRepository");

        ResponseTemplateVo response = new ResponseTemplateVo();
        User user = userRepository.findByUserId(userId);

        log.info("inside getUserWithDepartment method of UserRepository getting Department");
        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);

        response.setUser(user);
        response.setDepartment(department);
        return response;
    }
}
