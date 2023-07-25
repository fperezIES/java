# Software testing

## Introduction to Test Driven Development - Exercise solutions

> **Exercise 1:** 
> 
> Create a project called **PasswordTDD** with a class called `PasswordCheck` and a static method called `check` that receives a password (string) as a parameter and checks if this password is valid or not. A password will be valid if:
>
> * It's between 5 and 10 characters
> * It contains at least one digit
> * It contains at least one lower case letter from a to z
> * It contains at least one upper case letter from A to Z
> 
> Design the test cases for this method and implement its code applying the TDD aproach.

In this document we are going to design the test cases for this function. A possible test case table could be this one:

|Test case|Name|Input|Expected result|
|---|---|---|---|
|TC1|Null|null|false|
|TC2|TooShort|"Ab1"|false|
|TC3|TooLong|"aaAbbBccC222"|false|
|TC4|NoDigits|"abcde"|false|
|TC5|NoLowerCase|"123ABC"|false|
|TC6|NoUpperCase|"abc123"|false|
|TC7|OK|"ab12CD"|true|

You have the corresponding project attached to these test cases in the same ZIP file.