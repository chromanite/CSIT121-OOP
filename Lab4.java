import java.util.Scanner;

class InvalidHrException extends Exception {
    private String message;

    public InvalidHrException() {
    }

    public InvalidHrException(String str) {
        this.message = str;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}

class InvalidMinException extends Exception {
    private String message;

    public InvalidMinException() {
    }

    public InvalidMinException(String str) {
        this.message = str;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}

class InvalidSecException extends Exception {
    private String message;

    public InvalidSecException() {
    }

    public InvalidSecException(String str) {
        this.message = str;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}

public class Lab4 {
    static Scanner console = new Scanner(System.in);

    public static int getHours() throws InvalidHrException {
        InvalidHrException ihe = new InvalidHrException("The value of hours must be between 0 and 12");
        int hr;

        try {
            System.out.print("Enter hours: ");
            hr = console.nextInt();

            if (hr < 0 || hr > 12) {
                throw ihe;
            }

        } catch (InvalidHrException e) {
            console.nextLine();
            throw ihe;
        }
        return hr;
    }

    public static int getMinutes() throws InvalidMinException {
        InvalidMinException ime = new InvalidMinException("The value of minutes must be between 0 and 60");
        int min;

        try {
            System.out.print("Enter minutes: ");
            min = console.nextInt();
            
            if (min < 0 || min > 59) {

                throw ime;
            }

        } catch (InvalidMinException e) {
            console.nextLine();
            throw ime;
        }
        return min;
    }

    public static int getSeconds() throws InvalidSecException {
        InvalidSecException ise = new InvalidSecException("The value of seconds must be between 0 and 60");
        int sec;

        try {
            System.out.print("Enter seconds: ");
            sec = console.nextInt();
            if (sec < 0 || sec > 59) {
                throw ise;
            }

        } catch (InvalidSecException e) {
            console.nextLine();
            throw ise;
        }
        return sec;
    }

    public static void print24HourTime(int hr, int min, int sec, String str) {
        if (str.equalsIgnoreCase("am") && (hr == 12)) {
            hr = 0;
        } else if (str.equalsIgnoreCase("pm") && (hr >= 0 && hr <= 11)) {
            hr += 12;
        }
        
        System.out.printf("\n24 hour clock time: %02d:%02d:%02d", hr, min, sec);
    }

    public static void main(String[] args) throws InvalidHrException, InvalidMinException, InvalidSecException {
        int hr = -1;
        int min = -1;
        int sec = -1;

        while (hr < 0 || min < 0 || sec < 0) {
            try {
                if (hr < 0) {
                    hr = getHours();
                } else if (min < 0) {
                    min = getMinutes();
                } else if (sec < 0) {
                    sec = getSeconds();
                }
            } catch (InvalidHrException | InvalidMinException | InvalidSecException e) {
                System.err.println(e);
            }
        }
        System.out.print("Enter AM or PM: ");
        String ampm = console.next();

        print24HourTime(hr, min, sec, ampm);
    }
}