; Displays asterisks to the screen in an endless loop

	.ORIG x3400

; create a loop that adds one to a register each time through the loop. When the register becomes negative, the program prints an asterisk to the screen. Then the register is reset to zero and the loop is started again.
; -> use TRAPx21 to output character to the screen


	LD R0, ASTERISK ; load * ASCII character into R0
	AND R1, R1, #0 ; clear R1

LOOP2 ADD R1, R1, #1;
	BRzp LOOP2
	OUT
	AND R1, R1, #0
	BRnzp LOOP2


; LABELS
ASTERISK .FILL x002A

.END