/*This program contains three methods related to strings.
 *Creator: Vivian Yang
 * Date created: August 16, 2022
 */
public class Main {
    //Code your solution to problem number one here
    static int problemOne(String s){//count number of vowels in a string
        //TODO
        int count = 0; //variable to count vowels
        for (int i=0; i<s.length(); i++) {//use loop to run through each char in string
            int vow = s.charAt(i);
            //if char is a vowel, count increase by 1
            if(vow == 'a'|| vow == 'e'|| vow == 'i'|| vow == 'o'|| vow == 'u')
                count++;
        }
        return count;
    }
    //Code you problem number two here
    static int problemTwo(String s){//count number of times 'bob' occurs in a string
        //TODO
        int count = 0; //variable to count vowels
        for (int i=0; i<s.length()-2; i++) {//use loop to run through each char in string
            //if that char and its following two characters create 'bob', count increase by 1
            String bob = s.substring(i, i+3);
            if (bob.equals("bob"))
                count++;
        }
        return count;
    }
    //Code your solution to problem number 3 here
    static String problemThree(String s){//prints the longest sequence in alphabetical order in string
        //TODO
        int j = 0;
        String lgestSubStr = "";//variable for longest substring
        String tempStr = "";
        for (int i=0; i < s.length()-1; i++) {//use loop to run through each char in string as starting point
            j = i;
            //if current and next char are in alphabetical order, system continues comparing characters until a non-alphabetized pair is found.
            while(j+1 < s.length() && s.charAt(j) <= s.charAt(j+1) ){
                j++;//if a pair found is not alphabetized, loop will run again with char after the previous starting char
            }

            tempStr = s.substring(i, j+1);
            if( lgestSubStr.length() < tempStr.length()){//if a longer substring is found, it will replace the current lgestSubStr.
                lgestSubStr = tempStr;
            }
        }
        return lgestSubStr;
    }
    public static void main(String[] args) {
        /*
        Set s to a string and run your method using s as the parameter
        Run your method in a println statement to determine what the output was
        Once you think you have it working try running the tests.
        The tests will put your method through several different Strings to test
        all possible cases.  If you have 100% success then there is no bugs in your methods.
         */
        System.out.println(problemOne("wjeiocnjaqmoied"));
        System.out.println(problemTwo("bobofjeiowbseuoboesbobobob"));
        System.out.println(problemThree("tunivklq"));
    }
}
