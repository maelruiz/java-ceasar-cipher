import java.util.Scanner;

public class main {
    int key;
    String codedCipher;
    String rawCipher;
    Scanner scanner = new Scanner(System.in);
    String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String punctuation = "!\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~";
    String numbers = "1234567890";

    public main(int key, String coded, String raw) {
        this.key = key;
        this.codedCipher = coded;
        this.rawCipher = raw;
    }

    public String encodeCipher(String raw, int key) {
        char character;
        char newChar;
        String encoded = "";
    
        for (int i = 0; i < raw.length(); i++) {
            character = raw.charAt(i);
    
            if (alphabet.contains(String.valueOf(character))) {
                int index = alphabet.indexOf(character);
                newChar = alphabet.charAt((index + key) % alphabet.length());
            } else if (punctuation.contains(String.valueOf(character))) {
                int index = punctuation.indexOf(character);
                newChar = punctuation.charAt((index + key) % punctuation.length());
            } else if (numbers.contains(String.valueOf(character))) {
                int index = numbers.indexOf(character);
                newChar = numbers.charAt((index + key) % numbers.length());
            } else {
                // For unsupported characters, you might want to handle this case appropriately.
                // For now, let's keep the original character.
                newChar = character;
            }
            encoded = encoded + newChar;
        }
        return encoded;
    }
    

    public String getRawCipher() {
        if (codedCipher == null || codedCipher.isEmpty()) {
            System.out.print("What do you want to encode? ");
            codedCipher = scanner.nextLine();
        }
        return codedCipher;
    }

    public int getKey() {
        if (key == 0) {
            System.out.print("What should the key be? ");
            key = scanner.nextInt();
        }
        return key;
    }

    public String getString() {
        return codedCipher;
    }

    public static void main(String[] args) {
        int key = 0;
        String codedCipher = "";

        if (args.length == 2) {
            codedCipher = args[0];
            key = Integer.parseInt(args[1]);
        }

        main main = new main(key, codedCipher, "");
        String encoded = main.encodeCipher(main.getRawCipher(), main.getKey());
        System.out.println("Encoded Cipher: " + encoded);
    }
}