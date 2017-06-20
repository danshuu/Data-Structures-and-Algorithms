% Financial Engineering HW3
% This version 990324
% Author:  Daniel Shu
% Does Capital Budgeting I for different values of P and Q


clear all;    % resets memory - should be the first line of any pgm
format bank;  % controls how numbers are displayed e.g. 1.33
              % bank gives 2 digits to right of decimal (money)
              % versus format short e; e.g. 1.3333e+00
              % versus format short;  e.g. 1.3333

% change to USB path later
path(path, 'h:\bus444\hw3\functions');  

%/**************************** BEGIN CONTROL PANEL *****************************

% Set location to write NPV Matrix to 

swtWriteTo = 8;   %  3 = c:\bus444\hw1\, 4 = c:\bus444\hw1\ etc  9 = Apple etc 
                  %    Make sure C to H drives are available (via =3 to =8 ) 


% Overall Parameters 
swtProjectLife = 7;    % Expected life of project, in years 
swtWACC = 0.1720;      % Weighted average cost of capital for this project 
swtTaxRate = 0.3;     % Marginal tax rate for the project % 

% Capital Spending Parameters 
swtCostOfEquip = 69000;   % cost of factory at t=0, assume paid in cash 
swtSalvValue = 28000;     % Est. of Salvage value for deprec purposes 
                          % at the end of the assumed deprec period 
swtMktValue = 47000;      % Est. of the actual mkt value of factory at 
                          % the end of the projects life 
swtDeprecLife =  4;       % The Depreciation period (in yrs) to use. 
                          % Dictated by the IRS and the type of asset used 

% Operating Parameters  
                        % Added so that I can create a PNow while incorporating the PGrowth rate 
    swtMinP = 6.00;          % minimum Price per unit in the grid 
 	swtMaxP = 20.00;         % maximum Price per unit in the grid 
      swtGridP = 4;          % number of grid points (nodes) to for prices. 
                             % Must be > 1 
                             % This will only change the plot of the graph 
    swtQuantThisPer = 1500%  % Quantity per unit for this period 
                        % Added so that I can create a QNow while incorporating the QGrowth rate 
      swtMinQ = 400;         % minimum Q in the grid 
      swtMaxQ = 1500;        % maximum Q in the grid 
      swtGridQ = 6;          % number of grid points (nodes) to use with Q 
                             % Must be > 1 
                             % This will only change the plot of the graph 
      swtPGrowth = .1500;      % annualized nominal growth in prices beyond t=1 
      swtQGrowth = -0.1100;    % annualized growth of quantity sold beyond year 1 
                               % Enter above as a decimal, i.e. 0.0100 for +1% growth 

      swtFixOpCost = 4700;     % fixed Op. Costs at t=1 
      swtFixOpCostGr = 0.0500; % annualized growth in fixed Op. costs after year 1 
                               % Enter above as a decimal, i.e. 0.0100 for +1% growth 
                               % A value close to inflation is probably appropriate 
      swtVarOpCost =  6.86;    % variable op. Costs *per unit* at t=1 
      swtVarOpCostGr = 0.0400; % Ann. growth in variable Op. Cost per unit after t=1 
                               % Enter above as a decimal, i.e. 0.0100 for +1% growth 
                               % A value close to inflation is probably appropriate 

% Changes in Working Capital parameters  
      swtInvent = 0.190;  % Required Invent level as a proportion of next years sales 
      swtAR     = 0.260;  % Acct Rec level as a proportion of same year revenue 
      swtAP     = 0.220;  % Acct Pay level as a proportion of same year revenue 
     

%*************************** END OF CONTROL PANEL *****************************

% build P and Q grid for the loops 
% These column vectors hold the specific values of P and Q that we'll investigate 
PGrid = seqa(swtMinP, (swtMaxP-swtMinP)/(swtGridP-1), swtGridP);
QGrid = seqa(swtMinQ, (swtMaxQ-swtMinQ)/(swtGridQ-1), swtGridQ);

% Now initialize Matricies for CF from Capital Spending, Operations and changes 
% in Working Capital.  


CFOP  = zeros(6,swtProjectLife+1);  % CF from Operations % 
CFCS = zeros(7,swtProjectLife+1);  % CF from Capital Spending - all values entered 
CFWC  = zeros(10,swtProjectLife+1);  % CF from changes in Working Capital 

NPVMatx = zeros(swtGridP,swtGridQ) - 9.99; % will hold NPV for each P-Q combo 

i = 1; % loop of rows 
while i <= swtGridP;
    Pnow = PGrid(i,1); % Pnow is the price at which the loop is currently at 
    j = 1; % loop of columns 
    while j <= swtGridQ; 
        Qnow = QGrid(j,1); % Qnow is the quantity at which the loop is currently at 
          % row 1 = accting revenue before tax 
          % row 2 = accting value of fixed operating expenses - enter as positive values 
          % row 3 = accting value of total variable operating expenses - positive values 
          % row 4 = depreciation per year - enter as a positive value 
          % row 5 = Rev - Exp - Deprec = +row1 - row2 - row3 - row4 
          % row 6 = (row 5 * (1 - TaxRate)) + Deprec = CF from Operations 
        CFOP(1,2:swtProjectLife+1) = seqm(Pnow*Qnow,(1+swtPGrowth)*(1+swtQGrowth),swtProjectLife)'; % accounting revenue before tax at t=1 
        CFOP(2,2:swtProjectLife+1) = seqm(swtFixOpCost,(1+swtFixOpCostGr),swtProjectLife)';
        CFOP(3,2:swtProjectLife+1) = seqm(swtVarOpCost*Qnow,(1+swtVarOpCostGr)*(1+swtQGrowth),swtProjectLife)';
        if swtDeprecLife >= swtProjectLife;
            CFOP(4,2:swtProjectLife+1) = seqm((swtCostOfEquip-swtSalvValue)/swtDeprecLife, 1, swtProjectLife)';
        else;
            CFOP(4,2:swtDeprecLife+1) = seqm((swtCostOfEquip-swtSalvValue)/swtDeprecLife, 1, swtDeprecLife)';
        end; % end of if statements
        CFOP(5,:) = CFOP(1,:) - CFOP(2,:) - CFOP(3,:) - CFOP(4,:);
        CFOP(6,:) = CFOP(5,:) * (1 - swtTaxRate) + CFOP(4,:);

        % row 1 =   Turn-key purchase cost of Capital Equipment - enter as a negative num. 
        % row 2 =   Depreciation per year of capital Equipment - via straight line to 
        %           to an expected salvage value of swtSalvValue - positive value. 
        % row 3 =   Accumulated Depreciation 
        % row 4 =   Book Value of capital equipment at each point in time. 
        % row 5 =   Expected market selling price of capital equipment when disposed of 
        %           at the end of the project per swtMktValue.  Enter as a positive value 
        % row 6 =   CF from liqidation of capital equipment at end of % project.  This line 
        %           includes the tax effect from selling the %equipment at a price other   
        %           than the current book value = MV + (TaxRate)*(BV-% MV), will be pos %   
        % row 7 =   sum of rows 1 and 6 = CF from Capital Spending - % can have pos and neg values 
        CFCS(1,1) = -1 * swtCostOfEquip;
        if swtDeprecLife >= swtProjectLife;
            CFCS(2,2:swtProjectLife+1) = seqm((swtCostOfEquip - swtSalvValue)/swtDeprecLife,1,swtProjectLife)';
            CFCS(3,2:swtProjectLife+1) = seqa((swtCostOfEquip - swtSalvValue)/swtDeprecLife,(swtCostOfEquip - swtSalvValue)/swtDeprecLife,swtProjectLife)';
            CFCS(4,1:swtProjectLife+1) = seqa(swtCostOfEquip,-(swtCostOfEquip-swtSalvValue)/swtDeprecLife,swtProjectLife+1)';

        else;
            CFCS(2,2:swtDeprecLife+1) = seqm((swtCostOfEquip - swtSalvValue)/swtDeprecLife,1,swtDeprecLife)';
            CFCS(3,2:swtDeprecLife+1) = seqa((swtCostOfEquip - swtSalvValue)/swtDeprecLife,(swtCostOfEquip - swtSalvValue)/swtDeprecLife,swtDeprecLife)';
            CFCS(3,swtDeprecLife+2:swtProjectLife+1) = seqa(CFCS(3,swtDeprecLife+1),0,swtProjectLife-swtDeprecLife)';
            CFCS(4,1:swtDeprecLife+1) = seqa(swtCostOfEquip,-(swtCostOfEquip-swtSalvValue)/swtDeprecLife,swtDeprecLife+1)';
            CFCS(4,swtDeprecLife+2:swtProjectLife+1) = seqa(CFCS(4,swtDeprecLife+1),0,swtProjectLife-swtDeprecLife)';
            % The rest of the book value after position depreclife will just be left at zeros 
        end; % end of if statements
        
        CFCS(5,swtProjectLife+1) = swtMktValue;
        CFCS(6,swtProjectLife+1) = CFCS(5,swtProjectLife+1) + swtTaxRate * (CFCS(4,swtProjectLife+1) - CFCS(5,swtProjectLife+1)); % CF from capital equipment liquidation at the end of the project 
        CFCS(7,1) = (CFCS(1,1) + CFCS(6,1)); % total CF from Capital Spending % 
        CFCS(7,swtProjectLife+1) = (CFCS(1,swtProjectLife+1) + CFCS(6,swtProjectLife+1));
        % row 1 = inventory levels 
        % row 2 = A/R levels 
        % row 3 = A/P levels 
        % row 4 = Changes in inventory levels 
        % row 5 = Changes in A/R levels 
        % row 6 = Changes in A/P levels 
        % row 7 = CF implication from the change in inventory levels = row 4 * -1 
        % row 8 = CF implication from the change in A/R levels = row 5 * -1 
        % row 9 = CF implication from the change in A/P levels = row 6 
        % row 10 = sum of rows 7,8,9 = CF from changes in Working Capital 
        CFWC(1,1:swtProjectLife) = swtInvent * CFOP(1,2:swtProjectLife+1);
        CFWC(2,2:swtProjectLife+1) = swtAR * CFOP(1,2:swtProjectLife+1);
        CFWC(3,2:swtProjectLife+1) = swtAP * CFOP(1,2:swtProjectLife+1);
        CFWC(4,1) = CFWC(1,1);
        CFWC(4,2:swtProjectLife+1) = CFWC(1,2:swtProjectLife+1) - CFWC(1,1:swtProjectLife);
        CFWC(5,2:swtProjectLife+1) = CFWC(2,2:swtProjectLife+1) - CFWC(2,1:swtProjectLife);
        CFWC(5,swtProjectLife+1) = CFWC(2,swtProjectLife) * -1;
        CFWC(6,2:swtProjectLife+1) = CFWC(3,2:swtProjectLife+1) - CFWC(3,1:swtProjectLife);
        CFWC(6,swtProjectLife+1) = CFWC(3,swtProjectLife) * -1;
        CFWC(7,:) = CFWC(4, :) * -1;
        CFWC(8,:) = CFWC(5, :) * -1;
        CFWC(9,:) = CFWC(6, :) * 1;
        CFWC(10,:) = sum(CFWC(7:9,:));

        % the i variable will represent the price moving upwards in the vector 
        % the j variable will represent the quantity moving upwards in the vector 
        NPVMatx(i,j) = (CFCS(7,:) + CFOP(6,:) + CFWC(10,:)) * (seqm(1,1/(1+swtWACC),swtProjectLife+1));
        j = j + 1;
        end; % end of first while
    i = i + 1;
    end; %end of second while
    
% Done initializing matricies 

% Now YOU write the program using the above framework 

%How to plot a 3Dim surface plot in Gauss… type help surface (at the gaussprompt)for more info…
%Plot the NPV Surface 
%labels for the axis 

xlabel('Price per unit');       
ylabel('Quantity Sold');
zlabel('NPV');

XAxis = PGrid;
YAxis = QGrid;
surf(PGrid',QGrid,NPVMatx');

% print the graph
disp(NPVMatx);
disp(XAxis);
disp(YAxis);

% Export to USB ASCII FILE;
% save output to file (pick what to output)

if swtWriteTo == 1;
    save a:\bus444\hw3\FEHW3A.out XAxis YAxis NPVMatx -ascii;
elseif swtWriteTo == 3;
    save c:\bus444\hw3\FEHW3A.out XAxis YAxis NPVMatx -ascii;
elseif swtWriteTo == 4;
    save d:\bus444\hw3\FEHW3A.out XAxis YAxis NPVMatx -ascii;
elseif swtWriteTo == 5;
    save e:\bus444\hw3\FEHW3A.out XAxis YAxis NPVMatx -ascii;
elseif swtWriteTo == 6;
    save f:\bus444\hw3\FEHW3A.out XAxis YAxis NPVMatx -ascii;
elseif swtWriteTo == 7;
    save g:\bus444\hw3\FEHW3A.out XAxis YAxis NPVMatx -ascii;
elseif swtWriteTo == 8;
    save h:\bus444\hw3\FEHW3A.out XAxis YAxis NPVMatx -ascii;
elseif swtWriteTo == 9;
    save /users/Daniel/bus444/hw3/FEHW3A.out XAxis YAxis NPVMatx -ascii;
end;



