import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    // Problem#1: This demonstrates the maximum number of values stored in linkedlist. If duplicate number exist in linkedlist, then that
    // will be the basis of the maximum number.

    // PSEUDOCODE FOR THIS PROBLEM:
    // Step1 : Enter input size.
    // Step 2: Store integer values according to size. If size < values in linkedList, then print invalid
    // Step 3: List down all nos. in Linkedlist with duplicates.
    //         set rep = 0, if duplicate doesn't exist in linkedList, else set rep = 1;
    // Step 4: if no duplicates, find the max value.
    // Step 5: if duplicate number exist in linkedlist, find the max number of duplicates.


    /*
    case 1:
        input:
        5                        // This is the size of linkedlist
        23 1 23 1 4              // list of number to store in linkedlist

        output:
        max number: 23          // since 23 is the maximum duplicate number than 1

   case 2:
        input:
        5
        12 1 32 3 1

        output:
        32                       // because 32 is the maximum number

     */

    static int rep = 0;
        public static void main(String[] args) throws java.lang.Exception {
            // This try catch will handle wrong input value such as String instead of integer
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String nSize = br.readLine();
                String nVal = br.readLine();

                int size = Integer.parseInt(nSize);
                List<Integer> list = new LinkedList<>();
                List<Integer> list2 = new LinkedList<>();

                // Data stored in an array was moved to linkedList
                String[] data = nVal.split(" ");
                int convert;
                for (int x = 0; x < data.length; x++) {
                    convert = Integer.parseInt(data[x]);
                    list.add(convert);
                }

                // Checks i
                if(size == list.size()) {
                    for(int x = 0; x <= list.size() - 1; x++) {
                        for(int y = x+1; y <= list.size() - 1; y++) {
                            if(list.get(x).equals(list.get(y))) {
                                rep = 1;
                                list2.add(list.get(x));
                            }
                        }
                    }

                    int max = list.get(0);
                    int maxDu = list.get(0);
                    if(rep == 0) {
                        for(int x = 0; x <= list.size()-1;x++) {
                            if(max < list.get(x)) {
                                max = list.get(x);
                            }
                        }

                        System.out.println("max number: " + max);
                    } else {
                        for(int y = 0; y <= list2.size()-1;y++) {
                            if(maxDu < list2.get(y)) {
                                maxDu = list2.get(y);
                            }
                        }
                        System.out.println("max of duplicate: " + maxDu);
                    }

                } else {
                    System.out.println("Invalid input size");
                }
            }
            catch(NumberFormatException e) {
                System.out.println("Invalid Input. Please enter integer!");
            }


        }
}


