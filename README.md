# Object-oriented_Temperature-Converter demonstration
Farenheit and Celsius temperature numpad (Java GUI) program created for university.
There is both the compiled version and appropriately named package version here (for demonstration).

The class (<interediate converter interface class>) was written as a template for how I wanted the arithmetic data to be processed, but I ended up not using it. It's now preserved for documentative purposes.

  
  -------------------------------------------------------------------------------------
  [General description]{{
  
------------------------------------------------------------------------
This project contains a variety of graphical interface features. Each 
feature will be covered individually with all examples of where used.
Firstly, GUI component features, one being JButtons. There are 7 
instances of a JButton being used in this program in total (1 instance 
of which is reapplied multiple times to create 9 JButtons with the 
same instance name, that being "numpad". So it could be considered 15 
total), and they include the 2 "Convert to <scale>" buttons 
("celsButton" and "farenButton"), the "Clear" button ("clearButton"), 
the "-" button ("minusButton"), the "." button ("decimLButton"), the 
"0" button ("numpad0"), and the other numerical buttons ("numpad"). 

A 2nd GUI component used here is JPanels, of which there are 4 
instances. 2 of these are used to sort of design flow layouts, but they 
use the JPanel to class to accomplish this. These 4 include the JPanel 
for the conversion buttons ("convertFlow"), one for the input label and 
the metric text indicator ("labelFlow"), one to put the previous 2 
'flow layouts' together ("labelPanel"), and lastly one to aggregate all 
the numpad buttons ("numpadPanel").

Another GUI component used here is a simple text box for the input 
label strip, an instance of JTextField ("value").

Alongside the previous component, a text label was used as an indicator 
for the temperature scale, and this was simply a JLabel instance 
("metricNote").

A 5th GUI component used was menu bars containing menus and menu items. 
Needless to say there's only 1 instance of a JMenuBar ("menubar"), 
however, there are 3 instances of JMenu ("menuFile", "menuScale" and 
"menuHelp") all elaborated in the comments of the main java file 
("ConverterGUI.java"), and 5 instances of JMenuItem ("entryCelsius", 
"entryFaren", "entryExit", "entryHelp" and "entryAbout"-- the first 2, 
while being a type of menu item, are actually a 6TH GUI component used, 
each an instance of JRadioButtonMenuItem (rather than of JMenuItem)!)

The 7th and last GUI component used here is a Separator for grouping 
menu items! It seems they are not really their own class, but rather an 
aspect of the JMenu class. Fittingly, this is used to emphasise the 
difference between "Instruction" and "About" in the "Help" menu (more 
of a personal choice, I don't feel they belong (close) together).



Now as far as the other graphical interface features{layout managers} 
are concerned, there are only 2 instances of layout managers set: each 
(to create grids) for the complete/overall panels contained within the 
program window (one for "labelPanel" and the other for "numpadPanel").

Everything else related to the layout of the program window and its 
components are more a matter of Bounds and dimensions rather than 
Java's dedicated graphical interface features (nothing to do with 
layout managers or GUI components).

------------------------------------------------------------------------
  }}

