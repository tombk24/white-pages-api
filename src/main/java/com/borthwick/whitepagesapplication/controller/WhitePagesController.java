package com.borthwick.whitepagesapplication.controller;

import com.borthwick.whitepagesapplication.service.WhitePagesService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/API/v1/whitePages")
@AllArgsConstructor
@Log4j2
public class WhitePagesController {

    private final WhitePagesService whitePagesService;

    @GetMapping(path = "/phone")
    ResponseEntity<String> getPhoneNumber(@RequestParam String name){
        if(name.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            var phoneNumber = whitePagesService.getPhoneNumber(name);

            if(phoneNumber.isEmpty()){
                return new ResponseEntity<>("No results found.", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(phoneNumber, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: Catching generic exception is bad practice, should be more specific.
            log.error("Unable to process request", e);

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/name")
    ResponseEntity<String> getName(@RequestParam String phone){
        throw new UnsupportedOperationException("getName feature not yet implemented");
    }
}
