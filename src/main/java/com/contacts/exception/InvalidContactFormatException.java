package com.contacts.exception;

public class InvalidContactFormatException extends Exception {
    private static final long serialVersionUID = -2354142805348547727L;

    /**
     *  Takes in a message and throws a InvalidContactFormatException.
     * @param message message to use during logging.
     */
    public InvalidContactFormatException(String message) {
        super(message);
    }
}
