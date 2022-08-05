package com.borthwick.whitepagesapplication.service;

import com.borthwick.whitepagesapplication.connection.WhitePageClient;
import com.borthwick.whitepagesapplication.exception.WhitepagesException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WhitePagesService {

    private final WhitePageClient whitePageClient;

    public String getPhoneNumber(String name) {
        try {
            /* TODO: Assumes on empty response from third party, it will just return an empty string,
                but hopefully their docs would tell us if not!
             */

            return whitePageClient.sendNameRequest(name);
        } catch (Exception e) {

            throw new WhitepagesException("Something went wrong whilst requesting to third party.");
        }
    }

    // TODO: getName(String phoneNumber)
}
