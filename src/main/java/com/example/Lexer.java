package com.example;
import java.util.ArrayList;

public class Lexer {

    public ArrayList<String> tokenizeCode(String code) {
        ArrayList<String> tokens = new ArrayList<>();

        String[] output = code.split("\\s+");
        output = functionCall(output);

        for (String token : output) {
            switch (token) {
                case ("int"):
                    tokens.add("int --> DATA TYPE");
                    break;
                case ("float"):
                    tokens.add("float --> DATA TYPE");
                    break;
                case ("for"):
                    tokens.add("for --> Reserved Word");
                    break;
                case ("while"):
                    tokens.add("while --> Reserved Word");
                    break;
                case ("if"):
                    tokens.add("if --> Reserved Word");
                    break;
                case ("else"):
                    tokens.add("else --> Reserved Word");
                    break;
                    
                //Binary Operators
                case ("+"):
                    tokens.add("+ -->Binary Operator");
                    break;
                case ("-"):
                    tokens.add("- -->Binary Operator");
                    break;
                case ("*"):
                    tokens.add("* -->Binary Operator");
                    break;
                case ("/"):
                    tokens.add("/ -->Binary Operator");
                    break;

                //Symbols 
                case (""):
                tokens.add(token + " -->Empty ");
                    break;
                case ("="):
                tokens.add(token + " -->Symbol ");
                    break;
                case ("!"):
                tokens.add(token + "! -->Symbol ");
                    break;
                case ("<"):
                tokens.add(token + "< -->Symbol ");
                    break;
                case (">"):
                tokens.add(token + "> -->Symbol ");
                    break;
                case ("("):
                tokens.add(token + "() -->Symbol ");
                    break;
                case (")"):
                tokens.add(token + ") -->Symbol ");
                    break;
                case ("{"):
                tokens.add(token + "{ -->Symbol ");
                    break;
                case ("}"):
                tokens.add(token + "} -->Symbol ");
                    break;
                case (";"):
                tokens.add(token + "; -->Symbol ");
                    break;
                case (","):
                tokens.add(token + ", -->Symbol ");
                    break;
                case ("."):
                tokens.add(token + ". -->Symbol ");
                    break;
                case ("<="):
                tokens.add(token + "<= -->Symbol ");
                    break;
                case (">="):
                tokens.add(token + ">= -->Symbol ");
                    break;
                case ("!="):
                tokens.add(token + "!= -->Symbol ");
                    System.out.println("!= -->Symbol ");
                    break;
                case ("=="):
                tokens.add(token + " -->Symbol ");
                    break;
                default:
                    char[] ch = token.toCharArray();
                    if (Character.isDigit(ch[0])) {
                        tokens.add(token + " --> Integer Literal");
                    } else if (Character.isLetter(ch[0])) {
                        tokens.add(token + " --> Identifier");
                    } else {
                        tokens.add(token + " --> Invalid Token");
                    }
                    break;
            }
        }

        return tokens;
    }

    public String[] functionCall(String[] code1) {
        String[] output3;
        ArrayList<String[]> list1;
        char[] ch1 = new char[4];
        ch1[0] = '=';
        ch1[1] = '>';
        ch1[2] = '<';
        ch1[3] = '!';
        for (int o = 0; o < 4; o++) {
            list1 = new ArrayList<>();
            for (int i = 0; i < code1.length; i++) {
                list1.add(createArray(code1[i], ch1[o]));
            }
            int count = 0;
            for (String[] strings : list1) {
                count += strings.length;
            }
            output3 = new String[count];
            int k = 0;
            for (String[] strings : list1) {
                for (String string : strings) {
                    output3[k] = string;
                    k++;
                }
            }
            code1 = output3;
        }
        return code1;
    }

    public String[] createArray(String str, char c) {
        String[] str1 = str.split("");
        String ch = Character.toString(c);
        boolean flag = false;
        if (!str.equals("==") && !str.equals("!=") && !str.equals(">=") && !str.equals("<=")) {
            if (str.length() > 1 && str.contains(ch)) {
                if (str.charAt(0) == c && str.charAt(str.length() - 1) == c) {
                    String[] str2 = str.split(ch);
                    int m = str2.length + str2.length + 1;
                    str1 = new String[m];
                    str1[0] = ch;
                    int j = 0;
                    for (int i = 1; i < m - 1 && j < str2.length; i += 2, j++) {
                        str1[i] = str2[j];
                        if (j < str2.length - 1) {
                            str1[i + 1] = ch;
                        }
                    }
                    str1[m - 1] = ch;
                    flag = true;
                } else if (str.charAt(0) == c) {
                    String[] str2 = str.split(ch);
                    int m = str2.length + str2.length - 2;
                    str1 = new String[m];
                    str1[0] = ch;
                    int j = 1;
                    for (int i = 1; i < m && j < str2.length; i += 2, j++) {
                        str1[i] = str2[j];
                        if (j < str2.length - 1) {
                            str1[i + 1] = ch;
                        }
                    }
                    flag = true;
                } else if (str.charAt(str.length() - 1) == c) {
                    String[] str2 = str.split(ch);
                    int m = str2.length + str2.length;
                    str1 = new String[m];
                    int j = 0;
                    for (int i = 0; i < m - 1 && j < str2.length; i += 2, j++) {
                        str1[i] = str2[j];
                        if (j < str2.length - 1) {
                            str1[i + 1] = ch;
                        }
                    }
                    str1[m - 1] = ch;
                    flag = true;
                } else {
                    String[] str2 = str.split(ch);
                    int m = str2.length + str2.length - 1;
                    str1 = new String[m];
                    int j = 0;
                    for (int i = 0; i < m && j < str2.length; i += 2, j++) {
                        str1[i] = str2[j];
                        if (j < str2.length - 1) {
                            str1[i + 1] = ch;
                        }
                    }
                    flag = true;
                }
            }
        }
        if (!flag) {
            str1 = new String[1];
            str1[0] = str;
        }
        return str1;
    }
}
