package sorting;

import java.util.*;

public class SortingTool<T>{
     Scanner in = new Scanner(System.in);
   private  int totalNumOfElements;
   private long greatestNumber; // So any real input is >= Y
    private int greatestNumOrLongestLineOccurrences;
    private int numOccurrencePercentage;
    private String longestLine = " ";

    void InputValidation(String input,String sortedType){

        switch(input) {
            case "long":
                Map<Long, Integer> map = new HashMap<>();
                List<Long> longList =  new ArrayList<>();
                while (in.hasNextLong()) {
                    long number = in.nextLong();
                    in.nextLine();
                    longList.add(number);
                    map.put(number, map.getOrDefault(number, 0) + 1);

                    totalNumOfElements++;
                    if (number > greatestNumber) {
                        greatestNumber = number;
                        greatestNumOrLongestLineOccurrences = 1;
                    } else if (number == greatestNumber) {
                        greatestNumOrLongestLineOccurrences++;
                    }
                }
                numOccurrencePercentage = (greatestNumOrLongestLineOccurrences / totalNumOfElements) * 100;
                if(sortedType.equals("natural")){
                    sortedNaturalOrder(longList,totalNumOfElements);
                }else{
                    sortedByCount(map, totalNumOfElements, numOccurrencePercentage);
                }
                ///display(input, totalNumOfElements,greatestNumber,greatestNumOrLongestLineOccurrences,numOccurrencePercentage);
                break;
            case "line":
                List<String> lineList =  new ArrayList<>();
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    lineList.add(line);
                    totalNumOfElements++;
                    if (line.length() > longestLine.length()) {
                        longestLine = line;
                        greatestNumOrLongestLineOccurrences = 1;
                    } else if (line.equals(longestLine)) {
                        greatestNumOrLongestLineOccurrences++;
                    }
                }

                numOccurrencePercentage = (greatestNumOrLongestLineOccurrences / totalNumOfElements) * 100;
                sortedNaturalOrder(lineList,totalNumOfElements);
                ///display(input, totalNumOfElements,greatestNumber,greatestNumOrLongestLineOccurrences,numOccurrencePercentage);

                break;
            case "word":
                List<String> list =  new ArrayList<>();
                while (in.hasNext()) {

                    String word = in.next();
                    list.add(word);
                    totalNumOfElements++;
                    if (word.length() > longestLine.length()) {
                        longestLine = word;
                        greatestNumOrLongestLineOccurrences = 1;
                    } else if (word.equals(longestLine)) {
                        greatestNumOrLongestLineOccurrences++;
                    }

                }
                numOccurrencePercentage = (greatestNumOrLongestLineOccurrences / totalNumOfElements) * 100;
                sortedNaturalOrder(list,totalNumOfElements);
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    <T> void display(T datatype, T totalElement, T greatestElement,T numOccurrence,T percentange){
        if(datatype.equals("long")){
            System.out.printf("Total numbers: %d.\n", totalElement);
            System.out.print("Sorted data:");

//            System.out.printf("The greatest number: %d (%d time(s), %d).\n",greatestElement, numOccurrence,percentange);
        }
        else if(datatype.equals("line")){
            System.out.printf("Total lines: %d.\n", totalElement);
            System.out.printf("The longest line: %s (%d time(s), %d).\n",longestLine, numOccurrence,percentange);
        }
        else if(datatype.equals("word")){
            System.out.printf("Total words: %d.\n", totalElement);
            System.out.printf("The longest word: %s (%d time(s), %d).\n",longestLine, numOccurrence,percentange);
        }

    }

    <T> void sortedNaturalOrder(List<T> naturalOrderList,int totalNumbers){
        naturalOrderList.sort((s1,s2)->s1.toString().compareTo(s2.toString()));
        System.out.printf("Total words: %d.\n", totalNumbers);
        System.out.println("Sorted data: " + naturalOrderList);
    }

    <T> void sortedByCount(Map<Long,Integer> map,int totalNumbers,int percentage){
        System.out.printf("Total words: %d.\n", totalNumbers);
        List<Map.Entry<Long, Integer>> sortedList = new ArrayList<>(map.entrySet());
        sortedList.sort((s1,s2)->{
            int comparison = s1.getValue().compareTo(s2.getValue());//sort by count;
            if(comparison == 0){
                return s1.getKey().compareTo(s2.getKey());//sort by keys
            }
            return comparison;
        });

        for(Map.Entry<Long,Integer> entry: map.entrySet()){
            System.out.printf("%d: %d time(s), %d\n", entry.getKey(), entry.getValue(),percentage);
        }

    }
}
