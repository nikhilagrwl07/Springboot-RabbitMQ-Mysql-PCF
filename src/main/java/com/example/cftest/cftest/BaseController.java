package com.example.cftest.cftest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    private final ApplicationRepository applicationRepository;
    private final MessageProducer messageProducer;

    public BaseController(ApplicationRepository applicationRepository, MessageProducer messageProducer) {
        this.applicationRepository = applicationRepository;
        this.messageProducer = messageProducer;
    }


    @GetMapping(value = "/greet/{name}")
    public String elements(@PathVariable String name) {
        return "Hello " + name + " from Cloud Foundry!";
    }

    @GetMapping(value = "/app/{name}")
    public ResponseEntity<Application> applicationData(@PathVariable String name) {

        Application application = applicationRepository.findByName(name);
        return ResponseEntity.ok().body(application);
    }

    @GetMapping(value = "/rabbitmq/producer")
    public void testRabbitTopic(@RequestParam("empName") String empName, @RequestParam("empId") String empId) {

        EmployeeMessage emp=new EmployeeMessage(empId, empName);

        messageProducer.sendFirstMessage(emp);
        messageProducer.sendSecondMessage(emp);
    }
}
