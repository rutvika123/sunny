CODE -

import java.util.Scanner;

class TokenRing {
    private int numProcesses;
    private int tokenHolder;
    private Scanner scanner;

    public TokenRing(int numProcesses) {
        this.numProcesses = numProcesses;
        this.tokenHolder = 0; // Initially, Process 0 holds the token
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            for (int i = 0; i < numProcesses; i++) {
                tokenHolder = i;
                System.out.println("\nToken is currently with Process " + tokenHolder);
                System.out.print("Process " + tokenHolder + ", do you want the token? (yes/no): ");
                String response = scanner.next().toLowerCase();
                
                if (response.equals("yes")) {
                    enterCriticalSection();
                } else {
                    System.out.println("Process " + tokenHolder + " passed the token to the next process.");
                }
            }
        }
    }

    private void enterCriticalSection() {
        System.out.println("Process " + tokenHolder + " is now in the Critical Section.");
        try {
            Thread.sleep(2000); // Simulate critical section execution
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Process " + tokenHolder + " has exited the Critical Section.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of processes in the ring: ");
        int numProcesses = scanner.nextInt();

        TokenRing ring = new TokenRing(numProcesses);
        ring.start();
    }
}


