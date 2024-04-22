package main.java.com.ayiGroup.GolosinasApp.model;



import java.io.Serializable;



public class ExceptionDetail implements Serializable {

    public enum CodigoError {
        CAMBIO_ESTADO_INVALIDO(1, "Cambio de estado no válido"), // -
        
        USUARIO_INVALIDO(146, "Usuario no válido.");

        private int code;
        private String message;

        CodigoError(int code, String texto) {
            this.code = code;
            this.message = texto;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

 
   


    

  

    public ExceptionDetail() {
    }

    

  

}

 

