% Financial Engineering HW6
% This version 990515
% Author:  Daniel Shu
% Does Capital Budgeting I for different values of P and Q
%   generated from a multivariate normal distribution


clear all;  % reset ram 
format bank;  % set the way numbers are displayed 
% addpath a:\;

%*************************** BEGIN CONTROL PANEL *****************************

% Price and Quantity Parameters
   swtPMean = 14;    % Expected Price
   swtQMean = 1750;  % Expected Quantity
   swtPStDev = 2;    % Price Standard Deviation
   swtQStDev = 200;  % Quantity Standard Deviation
   swtPQCorr = -.20; % Correlation between Price and Quantity
   
   swtN = 100; % number of price/quantity draws to make from the bivariate normal distibution
   
% CI and Probability Parameters

swtCI = [.99 .975 .95 .50]'; % column vector 
   % enter [] to find no confidence intervals
   % enter any confidence intervals with a space in between
   % there are NO LIMITS on the number of intervals to be found.
   % eg [.99 .95 .50]
      
swtNPVProb = [-50000 -40000 -30000 -20000 -10000 0 10000 20000]';
   % enter [] to find no probabilities
   % enter any values with a space in between and the program will compute
   %    probability of achieving a greater NPV
   % there are NO LIMITS on the number of probabilities to be found.
   % eg [-1000 0 1500]   
   
% Overall Parameters 
	swtProjectLife = 4;    % Expected life of project, in years 
	swtWACC = 0.130;      % Weighted average cost of capital for this project 
	swtTaxRate = 0.35;     % Marginal tax rate for the project 

% Capital Spending Parameters 
	swtCostOfEquip = 75000;   % cost of factory at t=0, assume paid in cash 
	swtSalvValue = 18000;     % Est. of Salvage value for deprec purposes 
   	                       % at the end of the assumed deprec period 
	swtMktValue = 37000;      % Est. of the actual mkt value of factory at 
	                          % the end of the projects life
	swtDeprecLife =  6;       % The Depreciation period (in yrs) to use. 
	                          % Dictated by the IRS and the type of asset used

% Operating Parameters  

	swtPGrowth = .0500;      % annualized nominal growth in prices beyond t=1 
   swtQGrowth = -0.0200;    % annualized growth of quantity sold beyond year 1 
                            % Enter above as a decimal, i.e. 0.0100 for +1% growth 

   swtFixOpCost = 2300;     % fixed Op. Costs at t=1 
   swtFixOpCostGr = 0.0100; % annualized growth in fixed Op. costs after year 1 
                            % Enter above as a decimal, i.e. 0.0100 for +1% growth 
                            % A value close to inflation is probably appropriate 
   swtVarOpCost =  1.86;    % variable op. Costs *per unit* at t=1 
   swtVarOpCostGr = 0.0400; % Ann. growth in variable Op. Cost per unit after t=1
                            % Enter above as a decimal, i.e. 0.0100 for +1% growth 
                            % A value close to inflation is probably appropriate 

% Changes in Working Capital parameters  
   swtInvent = 0.170;  % Required Invent level as a proportion of next years sales 
   swtAR     = 0.180;  % Acct Rec level as a proportion of same year revenue 
   swtAP     = 0.190;  % Acct Pay level as a proportion of same year revenue 


% Program output functions 
   swtPrtNPV = 1; % 1 = print NPV matix to screen, 0 = don't print 
   swtPrtGph = 1; % 1 = print histogram graph to screen, 0 = don't print 
   swtPrtFile= 8; % 1,3 4 5 etc print NPV matrix to file, 0 = don't print 
      % i.e. 4 = print to d:\   5 = print to e:\   6 = print to f:\ etc

%************************** END OF CONTROL PANEL *****************************/

% you write the program from here.  Turn in the program with switches set as I sent you.

% means
% 2x1 vector
meanVector = zeros(2,1) - 9.99;
meanVector(1,1) = swtPMean;
meanVector(2,1) = swtQMean;

% VCV matrix
% 2x2 matrix
vcv = zeros(2,2) - 9.99;
vcv(1,1) = swtPStDev ^ 2; % variance of P
vcv(2,2) = swtQStDev ^ 2; %variance of Q
vcv(1,2) = swtPQCorr * (swtPStDev*swtQStDev); %covariance between P&Q
vcv(2,1) = swtPQCorr * (swtPStDev*swtQStDev); %covariance between P&Q

% mvnormal function
PQDrawnMatrix = mvnormal(meanVector,vcv,swtN); 

% P,Q NPV Matrix
% PQTranspose = PQDrawnMatrix';
OutMatrix = zeros(swtN, 3) - 9.99;
OutMatrix(:,1) = PQDrawnMatrix(1,:)'; % each row of OutMatrix should put the Drawn P in column 1
OutMatrix(:,2) = PQDrawnMatrix(2,:)'; % each row of OutMatrix should put the drawn Q in column 2

% Computed NPV in column 3
for i=1:swtN
    OutMatrixP = OutMatrix(i,1); %PNow
    OutMatrixQ = OutMatrix(i,2); %QNow
    NPVNow = HW6NPV(OutMatrixP,OutMatrixQ,...
            swtProjectLife,swtWACC,swtTaxRate,swtCostOfEquip,...
            swtSalvValue,swtMktValue,swtDeprecLife,...
            swtPGrowth,swtQGrowth,swtFixOpCost,swtFixOpCostGr,swtVarOpCost,...
            swtVarOpCostGr,swtInvent,swtAR,swtAP);
    OutMatrix(i,3) = NPVNow; % designates each position in the 3rd row of the matrix to the NPV at the current time
end;

% % Program output functions 
%    swtPrtNPV = 0; % 1 = print NPV matix to screen, 0 = don't print 
%    swtPrtGph = 1; % 1 = print histogram graph to screen, 0 = don't print 
%    swtPrtFile= 0; % 1,3 4 5 etc print NPV matrix to file, 0 = don't print 
%       % i.e. 4 = print to d:\   5 = print to e:\   6 = print to f:\ etc

% print P,Q,NPV Matrix to screen      
if swtPrtNPV == 1
disp(OutMatrix);
end;

%histogram plot
if swtPrtGph == 1
%     figure
nbins = 50;
histogram(OutMatrix, nbins);
end;
    
% report/print to the screen the mean NPV and sample StDev of NPVs
NPVmean = mean(OutMatrix(:,3));
fprintf('NPV Mean: %6.8f', NPVmean);
NPVstd = std(OutMatrix(:,3));
fprintf('\n\nNPV Standard Deviation: %5.8f', NPVstd);

% report different confidence intervals of NPV
rowsOfCI = rows(swtCI);
npvSort = sort(OutMatrix(:,3)); % sort PQNPVMatrix by NPVs

% 
% newMatrix(:,1) = swtCI; % CI intervals for printing
% newMatrix(:,2) = npvSort(((1-swtCI)/2)*swtN); % Lower Range CI
% newMatrix(:,3) = npvSort((((1-swtCI)/2)+swtCI)*swtN); % Upper Range CI
% % display new Matrix
% disp(newMatrix);

g = 1;
while g<=rowsOfCI
notCI=(1-swtCI(g,1)); % 1 - CI (iterating through CIs)
tails = notCI/2; % (1-CI)/2 -> tails of CI
UB = 1-tails; % upper bound of CI
UR=UB*swtN; % upper range of CI
J = npvSort(round(UR),1);
fprintf('\nUpper Bound\n');
disp(swtCI(g,1)*100); 
disp('              %');
disp(J);

LR = tails*swtN; % lower range of CI
R = npvSort(round(LR),1);
disp('\nLower Bound\n');
disp(swtCI(g,1)*100);
disp('              %');
disp(R);
g=g+1;
end;

%probabilty of achieving certain value larger than specified NPV

rowsNPVprobability = rows(swtNPVProb);
% # of rows of transposed swtNPVProb
i=1;
while i<=rowsNPVprobability;
    z=(OutMatrix(:,3)>=swtNPVProb(i,1));
    p=(sum(z>0)/swtN)*100;
    disp('Probability Greater Than');
    disp(swtNPVProb(i,1));
    disp(p);   
i=i+1;
end;

%ascii output

if swtPrtFile == 1;
    save a:\bus444\hw6\FEHW6.out OutMatrix -ascii;
elseif swtPrtFile == 3;
    save c:\bus444\hw6\FEHW6.out OutMatrix -ascii;
elseif swtPrtFile == 4;
    save d:\bus444\hw6\FEHW6.out OutMatrix -ascii;
elseif swtPrtFile == 5;
    save e:\bus444\hw6\FEHW6.out OutMatrix -ascii;
elseif swtPrtFile == 6;
    save f:\bus444\hw6\FEHW6.out OutMatrix -ascii;
elseif swtPrtFile == 7;
    save g:\bus444\hw6\FEHW6.out OutMatrix -ascii;
elseif swtPrtFile == 8;
    save h:\bus444\hw6\FEHW6.out OutMatrix -ascii;
elseif swtPrtFile == 9;
    save /users/Daniel/bus444/hw6/FEHW6.out OutMatrix -ascii;
end;








