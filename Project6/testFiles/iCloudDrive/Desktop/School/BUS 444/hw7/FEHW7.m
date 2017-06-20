% Financial Engineering Homework #7
% This version (7C) has complex constraints
% Versioin 7D has simple constraints.  Good to demo both.
% Author LRG
% Does portfolio optimization

clear all;  % reset ram 
path(path, 'h:\');  % location of custom .m files 

format short g;  % set the way numbers are displayed 

% *****************************Begin Control Panel********************************

StockReturns = xlsread('CoBPort.xls');

swtN = cols(StockReturns); %returns the quantified number of columns

options(1) = 1; % 1 = turn on screen, 0 = off, -1 = surpress warning messages
options(2) = le-5; % tollerance for weights, default = le-4
options(3) = le-5; % tollerance for objective function, default = le-4

% Expected Retun Grid Parameters
% These are only meaningful if swtERMaxMinHistorical = 0;
swtERMax = .75; % maximum expected return
swtERMin = .05; % minimum expected return
swtERInc = .01; % INCrement between max and min
  % For example, if the swithes are set to 0.15, 0.08, and 0.01 respectively, then the
  % ER-Grid will be [ .08 .09 .10 .11 .12 .13 .14 .15 ];
  % NOTE:  if swtERMaxMinHistorical is not equal to zero, then these three switches 
  %        are ignored completely.

swtERMaxMinHistorical = 20; % A non-negative integer scalar, Never equal to one.
                            % Controls the set of E[R] nodes that we will minimize variance for.
                            % If = 0 then use the max/min grid indicated via the three 
                            %     switches swtERMax, swtERMin and swtERInc.   
                            % If >= 2, then the max and min E[R]'s to use in the E[R]-Grid will 
                            % equal the highest and lowest E[R]'s across all of the stocks.  The value of 
                            % swtERMaxHistorical indicates how many nodes are in the E[R]-Grid.
                            % For example, if the highest and lowest E[R]'s (across the N stocks) are
                            % 0.02 and 0.18 (annualized), and if swtERMaxMinHistorical equals 5, then
                            % the ER-Grid would be = [ .02  .06  .10  .14   .18 ]'.
                            % Note: If value is >= 2 then higher values improve precision, i.e. 100 gives
                            % more precise optimal weight vectors than does 99.  
                          
                            
swtERMethod = 0; % 0 = expected return for each stock estimated as Mu, 
                 % 1 = expected return estimated as Mu - (sigma^2)/2
                 %  Note: Other ways, we could do, but are not, include CAPM, APT which could be 
                 % invoked by setting this switch equal to 2 or 3.
                 
swtAllowShortSales = 0; % 1 = allow short sales, 0 = don't

% swtMinWt = -inf; % Can be a scalar, or an Nx1 vector (with different values in each position).
                 % Puts a lower bound on the weight any stock may have
                 % -inf = short selling allowed, -0.15 means any stock can be shorted up to
                 % 15% of the value of the portfilio, 0 = no short selling allowed 
                 
  
% swtMinWt =   [ .00 .00 .00 .00 .02 .02 .02 .02 .02 .02 ]';    
                 % lower bound constraints
                
swtMaxWt = +inf; % Can be a scalar, or an Nx1 vector (with different values in each position).
                 % Puts an upper bound on the weight any stock may have
                 % use '+inf' to not use an upper bound, use .20 to insure that no
                 % stock comprises more than 20% of the portfolio.
                 
                 % Example (with column vectors of dim Nx1):  
                 % To have the first four stocks (of N=10) be bounded between zero and 0.07 weighting,
                 %   and the last six stocks bounded between 2% and 6% weights, then you would use:
                 % swtMinWt = [ .00 .00 .00 .00 .02 .02 .02 .02 .02 .02 ]' and
                 % swtMaxWt = [ .07 .07 .07 .07 .06 .06 .06 .06 .06 .06 ]' 
% swtMaxWt = [ .34 .34 .34 .34 .16 .16 .16 .16 .16 .16 ]' ;
                 %upper bound constraints

% The next two switches are for specifying custom linear EQuality constraints, as demonstrated 
% in pages 4-37 and 4-38 of the Matlab optimization manual.
% These switches are NOT to be used for insuring that all weights sum to one, or for insuring that the E[R] of the
% portfilio equals a specific value - those two constraints are to be hardcoded within the loop since they are ALWAYS imposed.
%  The switches below are for additional constraints beyond these two.
%  For example to insure that (i) stocks 1, 3, and 7 weights sum to exactly 0.22, (ii) stocks 1 and 4 weights sum to 0.16, and 
%  (iii) stocks 2 and 8 have their weights equal to each other (i.e. w_2 - w_8 = 0), (Three constraints total) you would use:
%    swtOther_Aeq = [ 1 0 1 0 0 0 1 0 0 0 ; 1 0 0 1 0 0 0 0 0 0 ; 0 1 0 0 0 0 0 -1 0 0 ] and 
%    swtOther_beq = [ 0.22 ; 0.16 ; 0]
% Turn these switches off with =[];
% swtOther_Aeq = [ 1 0 1 0 0 0 1 0 0 0 ];
% swtOther_beq = [ 0.22 ];

% The next two switches are for specifying custom linear INequality constraints, as demonstrated 
% in pages 4-37 and 4-38 of the Matlab optimization manual.  Make sure the linear constraint equations are written
% as A*x <= b, not as A*x >= b  
% For example to insure that stocks 5, 8, and 10 have their collective weight between 6% and 40% (two constraints)
% you would use:
% swtOther_A   = [ 0 0 0 0 -1 0 0 -1 0 -1 ; 0 0 0 0 1 0 0 1 0 1 ]; 
% swtOther_b   = [ -0.06 ; +0.40 ];

% swtOther_A   = [ 0 0 0 0 -1 0 0 -1 0 -1 ; 0 0 0 0 1 0 0 1 0 1 ]; 
% swtOther_b   = [ -0.06 ; +0.40 ];


swtWtPort = [.1166 .0478 .0805 .1013 .1163 .0674 .0817 .0395 .0879 .0697]';
swtWtCash = .1912;
swtRf = .0475; % Risk-free rate, annualized, as a decimal (e.g. 0.052)


% *****************************End Control Panel***********************************

MinimumVector = zeros(1,swtN)+swtMinWt;
MaximumVector = zeros(1,swtN)+swtMaxWt;

%define averages with two methods dictated by switch
global ERMean
if swtERMethod == 0;
ERMean = mean(StockReturns)*252;
elseif swtERMethod == 1;
ERMean = (mean(StockReturns)*252)-(0.5*(var(StockReturns)));
end;

swtN_size = size(swtN);
%create ERGrid uner each condition

if swtERMaxMinHistorical >= 1;
    if swtERMaxMinHistorical == 1;
        disp('Error, switching swtERMaxMinHistorical to 2');
    end;
swtERMax = max(ERMean);
swtERMin = min(ERMean);
swtERInc = ((swtERMax-swtERMin)/(swtERMaxMinHistorical-1));
ERInc = seqa(swtERMin,swtERInc,swtERMaxMinHistorical)';
ERGrid = zeros(swtN+1,swtERMaxMinHistorical)-9.99;
ERGrid (1,:) = ERInc;

% elseif swtERMaxMinHistorical == 1;
% disp('Error, switching swtERMaxMinHistorical to 2');
% swtERMax = max(ERMean);
% swtERMin = min(ERMean);
% swtERInc = ((swtERMax-swtERMin)/swtERMaxMinHistorical);
% ERInc = seqa(swtERMin,swtERInc,swtERMaxMinHistorical+1)';
% ERGrid = zeros(swtN+1,swtERMaxMinHistorical+1)-9.99;
% ERGrid (1,:) = ERInc;

elseif swtERMaxMinHistorical == 0;
ERInc = seqa(swtERMin,swtERInc,((swtERMax-swtERMin)/swtERInc)+1);
ERGrid = zeros(swtN+1,((swtERMax-swtERMin)/swtERInc)+1)-9.99;
ERGrid (1,:) = ERInc;
end;

%define dimension of W (weights for each stock in port)

W = zeros(swtN,1);


%create VCV matrix
global VCVMatx;
VCVMatx = cov(StockReturns)*252;

%starting guess for solution of W star

x0(1:swtN)=0.00;

%find optimal W

options = optimset('LargeScale','off','Display','iter');


i=1;
while i<=cols(ERGrid);
swtOther_Aeq1 = [swtOther_Aeq; ERGrid(2:swtN+1,i)'; ERMean];
swtOther_beq1 = [swtOther_beq;(-1.00*10)+0.01; ERGrid(1,i)];
[W] = fmincon('objfun',x0,swtOther_A,swtOther_b,swtOther_Aeq1,swtOther_beq1,MinimumVector,MaximumVector,[],options);
ERGrid(2:swtN+1,i) = W;
i=i+1;
end;

WStarSave = ERGrid(2:swtN+1,:);

%variance of each optimized portfolio

if swtERMaxMinHistorical > 1;
    VarMatx = zeros(1,swtERMaxMinHistorical)-9.99;
elseif swtERMaxMinHistorical == 1;
    VarMatx = zeros(1,swtERMaxMinHistorical+1)-9.99;
elseif swtERMaxMinHistorical == 0;
    VarMatx = zeros(1,((swtERMax-swtERMin)/swtERInc)+1)-9.99;
end;

j=1;
while j<=cols(VarMatx);
VarMatx(1,j) = ERGrid(2:swtN+1,j)'*VCVMatx*ERGrid(2:swtN+1,j);  
j=j+1;
end;

%sharpe ratio for each portfolio

SharpeMatx = zeros(1,cols(VarMatx))-9.99;

k=1;
while k<=cols(VarMatx);
SharpeMatx (1,k) = (ERGrid(1,k)-swtRf)/(VarMatx(1,k)^0.5);
k=k+1;
end;

SharpeMatx1 = SharpeMatx';

%efficient frontier graph (without risk free asset)

if swtERMaxMinHistorical == 0;
    Slope = max(SharpeMatx);
elseif swtERMaxMinHistorical == 1;
    Slope = max(SharpeMatx1);
elseif swtERMaxMinHistorical > 1;
    Slope = max(SharpeMatx1);
end;

%efficient frontier with risk-free asset (red) and without risk-free asset
%(blue)

X = seqa(0,sqrt(VarMatx)+.015/1e3,1e3);
Y = Slope*X+swtRf;
plot(sqrt(VarMatx),ERInc,X,Y,'--','LineWidth',2);
set(gca, 'ylim',[min(ERInc)-.1,max(ERInc)+.1],'xlim', [0, sqrt(max(VarMatx))+.1]);

%output values displayed to the screen

[mxval,row] = (max(SharpeMatx));
C = [mxval,row];
E = C(1,2);
disp('The Tangency is at Node');
disp(E);
disp('The Tangency Porfolio has StDev and E[R]');
disp(VarMatx(1,E)^0.5);
disp(ERGrid(1,E));
disp('The Sharpe Ratio (Slope of Captial Market Line) is');
% disp('Maxslope =');
disp(max(SharpeMatx));
disp('Weights associated with the Tangency Portfolio');
disp(WStarSave(:,E));