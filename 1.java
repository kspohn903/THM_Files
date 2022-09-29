// 
// Decompiled by Procyon v0.5.36
// 

public final class 1
{
    private static final String[] a;
    
    static {
        (a = new String[12])[0] = "";
        1.a[2] = "[>T\u05f7\u05885\t\u0006\u05d4\u05d968\u0001\u05da\u05deRh\u0003\u05cc\u0580G0\u0006\u058d\u05d00\u001a";
        1.a[4] = "AmB\u05cb\u058cav\u0011";
        1.a[6] = "KHS\u05d6\u059bpCS\u05cd";
        1.a[8] = "R;U\u05d8\u059agw@\u05cb\u0586t>T\u05dc\u05c9cw@\u05d8\u059aq _\u05cb\u058d";
        1.a[10] = "[/T\u0ee7\u0eb85\u0018\u0006\u0ec4\u0ee96)\u0001\u0eca\u0eeeRy\u0003\u0edc\u0eb0G!\u0006\u0e9d\u0ee00\u000b";
    }
    
    public static String a(final int n, final int n2) {
        if (c.3 != 0) {
            throw null;
        }
        Thread currentThread = null;
        StackTraceElement[] stackTrace = null;
        int hashCode = 0;
        int hashCode2 = 0;
        char[] charArray = null;
        char[] value = null;
        char c = '\0';
        int n3 = 0;
    Label_0019_Outer:
        while (true) {
        Label_0008_Outer:
            while (true) {
                switch (n3) {
                    default: {
                        final YourMum yourMum = null;
                        break;
                    }
                    case 2: {
                        currentThread = Thread.currentThread();
                        n3 = 3;
                        continue Label_0019_Outer;
                    }
                    case 7: {
                        charArray = 1.a[n * 2].toCharArray();
                        value = new char[charArray.length];
                        n3 = 8;
                        continue Label_0019_Outer;
                    }
                    case 8: {
                        c = '\0';
                        break Label_0019;
                    }
                    case 1: {
                        return 1.a[n * 2 + 1] = new String(value);
                    }
                    case 5: {
                        hashCode2 = stackTrace[2].getMethodName().hashCode();
                        n3 = 7;
                        continue Label_0019_Outer;
                    }
                    case 0:
                    case 6: {
                        final String s = 1.a[n * 2 + 1];
                        if (s != null) {
                            return s;
                        }
                        n3 = 2;
                        continue Label_0019_Outer;
                    }
                    case 3: {
                        stackTrace = currentThread.getStackTrace();
                        n3 = 4;
                        continue Label_0019_Outer;
                    }
                    case 4: {
                        hashCode = stackTrace[2].getClassName().hashCode();
                        n3 = 5;
                        continue Label_0019_Outer;
                    }
                }
                int n4 = 0;
            Label_0141:
                while (true) {
                    n4 = (charArray[c] ^ c);
                    break Label_0141;
                    if (c >= charArray.length) {
                        n3 = 1;
                        continue Label_0019_Outer;
                    }
                    switch (c % '\u0005') {
                        case 5: {
                            continue;
                        }
                        case 3: {
                            n4 = (charArray[c] ^ hashCode2);
                            break;
                        }
                        case 0: {
                            n4 = (charArray[c] ^ '\u0002');
                            break;
                        }
                        case 4: {
                            n4 = (charArray[c] ^ hashCode2 + hashCode);
                            break;
                        }
                        case 2: {
                            n4 = (charArray[c] ^ hashCode);
                            break;
                        }
                        case 1: {
                            n4 = (charArray[c] ^ n2);
                            break;
                        }
                        default: {
                            throw null;
                        }
                    }
                    break;
                }
                value[c] = (char)n4;
                ++c;
                continue Label_0008_Outer;
            }
        }
    }
}