
package Sys.Core.Util;

/**
 * ---------------------------class BubbleSort----------------------------------
 * This class contains methods that can sort a link-list in ascending order using
 * a variation of the "Bubble Sort" algorithm.
 * @author G.B. Shehan Jayasekera, IB Session number: 001426-002, The British School in Colombo
 */
public class BubbleSort {

/**
 * bubbleSort - This method sorts the link-list by comparing adjacent terms of the
 *      current nodes and then swapping them into the correct position.
 * @param currentNode - The current node, ie. head node when the sort is first called
 * @param list - The link-list to be sorted.
 */
    private static void bubbleSort(Node currentNode, List list) {
        if (currentNode != null && currentNode.next != null) {
            if (currentNode.element.compareToIgnoreCase(currentNode.next.element) > 0) {
               Node nextNode = currentNode.next;
//  Assigns the second node to the first node.
               Node afterNextNode = nextNode.next;
//  Assigns the old third node to the new second node.
               nextNode.next = currentNode;
//  Assigns the new third node to the old first node.
               currentNode.next = afterNextNode;
//  Assigns the old second node to the third node.

               Node prevNode = list.getPreviousNode(list, currentNode);
//  Gets the previous node of the current node.
               if(prevNode != null) {
                   prevNode.next = nextNode;
               } else {
                   list.setHead(nextNode);
               }
            }
            bubbleSort(currentNode.next, list);
        }
    }

/**
 * testSort - This method is to test whether the sorting was succesful or not. 
 * @param node - The current node.
 * @param correct - The boolean value.
 * @return correct[0] - returns the value of the boolean correct.
 */
    private static boolean testSort(Node node, boolean[] correct) {
       if ((node != null) && (node.next != null)) {
           if (node.element.compareToIgnoreCase(node.next.element) < 0) {
                correct[0] = true;
                testSort(node.next, correct);
            } else if (node.element.compareToIgnoreCase(node.next.element) == 0) {
                correct[0] = true;
                testSort(node.next, correct);
            } else {
                correct[0] = false;
                return correct[0];
            }
        }
        return correct[0];
    }

/**
 * beginSort - This method is for begining the sorting method. The method, with
 * the use of recursion and iteration, makes sure that the link-list gets sorted.
 * @param list - The list to be sorted.
 * @param field - The field to be sorted, ie. stoneTag.
 */
    public static void beginSort(List list, String field) {
        Node head = list.getHead();

        if(head != null) {

            boolean test = false;
            boolean[] check = new boolean[1];
            check[0] = false;

            while(test == false) {
                bubbleSort(head, list);
                head = list.getHead();
                test = testSort(head, check);
            }
        }
    }
}
