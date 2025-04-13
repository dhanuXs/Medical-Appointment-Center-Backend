package lk.ijse.medical_appointment_bookig_backend.advicer;

public class RecourceNotFoundException {
    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

}
