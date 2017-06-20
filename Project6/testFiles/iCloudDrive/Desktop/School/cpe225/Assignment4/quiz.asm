; Daniel Shu
; Thinh Lun
; CPE 225
; Assignment 4
; This assignment allows the user to take a quiz and outputs the results

.ORIG x3000

; Display/Prompt Question 1 *********
START LD R0, Q1
PUTS
;HALT (why would you halt?)

AND R4, R4, #0 ; clear R4 (result counter)
;print Answer:
LEA R0, ANSWERPROMPT
PUTS

GETC ; gets number in R0
OUT;
ADD R1, R0, #0 ; R1 hold holds the integer value
LD R3, Q1ANS
LD R5, NEG_ONE
ADD R1, R1, R5 ; check to see if the input was a 1
BRz FIRST
ADD R1, R1, #-1 ; check to see if the input was a 2
BRz SECOND
ADD R1, R1, #-1 ; check to see if the input was a 3
BRz THIRD
ADD R1, R1, #-1 ; check to see if the input was a 4
BRz FOURTH


FIRST LDR R2, R3, #0 ; load the value of the answer in choice 1
BRnzp COUNTER ; branch to ADD the result counter with this answer grade points
SECOND LDR R2, R3, #1 ; load the value of the answer in choice 2
BRnzp COUNTER
THIRD LDR R2, R3, #2 ; load the value of the answer in choice 3
BRnzp COUNTER
FOURTH LDR R2, R3, #3 ; load the value of the answer in choice 4

COUNTER ADD R4, R2, R4 ; ADD counter with Qresult


; Display/Prompt Question 2 *********
LD R0, Q2
PUTS
;HALT (why would you halt?)

;print Answer:
LEA R0, ANSWERPROMPT
PUTS

GETC ; gets number in R0
OUT;
ADD R1, R0, #0 ; R1 now holds the integer value
LD R3, Q2ANS
; LD R5, NEG_ONE (never changed)
ADD R1, R1, R5 ; check to see if the input was a 1
BRz FIRST2
ADD R1, R1, #-1 ; check to see if the input was a 2
BRz SECOND2
ADD R1, R1, #-1 ; check to see if the input was a 3
BRz THIRD2
ADD R1, R1, #-1 ; check to see if the input was a 4
BRz FOURTH2


FIRST2 LDR R2, R3, #0
BRnzp COUNTER2
SECOND2 LDR R2, R3, #1
BRnzp COUNTER2
THIRD2 LDR R2, R3, #2
BRnzp COUNTER2
FOURTH2 LDR R2, R3, #3

COUNTER2 ADD R4, R2, R4 ; ADD counter with Qresult


; Display/Prompt Question 3 *********
LD R0, Q3
PUTS
;HALT (why would you halt?)

;print Answer:
LEA R0, ANSWERPROMPT
PUTS

GETC ; gets number in R0
OUT;
ADD R1, R0, #0 ; R1 now holds the integer value
LD R3, Q3ANS
; LD R5, NEG_ONE (never changed)
ADD R1, R1, R5 ; check to see if the input was a 1
BRz FIRST3
ADD R1, R1, #-1 ; check to see if the input was a 2
BRz SECOND3
ADD R1, R1, #-1 ; check to see if the input was a 3
BRz THIRD3
ADD R1, R1, #-1 ; check to see if the input was a 4
BRz FOURTH3


FIRST3 LDR R2, R3, #0
BRnzp COUNTER3
SECOND3 LDR R2, R3, #1
BRnzp COUNTER3
THIRD3 LDR R2, R3, #2
BRnzp COUNTER3
FOURTH3 LDR R2, R3, #3

COUNTER3 ADD R4, R2, R4 ; ADD counter with Qresult


; check results by subtracting to see which result it would be

ADD R4, R4, #-5
BRnz FAIL
ADD R4, R4, #-7
BRnz BAD
ADD R4, R4, #-6
BRnz OKAY
; ADD R4, R4, #-4 (unnecessary)
BRnzp GOOD ; skip straight to GOOD result


; Print Results of the quiz after all 3 questions *******

FAIL LD R0, RESULTONE ; print result 1
BRnzp PRINT
BAD LD R0, RESULTTWO ; print result 2
BRnzp PRINT
OKAY LD R0, RESULTTHREE ; print result 3
BRnzp PRINT
GOOD LD R0, RESULTFOUR ; print result 4

PRINT PUTS

BRnzp START ; continual loop of program


; LABELS

ANSWERPROMPT .STRINGZ "Answer: "

NEG_ONE .FILL xFFCF

Q1 .FILL x3300
Q2 .FILL x3363
Q3 .FILL x33C7

Q1ANS .FILL x335F
Q2ANS .FILL x33C3
Q3ANS .FILL x3416

RESULTONE .FILL x341A
RESULTTWO .FILL x3425
RESULTTHREE .FILL x342B
RESULTFOUR .FILL x344C



.END