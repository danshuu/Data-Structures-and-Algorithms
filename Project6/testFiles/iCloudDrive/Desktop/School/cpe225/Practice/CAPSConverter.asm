;Main
.ORIG x3000
REPEAT GETC ; read the character
JSR TO_CAP; jumps to the subroutine
ADD R0, R0, #0
BRz EXIT
OUT
BRnzp REPEAT
EXIT HALT

;subroutine
TO_CAP ST R1, SAVER1;
LD R1, NEG_A
ADD R1, R0, R1
BRzp CHECKIFSYMBOL
;if it gets here, then it was never a lower case letter
CLEAR AND R0, R0, #0;
BRnzp END
CHECKIFSYMBOL LD R1, FIRSTSYMBOL
ADD R1, R0, R1
BRzp CLEAR
LD R1, CONVERT
ADD R0, R0, R1
END LD R1, SAVER1
RET

SAVER1 .FILL x0000
NEG_A .FILL x-61
FIRSTSYMBOL .FILL x-7B
CONVERT .FILL x-20
.END



