# CharacterCounter


A simple JavaFX frontend where the user can enter a text. The application shall display the characters of the entered text with the highest occurrence. Here is an example.

-as soon as the user updates the text, the result is updated -all characters are converted to lower space (’T’ counts as ’t’) 
-spaces are not counted 
-if multiple characters have the same occurrence, they are all listed up.

Additionally the following details should be considered:

-There should be a clean separation of frontend and business logic 
-The business logic should have a unit test (e.g. JUnit) with a complete coverage 
-The result should be a self contained Maven (or Gradle) project containing: 
--The business logic 
--A Unit test for the business logic
--The JavaFX frontend

