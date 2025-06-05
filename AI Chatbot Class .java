import java.util.Scanner;

public class AiChatbotClass {

    public static void main(String[] args) {
        // Create an instance of the scanner class to read input from the user
        Scanner scanner = new Scanner(System.in);
        
        // Greet the user
        System.out.println("Chatbot: Hello! I am your friendly chatbot. How can I help you today?");
        
        while (true) {
            // Get user input
            String userInput = scanner.nextLine().toLowerCase().trim();
            
            // If user wants to quit, end the chat
            if (userInput.equals("exit") || userInput.equals("bye") || userInput.equals("quit")) {
                System.out.println("Chatbot: Goodbye! Have a great day!");
                break;
            }
            
            // Process user input and provide a response
            String response = getResponse(userInput);
            
            // Display the response
            System.out.println("Chatbot: " + response);
        }
        
        // Close the scanner
        scanner.close();
    }
    
    // Method to generate the chatbot's response based on user input
    public static String getResponse(String userInput) {
        if (userInput.contains("hello") || userInput.contains("hi")) {
            return "Hi there! How can I assist you today?";
        } else if (userInput.contains("your name")) {
            return "I am Chatbot, your virtual assistant.";
        } else if (userInput.contains("how are you")) {
            return "I'm doing great, thank you for asking!";
        } else if (userInput.contains("time")) {
            return "I am not sure about the time, but you can check your device clock.";
        } else if (userInput.contains("thank you") || userInput.contains("thanks")) {
            return "You're welcome! Let me know if you need further assistance.";
        } else if (userInput.contains("bye")) {
            return "Goodbye! Have a wonderful day!";
        } else {
            return "Sorry, I didn't quite understand that. Can you ask something else?";
        }
    }
}
