// 
// Decompiled by Procyon v0.5.36
// 

public class 0
{
    public static String c;
    
    static {
        0.c = 1.a(5, 78);
    }
    
    public static void main(final String[] array) {
        if (array.length >= ((int)1506594314L ^ 0x59CCCE0B)) {
            1.a(0, 100);
            String anObject;
            try {
                anObject = array[(int)(-753045066L) ^ 0xD31D71B6];
            }
            catch (IndexOutOfBoundsException ex) {
                throw ex;
            }
            if (c(1.a(1, 95)).equals(anObject)) {
                System.out.println(1.a(2, 2));
            }
            else {
                System.out.println(1.a(3, 38));
            }
            return;
        }
        System.out.println(1.a(4, 87));
    }
    
    public static String c(final String s) {
        final char[] charArray = s.toCharArray();
        final char[] value = new char[charArray.length];
        for (int i = (int)1072331622L ^ 0x3FEA7B66; i < value.length; ++i) {
            value[i] = (char)(charArray[i] ^ (i & ((int)(-1108647316L) ^ 0xBDEB626E)));
        }
        return new String(value);
    }
}