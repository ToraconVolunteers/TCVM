/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys.Core.Util;

/**
 * Shamelessly copied from one of my earlier projects.
 * It was probably originally stolen from else where.
 * @author TheHoudhini
 * @date Oct 9, 2013
 */
abstract public class BinarySearch {
    public static int binarySearch(String target, String searching[], int size) {

        System.out.println(target);
        System.out.println(size);
        for (int i=0;i<size;i++) {
            System.out.println(searching[i]);
        }
        int middle;
        int left;
        int right;
        int counter;
        boolean found = false;

//  TESTING       System.out.println("target   " + target);

            left = 0;
            right = size-1;
            middle = -1;
            counter = 0;

                while ((right >= left) && (found == false) && (counter < 200)) {
                    middle = ((left + right) / 2);

                 System.out.println("middle   " + middle);
//  TESTING                  System.out.println("searching[middle]   " + searching[middle].substring(1));
//  TESTING                  System.out.println(target.compareToIgnoreCase(searching[middle].substring(1)));
                     if ((target.compareToIgnoreCase(searching[middle])) < 0) {
                        right = (middle - 1);
//  TESTING                  System.out.println("right   " + right);
                    } else if ((target.compareToIgnoreCase(searching[middle])) > 0) {
//  TESTING                  System.out.println("left   " + left);
                        left = (middle + 1);
                    } else {
                        found = true;
                        break;
                    }
                }
//  TESTING          System.out.println(found);
//  TESTING          System.out.println("We have arrived" + middle);
            if (found == true) {
//  TESTING          System.out.println(searching[middle]);
                return middle;

            } else {
//  TESTING          System.out.println("not found");
                return -1;
            }
     }    
}
