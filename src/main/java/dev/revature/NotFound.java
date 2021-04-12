package dev.revature;

public class NotFound extends Exception{
    public NotFound(){
        super();
    }

    public NotFound(String message){
        super(message);
    }
}
