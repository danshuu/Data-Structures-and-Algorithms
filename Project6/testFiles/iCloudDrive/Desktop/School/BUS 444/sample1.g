@ sample1.g @
@ Gauss program - example of Gauss syntax @
@ this first made 990123 by LRG @
@ This version: 990330 @
@ You make comments via leading and ending with with an ampersand @
@ Note:  Matlab is ALWAYS case-sensitive, Gauss typically is not. @
@ Gauss lines MUST end with a semicolon.  In Matlab that is optional @


new;             @ resets memory - should be the first line of any pgm @
format /rd 8,4;  @ controls how numbers are displayed e.g. 1.3333 @
                 @ versus format /re 8,4; e.g. 1.3333e+00 @
library pgraph;  @ required to do any graphing @
graphset;


load path= a:\;  @ tells gauss where to look for data input and output @

BeginTime = date;   @ Returns a 4x1 vector of year, month, day, and how many @
                    @ hundreds of seconds since midnite.  Useful for timing @
                    @ programs @

x = { 1 2 3 };  @ makes a 1x3 row vector, use squigly brackets {} for this @
y = { 4 5 6 };  @ makes a 1x3 column vector, the prime is for transpose @
y=y';           @ y is now 3x1 - the prime is for transposing rows and columns @
z = { 7, 8, 9}; @ makes a 3x1 column vector, the ,'s start a new row  @
zz=x'+y;        @ add two column vectors to get a third @

yz = y*z';      @ matrix multiplication, gives a 3x3 matrix @
zy = y'z;       @ matrix multiplication, gives a 1x1 matrix = 122 @
                @ 122 = 4*7 + 5*8 + 6*9 @
                @ In Matlab you need to put in the mult sign i.e. =y'*z; @

abc = x .* y;   @ element by element multiplication giving {4 10 18} @



zz=zz+zz;       @ add a vector to itself @

y=0;
z=0;
zz=0;   @ sets y,z,zz to the scalar zero, used to save ram memory @

n=4;     @ sets the variable n equal to 4, n is a 1x1 matrix (a scalar) @

zz2 = seqa(1,1,n);   @ seqa stands for SEQuence Additive @
           @ Sets zz2 equal to a column vector with elements of @
           @ [ 1 2 3 4 ].  A nice short way to define vectors.  @

zz3 = seqa(15,-4,3);  @ start at 15, add -4 each time and build a column @
                @vector of dim 3x1 @ 
                @ sets zz3 equal to the vector [15 11 7]' @
                @ That is, it starts at 15, increments by -4 and @
                @ continues until it gets 3 numbers @

DiscFactors = seqm(1,1.05,10);
     @ gives a 10x1 vector consisting of a SEQuence of Multiplicative values @
     @ In this case, the values are 1, 1.05, 1.1025, ... 1.05^9 @

y = { 1 2 3, 1e0 2e-2 3e3, 3.1  pi 2};  

  @ above makes a 3x3 matrix, note the mix of scientific and @
  @ tradtional notation, again ,'s start a new row @

y=y';  @ Transpose y.  That is, make the rows the columns and vice @
       @ versa.  @
y=y';  @ Undoes the previous command.  @

z = { 1 2 3 4 5 6 7 8 9, 9 8 7
            6 5 4 3 2 1 };
   @ z is a 2x9 matrix @
   @ notice how you can continue a line of code simply by omiting the ; @

yInv = inv(y);  @ Inverts the matrix y. @
                @ FACT: you can only invert square matricies. @
                @ Since Gauss is not case sensitive, yinv IS the @
                @ same as yInv. @
                @ you can type show at the prompt to see what exists @
                @ show y* will show all variables starting with y @

zR2 = z[2,.];  @ Grabs the 2nd row and all columns of z. @
               @ Notice that SQUARE brackets must be used to index a @
               @ matrix.  The period means all columns @
               @ zR2 is dimension 1x9. @

zR2C4_7 = z[2,4:7];  @ Grabs 2nd row, and cols 4 to 7.  Thus @
                     @ zR2C4_7 is dim 1x4. @

temp1 = ones(4,3);  @ Makes a matrix of dim 4x3 consisting entirely @
                    @ of 1's.  Also see the commands zeros, ident, @
                    @ rndu and rndn. @

Ident1 = eye(5);    @ makes a 5x5 identity matrix, i.e. all zeros with 1's @
                    @ on the diagonal only @



random1 = rndu(3,7);  @ a 3x7 matrix of numbers drawn randomly from @
                      @ the interval [0,1], i.e. from the uniform @
                      @ distribution. @

randNorm1 = rndn(3,4); @ A 3x4 matrix of numbers drawn randomly from @
                        @ the standard normal distribution, i.e. with @
                        @ mean zero and StDev one.  Useful in Monte @ 
                        @ Carlo simulations.  Recall, to convert these @
                        @ values, call them X, to draws from another @
                        @ normal distb with mean=Mu and Stdev=S, call @
                        @ them Y, then invoke Y = (X*S)+Mu. @
                        

randomS1=sortc(random1,2); @ Sorts random1, small to large, based on values @
                          @ in column 2. @

/*  
    Matlab can do the following command, I don't know of a canned Gauss
    Command that will... thus the following is associated with Matlab only.
    This block is commened out via slash-* and *-slash.  In Gauss you can
    Comment out large blocks of text this way.  That does not work in Matlab.
Diff2nd = diff(random1,2);
  @ Returns a 5x7 matrix of second differences (computed down the 
  @ columns). That is, the (3,4) entry will be equal to random1(5,4)
  @ minus random(3,4).  See Reference Guide for more info.
*/


dimenNow = rows(random1) ~ cols(random1);  
                           @ Produces a 1x2 row vector containing @
                           @ the number of rows and columns that exist @
                           @ in the matrix random1 @
                           @ The tilde (~) is used to put a matrix next @
                           @ to another matrix @

colsNow1 = dimenNow[1,2];  @ Grabs the number in the first (and only) @
                           @ row and 2nd column.  Here we are indexing @
                           @ a row vector as a matrix which is OK. @
                           @ colsNow1 is a 1x1 matrix (a scalar). @
                           @ Note that in Matlab you *must* use round @
                           @ brackets for indexing. i.e. in Matlab we'd @
                           @ write, colsNow1= dimenNow(1,2); @

colsNow2 = dimenNow[2];  @ Same effect as the above command.  The idea @
                         @ is that IF something is a row or col vector @
                         @ then you can put in a single number to index @
                         @ the vector - which is easier. @



xxx9 = rows(random1) | cols(random1);  
     @ the | operator stacks matricies.  In this case it is putting a scalar @
     @ on top of another scalar, to form a 2x1 matx @
     @ The operator to put a matx next to a matx is tilde ~ @
                  

colsNow4= maxc(xxx9);
  @ Returns the largest dimension of the matx random1 @
  @ maxc() returns a column vector of the max value in each column, @
  @ In this case, the argument is just a 2x1 col vector, so the value of @
  @ colsNow4 is just a scalar @
  @ In Matlab, the function length() returns the largest dimension of a matx @

tempSum1 = sumc(random1); @ Gives a col vector that equals the sum of  @
                          @ each column in random1.  Note that in Matlab @
                          @ the eqivalent command is sum() but it @
                          @ returns a row vector (of the sum of each @
                          @ column in random1. @

AllSum1 = sumc(sumc(random1)); @ Will sum up ALL elements in a matrix. @
                               
                 

tempMax1 = maxc(random1); @ Gives a col vector of the maximum value @
                          @ in each column.  Also see minc().  The @
                          @ equivalent Matlab commands are max() and @
                          @ min(), and return row vectors. @

AllMax1 = maxc(maxc(random1));  @ Returns the max value in the entire matrix. @

tempStd1 = stdc(random1);  @ Returns a col vector containing the sample @
                           @ standard deviation of each column. @
                           @ Matlab command is std() and gives a row vector @


tempMean1 = meanc(random1);   @ Returns a col vector containing the mean @
                              @ of each column. @
                              @ The Matlab command is mean() and gives a @
                              @ row vector @                          

AllMean1 = meanc(meanc(random1));  @ Returns the mean value of a matrix. @

Combo1 = random1~randNorm1;    @ Forms a new matx by placing randNorm1 @
                               @ to the right of random1.  For this @
                               @ to work both random1 and randNorm1 @
                               @ must have the same number of rows. @
                               @ Combo1 is 3x11. @
                               @ The Matlab command is:  = [random1 randNorm1]; @


Combo2 = combo1 | (random1~randNorm1);
  @ Builds a new matrix via combining other matricies. @
  @ Puts random1 next to randNorm1, and puts all this @
  @ beneath Combo1.  This will crash if you aren't carefull to make @
  @ sure that there is row and column agreement. @
  @ Combo2 is 6x11.  Combo1 was 3x11. @
  @ The matlab command is = Combo1 | (random1 ~ randNorm1); @


VCV1 = vcx(Combo2);  
  @ Returns the 6x6 variance-covariance (VCV) matrix of Combo2. @
  @ if the argument (Combo2 in this case) is of dim NxM, then the @
  @ output is MxM.  That is, it assumes you have N observations of @
  @ M different variables, and it returns the MxM VCV matx @
  @ In this case, Combo2 is 6x11, so VCV1 is 11x11. @
  @ The Matlab command is cov() but it would return an NxN matx.  @
  @ That is, Matlab assumes the data series are in the rows, i.e. you @
  @ have M obs on each of N variables @



CorrMat1 = corrx(Combo2); 
  @ Returns a correlation matrix of dim 11x11. @
  @ The (2,5) position gives the correlation between the data @
  @ in cols 2 and 5 of Combo2, which will be the same as the value in @
  @ the (5,2) position. @
  @ The diagonal entries are all 1's, and no entry is outside of the range @
  @ -1 to +1 @
  @ The Matlab command of corrcoef() would give a 6x6 matx @

@***********************************************************************@
@ The above line makes a nice (easy to see) visual break in the pgm.    @
@ The next few commands demonstrate the extraction of part of a matrix. @
@***********************************************************************@

index1 = { 1 3 4 };  @ define a row matrix.  Note the curly braces.  In @
                     @ Matlab you use square [] brackets to define matricies @
index2 = { 2 5 };    
                     

zzz = rndu(7,7);  @ a 7x7 matrix with elements distributed uniform[0,1] @
                  @ the command mean RaNDom from Uniform distribution @
                  @ Also see rndn for random from a Normal distb @
                  @ The Matlab command is rand() @                  

tempZ0 = zzz[3,4];  @ Returns the value in row 3, column 4. @
                    @ In Gauss we use square [] brackets for indexing @
                    @ In Matlab you use round () brackets @

tempZ1 = zzz[index1,index2];  
  @ Returns a 3x2 matx with elements at the intersection of rows @
  @ 1,3, and 4 and columns 2, and 5.  Notice that the arguments index1 @
  @ and index2 can be row or column vectors @
  @ The Matlab command is the same but with round () brackets @



tempZ2 = diag(VCV1);  
  @ Returns the diagonal elements of VCV1, as a COLUMN vector, which @
  @ (of course) are the variances of the 11 cols of data in Combo2. @
  @ In Matlab it's the exact same command @

tempZ2B = diagrv(VCV1, seqa(1,1,11));
  @ diagrv inserts a vector into the diagonal of a square matx @
  @ in this case, the inserted vector is 1,2,3, ... , 11 @


tempZ3 = sqrt(diag(VCV1));  
   @ The standard deviations (as a 1x6 vector) of the 6 rows of data @
   @ in Combo2.  sqrt() takes the square root of each element of a  @
   @ matx. @
   @ In Matlab its the exact same command @

tempZ4 = VCV1[2,4];  @ A scalar.  The covariance between the data in @
                     @ cols 2 and 4 of Combo2.  Due to the symetry of  @
                     @ a VCV matx, this is the same as VCV1[4,2]. @


/*********************/
@ One really cool trick in Matlab (and Gauss via the command selif) @ 
@ is the ability to remove specific rows from matricies.  This is @
@ done using vectors that consist entirely of 1's and 0's. @
@ In order to do that you need to make the 0-1 vectors.  @
@ Lets do that:  Lets make a 0-1 col vector that @
@ has 1's where the 5th column of VCV1 has values that are @
@ non-negative, and 0's where these values are neg. @

Col5OK = VCV1[.,5] .>= 0;  @ builds a 0-1 col vector. @
  @ Returns a col vector with 1's where the entries in the fifth @
  @ column of VCV1 are non-negative.  Notice the period before the >= @
  @ This tells Gauss to make the 0-1 vectors based on the condition @
  @ specified (in this case the condition is greater than or equal to 0). @
  @ The Matlab command is = VCV1(:,5) >= 0; @



  @ Now lets keep only the rows of VCV1 where the value in the 5th @
  @ column is non-negative. This requires the use of the selif() command @
VCV1NNeg1 = selif(VCV1, Col5OK);  
  @ Above line keeps all columns but only the rows where Col5OK @
  @ has 1's.  The 2 lines can be condensed into one line that does @
  @ the same thing.  @
  @ The Matlab command is:  = VCV1(Col5OK,:);  @

  @ To do the above 2 lines in 1 line, you'd code the following @
VCV1NNeg1 = selif(VCV1, VCV1[.,5] .>= 0);
  @ In Matlab, the above 2 lines would be; @
  @ VCV1NNeg2 = VCV1(VCV1(:,5) >= 0,:);  @



@ We could keep only the rows where there is a non-neg value in cols 2 @
@ 2 OR 5, OR a negative value in col 3. Lets do that... slowly... @
KeepOK1A = VCV1[.,2 5] .>= 0;  @ gives a 11x2 matx with 1's where associated @
                               @ values in VCV1 are non-negative @
KeepOK1B = VCV1[.,3] .< 0;  @ gives an 11x1 col vector with 1's where col @
                            @ 3 of VCV1 has a negative value @
KeepOK1AB = KeepOK1A ~ KeepOK1B;  @ gives an 11x3 matx @
  
@ we now want to know which rows of KeepOK1AB have at least one 1 in them @
KeepOK1X = sumc(KeepOK1AB');  @ gives an 11x1 vector with values of 0,1,2 or 3 @
                             @ Notice that I had to transpose KeepOK1AB because @
                             @ we wanted to sum rows, but sumc() only sums columns @
@ Now find which entries of KeepOK1X have values of 1,2 or 3 @
KeepOK1 = KeepOK1X .> 0;  @ returns an 11x1 col vector consisting of 0's and 1's @
                          @ where there is a 1 if the associated entry of KeepOK1X @
                          @ had a 1,2, or 3 @

@ Now select the rows we want @
VCV1_235or = selif(VCV1, KeepOK1);  @ will have only rows that met our criteria @



@ Now assume we want to keep only the rows where there is a non-neg @
@ value in cols 2 AND 5, AND a negative value in col 3.  (All 3  @
@ conditions are required since we're using AND and not OR). @
@ In this case, we only want to keep rows where KeepOK1X has a 3 @
@ i.e. all 3 conditions were met @
KeepOK3 = KeepOK1X .== 3;  @ notice the double equal signs preceeded by @
                           @ a period @

@ now pull the rows of interest @
VCV1_235and = selif(VCV1, KeepOK3);  @ Done @



@**************************************************************@
@ Now lets do some stuff related to OLS regression             @
@**************************************************************@

@ Our regression will be of the form @
@ y = alpha + beta1*X1 + beta2*X2 + epsilon @
@ In matrix form this is y = X*Beta + epsilon with y a Tx1 vector @
@ and X a Tx(N+1) matrix with N = number of Right Hand Side variables @
@ other than the intercept (N=2 in the example).  Epsilon is @
@ a Tx1 vector, T= number of time observations (60 in our example). @

RetIBM = 0.01 + rndn(1,60)*0.30/(sqrt(12));
  @ generate some theoritical monthly returns for IBM, assume the @
  @ returns are distb normal with mean 0.01 per month and annualized @
  @ standard deviation of 0.30 (which implies a monthly stnd dev of @
  @ 0.30 divided by sqrt(12)).  This gives 5 years of monthly returns. @
  @ Recall, to convert data from normal(0,1) to a normal(mu,std) distribution @
  @ you mult the data by std and add mu.  That's what I'm doing above. @
  @ rndn() gives data from a normal(0,1) distribution @

RetSP500 = 0.103/12 + rndn(1,60)*0.10/sqrt(12);
  @ Generate some returns for the market portfolio. Here I'm assuming annualized @
  @ returns of 10.3% and annualized volatility of 10%, then I convert to monthly @

RHSVar2 = rndu(1,60) - 2;  
  @ Additional RHS variable distributed uniform[-2,-1] that we'll use in @
  @ our sample regression. @

intercept1 = ones(1,60);
  @ we'll need this if we want an intercept in our regression. @
  @ You have to make it explicitly, and then make sure its in the first @
  @ column of the RHS matrix X @

@ now lets regress IBM on the S&P500, RHSVar2, and an intercept @
@ first form the RHS matrix of dimension 60x3 @

RHS =  intercept1' ~ RetSP500' ~ RHSVar2' ;
  @ The first column is all 1's, (the intercept), the last 2 columns @
  @ are the SP500 data and the Var2 data. @

LHS = RetIBM';  
  @ The LHS variable, we need to make sure its a column vector - so @
  @ we transposed it. @

@ now compute alpha, beta1 and beta2 @

betaHat = inv(RHS'*RHS)*RHS'*LHS;
  @ This is from the well known result:  beta_hat = inv(X'X)*X'Y @
  @ BetaHat is a 3x1 vector, alpha is in row1, beta1 in row2, beta2 in @
  @ row3. @

@ Now calculate the regression residuals which are equal to @
@ LHS minus RHS*BetaHat. @
resids = LHS - RHS*betaHat;  @ resids is of dim 60x1 @
  @ We could test the resids for autocorrelation and heteroskedasticity @
  @ at this point.  We wont do formal tests now, but it would be nice @
  @ to at least see a plot (a graph) of the resids and do a visual @
  @ inspection to see if it looks like autocorr or heterosk exists. @



/********** SOME GRAPHICS **********/
xlabel("Observation number");
ylabel("Residual Value");
xy(seqa(1,1,60),resids);  @ A simple plot, see Reference Guide for more info. @
                          @ see also xyz() @
                          @ Matlab and Gauss can do some VERY cool graphics stuff. @
                          @ Matlab is especially strong with graphics capabilities @

pause(2.1);  @ pauses the program 2.1 seconds so that you can see the first graph @
           @ before the second graph is placed on top of it @
           @ Also, you can drag the graphs around with the mouse, so that you can @
           @ see both at once @

@ Next is an example of a 3-D surface plot @

zlabel("Output Values");
XAxis=seqa(1,1,20);
YAxis=seqa(1,1,40);
XAxis=XAxis';
ZAxis=XAxis+YAxis^0.5;
surface(XAxis,YAxis,ZAxis);  @ a 3-D surface plot @
   @ the first argument must be 1xN, the second Mx1, the third MxN @



@******************** end of regression stuff *********************@

@******************************************************************@
@**** Now lets look at Control Flow - IF statements and Loops *****@
@******************************************************************@

@ Below I show how loops work in Gauss @

@ Initialize a matrix with -9.99's and then fill it in @
Matx1 = zeros(5,10) - 9.99;  @ will be full of -9.99's @

j=1;
do while j <= 10;
  Matx1[.,j] = rndn(5,1) + j;  @ will fill in the matx with col vectors @
                               @ drawn from a standard normal distribution @
                               @ with increasing means @
j=j+1;
endo;

@ You can put a loop inside of a loop @
B = zeros(6,12) - 9.99;
j=1;
do while j<= rows(B);
  k=1;
  do while k <= cols(B);
    B[j,k] = j*(k^2);  @ fills in B one entry at a time @
  k=k+1;
  endo;
j=j+1;
endo;



@ Now lets look at the IF statement in Gauss @
RandN = rndu(1,1);  @ A random number from uniform distb [0,1]. @
RandN = RandN*10;   @ Now it's in the range of 0 to 10. @
if RandN < pi;
  print "The random draw was less than 0.31416";  @ print writes to @
                                                  @ the screen. @
elseif (RandN >= pi) and (RandN < 8);
  print "The random draw was between approx .31415 and .8";
else;
  print "The random draw was >= 0.80";
endif;

@ Of course, you can put if statements inside of loops and vice versa. @


@**********************************************************@
@************* prompted input and pausing *****************@
@**********************************************************@

print "How old are you?  Enter the value and hit return";
AskEm=con(1,1);  @ will take the scalar response and put it in AskEm @



@*****************************************************************@
@************* File Input and Output (i.e. file I/O) *************@
@*****************************************************************@



@ There are a bunch of ways of bringing in data from an external file. @
@ I'll look at one of the easier ways, but other ways are faster, and @
@ more efficient as far as disk space needs.  See the Users Guide on  @
@ importing and exporting data for more info on all this. @

@ I typically work with ASCII files (AKA flat files) for both input @
@ and output.  In class that is what we will use exclusively.  Most @
@ any computer application (e.g. Gauss, Excel) can both read and write @
@ ASCII files, so it's pretty darn flexible. @

@ well write an ascii file first (to the a-drive) and we'll read it after that @
@ Lets write an ascii file @
@ First lets prompt the user to put a floppy in the a-drive @
print " "; @ prints a blank line - makes things easier to read @
print "You need a floppy disk in the a-drive to proceed.  Please insert ";
print "a floppy disk in the a-drive now.";
print " ";
print "Hit any key after you have made sure you have a floppy inserted";
print " ";
waitc;  @ pauses the program until you hit the Console (keyboard) @



format /rd 10,4;  @ set the format for writting to the file @
outwidth 256; @ the max width of the ascii file, but 256 means that the @
              @ width is unconstrained - I typically use 256 @
output file= a:\sample1.out reset;  @ name of the output file we'll make @
                                    @ Reset means wipe out any existing file @
                                    @ with the same name that may exist, and @
                                    @ start a new one.  The alternative is to @
                                    @ use ON - which just appends to the @
                                    @ an existing file - see below @
xxx=rndn(5,4);
screen off;  @ turn off output to the screen @
print xxx;  @ will send xxx to the file, but not to the screen @
screen on;  @ turn the screen back on, any print statements will now be shown @
            @ on the screen too @
output off; @ stop output to the file @

@ Now lets append something to the file we just made @
output file= a:\sample1.out on;  @ we're now using ON instead of reset.  Thus @
                                 @ any output will be sent to the already existing @
                                 @ file, and will begin at a line just below the @
                                 @ last line of the existing file @
screen off;
print " ";  @ print a blank line to seperate the original output from the appended @
xxx2 = seqa(1,2,4)';  @ makes a 1x4 column vector with entries of 1 3 5 7 @
print xxx2;
output off;
screen on;


@ Now lets read the ascii file we just made. @


load Zebra[6,4] = a:\sample1.out;
  @ You now have a matrix called Zebra in the RAM memory. @
  @ load reads across the rows of the ascii file and fills in the elements @
  @ of Zebra.  It's important to understand how the load command works @
  @ so make sure you read the help screen on load before you use it. @
  @ The first time you read in any matrix is a very good idea to make @
  @ sure it worked as you think it did.  Check the dimension via rows() and @
  @ cols(), and take a peek at a bit of the matrix to make sure @
  @ its not all full of garbage.  If there are any letters in sample1.out @
  @ you are in trouble.  Matlab (and Gauss) can read NUMBERS ONLY!!!@
  @ Sometimes letters are interpreted as very very large numbers, so @
  @ running max(max(file1)) to see what the biggest overall number is @
  @ is often prudent (i.e. do it!). @

EndTime=date;  @ a 4x1 vector of YYYY MM DD and 100's of a second since midnite @
ElapsedTime = (EndTime[4]-BeginTime[4])/100;  @ gives the number of seconds the @
                                                 @ the program took to run @
format /rd 10,3;
print " ";
print "The program ran in "  ElapsedTime " seconds.";
