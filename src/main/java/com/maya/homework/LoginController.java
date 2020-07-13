package com.maya.homework;

import com.maya.homework.models.requests.LoginForm;
import com.maya.homework.models.responses.LoginResponse;
import com.maya.homework.services.ApiService;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public ResponseEntity<Object> loginPost(@RequestBody LoginForm loginForm) throws JSONException {

        ApiService service = new ApiService();
        LoginResponse loginService = service.login(loginForm);

        return ResponseEntity.status(loginService.getStatus()).body(loginService);
    }
}
