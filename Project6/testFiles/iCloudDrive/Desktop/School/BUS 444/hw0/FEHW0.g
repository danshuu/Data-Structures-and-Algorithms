new;

@*************************************************************@
@**********************Begin Control Panel *******************@
@*************************************************************@
swtHomeworkWeight = 0.250; @ the homework weight - as a decimal @
swtMidtermWeight = 0.350; @ the midterm weight - as a decimal @
swtFinalWeight = 0.400; @ the final exam weight - as a decimal @

swtNumStudents = 5; @ number of students to process @

swtReadFrom = 8; @ a scalar, indicating which drive to READ from @
@ 1 = a, 3 = c, 4 = d, 5 = e, 6 = f, 7 = g, 8 = h, 9 = Using a Mac @

swtWriteTo = 8; @ a scalar, indicating which drive to WRITE from @
@ 1 = a, 3 = c, 4 = d, 5 = e, 6 = f, 7 = g, 8 = h, 9 = Using a Mac @

if swtReadFrom == 1;
    load GradeDataIn[5,4] = a:\bus444\hw0\grades.csv;
elseif swtReadFrom == 3;
    load GradeDataIn[5,4] = c:\bus444\hw0\grades.csv;
elseif swtReadFrom == 4;
    load GradeDataIn[5,4] = d:\bus444\hw0\grades.csv;
elseif swtReadFrom == 5;
    load GradeDataIn[5,4] = e:\bus444\hw0\grades.csv;
elseif swtReadFrom == 6;
    load GradeDataIn[5,4] = f:\bus444\hw0\grades.csv;
elseif swtReadFrom == 7;
    load GradeDataIn[5,4] = g:\bus444\hw0\grades.csv;
elseif swtReadFrom == 8;
    load GradeDataIn[5,4] = h:\bus444\hw0\grades.csv;
elseif swtReadFrom == 9;
    load GradeDataIn[5,4] = /users/Daniel/bus444/hw0/grades.csv;
endif;

@*************************************************************@
@**********************End Control Panel *********************@
@*************************************************************@

ComputationStorage = zeros(swtNumStudents, 2) - 9.999;
@ The above matrix will have overall scores in column one, and @
@ Overall grades in column two. @

i = 1; @ set the counter to 1.0 initially @
do while i <= swtNumStudents;
    StudentDataNow = GradeDataIn[i,.];
    OverallScore = StudentDataNow[1,2] * swtHomeworkWeight + StudentDataNow[1,3] * swtMidtermWeight + StudentDataNow[1,4] * swtFinalWeight;
    ComputationStorage[i, 1] = OverallScore;
    if OverallScore >= 90;
        Grade = 4;
    elseif OverallScore < 90 and OverallScore >= 80;
        Grade = 3;
    elseif OverallScore < 80 and OverallScore >= 70;
        Grade = 2;
    elseif OverallScore < 70 and OverallScore >= 60;
        Grade = 1;
    else;
        Grade = 0;
    endif;
    ComputationStorage[i, 2] = Grade;
    i = i + 1; @ increment the counter by one @
endo;

OutputData = GradeDataIn ~ ComputationStorage;
Print OutputData;

@output the final form of the gradebook, as space-delimited file@
format /rd 10,4;
outwidth 256;

if swtWriteTo == 1;
    output file = a:\bus444\hw0\GradesFinal.out reset;
elseif swtWriteTo == 3;
    output file = c:\bus444\hw0\GradesFinal.out reset;
elseif swtWriteTo == 4;
    output file = d:\bus444\hw0\GradesFinal.out reset;
elseif swtWriteTo == 5;
    output file = e:\bus444\hw0\GradesFinal.out reset;
elseif swtWriteTo == 6;
    output file = f:\bus444\hw0\GradesFinal.out reset;
elseif swtWriteTo == 7;
    output file = g:\bus444\hw0\GradesFinal.out reset;
elseif swtWriteTo == 8;
    output file = h:\bus444\hw0\GradesFinal.out reset;
elseif swtWriteTo == 9;
    output file = /users/Daniel/bus444/hw0/GradesFinal.out reset;
endif; 
