package org.example;

public class StringProcessor {
    /*In this method we need to check if the password is strong*/
    public boolean isStrongPassword(String password){
        if(password.length() < 8 || password == null){
            return false; /*Return false immediately if the password is empty or less then 8 char*/
        }

        boolean upperChar = false; /*we need this 4 rows to compare in the end if they all contains in our password*/
        boolean lowerChar = false;
        boolean digitChar = false;
        boolean specialChar = false;

        String specialCharacters = "!@#$%^&*()-+"; /* separate line with special characters*/

        for( char c : password.toCharArray()){ /* in this for each loop we are cheking if our password:*/
            if(Character.isUpperCase(c)){ /*has upper case latter*/
                upperChar = true;
            }
            else if(Character.isLowerCase(c)){/*has lower case latter*/
                lowerChar = true;
            }
            else if(Character.isDigit(c)){/*has digits*/
                digitChar = true;
            }
            else if(specialCharacters.contains(Character.toString(c))){ /*has special char*/
                specialChar = true;
            }
        }

        if(upperChar&&lowerChar&&digitChar&&specialChar){ /* if all 4 attributes are exist in a password then it's strong*/
            return true;
        }
        return false; /*and weak otherwise*/
    }

    public int calculateDigits(String sentence){
        if(sentence == null){ /* base case*/
            return 0;
        }
        int digits = 0;
        for(char c : sentence.toCharArray()){ /*using for each loop separate chars in a sentence to count them*/
            if(Character.isDigit(c)){
                digits++;
            }
        }
        return digits; /*and return the value*/
    }

    public int calculateWords(String sentence){ /*Simple method where we are just splitting the sentences by space in it*/
        if(sentence == null){ /*base case*/
            return 0;
        }
        String[] words = sentence.trim().split(" ");
        return words.length;
    }
}
