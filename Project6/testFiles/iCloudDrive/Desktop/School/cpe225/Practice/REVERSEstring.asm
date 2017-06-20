; Practice program that prints out words in reverse using a stack

.ORIG x3000

AND R2, R2, #0 ; clear R2 for temp
LD R6, STACK ; loads beginning of stack into R6
AND R1, R1, #0 ; charTracker = 0
LEA R0, PROMPT ; load prompt
PUTS ; print "Enter a word or sentence: "

; Get the character and print to console
INPUT GETC
	  OUT

ADD R2, R0, #-10 ; check if newline
BRz CHECKTRACKER
JSR PUSH 
BRnzp INPUT

CHECKTRACKER ADD R1, R1, #0;
			 BRz DONE
			 JSR POP
			 OUT ; print char that was just popped
			 BRnzp CHECKTRACKER

DONE HALT;

PUSH ADD R6, R6, #-1 ; decrement R6 to push
	 STR R0, R6, #0 ; push char into stack
	 ADD R1, R1, #1 ; increment charTracker
	 RET

POP LDR R0, R6, #0 ; load char into R0
	ADD R6, R6, #1 ; increment R6 to pop
	ADD R1, R1, #-1 ; decrement charTracker
	RET


; LABELS
PROMPT .STRINGZ "Enter a word or sentence: "
STACK .FILL x3000

.END