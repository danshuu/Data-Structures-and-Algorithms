; Daniel Shu
; CPE225 Assignment 7

          .ORIG x3300

          ;*********************************************************
          ADD R6, R6, #-1 ;lets allocate a spot for the ret value

          ADD R6, R6, #-1 ;decrement r6 for the ret &
          STR R7, R6, #0  ;push our r7 onto the stack

          ADD R6, R6, #-1; decrement r6 for the dyn link
          STR R5, R6, #0  ; push dyn link

          ADD R5, R6, #-1 ; set new frame pointer
          ADD R6, R6, #-1 ; allocate memory for the local variable of charCount
          ;***********************************************************
          ;if
          LDR R1, R5, #5 ; LD r1 with c
          LDR R0, R5, #4 ; LD r0 with the index of array
          LDR R0, R0, #0
          BRZ ZERO
          ;else

            ;if
          NOT R1, R1
          ADD R1, R1, #1
          ADD R2, R1, R0 ; Check if the spot in the array is a char we are looking for
          BRZ CHAR
            ;else
          AND R0, R0, #0 ; clear r0
          STR R0, R5, #0 ; put 0 into result
          BR NEXT

ZERO      AND R0, R0, #0 ; clear r0
          STR R0, R5, #3 ; put 0 into return

          ADD R6, R5, #1 ; Pop the local variable

          LDR R5, R6, #0 ;
          ADD R6, R6, #1 ; POP dynamic link

          LDR R7, R6, #0 ;
          ADD R6, R6, #1 ; POP return address
          BR END

CHAR      AND R0, R0, #0; clear r0
          ADD R0, R0, #1; put 1 into result
          STR R0, R5, #0; put 1 into what r5 is pointing to (the variable result)

NEXT      LDR R0, R5, #5 ; put c into r1
          ADD R6, R6, #-1; decrement r6
          STR R0, R6, #0 ; push c onto the stack

          LDR R0, R5, #4 ;
          ADD R0, R0, #1 ;
          ADD R6, R6, #-1; decrement r6
          STR R0, R6, #0 ;

          LD R0, CHARCOUNT
          JSRR R0

END       AND R0, R0, #0; clear r0
          LDR R0, R5, #0; put what r5 is pointing to in r0
          LDR R1, R6, #0; put what r6 is pointing to in r1

          ADD R0, R1, R0; result += charCount(str+1, c);

          ADD R6, R6, #4; pop argv

          LDR R5, R6, #0;
          ADD R6, R6, #1; pop dynamic link

          LDR R7, R6, #0;
          ADD R6, R6, #1; pop return &

          STR R0, R6, #0; put this bitch into return

          RET





TOA       .FILL x2FEC ; the top of the array
CHARCOUNT .FILL x3300 ;

          .END
