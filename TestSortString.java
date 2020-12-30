public class TestSortString {

    public static void testSort(){
        String[] input = {"egg" , "an" , "i" , "have"};
        String[] expected = {"an" , "egg" , "have" , "i"};
        SortString.SortArray(input);

//        Checks for error
        for(int i = 0 ; i < input.length ; ++i){
            if(!input[i].equals(expected[i])){
                System.out.println("Error expected \"" + expected[i] + "\"  but found  \"" + input[i] + "\" at position " + i);
                return;
            }
        }
    }

    public static void main(String[] args){
        testSort();
    }

}
