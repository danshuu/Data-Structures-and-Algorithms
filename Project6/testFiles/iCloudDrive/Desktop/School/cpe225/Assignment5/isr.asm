; Interrupt Service Routine services the interrupt for the KB device

.ORIG x3500

; get the character from KBDR. Don't use a trap for it
LDI R0, KBDR ; load whatever's in KBDR into R0 (the character)


; Clear KBSR (ready bit and interrupt enable bit)
LD R4, CLEAR ; clear R4
STI R4, KBSR

; use RTI to return to UP1. The PC of UP1 needs to be written over the PC of UP2 on the stack. The PC of UP2 needs to be on the current top of the stack. You MUST use the stack pointer for this operation
;ADD R6, R6, #-1; decrement Stack pointer (apparently RTI automatically does this)
;STR R0, R6, #0; store the character into the pointer (apparently RTI automatically does this)

; you don't need to update R0 as when the interrupt occurs, the R0 will be iupdated with the input of the keyboard
; Thus you need to store whats in x32FF (the original address prior to calling the trap) into R5 so you can RTI into it
LDI R5, UP1 ; store what's in x32FF into R5
STR R5, R6, #0; store R5 into R6

RTI

;LABELS

KBSR .FILL xFE00
KBDR .FILL xFE02
CLEAR .FILL x0000
UP1 .FILL x32FF

.END