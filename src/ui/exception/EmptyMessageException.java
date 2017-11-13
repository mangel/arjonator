package ui.exception;

/**
 *
 * @author mangel
 */
public class EmptyMessageException extends Exception {
    
    public EmptyMessageException(){
        
    }
    
    @Override
    public String toString(){
        return "ARJONATOR 3000 ERROR: Se ha enviado un mensaje sin texto. Arjonator considera que el campo de mensaje debe tener texto porque Arjonator no responde textos vacíos.";
    }
}
