package converterPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/** This class contains the graphical interface (hence the extending of JFrame) through which the user can convert a number between temperatures, hence the name.
* @author Miles (amn35)
*/
public class pakConverterGUI extends JFrame{
    /**
     * 'df' is a handler for formatting text input as decimal.
     */
    static DecimalFormat df = new DecimalFormat("#.#");
    private FloatInputPad inputTag = new FloatInputPad();
    public static String goodChars = "0123456789.-";
    /** 
     * Constructs an instance of the graphical interface when called. All elements, comments or text mentioning a "window" from here on is in reference to this one interface.
     */
    public pakConverterGUI()
    {
        //Object & element names;
        // entryCelsius: radio button in menu.
        // entryFaren: same button but for Fahrenheit.
        // menuScale: dropdown button for Scale containing entryFaren & entryCelsius.
        // entryExit: menu item button to close the program.
        // menuFile: dropdown button for File containing entryExit.
        // entryHelp: menu item button for instruction alert.
        // (Note-to-self) add a separator!
        // entryAbout: button for info. ("Temperature Converter by Miles")
        // menuHelp: dropdown button for Help containing entryHelp & entryAbout.
        /**
         * The following method will set a suitable minimum size for the GUI window so that the user cannot warp it down to a smaller size.
         */
        setMinimumSize(new Dimension(600, 300));
        /**
         * The following method sets a defined size and position for the window  to take when the program loads.
         */
        setBounds(10, 10, 600, 300);
        /**
         * The following method sets a trigger for the program to be able to close by the user's input command (such as the red "X" button in any Microsoft Windows window).
         */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /**
         * The following method sets the name given to the program, which usually displays as a title across the top border pane of the window when the program loads.
         */
        setTitle("Miles's Temperature Converter");
        
        /**
         * The following programming instructions create a menu bar and generate it.
         */
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        /**
         * The following programming instructions will create a dropdown menu called "File" with an entry called "Quit" and add them to the menu bar.
         */
        JMenu menuFile = new JMenu("File");
        menubar.add(menuFile);
        JMenuItem entryQuit = new JMenuItem("Quit");
        menuFile.add(entryQuit);
        
        /**
         * The following method sets a trigger for when the menu item "Quit" is selected which will cause the window to close as normal.
         */
        entryQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        /**
         * The following programming instructions will create a dropdown menu called "Scale" with 2 entries named "Celsius" and "Fahrenheit", proceeding to add them to the menu bar. The 2 items have visual indicators to show whether they're active, and note that Celsius is selected/set to active here while Fahrenheit isn't.
         */
        JMenu menuScale = new JMenu("Scale");
        menubar.add(menuScale);
        
        JRadioButtonMenuItem entryCelsius = new JRadioButtonMenuItem("Celsius");
        //Again, note this statement which sets Celsius as selected.
        entryCelsius.setSelected(true);
        menuScale.add(entryCelsius);
        
        JRadioButtonMenuItem entryFaren = new JRadioButtonMenuItem("Fahrenheit");
        menuScale.add(entryFaren);
        
        /**
         * The following programming instructions will create a dropdown menu called "Help" containing 2 separated entries named "Instruction" and "About", and adds them to the menu bar. This block of programming instructions will also set triggers for each item such that selecting either item with spawn an alert box with relevant text on it.
         */
        JMenu menuHelp = new JMenu("Help");
        menubar.add(menuHelp);
        
        JMenuItem entryHelp = new JMenuItem("Instruction");
        menuHelp.add(entryHelp);
        //Alert box pop-up.
        entryHelp.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(rootPane, "This temperature converter is designed so that you can\nuse it without typing or use it on a tablet\nif you don't have a desktop. Just remember to first set the temperature scale\nyou want to convert from, type in the number you want to convert,\nthen finally select the temperature scale you wish to convert it to.\nIf you don't use backspace and you've made a mistake typing\nin the number you want, you can click the \"Clear\" button\non the pad on-screen to reset the number you typed back to\n\"0\" so that you can type it again. Thanks for using my program.");
            }
        });
        
        //ADDS SEPARATOR HERE!!
        menuHelp.addSeparator();
        
        JMenuItem entryAbout = new JMenuItem("About");
        menuHelp.add(entryAbout);
        entryAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(rootPane, "A Temperature Conversion Calculator by Miles-THugo");
            }
        });
        
        
        //celsButton: Convert to Celsius
        //farenButton: Convert to Fahrenheit
        //metricNote: text indicating metric
        //value: label strip input text
        //convertFlow: conversion buttons
        //labelFlow: value and metric text
        //labelPanel: labelFlow and convertFlow
        //numpad: individual button element
        //decimLButton: individual button element
        //minusButton: individual button element
        //clearButton: individual button element
        //numpadPanel: numPad, minusButton and clearButton
        
        //inputTag: instance of FloatInputPad
        //getThatTemp: instance of Temperature
        
        /**
         * From here on, all GUI objects and elements will be prepared together before being added to the window as opposed to being added immediately after the instruction defining it.
         */
        
        
        /**
         * The following programming instructions will create a GUI panel made to occupy the window using a grid-formatted layout manager. "labelPanel" is simply the panel containing the 2 flow panels that represent the temperature label and the scale buttons.
         */
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(2, 1, 10, 10));
        JPanel convertFlow = new JPanel();
        JPanel labelFlow = new JPanel();
        
        /**
         * The following programming instructions will create a text field which functions as the temperature label where the user will type the number they want (setting the digit limit to 25 characters and making the text read "0"), as well as a label which is a piece of text right next to the text box that remains visible, serving to indicate the current temperature scale. There are also instructions here that create 2 buttons reading "Convert to Celsius" and "Convert to Fahrenheit".
         */
        JTextField value = new JTextField("0", 25);
        JLabel metricNote = new JLabel();
        JButton celsButton = new JButton("Convert to Celsius");
        JButton farenButton = new JButton("Convert to Fahrenheit");
        
        /**
         * The following programming instructions will set metricNote so that "°C" is labelled next to the text box, will disable the "Convert to Celsius" button, and enable the "Convert to Fahrenheit" button. This is written here so that when the program loads, these settings take effect immediately.
         */
        farenButton.setEnabled(true);
        celsButton.setEnabled(false);
        metricNote.setText("°C");
        
        /**
         * "0" button
         */
        JButton numpad0 = new JButton("0");
        numpad0.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                contains0Action(numpad0, value, numpad0);
            }
        });
        
        /**
         * Decimal button
         */
        JButton decimLButton = new JButton(".");
        decimLButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = value.getText();
                text = text + decimLButton.getText();
                value.setText(text);
                decimLButton.setEnabled(false);
                numpad0.setEnabled(true);
            }
        });
        
        /**
         * The next several instructions written from here on all relate to making the temperature conversions happen to not only change the text in the temperature label, but also change the state of the buttons and the menu items under "Scale". 2 methods (namely "changeToCels()" and "changeToFaren()") will be made specifically for these actions to reduce code duplication, and they will be called in order to apply these conversions in relation to the relevant GUI objects.
         */
        /**
         * The following programming instructions will add functionality to the "Convert to Celsius" button. The instructions here should be familiar as they have been used & described above.
         */
        celsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeToCels(metricNote, value, farenButton, celsButton, entryCelsius, entryFaren, decimLButton);
            }
        });
        
        /**
         * The following programming instructions will add functionality to the "Celsius" item from the "Scale" menu. The instructions here should be familiar as they have already been used & are aforementioned.
         */
        entryCelsius.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeToCels(metricNote, value, farenButton, celsButton, entryCelsius, entryFaren, decimLButton);
            }
        });
        
        /**
         * The following programming instructions will add functionality to the "Convert to Fahrenheit" button. The instructions here should be familiar as they have already been used & are aforementioned.
         */
        farenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeToFaren(metricNote, value, farenButton, celsButton, entryCelsius, entryFaren, decimLButton);
            }
        });
        
        /**
         * The following programming instructions will add functionality to the "Fahrenheit" item from the "Scale" menu. The instructions here should be familiar as they have already been used & are aforementioned. 
This is the last of the several instructions previously mentioned.
         */
        entryFaren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeToFaren(metricNote, value, farenButton, celsButton, entryCelsius, entryFaren, decimLButton);
            }
        });
        
        /**
         * The following programming instructions will add, in a particular order, the GUI objects to the panel dedicated for the label now that they've been fully programmed.
First the text box is added to the labelFlow object, then the Scale indicator text is added to it afterward so that they remain next to each other in proper order. The "Convert to Celsius" button is added to the convertFlow object before the "Convert to Fahrenheit" button. Then finally the convertFlow object is added to the panel dedicated to the input label before the labelFlow object is, so the conversion buttons remain above the temperature label.
That wraps up the label panel, so a separate panel for the number pad buttons will follow.
         */
        labelFlow.add(value);
        labelFlow.add(metricNote);
        convertFlow.add(celsButton);
        convertFlow.add(farenButton);
        labelPanel.add(convertFlow);
        labelPanel.add(labelFlow);
        
        /**
         * The following programming instructions will create a GUI panel, from a grid-formatted layout manager, that will occupy the window. "numpadPanel" is the panel containing the number pad buttons from which the user can type in a value to convert.
         */
        JPanel numpadPanel = new JPanel();
        numpadPanel.setLayout(new GridLayout(5, 3, 2, 2));
        
        /**
         * The following programming instructions create a row of buttons on the number pad from 7 to 9, and also program them to change the temperature label appropriately when pressed. Then for each button programmed, there's a final instruction that adds each single button to the numpad panel.
         */
        for(int i = 7; i <=9; i++) {
            JButton numpad = new JButton(""+i);
            numpad.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    contains0Action(numpad, value, numpad0);
                }
            });
            
            numpadPanel.add(numpad);
        }
        
        /**
         * The following programming instructions do exactly the same thing as the previous set of instructions, but for a new row of buttons from 4 to 6.
         */
        for(int i = 4; i <=6; i++) {
            JButton numpad = new JButton(""+i);
            numpad.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    contains0Action(numpad, value, numpad0);
                }
            });
            
            numpadPanel.add(numpad);
        }
        
        /**
         * The following programming instructions do exactly the same thing as the previous set of instructions, but for a new row of buttons from 1 to 3.
         */
        for(int i = 1; i <=3; i++) {
            JButton numpad = new JButton(""+i);
            numpad.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    contains0Action(numpad, value, numpad0);
                }
            });
            
            numpadPanel.add(numpad);
        }
        
        /**
         * ((Minus button)) The following programming instructions do exactly the same thing as the previous set of instructions, but for a new row of buttons from 1 to 3.
         */
        JButton minusButton = new JButton("-");
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = value.getText();
                if(text.contains("-")) {
                    String new_text = text.replace("-", "");
                    value.setText(new_text);
                } else {
                    text = minusButton.getText() + text;
                    value.setText(text);
                }
            }
        });
        numpadPanel.add(minusButton);
        
        /**
         * "0" button.
         */
        // Code
        numpadPanel.add(numpad0);
        
        /**
         * The following pair of programming instructions will set the temperature label to "0", and ensure the "0" button is disabled in this state. As it's written here, this will take effect the moment the user loads the program.
         */
        value.setText("0");
        numpad0.setEnabled(false);
        
        
        /*/**
         * Decimal button
         */
        // code
        numpadPanel.add(decimLButton);
        
        /**
         * Clear
         */
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                value.setText("0");
                decimLButton.setEnabled(true);
                numpad0.setEnabled(false);
            }
        });
        numpadPanel.add(clearButton);
        
        value.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                if(!(value.getText()).contains(".")) {
                    decimLButton.setEnabled(true);
                } else {
                    decimLButton.setEnabled(false);
                }
                
                //Now for "0" button.
                if(!(value.getText()).startsWith("0")) {
                    numpad0.setEnabled(true);
                } else {
                    numpad0.setEnabled(false);
                    /*String new_text = value.getText().replace("0", "");
                    value.setText(new_text);*/
                    //value.setText("0"); -- Maybe we don't need to force the typing of 0s.
                }
                
                //Proof-of-concept to ignore non-numerical characters (keep "-" though).
                /* if(value.getText().contains(goodChars)) {
                    __
                } else {
                    __
                    /*String new_text = value.getText().replace("0", "");
                    value.setText(new_text);/
                    //value.setText("0");
                } */
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                if(!(value.getText()).contains(".")){
                    decimLButton.setEnabled(true);
                } else {
                    decimLButton.setEnabled(false);
                }
                
                //Now for "0" button.
                if(!(value.getText()).startsWith("0")) {
                    numpad0.setEnabled(true);
                } else {
                    numpad0.setEnabled(false);
                    //value.setText("0");
                }
            }
        });
        
        this.add(labelPanel, BorderLayout.NORTH);
        this.add(numpadPanel, BorderLayout.CENTER);
    }
    
    /**
     * Main method. Intialises the GUI window.
     */
    public static void main (String[] args)
    {
        pakConverterGUI gui = new pakConverterGUI();
        gui.setVisible(true);
    }
    
    /**
     * The instructions in this method will invert the states of the conversion buttons as well as the Scale menu items, change the reading next to the temperature label to "°C", calculate the conversion of the input number from Fahrenheit to Celsius, and then replace the text on the temperature label input with the result.
     */
    private void changeToCels(JLabel metricNote, JTextField value, JButton farenButton, JButton celsButton, JMenuItem entryCelsius, JMenuItem entryFaren, JButton decimLButton) {
        farenButton.setEnabled(true);
        celsButton.setEnabled(false);
        entryCelsius.setSelected(true);
        entryFaren.setSelected(false);
        metricNote.setText("°C");
        
        /**
         * Handler to make use of input registry methods from FloatInputPad (rather than
         * using 'Double.parseDouble()'.
         */
        // this.inputTag.splitInput(value.getText());
        try{
            this.inputTag.splitInput(value.getText());
        }catch (java.lang.NumberFormatException emptyString){
            System.out.println("Apparently your input is empty...");
            value.setText("0");
            decimLButton.setEnabled(true);
        }
        
        /**
         * "farenReading" is simply a variable used to store the number in the temperature label in the case where the temperature is about to go through Celsius conversion. "finalValue" simply stores the result of the conversion and replaces the text in the temperature label with it.
         */
        double farenReading = this.inputTag.getTempInput();//CHANGE IT TO USE THE FLOATINPUTPAD!
        Temperature getThatTemp = new Temperature(farenReading);
        double finalValue = getThatTemp.convertToCelsius();
        value.setText(String.valueOf(df.format(finalValue)));
    }
    private void changeToFaren(JLabel metricNote, JTextField value, JButton farenButton, JButton celsButton, JMenuItem entryCelsius, JMenuItem entryFaren, JButton decimLButton) {
        farenButton.setEnabled(false);
        celsButton.setEnabled(true);
        entryCelsius.setSelected(false);
        entryFaren.setSelected(true);
        metricNote.setText("°F");
        
        try{
            this.inputTag.splitInput(value.getText());
        }catch (java.lang.NumberFormatException emptyString){
            System.out.println("Apparently your input is empty...");
            value.setText("0");
            decimLButton.setEnabled(true);
        }
        
        /**
         * "celsReading" is simply a variable used to store the number in the temperature label in the case where the temperature is about to go through Fahrenheit conversion.
         */
        double celsReading = this.inputTag.getTempInput();
        Temperature getThatTemp = new Temperature(celsReading);
        double finalValue = getThatTemp.convertToFaren();
        value.setText(String.valueOf(df.format(finalValue)));
    }
    
    /**
     * The instructions in this method tell the program what to do if a numerical numpad button is pressed depending on if the temperature label reads "0" or not.
     */
    private void contains0Action(JButton numpad, JTextField value, JButton numpad0) {
        /**
         * "text" is simply a temporary variable for the value in the temperature label.
         */
        String text = value.getText();
        if(text.equals("0")) {
            text = numpad.getText();
            if(text != "0"){
                value.setText(text);
                numpad0.setEnabled(true);
            }else{
                numpad0.setEnabled(false);
            }
        } else {
            if(text == "" && numpad.getText() == "0"){
                text = numpad.getText();
                value.setText(text);
                numpad0.setEnabled(false);
            }else{
                text = text + numpad.getText();
                value.setText(text);
                numpad0.setEnabled(true);
            }
        }
    }
}

