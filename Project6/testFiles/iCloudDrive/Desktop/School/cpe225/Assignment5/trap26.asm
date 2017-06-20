.ORIG x3300

; save PC from UP1 into a hard-coded memory location (x32FF)
STI R7 UP1 ; The original address prior to calling the trap in UP1 would be stored in R7


; Turn on the interrupt enable bit in the KBSR by storing x4000 into xFE00
LD R3, ENABLEBIT14; load R3 with x4000
STI R3, KBSR; load x4000 into xFE00

; JMP to UP2
LD R2, UP2 ; load R2 with location of UP2
JMP R2

;LABELS
UP1 .FILL x32FF
ENABLEBIT14 .FILL x4000 ; 14th bit
KBSR .FILL xFE00
UP2 .FILL x3400

.END