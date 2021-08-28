# StringCalculator
This repository contains String Calculator master code. It supports addition of number which is given by string format. We can also give dynamic delimiter. It also support different type of validation like no support for negative numbers.

<h1>String Calculator</h1>

<b>Create a simple String calculator with a method signature:</b><br/>
———————————————<br/>
int Add(string numbers)<br/>
———————————————<br/>
The method can take up to two numbers, separated by commas, and will return their sum. <br/>
for example “” or “1” or “1,2” as inputs.<br/>
(for an empty string it will return 0) <br/>
<b>Hints:</b><br/>
——————<br/>
Start with the simplest test case of an empty string and move to one and two numbers<br/>
Remember to solve things as simply as possible so that you force yourself to write tests you did not think about<br/>
Remember to refactor after each passing test<br/>
———————————————————————————————<br/>
<b>Allow the Add method to handle an unknown amount of numbers</b><br/>
————————————————————————————————<br/>
<b>Allow the Add method to handle new lines between numbers (instead of commas).</b><br/>
the following input is ok: “1\n2,3” (will equal 6)<br/>
the following input is NOT ok: “1,\n” (not need to prove it - just clarifying)<br/>
——————————————————————————————-<br/>
<b>Support different delimiters</b><br/>
to change a delimiter, the beginning of the string will contain a separate line that looks like this: “//[delimiter]\n[numbers…]” for example “//;\n1;2” should return three where the default delimiter is ‘;’ .<br/>
the first line is optional. all existing scenarios should still be supported<br/>
————————————————————————————————<br/>
<b>Calling Add with a negative number will throw an exception “negatives not allowed” - and the negative that was passed.</b><br/>
if there are multiple negatives, show all of them in the exception message.<br/>
————————————————————————————————<br/>
<b>Numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2</b><br/>
————————————————————————————————<br/>
<b>Delimiters can be of any length with the following format: “//[delimiter]\n” for example: “//[***]\n1***2***3” should return 6</b><br/>
————————————————————————————————<br/>
<b>Allow multiple delimiters like this:</b><br/> “//[delim1][delim2]\n” for example “//[*][%]\n1*2%3” should return 6.<br/>
————————————————————————————————<br/>
<b>make sure you can also handle multiple delimiters with length longer than one char</b>

<b>The TDD Test Case execution result are attached here with</b>
![image](https://user-images.githubusercontent.com/57661407/131221262-b297d30b-3bcf-40bb-9f1b-c9531ef27c87.png)

