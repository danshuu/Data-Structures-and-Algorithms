; Daniel Shu
; CPE 225
; Assignment 4
; TRAP that takes input and prints it out

; TRAP x26

; trap routine should originate at memory location x3300
; R0 should contain the starting address of where the string should be stored (block)
; trap should quit when user presses <enter> key


;JSR -> x3300 (manually input x3300)

	.ORIG x3300

	ST R0 SAVER0;
	ST R1 SAVER1;
	ST R2 SAVER2;
	ST R3 SAVER3;
	ST R7 SAVER7;

	LD R1 SAVER0; R1 holds the address of the STORE

; get input

POLL LDI R0, KBSR ; if character is inputted, 15th bit will be a 1 (only used to see if a char was inputted, and then R0 is subsequently overwritten with the ASCII value)
	BRzp POLL ; branch back if no character was inputted (POLLING)
	LDI R0, KBDR ; load whatever character ASCII was inputted into R0
	ADD R2, R0, #-10; subtract 10 from the ASCII value of whatever 
	BRz RETURN
	STR R0, R1, #0; store the ASCII value into R1
	ADD R1, R1, #1; increment R1 (address of block)


; write input into DDR/DSR

POLL2 LDI R3, DSR; loads the ready/nonready bit in DSR into R3 so we know if its ready or not to display
	BRzp POLL2;
	STI R0, DDR; stores the character stored in R0 into DDR 

	BRnzp POLL;

	
; done with storing input, now echo it to console

RETURN 
	AND R5, R5, #0;
	STR R5, R1, #0

	LD R0, SAVER0 ;
	LD R1, SAVER1 ;
	LD R2, SAVER2 ;
	LD R3, SAVER3 ;
	LD R7, SAVER7 ; load back the address that was in r7, and return *** is this even necessary?***
	RET

;LABELS

KBSR .FILL xFE00 
KBDR .FILL xFE02 
DSR .FILL xFE04
DDR .FILL xFE06

SAVER0 .FILL x0000
SAVER1 .FILL x0001
SAVER2 .FILL x0002
SAVER3 .FILL x0003
SAVER7 .FILL x0007

	.END



