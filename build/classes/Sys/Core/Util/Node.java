
package Sys.Core.Util;

/**
 * -------------------------------class Node------------------------------------
 * This class creats nodes according the parameters that are passed to the class
 * during initialisation. The two constructors overload to make two different type
 * of nodes depending on the parameters passed.
 * @author G.B. Shehan Jayasekera, IB Session number: 001426-002, The British School in Colombo
 */
public class Node {
    
    public String element;
    public String[] rowElements;
    // For assigning the next node
    public Node next;

    // This constructor creates a node using data from the excel file
    public Node(String element, String[] rowElements) {
        this.element = element;
        this.rowElements = rowElements;
    }
}
