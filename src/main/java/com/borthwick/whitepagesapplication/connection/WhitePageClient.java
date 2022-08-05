package com.borthwick.whitepagesapplication.connection;

import java.net.Socket;

public class WhitePageClient {

    private Socket whitepagesSocket;

    private volatile State state;

    public enum State {
        IDLE, ERROR, RUNNING, STOPPED
    }

    public void start(){
        if(state != State.RUNNING) {
            // Open connection to socket
        }
    }

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
