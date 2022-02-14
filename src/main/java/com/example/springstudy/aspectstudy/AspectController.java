package com.example.springstudy.aspectstudy;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AspectController {

    private final AspectStudyService aspectStudyService;

    @GetMapping("/aspect/around")
    public String testAspectFunction() {
        aspectStudyService.testAround();

        return "OK";
    }

}
