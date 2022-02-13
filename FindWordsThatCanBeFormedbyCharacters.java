/*
(Sorry! If you think my sentences are wired that is normal.Because I'm practiceing English now.)

line 11
findFrom <= chars.length()
I stuck for a while because I coded my while condition "findFrom < chars.length()"
The error test code is  "hyiozy"
my old while condition will misjudge 

the chars is "ilumzpopwlhlky" (chars.length() is  14)
the first y is in index 13 (the last index)
when my old code scan to the second y ("hyiozy")
it will set findFrom to 13 + 1 = 14
and the 14 can't be catched to the first if() in while because the while already end 
so that,"hyiozy" will be true.
*/
class Solution {    
    public boolean check(String word, String chars){        
        boolean[] checkRecord = new boolean[chars.length()];
        for(int i = 0; i < word.length(); i++){
            char eachLetter = word.charAt(i);
            int findFrom = 0;
            while(findFrom <= chars.length()){
                if(chars.indexOf(eachLetter, findFrom) == -1){
                    return false;
                }
                if(!checkRecord[chars.indexOf(eachLetter, findFrom)]){
                    checkRecord[chars.indexOf(eachLetter, findFrom)] = true;
                    break;
                }
                else{
                    findFrom = chars.indexOf(eachLetter, findFrom) + 1;
                }
            }            
        }
        return true;
    }
    
    public int countCharacters(String[] words, String chars) {
        int answerLen = 0;
        for(String word: words){
            if(check(word, chars)){
                answerLen += word.length();
            }
        }
        return answerLen;
    }
}
