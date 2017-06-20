; Daniel Shu
; CPE225 Assignment#7
; charCount.asm

.ORIG x3300

; *************** CALLEE SETUP *****************
; Start of the Activation Record
RECURSE ADD R6, R6, #-1 ; allocate spot for return value

		ADD R6, R6, #-1 ; allocate spot for return address
		STR R7, R6, #0 ; push return address

		ADD R6, R6, #-1 ; allocate spot for dynamic link
		STR R5, R6, #0 ; push dynamic link

		ADD R5, R6, #-1 ; set new frame pointer
		ADD R6, R6, #-1 ; allocate spot for local variables (result)

		LDR R1, R6, #5 ; R1 holds char
		LDR R2, R6, #4 ; R2 holds str[0]
		LDR R2, R2, #0 ;
; *************** CHECK FOR 0 ******************
; *************** if (*str == 0) ***************
		BRz ZERO

; *************** CHECK FOR C ******************
ELSE 	NOT R2, R2
	 	ADD R2, R2, #1 ; make char negative

	 	ADD R3, R2, R1 ; subtract char from str[x] to see if they're equal

; *************** if (*str == c) ***************
	 	BRz INCREMENTCOUNT ;

; *************** else ***************
	 	AND R4, R4, #0 ; clear 0
	 	STR R4, R6, #0 ; store 0 into result 
	 	BRnzp PUSHARGS ; if null character (end of string)

ZERO 	AND R4, R4, #0 ; clear 0
	 	STR R4, R6, #0 ; store 0 into result

	 	ADD R6, R6, #1 ; pop local variable 

	 	LDR R5, R6, #0 ;
	 	ADD R6, R6, #1 ; pop dynamic link

	 	LDR R7, R6, #0 ; load 
	 	ADD R6, R6, #1 ; pop return address

	 	BRnzp THEEND

INCREMENTCOUNT AND R4, R4, #0 ; return 0
		ADD R4, R4, #1 ; add one to R4
	 	STR R4, R6, #0 ; store 0 into result

PUSHARGS LDR R2, R6, #5  ; load c into R2
		 ADD R6, R6, #-1 ; decrement R6
		 STR R2, R6, #0  ; push c into stack

		 LDR R0, R5, #4  ; 
		 ADD R0, R0, #1  ; increment str[location]
		 ADD R6, R6, #-1 ;
		 STR R0, R6, #0  ; push new str[location] onto stack

		 JSR RECURSE ; make recursive call

THEEND AND R0, R0, #0 ; clear r0
	   LDR R0, R5, #0 ; 
	   LDR R1, R6, #0 ;

	   ADD R0, R1, R0 ; result += charCount(str+1, c);

	   ADD R6, R6, #4 ; pop args

	   LDR R5, R6, #0 ;
	   ADD R6, R6, #1 ; pop dynamic link

	   LDR R7, R6, #0 ;
	   ADD R6, R6, #1 ; pop return address

	   STR R0, R6, #0 ;

	   RET

.END
