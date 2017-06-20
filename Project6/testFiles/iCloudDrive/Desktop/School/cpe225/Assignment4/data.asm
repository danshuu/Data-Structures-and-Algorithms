; Daniel Shu
; CPE 225
; Assignment 4
; Data for the quiz
	 .ORIG 	x3300




Q1        .STRINGZ  "\nWho is your favorite basketball team?\n   1 - Lakers\n   2 - Warriors\n   3 - Cavs\n   4 - Spurs\n"
Q1Answ   .FILL    #4
         .FILL    #2
         .FILL    #6
         .FILL    #7

Q2    	 .STRINGZ  "\nWhat is your favorite city?\n   1 - Los Angeles\n   2 - Montana\n   3 - NYC\n   4 - San Francisco\n"
Q2Answ   .FILL    #2
         .FILL    #0
         .FILL    #6
         .FILL    #5

Q3    	 .STRINGZ  "\nWho's the best NBA player?\n   1 - Lebron\n   2 - Curry\n   3 - KD\n   4 - Kanye\n"
Q3Answ   .FILL    #8
         .FILL    #3
         .FILL    #7
         .FILL    #10

; results can range from 0-22

; if result are between 0-5
Result1	.STRINGZ  "\nYou fail!"

; if results are between 6-12
Result2	.STRINGZ  "\nEhhh"

; if results are between 13-18
Result3	.STRINGZ  "\nNot bad, but you can do better."

; if results are between 19-22
Result4	.STRINGZ  "\nYou win!"

	.END