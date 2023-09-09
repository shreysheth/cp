import java.util.*;
import java.math.BigInteger;

public class FavouriteSinger {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Read the number of songs (n)
            BigInteger n = new BigInteger(scanner.nextLine());
            
            // Read the entire line of input and split it into integers
            String[] inputLine = scanner.nextLine().split(" ");
            
            // Create an array to store the singers
            BigInteger[] playlist = new BigInteger[inputLine.length];
            
            // Parse the input as BigIntegers and store them in the array
            for (int i = 0; i < inputLine.length; i++) {
                playlist[i] = new BigInteger(inputLine[i]);
            }
            
            // Calculate and print the number of favourite singers
            BigInteger favouriteSingerCount = countFavouriteSingers(n, playlist);
            System.out.println(favouriteSingerCount);
        }
    }
    
    public static BigInteger countFavouriteSingers(BigInteger n, BigInteger[] playlist) {
        Map<BigInteger, BigInteger> singerCount = new HashMap<>(); // Map to store singer counts
        
        // Count the songs for each singer
        for (BigInteger singer : playlist) {
            singerCount.put(singer, singerCount.getOrDefault(singer, BigInteger.ZERO).add(BigInteger.ONE));
        }
        
        BigInteger maxCount = Collections.max(singerCount.values()); // Maximum count of songs
        
        // Count the number of singers with the maximum count
        BigInteger favouriteSingerCount = BigInteger.ZERO;
        for (BigInteger count : singerCount.values()) {
            if (count.equals(maxCount)) {
                favouriteSingerCount = favouriteSingerCount.add(BigInteger.ONE);
            }
        }
        
        return favouriteSingerCount;
    }
}
