# xml-html-renamer

Very simple script to loop around some xml or html fragment and modify the elements.

It took me a while to succeed, mainly because the renameNode method from dom3 core has not been implemented by browsers and the javascript community. Only within JAVA have I found it. 


## You will find here ##

### a single html page version ###
In plain javascript, launched from a browser, you cannot access directly a file (nor write files). Therefore, in this solution, the user has to choose the file by clicking on the button.
 * Chrome erases the content of the boxes and the name of the file at each page reload
 * Firefox keeps the content and the file... which is good at usage, but made things very complicated during the debugging 
 
 
### the java version ###
At first I thought to simply use Xalan or Xerces, but all the tools are directly available from the jdk (maybe even from the jre). 

### the electron app version ###
I didn't bundle the complete app, so you have just the render.js with the direct file access, and the html file.


 
 
 ![converter renamer example on Romeo and Juliet](https://github.com/fxpar/xml-html-renamer/blob/master/screenshots/screen_20191231_212330.png)
 
 Notice that SELF-CLOSING elements are throwing errors during parsing. 
