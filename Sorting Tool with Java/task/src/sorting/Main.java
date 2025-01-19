package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) throws SortingToolException {
        String sortingType = "natural";
        String dataType = "word";
        for(int i = 0;i < args.length;i++){
            if(args[i].equals("-sortType")&& i + 1 < args.length ){
                    sortingType = args[i + 1];
            }else{
               throw new SortingToolException("No sorting type defined!");
            }
            if(args.equals("-dataType") && i + 1 < args.length){
                String nextArgs = args[i + 1];
                if(nextArgs.equals("word")|| nextArgs.equals("long") || nextArgs.equals("line")){
                    dataType = nextArgs;
                }else{
                    throw new SortingToolException(nextArgs + " is not a valid parameter. It will be skipped.");
                }
            }else{
                throw new SortingToolException("No data type defined!");
            }
        }
        Scanner scanner = new Scanner(System.in);
      SortingTool sortingTool = new SortingTool();
      sortingTool.InputValidation(dataType,sortingType);



    }
}
