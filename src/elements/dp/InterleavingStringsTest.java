package elements.dp;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class InterleavingStringsTest {

    // InterleavingStrings i = new InterleavingStrings();
   @Test
    void testIsInterleaving() {
        String s1 = "gtaa";
        String s2 = "atc";
        String t  = "gattaca";  // Expected to be a valid interleaving

        InterleavingStrings checker = new InterleavingStrings();
        boolean result = checker.isInterleaving(s1, s2, t);
        
        assertTrue(result, "Expected true because t is a valid interleaving of s1 and s2");
    }

    @Test
    void testIsInterleavingWrongCheck() {
        String s1 = "gtaa";
        String s2 = "atc";
        String t  = "gatacta";  // Expected to be a valid interleaving

        InterleavingStrings checker = new InterleavingStrings();
        boolean result = checker.isInterleaving(s1, s2, t);
        
        assertFalse(result, "Expected false because t is a valid interleaving of s1 and s2");
    } 

    @Test
    void testIsInterleavingWrongCheckTabular() {
        String s1 = "gtaa";
        String s2 = "atc";
        String t  = "gatacta";  // Expected to be a valid interleaving

        InterleavingStrings checker = new InterleavingStrings();
        boolean result = checker.checkIsInterleavingTabular(s1, s2, t);
        
        assertFalse(result, "Expected false because t is a valid interleaving of s1 and s2");
    } 
    
    @Test
    void testIsInterleavingValid1() {
        String s1 = "aba";
        String s2 = "bba";
        String t  = "abbbaa";  // Expected to be a valid interleaving

        InterleavingStrings checker = new InterleavingStrings();
        boolean result = checker.isInterleaving(s1, s2, t);
        
        assertTrue(result, "Expected true because t is a valid interleaving of s1 and s2");
    }

    @Test
    void testIsInterleavingValid1Tabular() {
        String s1 = "aba";
        String s2 = "bba";
        String t  = "abbbaa";  // Expected to be a valid interleaving

        InterleavingStrings checker = new InterleavingStrings();
        boolean result = checker.checkIsInterleavingTabular(s1, s2, t);
        
        assertTrue(result, "Expected true because t is a valid interleaving of s1 and s2");
    }

    @Test
    void testIsInterleavingInvalid1() {
        String s1 = "aba";
        String s2 = "bba";
        String t  = "abaabb";  // Expected to be a valid interleaving

        InterleavingStrings checker = new InterleavingStrings();
        boolean result = checker.isInterleaving(s1, s2, t);
        
        assertTrue(!result, "Expected false because t is a invalid interleaving of s1 and s2");
    }

    @Test
    void testIsInterleavingInvalid1Tabular() {
        String s1 = "aba";
        String s2 = "bba";
        String t  = "abaabb";  // Expected to be a valid interleaving

        InterleavingStrings checker = new InterleavingStrings();
        boolean result = checker.checkIsInterleavingTabular(s1, s2, t);
        
        assertTrue(!result, "Expected false because t is a invalid interleaving of s1 and s2");
    }

    @Test
    void testIsInterleavingTabularValid() {
        String s1 = "gtaa";
        String s2 = "atc";
        String t  = "gattaca";  // Expected to be a valid interleaving

        InterleavingStrings checker = new InterleavingStrings();
        boolean result = checker.checkIsInterleavingTabular(s1, s2, t);
        
        assertTrue(result, "Expected true because t is a valid interleaving of s1 and s2");
    }
}
