% sample1x.m
% matlab program - example of matlab syntax
% Parallels the code of sample1.g
% this first made 990122 by LRG
% You make comments via leading, but not ending with a percent sign
% Note:  Matlab is ALWAYS case-sensitive, Gauss typically is not.


clear all;    % resets memory - should be the first line of any pgm
format bank;  % controls how numbers are displayed e.g. 1.33
              % bank gives 2 digits to right of decimal (money)
              % versus format short e; e.g. 1.3333e+00
              % versus format short;  e.g. 1.3333

path(path, 'e:\code\matlab\larrylib');  
  % above augments the search path to include my custom .m pgms 
  % many of the custom pgms are intended to make gauss commands
  % work in matlab, but you can custom build anything you want.

BeginTime = clock;  % Returns a 1x6 vector of year, month, day, hour
                    % minute, seconds.  e.g Jan. 23, 1999 at 2:15 pm
                    % and 22 seconds is reprsented as:
                    % [1999 1 23 14 15 22]
                    % Useful to time how long a program has run.

x = [ 1 2 3 ];  % makes a 1x3 row vector, use square brackets for this
y = [ 4 5 6 ]'; % makes a 3x1 column vector, the prime is for transpose
z = [ 7; 8; 9]; % makes a 3x1 column vector, the ;'s start a new row   
zz=x'+y;        % add two column vectors to get a third

zz=zz+zz;       % add a vector to itself

clear y z zz;     % removes y,z,zz from memory, like they never existed

n=4;   % sets the variable n equal to 4, n is a 1x1 matrix (a scalar)

zz2 = 1:n; % Sets zz2 equal to a row vector with elements of 
           % [ 1 2 3 4 ].  A nice short way to vectors.

zz3 = 15:-n:n;  % sets zz3 equal to the vector [15 11 7]
                % That is, it starts at 15, increments by -4 and
                % continues until it gets to 4, but it WONT go 
                % below 4.  Thus the next element of 3 (=7-4) is
                % not included.  Notice that xxx=1:n is the same as
                % xxx=1:1:n  (start at 1, increment by 1 till you get
                % to n).

y = [ 1 2 3; 1e0 2e-2 3e3; 3.1  pi sqrt(2)];  
  % above makes a 3x3 matrix, note the mix of scientific and 
  % tradtional notation, again ;'s start a new row;

y=y';  % Transpose y.  That is, make the rows the columns and vice 
       % versa.  
y=y';  % Undoes the previous command.  

z = [ 1 2 3 4 5 6 7 8 9; 9 8 7 ...
            6 5 4 3 2 1];
   % z is a 2x9 matrix.
   % notice how you can continue a line of code with an elipse (...)

yInv = inv(y);  % Inverts the matrix y.
                % FACT: you can only invert square matricies.
                % Since matlab is case sensitive, yinv is not the
                % same as yInv.  yinv does not exist yet.
                % you can type whos at the >> prompt to see what exists.

zR2 = z(2,:);  % Grabs the 2nd row and all columns of z.
               % Notice that round brackets must be used to index a
               % matrix.  zR2 is dimension 1x9.

zR2C4_7 = z(2,4:7);  % Grabs 2nd row, and cols 4 to 7.  Thus 
                     % zR2C4_7 is dim 1x4.
clear z*;  % This will NOT clear all variables starting with z.
           % This command does nothing.

temp1 = ones(4,3);  % Makes a matrix of dim 4x3 consisting entirely
                    % of 1's.  Also see the commands zeros, eye, 
                    % rand and randn.

Ident1 = eye(5);  % makes a 5x5 identity matrix

random1 = rand(3,7);  % a 3x7 matrix of numbers drawn randomly from
                      % the interval [0,1], i.e. from the uniform
                      % distribution.

randNorm1 = randn(3,4); % A 3x4 matrix of numbers drawn randomly from
                        % the standard normal distribution, i.e. with
                        % mean zero and StDev one.  Useful in Monte
                        % Carlo simulations.  Recall, to convert these
                        % values, call them X, to draws from another 
                        % normal distb with mean=Mu and Stdev=S, call 
                        % them Y, then invoke Y = (X*S)+Mu.
                        % I have custom code that will produce draws
                        % from a *multivariate normal* distb.  See
                        % mvnormal.m AND mvn0I.m in my library.

randomS1=sort(random1); % Sorts EACH column of random1, small to large.
                        % See the Reference Guide for more info.

Diff2nd = diff(random1,2);
  % Returns a 5x7 matrix of second differences (computed down the 
  % columns). That is, the (3,4) entry will be equal to random1(5,4)
  % minus random(3,4).  See Reference Guide for more info.

dimenNow = size(random1);  % Produces a 1x2 row vector containing 
                           % the number of rows and columns that exist
                           % in the matrix random1.

colsNow1 = dimenNow(1,2);  % Grabs the number in the first (and only)
                           % row and 2nd column.  Here we are indexing
                           % a row vector as a matrix which is OK.
                           % colsNow1 is a 1x1 matrix (a scalar).
                           % Note that in Gauss you *must* use square
                           % brackets for indexing. i.e. in Gauss we'd 
                           % write, colsNow1= dimenNow[1,2];

colsNow2 = dimenNow(2);  % Same effect as the above command.  The idea
                         % is that IF something is a row or col vector
                         % then you can put in a single number to index
                         % the vector - which is easier.

colsNow3 = cols(random1);  % One of my custom .m commands (rows) that 
                          % returns a scalar (1x1 matrix) containing 
                          % the number of cols in random1.  This is NOT
                          % a standard Matlab command.  It IS a standard
                          % Gauss command.  I wrote it to make my life
                          % easier.  Also see my pgm rows.m
                          % This is basically doing the following:
                          % tempX=size(random1); rowsNow=tempX(2);

colsNow4 = length(random1(2,:));
  % lenght() is similar to size().  length gives the length of a row
  % or a column vector.  This command first grabs the 2nd row of 
  % random1, and then length returns the length of this row
  % vector.  Only use the length command on vectors.  It is essentially
  % the same as max(size(some_vector))

tempSum1 = sum(random1);  % Gives a row vector that equals the sum of 
                          % each column in random1.  Note that in Gauss
                          % the eqivalent command is sumc() but it
                          % returns a column vector (of the sum or each
                          % column in random1.

AllSum1 = sum(sum(random1)');  % Will sum up All elements in a matrix.
                               % Notice the prime appears to be 
                               % required in order 
                               % to convert the internal sum() from a
                               % row vector to a column vector so that
                               % the second sum can have a column to 
                               % sum up, but actually sum(sum(random1))
                               % will work since, in Matlab, when the sum
                               % command works on a vector (not a matrix)
                               % it will sum up the vector, whether it's a 
                               % row or column vector.
                               
CumSum1 = cumsum(random1);  
  % Returns a row vector that is the cummulative sum of a matrix.
  % That is, the first entry is the sum of column 1 of random1, the
  % second entry is the sum of column 2 PLUS the sum of column 1, etc.
  % See cumprod() for cummulative products.

tempMax1 = max(random1);  % Gives a row vector of the maximum value
                          % in each column.  Also see min().  The 
                          % equivalent Gauss commands are maxc() and
                          % minc(), and return column vectors.

AllMax1 = max(max(random1));  % Returns the max value in the entire matrix.

tempStd1 = std(random1);  % Returns a row vector containing the sample 
                          % standard deviation of each column.

tempMean1 = mean(random1) % Returns a row vector containing the mean
                          % of each column.
                          % NOTICE I omited the semicolon.  This will 
                          % force the printing of tempMean1 to the 
                          % screen - something you may or may not want.
                          % This will also require you to hit the
                          % return key after you run the pgm in order
                          % to get a >> prompt back.  Thus, its hard
                          % hard to tell if the program is done yet if
                          % you omit ;'s - so avoid doing it unless
                          % you have a good reason.  
                          % Also see the command median().

AllMean1 = mean(mean(random1));  % Returns the mean value of a matrix.

Combo1 = [random1 randNorm1];  % Forms a new matx by placing randNorm1
                               % to the right of random1.  For this 
                               % to work both random1 and randNorm1
                               % must have the same number of rows.
                               % Notice that square brackets are used.
                               % Combo1 is 3x11.

Combo2 = [Combo1; random1 randNorm1];
  % Builds a new matrix via combining other matricies.
  % Puts random1 next to randNorm1, and puts all this 
  % beneath Combo1.  This will crash if you aren't carefull to make
  % sure that there is row and column agreement.
  % Combo2 is 6x11.  Combo1 was 3x11.

VCV1 = cov(Combo2);  
  % Returns the 6x6 variance-covariance (VCV) matrix of Combo2. cov() 
  % assumes the ROWS of Combo2 contain the 6 variables of interest 
  % (maybe the returns on 6 different stocks) and that there are 
  % 11 periods of (return) data spread across the COLUMNS.  Thus, 
  % if computing the VCV matx of an NxT return matrix (where N is the 
  % number of firms, each with T months of return data obtained) you'd
  % want to transpose the data to make it TxN, i.e. you'd invoke the
  % command VCV1 = cov(NxTMatrix');  Notice the prime!

CorrMat1 = corrcoef(Combo2); 
  % Returns a correlation matrix of dim 6x6.  As with cov() (above) 
  % corrcoef() assumes the variables are in rows, with observations
  % across time in the columns.  The diagonal will be composed entirely
  % of 1's, the off diagonal entries will be numbers in the range -1 
  % to +1.  The (2,5) position gives the correlation between the data
  % in rows 2 and 5 of Combo2, which will be the same as the value in
  % the (5,2) position.

%*******************************************************************
% The above line makes a nice (easy to see) visual break in the pgm.
% The next few commands demonstrate the extraction of part of a matrix.
%*******************************************************************

index1 = [ 1 3 4 ];  % define a row matrix
index2 = [ 2 5 ];    % notice the use of square brackets for defining
                     % matricies & vectors.

zzz = rand(7,7);  % a 7x7 matrix with elements distributed uniform[0,1] 
                  % recall rand() gives random numbers from [0,1]                  

tempZ0 = rand(3,4);  % Returns the value in row 3, column 4.

tempZ1 = zzz(index1,index2);  
  % Returns a 3x2 matx with elements at the intersection of rows
  % 1,3, and 4 and columns 2, and 5.

tempZ2 = diag(VCV1);  
  % Returns the diagonal elements of VCV1, as a COLUMN vector, which 
  % (of course) are the variances of the 6 rows of data in Combo2.

tempZ3 = sqrt(diag(VCV1));  
   % The standard deviations (as a 1x6 vector) of the 6 rows of data
   % in Combo2.  sqrt() takes the square root of each element of a 
   % matx.

tempZ4 = VCV1(2,4);  % A scalar.  The covariance between the data in
                     % rows 2 and 4 of Combo2.  Due to the symetry of 
                     % a VCV matx, this is the same as VCV1[4,2].

UpperTri1 = triu(VCV1);  
  % Returns a 7x7 matx of the Upper Triangular components of VCV1, 
  % including the diagonal.  The lower off-diagonal terms are all
  % set equal to zero.  See tril() for Lower Triangular extraction.

% One really cool trick in Matlab (and Gauss via the command selif) 
% is the ability to remove specific rows using vectors that consist
% entirely of 1's and 0's. In order to do that you need to make 
% the 0-1 vectors.  Lets do that:  Lets make a 0-1 col vector that 
% has 1's where the 5th column of VCV1 has values that are 
% non-negative, and 0's where these values are neg.

Col5OK = VCV1(:,5) >= 0;  % builds a 0-1 col vector. 
  % Now lets keep only the rows of VCV1 where the value in the 5th
  % column is non-negative:
VCV1NNeg1 = VCV1(Col5OK,:);  
  % Above line keeps all columns and only the rows where Col5OK 
  % has 1's.  The 2 lines can be condensed into one line that does 
  % the same thing:
VCV1NNeg2 = VCV1(VCV1(:,5) >= 0,:); % Same as previous 2 lines.

% We could keep only the rows where there is a non-neg value in cols
% 2 OR 5, OR a negative value in col 3.
KeepOK1 = (VCV1(:,2) >= 0) + (VCV1(:,5) >= 0) + (VCV1(:,3) < 0);
  % KeepOK1 could have values of 0,1,2 or 3 in it.  It'd have a 3 in, 
  % say, row 4, if the 4,2 and 4,5 position of VCV1 are non-negative,
  % and the 4,3 position of VCV1 is negative.  Now we want to turn any
  % 2's and 3's into 1's, so that we have only 0's and 1's.
KeepOK2 = KeepOK1 >= 1;  % 0's are still 0's, 1's are still 1's , but
                         % 2's and 3's are now 1's.  So have only 0-1's
VCV1_235OR = VCV1(KeepOK2,:);  % Will have only the rows that met our
                               % our criteria.
% Now assume we want to keep only the rows where there is a non-neg 
% value in cols 2 AND 5, AND a negative value in col 3.  (All 3 
% conditions are required since we're using AND and not OR).
KeepOK3 = (VCV1(:,2) >= 0) .* (VCV1(:,5) >= 0) .* (VCV1(:,3) < 0);
  % The .* operator forces element-by-element multiplication. 
  % i.e. [0 1 1]' .* [1 1 0]' = [0 1 0]'
  % Now grab the rows meeting the AND condition.
KeepOK3 = KeepOK3 == 1;  % need to do this additional line in latest
                           % Matlab version to make it correct type.
VCV1_235AND = VCV1(KeepOK3,:);  % Done.

%**************************************************************
% Now lets do some stuff related to OLS regression
%**************************************************************

% Our regression will be of the form
% y = alpha + beta1*X1 + beta2*X2 + epsilon
% In matrix form this is y = X*Beta + epsilon with y a Tx1 vector
% and X a Tx(N+1) matrix with N = number of Right Hand Side variables
% other than the intercept (N=2 in the example below).  Epsilon is
% a Tx1 vector, T= number of time observations (60 in our example).

RetIBM = 0.01 + randn(1,60)*0.30/(sqrt(12));
  % generate some theoritical monthly returns for IBM, assume the 
  % returns are distb normal with mean 0.01 per month and annualized
  % standard deviation of 0.30 (which implies a monthly stnd dev of
  % 0.30 divided by sqrt(12)).  This gives 5 years of monthly returns.

RetSP500 = 0.103/12 + randn(1,60)*0.10/sqrt(12);
  % Generate some returns for the market portfolio.

RHSVar2 = rand(1,60) - 2;  
  % Additional RHS variable distb uniform[-2,-1] that we'll use in 
  % our sample regression.

intercept1 = ones(1,60);
  % we'll need this if we want an intercept in our regression.

% now lets regress IBM on the S&P500, RHSVar2, and an intercept
% first form the RHS matrix of dimension 60x3

RHS = [ intercept1' RetSP500' RHSVar2' ];
  % The first column is all 1's, (the intercept), the last 2 columns
  % are the SP500 data and the Var2 data.

LHS = RetIBM';  
  % The LHS variable, we need to make sure its a column vector - so
  % we transposed it.

% now compute alpha, beta1 and beta2

betaHat = inv(RHS'*RHS)*RHS'*LHS;
  % BetaHat is a 3x1 vector, alpha is in row1, beta1 in row2, beta2 in 
  % row3.

% Now calculate the regression residuals which are equal to 
% LHS minus RHS*BetaHat.
resids = LHS - RHS*betaHat;  % resids is of dim 60x1
  % We could test the resids for autocorrelation and heteroskedasticity
  % at this point.  We wont do formal tests now, but it would be nice
  % to at least see a plot (a graph) of the resids and do a visual 
  % inspection to see if it looks like autocorr or heterosk exists.
  
plot(resids);  % A simple 2D plot, see Reference Guide for more info.
    % Matlab can do some VERY cool graphics stuff.
    % Also see mesh() for the Gauss equivalent of surface().
    % Sometimes Matlab prints graphs to the background, and thus
    % you should look at the bottom bar of the screen to see if there
    % is a Matlab figure waiting for you... Kill it when done to save ram.
    
title('A plot of the residuals');
ylabel('Residual value');
xlabel('Observation');


    
%******************** end of regression stuff *********************

%******************************************************************
%**** Now lets look at Control Flow - IF statements and Loops *****
%******************************************************************

% Below I show how loops work in Matlab;
% There are 2 type of loops, for-loops and while-loops.
% Next we look at for-loops.
 
T=length(resids);  % The length of resids is 60, so T=60;
for i=1:T  % notice that this line does NOT require a semi-colon
           % but including one is OK.
  A(1,i) = 1000 / i;  % builds a 60x1 vector A one iteration at a time.  
end        % each for must match up to an end, also with an
           % optional semi-colon.  I typically include them to
           % be consistent (less to remember).


% You can put a loop inside of a loop, make sure you have an end for
% each loop.
for i=1:(T/10);
  for j=1:(T/5);
    B(i,j) = 1000 / (i*j);
  end;
end;
% The above section builds up a 6x12 matrix called B.  Notice that B
% will be built up as needed, but the loop will run much faster if you
% predefine B before the loop begins.  I do that in an example
% about 15 lines below.

% Now lets look at while-loops.  With while-loops YOU must remember
% to increment the counter (via something like i=i+1, otherwise you'll
% never exit the loop, and the program will run forever, AKA as an
% infinite loop.  As with for-loops, you need end statements.
k=1;
while k <= T;
  A(1,k) = 1000 / k;
  k=k+1;  % remember to increment the counter, so that eventually the
          % loop will terminate.
end;

% As with for-loops, you can put a while-loop inside a while-loop:
B = zeros(T/10,T/5) -9.99;  % I've predefined the matrix B in order
                            % to increase speed in the loop.  I fill
                            % it with -9.99's.  That way if something
                            % doesn't get filled in, I'll know it cuz
                            % -9.99 is pretty easy to spot.
k=1;
while k <= (T/10);
  m=1;
  while m <= (T/5);
    B(k,m) = 1000 / (k*m);
    m=m+1;
  end;
k=k+1;
end;

% And (of course) you can put a do-loop inside a while loop (and
% vice-versa) as shown below:
k=1;
while k <= (T/10);
  for n=1:(T/5);
    B2(k,n) = 1000 / (k*n);
  end;
k=k+1;
end;

% Now lets look at the IF statement in Matlab:
RandN = rand(1,1);  % A random number from uniform distb [0,1].
RandN = RandN*10;   % Now it's in the range of 0 to 10.
if RandN < pi ;   %  Note:  & is the 'and' operator while
                  %         | is the 'or'  operator, thus
                  %         the above if stmt is true if
                  %         RandN is < Pi *OR* if RandN
                  %         is greater than 7
  disp('The random draw was < 0.31415926535');  
       % disp() writes to the screen.
elseif (RandN >= pi) & (RandN < 7);  % the brackets help to make it 
                                     % easier to read, but are not
                                     % necessary.  Remember & is for 
                                     % 'and' and | is for 'or'
  disp('The random draw was between approx .31415 and .7');
else;
  disp('The random draw was >= 0.70');
end;

% Of course, you can put if statements inside of loops and vice versa.

%**********************************************************
%************* prompted input and pausing *****************
%**********************************************************

AskEm = input('How old are you? Enter value and hit return. ');  
                                  % prompts the user for input.
                                  % will wait till a number is entered
                                  % and user hits return.
pause(5);    % Will pause the program for 5 seconds.  Useful
             % to allow the user time to read something that was
             % written to the screen.  pause by itself will stop the
             % program indefinitely until the user hits any key.
             % Its a good idea to preceed this with a statement that 
             % the computer is waiting on you.  That is...
disp('Hit any key to continue');
pause;

          % pause and disp can also be useful for debugging purposes.
disp('pgm got to line 129 w/o crashing.  The value of RHS(2,3) is');
RHS(2,3)  % no semicolon forces writing to the screen.
disp('hit any key to continue');
pause;

%*****************************************************************
%************* File Input and Output (i.e. file I/O) *************
%*****************************************************************

% There are a bunch of ways of bringing in data from an external file.
% I'll look at one of the easier ways, but other ways are faster, and
% more efficient as far as disk space needs.  See the Users Guide on 
% importing and exporting data for more info on all this.

% I typically work with ASCII files (AKA flat files) for both input
% and output.  In class that is what we will use exclusively.  Most
% any computer application (e.g. Gauss, Excel) can both read and write
% ASCII files, so it's pretty darn flexible.

% To read an ascii file, (assume it's called file1.asc) which contains
% return data on 50 stocks for 60 months (is dim NxT = 50x60) which 
% has at least 1 space between each number (i.e. it's space delimited)
% you do this:

load a:\file1.asc;
% will crash if file1.asc does not exist, So make it.
% A simple 2x2 matrix will suffice.
  % You now have a matrix called file1 in the matlab memory.
  % The first time you read in any matrix is a very good idea to make
  % sure it worked as you think it did.  Check the dimension via
  % size(file1), and take a peek at a bit of the matrix to make sure
  % its not all full of garbage.  If there are any letters in file1.asc
  % you are in trouble.  Matlab (and Gauss) can read NUMBERS ONLY!!!
  % Sometimes letters are interpreted as very very large numbers, so
  % running max(max(file1)) to see what the biggest overall number is 
  % is often prudent (i.e. do it!).

% If you want to write an ASCII file to disk (i.e. save your results)
% You do the following.  Lets assume the data is in a matrix called
% XXX and you want to make a file called results.asc, do this:

XXX = randn(3,3);  % make up some data to print out as a file.

save a:\results.out XXX -ascii;
  % the above writes 8 digits per element of XXX in scientific
  % notation.  i.e. 72.304 will be written as 7.2304000e+01
  % I try and identify my output files via assigning an extension of
  % .out to them.
  
EndTime = clock;  % 1x6 vector of current time.
TotalTime = etime(EndTime,BeginTime);  % Computes elapsed seconds.
disp('Total time (in minutes) to run the program was ');
disp(TotalTime/60);




