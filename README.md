*Project was created with Java-Selenium.*

``Maven`` were used as build automation tool, to create framework. 
main tools and additional classes:

``librarys added to maven:``
Java-Selenium 3.141.59 ; WebDrivermanager (bonigarcia) 5.3.1 ; TestNG 7.7.0 ;
you also can find javafaker 1.0.2 in pom.xml, I am didn't get it during the test. 




*``utils Package:``*

``Driver`` (utile) were created, with Singleton Pattern Design. Works with both Chrome and Fire-Fox browsers. Also has inside:

``Configuration.properties`` created to prevent hard coding, geting on same url, also used for search value.



``tools_Utils`` has three custom methods, first to handle a special requirement for output.
Second to make code more readable. Third Sleep method to prevent internet connection issues. 

!!! I need sleep test for ``2 sec`` in the loop beacouse of internet connection 