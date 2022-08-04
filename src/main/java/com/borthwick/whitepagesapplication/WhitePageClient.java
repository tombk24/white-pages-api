package com.borthwick.whitepagesapplication;

import java.net.Socket;

public class WhitePageClient {

    private Socket whitepagesSocket;

    public String sendNameRequest(String name){
        // If connection is alive, send the message.
        // On successful response, return message

        // If connection is alive, send the message.
        // On error response, throw InternalServerError

        // If the connection is dead, attempt to reconnect.
        // If fails, throw InternalServerError.

        throw new UnsupportedOperationException();
    }

    // sendPhoneRequest -> assumes there's two different entries in the third party! (eg. name/phone)
}
