class TableAlreadyBookedException extends Exception {
    public TableAlreadyBookedException(String message) { super(message); }
}

class TableNotFoundException extends Exception {
    public TableNotFoundException(String message) { super(message); }
}

class MenuItemNotFoundException extends Exception {
    public MenuItemNotFoundException(String message) { super(message); }
}

class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(String message) { super(message); }
}