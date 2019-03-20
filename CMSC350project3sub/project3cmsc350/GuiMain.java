package project3cmsc350;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/*Pressing the Perform Sort button should cause all the numbers in the original list to be added to a
binary search tree. Then an inorder traversal of the tree should be performed to generate the list
in sorted order and that list should then be displayed in the sorted list text field.Pressing the Perform Sort button should cause all the numbers in the original list to be added to a
binary search tree. Then an inorder traversal of the tree should be performed to generate the list
in sorted order and that list should then be displayed in the sorted list text field.*/
public class GuiMain {

    public static class GuiPanel extends JPanel {

        // create variable to hold infix expression
        String inputList;

        // create text fields
        private JTextField inputListTxt = new JTextField("");
        private JTextField resultListTxt = new JTextField("");

        // create labels
        private JLabel originalListLbl = new JLabel("Original List");
        private JLabel sortedListLbl = new JLabel("Sorted List");

        // create buttons
        private JButton sortButton = new JButton("Perform Sort");


		 
        //Input/Output Panel constructor
        public GuiPanel() {
            // set layout
            setLayout(new GridLayout(4, 1));
            setBackground(Color.lightGray);

            // create the input panel for the text input field
            JPanel inputPanel = new JPanel();
            inputPanel.setLayout(new FlowLayout());

            // modify and add new text field
            inputListTxt.setBackground(Color.WHITE);
            inputListTxt.setEditable(true);
            inputListTxt.setPreferredSize(new Dimension(240, 18));
            inputListTxt.setToolTipText("Enter your infix expression");
            inputPanel.add(originalListLbl);
            inputPanel.add(inputListTxt);

            // create the buttons panel
            JPanel buttonsPanel = new JPanel();
            buttonsPanel.setLayout(new FlowLayout());

            // create tool tip for Evaluate Button
            sortButton.setToolTipText("Click to perform sort");

            // set preferred size for button
            sortButton.setPreferredSize(new Dimension(150, 35));

            // add the Jbutton to the Button Panel
            buttonsPanel.add(sortButton);

            // create the output text panel
            JPanel resultsPanel = new JPanel();
            resultsPanel.setLayout(new FlowLayout());

            //modify and add new text field
            resultListTxt.setBackground(Color.LIGHT_GRAY);
            resultListTxt.setEditable(false);
            resultListTxt.setPreferredSize(new Dimension(250, 20));
            resultsPanel.add(sortedListLbl);
            resultsPanel.add(resultListTxt);
            JPanel radioButtonsPanel = new JPanel();

            // create main panel for radio buttons
            radioButtonsPanel.setLayout(new FlowLayout());

            // create panel for the radio buttons that determine sort order
            JPanel sortOptionsPanel = new JPanel();
            sortOptionsPanel.setLayout(new GridLayout(2, 1));
            sortOptionsPanel.setPreferredSize(new Dimension(210, 90));
            Border loweredEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
            TitledBorder sortOptionsTitle = BorderFactory.createTitledBorder(loweredEtched, "Sort Order");
            sortOptionsPanel.setBorder(sortOptionsTitle);
            final JRadioButton ascendingBtn = new JRadioButton("Ascending");
            ascendingBtn.setSelected(true);
            final JRadioButton descendingBtn = new JRadioButton("Descending");
            ButtonGroup group1 = new ButtonGroup();
            group1.add(ascendingBtn);
            group1.add(descendingBtn);
            sortOptionsPanel.add(ascendingBtn);
            sortOptionsPanel.add(descendingBtn);

            // create panel for the radio buttons that determine numeric type
            JPanel numericTypePanel = new JPanel();
            numericTypePanel.setLayout(new GridLayout(2, 1));
            numericTypePanel.setPreferredSize(new Dimension(210, 90));
            TitledBorder numericTypeTitle = BorderFactory.createTitledBorder(loweredEtched, "Numeric Type");
            numericTypePanel.setBorder(numericTypeTitle);
            final JRadioButton integerBtn = new JRadioButton("Integer");
            integerBtn.setSelected(true);
            JRadioButton fractionBtn = new JRadioButton("Fraction");
            ButtonGroup group2 = new ButtonGroup();
            group2.add(integerBtn);
            group2.add(fractionBtn);
            numericTypePanel.add(integerBtn);
            numericTypePanel.add(fractionBtn);

            // add both of the radio buttons panels to the main radio button panel
            radioButtonsPanel.add(sortOptionsPanel);
            radioButtonsPanel.add(numericTypePanel);

            // add all 4 panels to the jframe
            add(inputPanel);
            add(resultsPanel);
            add(buttonsPanel);
            add(radioButtonsPanel);

            // create listener for to trigger calcs when sort button clicked
            sortButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // String array for tokens from the original list
                    String[] tokens;
                    resultListTxt.setText("");
                    inputList = inputListTxt.getText();
                    tokens = inputList.split("\\s");//tokens split on spaces
                    try {

                        if (ascendingBtn.isSelected()) {
                            if (integerBtn.isSelected()) {
                                BinarySearchTree<Integer> integerTree = new BinarySearchTree<>();
                                for (String str: tokens) {
                                    integerTree.insert(Integer.parseInt(str));
                                }
                                resultListTxt.setText(integerTree.Ascending(integerTree.getRoot()).toString());
                            } else {
                                BinarySearchTree<Fraction> fracTree = new BinarySearchTree<>();
                                for (String str: tokens) {
                                    fracTree.insert(new Fraction(str));
                                }
                                resultListTxt.setText(fracTree.Ascending(fracTree.getRoot()).toString());
                            } // end if else
                        }

                        if (descendingBtn.isSelected()) {
                            if (integerBtn.isSelected()) {
                                BinarySearchTree<Integer> integerTree = new BinarySearchTree<>();
                                for (String str: tokens) {
                                    integerTree.insert(Integer.parseInt(str));
                                }
                                resultListTxt.setText(integerTree.Descending(integerTree.getRoot()).toString());
                            } else {
                                BinarySearchTree<Fraction> fracTree = new BinarySearchTree<>();
                                for (String str: tokens) {
                                    fracTree.insert(new Fraction(str));
                                }
                                resultListTxt.setText(fracTree.Descending(fracTree.getRoot()).toString());
                            } // end if else
                        }

                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Non numeric Input");
                    } catch (ArithmeticException ae) {
                        JOptionPane.showMessageDialog(null, "Denominator cannot be 0");
                    }// end try catch
                } // end method
            }); // end action listener
        } // end constructor

        // create the frame for the binary search tree sort
        public static class BSTFrame extends JFrame {
            private static final int WIDTH = 500;
            private static final int HEIGHT = 435;

            // binary search tree frame constructor
            public BSTFrame() {
                super("Binary Search Tree Sort");
                super.setSize(WIDTH, HEIGHT);
                super.setLocationRelativeTo(null);
                super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                super.add(new GuiPanel());
            } // end method

            // main method
            public static void main() {
                BSTFrame gui = new BSTFrame();
                gui.setVisible(true);
            } // end main

        } // end class
      //create the jframe for the whole gui put it here to 
		
      		public static void main(String[] args) { BSTFrame.main(); }
    }
}



