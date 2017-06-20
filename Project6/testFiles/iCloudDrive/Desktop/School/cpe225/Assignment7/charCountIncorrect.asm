; subroutine for CHAR_COUNT

.ORIG x3300

; Save space for return value 

; Callee Setup
; --------------------------------------------------
CHARC ADD R6, R6, #-1 ; Move R6 up

; Store return address
ADD R6, R6, #-1 ; Move R6 up
STR R7, R6, #0 ; R7 holds the return address

; Load R5 into dynamic link (Right above return address) ; Also the caller's frame pointer
ADD R6, R6, #-1 ; 
STR R5, R6, #0 ;

ADD R5, R6, #-1 ; Set new frame pointer
ADD R6, R6, #-1 ; Allocate memory for local variables
;----------------------------------------------------

; Store arguments from activation record
LDR R2, R6, #4 ; R2 holds *str[x] 
LDR R3, R6, #5 ; R3 holds *c[0]
LDR R2, R2, #0 ;

; BASE CASE
; ----------- (if (*str == 0)) ----------------------
BRz DONE ;
BRnzp CHECKFORCHAR ;

DONE AND R1, R1, #0 ; result = 0;
	 STR R1, R6, #4 ; store 0 into return value (result + 4)

	STR R0, R5, #3 ; Write it in return value slot

	; "Pop" local variables
	ADD R6, R5, #1 ; 

	; "Pop" dynamic link
	LDR R5, R6, #0 ; 
	ADD R6, R6, #1

	; "Pop" the return address
	LDR R7, R6, #0
	ADD R6, R6, #1
	BRnzp END ; Jump to CALLEETEARDOWN

; ----------- (else) ----------------------

; Turn search negative so you can check for it
CHECKFORCHAR NOT R3, R3 ;
			 ADD R3, R3, #1 
			 ADD R4, R3, R2 ; Check if first letter is equal to searched char

BRnp NOTEQUAL

; ----------- (if (*str == c)) ----------------------
AND R1, R1, #0 ; Clear R1 to add 1 to result
ADD R1, R1, #1 ;
STR R1, R6, #0 ; store into result
BRnzp NEXT 




; ----------- (Else) ----------------------
NOTEQUAL AND R1, R1, #0 
		 STR R1, R6, #0
		 

NEXT 
	 ADD R6, R6, #-1
	 NOT R3, R3 ;
	 ADD R3, R3, #1 ;
	 STR R3, R6, #0 ;

	 LDR R1, R5, #4 
	 ADD R1, R1, #1
	 ADD R6, R6 #-1

	JSR CHARC;
	

; Ending Callee Function
; CALLEE TEARDOWN --------------------
END LDR R1, R5, #0
	LDR R0, R6, #0
	ADD R2, R1, R0 ; 

	ADD R6, R6, #4
	LDR R5, R6, #0
	ADD R6, R6, #1 ; pop

	LDR R7, R6, #0
	ADD R6, R6, #1

	STR R2, R6, #0

	RET

; LABELS
; MAINRETURN .FILL x3024 ; Address after JSRR was called
SEARCH .FILL x2FEB 

.END