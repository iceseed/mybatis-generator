//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.maven.plugins.mybatis.utils;

public class JavaBeanUtils {
    public JavaBeanUtils() {
    }

    public static String getSetterMethodName(String property) {
        StringBuilder sb = new StringBuilder();
        sb.append(property);
        if (Character.isLowerCase(sb.charAt(0)) && (sb.length() == 1 || !Character.isUpperCase(sb.charAt(1)))) {
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        }

        sb.insert(0, "set");
        return sb.toString();
    }

    public static String getGetterMethodName(String property) {
        StringBuilder sb = new StringBuilder();
        sb.append(property);
        if (Character.isLowerCase(sb.charAt(0)) && (sb.length() == 1 || !Character.isUpperCase(sb.charAt(1)))) {
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        }

        sb.insert(0, "get");
        return sb.toString();
    }

    public static String firstLowerCase(String property) {
        if (Character.isLowerCase(property.charAt(0))) {
            return property;
        } else {
            StringBuilder sb = new StringBuilder(property);
            sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
            return sb.toString();
        }
    }

    public static String getCamelCaseString(String inputString, boolean firstCharacterUppercase) {
        StringBuilder sb = new StringBuilder();
        boolean nextUpperCase = false;

        for(int i = 0; i < inputString.length(); ++i) {
            char c = inputString.charAt(i);
            switch(c) {
                case ' ':
                case '#':
                case '$':
                case '&':
                case '-':
                case '/':
                case '@':
                case '_':
                    if (sb.length() > 0) {
                        nextUpperCase = true;
                    }
                    break;
                default:
                    if (nextUpperCase) {
                        sb.append(Character.toUpperCase(c));
                        nextUpperCase = false;
                    } else {
                        sb.append(Character.toLowerCase(c));
                    }
            }
        }

        if (firstCharacterUppercase) {
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        }

        return sb.toString();
    }

    public static String splitString(String packageName) {
        StringBuilder sb = new StringBuilder("/");

        for(int i = 0; i < packageName.length(); ++i) {
            char c = packageName.charAt(i);
            switch(c) {
                case '.':
                    sb.append("/");
                    break;
                default:
                    sb.append(c);
            }
        }

        return sb.toString();
    }
}
