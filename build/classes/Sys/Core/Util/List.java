
package Sys.Core.Util;

import javax.swing.JOptionPane;

/**
 * ------------------------------class List-------------------------------------
 * This class, along with the Node class, creats link-lists from either the entry
 * files or the staff master file. The choice is verified in the constructor List.
 * @author G.B. Shehan Jayasekera, IB Session number: 001426-002, The British School in Colombo
 */
public class List {

    Node head;
    int firstName = Sys.Core.File.ExcelFilePrep.getNameCol();
    

/**
 * List - The constructor calls two different methods depending on whether the link-list
 *      to be made is for entries or for user details.
 * @param purpose - The parameter signifies which type of link-list is to be made.
 *      It can be either "entries" (for making a link-list from the data stored in the
 *      entry files) or "users" (for making a link-list from the data stored in the
 *      StaffMasterFile.dat).
 */
    public List(String sortBy) {
        head =  null;
    }

/**
 * loadList - Reads every line of each file and then adds the corresponding
 * line of each file to a node.
 */
    public void loadList(int sortCol) {
        try {
            String element;
            String[] rowElements;
            int colHeight = Sys.Core.File.ExcelReader.getColContent(sortCol).length;
            for (int i = 0; i < colHeight; i++) {
                element = Sys.Core.File.ExcelReader.getCellContent(sortCol, i);
                rowElements = Sys.Core.File.ExcelReader.getRowContent(i);
                // Calls the addNode method adds the sort element along with its resective row to node
                addNode(new Node(element, rowElements));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Link-list loading unsuccessful", "Fatal Error: System error", JOptionPane.ERROR_MESSAGE);
        }
    }

/**
 * Node getHead - The method is used to return the head of the link-list.
 * @return head - Returns the head value of the link-list.
 */
    public Node getHead() {
        return head;
    }

/**
 * setHead - This method sets the passed node as the head.
 * @param newHead -  The node to be assigned as the head.
 */
    public void setHead(Node newHead) {
        head = newHead;
    }

/**
 * addNode - Adds the parameters passed into individual nodes.
 * @param node - Passes the parameters to the node constructor in order for the
 *      nodes to be created.
 */
    private void addNode(Node node) {
        if (head == null) {
            head = node;
//  Checks and adds each new node to the head of the link-list.
        } else {
            Node point = traverseToLastNode();
            point.next = node;
        }
    }

/**
 * traverseToLastNode - For finding the last node of the link-list.
 * @return last - Returns the last node (tail node) of the link-list.
 */
    private Node traverseToLastNode() {
        Node last = head;
        while(last.next != null) {
            last = last.next;
        }
        return last;
    }

/**
 * sizeOfList - This method traverses the link-list untill reaching the last node,
 *      all the while incrementing the int size. Once the entire link-list is traversed,
 *      the int size would then represent the number of nodes in the link-list.
 * @return size - The size of the link-list is returned.
 */
    public int sizeOfList() {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            System.out.println(temp+"i");
            size++;
            temp = temp.next;
        }
        return size;
    }

/**
 * getPreviousNode - To find the node before a particular node in a link-list.
 * @param list - The link-list
 * @param node - The node which the node before it is to be located.
 * @return currentNode - The node before the passed node.
 * @return null - Returns null if there are no previuos node to the node passed,
 *      ie. the passed node is the head node of the link-list
 */
    public Node getPreviousNode(List list, Node node) {
        Node currentNode = list.head;
        while (currentNode != null) {
            if (currentNode.next == node) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

///**
// * outputLinkList - Prints out the entire link-list in terms of a partcular field
// *      in each node. Used for testing.
// * @param field - The field of each node to be displayed.
// */
//    public void outputLinkList(String field) {
//        Node currentNode = head;
//
//        if (field.equals("stoneTag")) {
//            while (currentNode != null) {
//                System.out.println(currentNode.stoneTag);
//                currentNode = currentNode.next;
//            }
//        }
//    }
}


