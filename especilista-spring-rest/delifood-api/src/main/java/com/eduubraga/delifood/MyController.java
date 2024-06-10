package com.eduubraga.delifood;

import com.eduubraga.delifood.model.Client;
import com.eduubraga.delifood.service.ClientActivationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    private final ClientActivationService clientActivationService;

    public MyController(ClientActivationService clientActivationService) {
        this.clientActivationService = clientActivationService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        Client eduardo = new Client("dudu@gmail.com", "Eduardo Braga", "85992929292");

        clientActivationService.activate(eduardo);

        return "Hello World!";
    }

}
