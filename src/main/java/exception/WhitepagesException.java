package exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WhitepagesException extends RuntimeException{

    public WhitepagesException(String message) { super(message); }
}
