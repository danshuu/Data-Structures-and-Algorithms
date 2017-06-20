	.ORIG	x3000

	; load x3300 into x0026

	LD R5, TRAPLOCATION
	STI R5, TRAP26

	; load x3500 into x0180
	LD R5, IVTLOCATION
	STI R5, IVT

	; initialize the stack pointer (stored in R6) to x3000 
	LD R6, STACK
	
	; (The BASE address of the stack is always the address before, which is at x2FFF) because in a PUSH you will decrement R6 and then store the value into R0
	; in a POP you will load R6 into R0, then increment R6, and do something with R0 after you RTI



LOOP	TRAP	x26  ; get char
	TRAP	x21  ; print char to screen
	TRAP	x26  ; get char
	TRAP	x21  ; print char to screen
	TRAP	x26  ; get char
	TRAP	x21  ; print char to screen
	TRAP	x26  ; get char
	TRAP	x21  ; print char to screen
	TRAP	x26  ; get char
	TRAP	x21  ; print char to screen
	LEA	R0, END_MSG
	PUTS
	BRnzp LOOP

	; LABELS
	; TRAP
	TRAPLOCATION .FILL x3300
	TRAP26 .FILL x0026

	; Interrupt Vector Table
	IVT .FILL x0180
	IVTLOCATION .FILL x3500

	; STACK
	STACK .FILL x3000



END_MSG .STRINGZ "\nSuccess!  Running again...\n"
        .END