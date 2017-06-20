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
% path('g:\bus444\functions', path);  

%/**************************** BEGIN CONTROL PANEL *****************************

% Set location to write NPV Matrix to 

swtWriteTo = 9;   %  3 = c:\bus444\hw1\, 4 = c:\bus444\hw1\ etc  9 = Apple etc 
                  %    Make sure C to H drives are available (via =3 to =8 ) 


% Overall Parameters 
swtProjectLife = 4;    % Expected life of project, in years 
swtWACC = 0.1220;      % Weighted average cost of capital for this project 
swtTaxRate = 0.34;     % Marginal tax rate for the project % 

% Capital Spending Parameters 
swtCostOfEquip = 65000;   % cost of factory at t=0, assume paid in cash 
swtSalvValue = 20000;     % Est. of Salvage value for deprec purposes 
                          % at the end of the assumed deprec period 
swtMktValue = 40000;      % Est. of the actual mkt value of factory at 
                          % the end of the projects life 
swtDeprecLife =  7;       % The Depreciation period (in yrs) to use. 
                          % Dictated by the IRS and the type of asset used 

% Operating Parameters  
                        % Added so that I can create a PNow while incorporating the PGrowth rate 
    swtMinP = 5.00;          % minimum Price per unit in the grid 
 	swtMaxP = 20.00;         % maximum Price per unit in the grid 
      swtGridP = 8;          % number of grid points (nodes) to for prices. 
                             % Must be > 1 
                             % This will only change the plot of the graph 
    swtQuantThisPer = 1500%  % Quantity per unit for this period 
                        % Added so that I can create a QNow while incorporating the QGrowth rate 
      swtMinQ = 500;         % minimum Q in the grid 
      swtMaxQ = 1500;        % maximum Q in the grid 
      swtGridQ = 5;          % number of grid points (nodes) to use with Q 
                             % Must be > 1 
                             % This will only change the plot of the graph 
      swtPGrowth = .0500;      % annualized nominal growth in prices beyond t=1 
      swtQGrowth = -0.0100;    % annualized growth of quantity sold beyond year 1 
                               % Enter above as a decimal, i.e. 0.0100 for +1% growth 

      swtFixOpCost = 2700;     % fixed Op. Costs at t=1 
      swtFixOpCostGr = 0.0300; % annualized growth in fixed Op. costs after year 1 
                               % Enter above as a decimal, i.e. 0.0100 for +1% growth 
                               % A value close to inflation is probably appropriate 
      swtVarOpCost =  3.86;    % variable op. Costs *per unit* at t=1 
      swtVarOpCostGr = 0.0200; % Ann. growth in variable Op. Cost per unit after t=1 
                               % Enter above as a decimal, i.e. 0.0100 for +1% growth 
                               % A value close to inflation is probably appropriate 

% Changes in Working Capital parameters  
      swtInvent = 0.150;  % Required Invent level as a proportion of next years sales 
      swtAR     = 0.160;  % Acct Rec level as a proportion of same year revenue 
      swtAP     = 0.120;  % Acct Pay level as a proportion of same year revenue 
     

%*************************** END OF CONTROL PANEL *****************************




%**************************** BEGIN Gorman's CONTROL PANEL *****************************

swtWriteTo = 7;  % where to write output to: 3 = c:\, 5 = e:\  etc

% Overall Parameters 
swtProjectLife = 7;    % Expected life of project, in years 
swtWACC = 0.1720;      % Weighted average cost of capital for this project 
swtTaxRate = 0.3;     % Marginal tax rate for the project 

% Capital Spending Parameters 
swtCostOfEquip = 69000;   % cost of factory at t=0, assume paid in cash 
swtSalvValue = 28000;     % Est. of Salvage value for deprec purposes 
                          % at the end of the assumed deprec period 
swtMktValue = 47000;      % Est. of the actual mkt value of factory at 
                          % the end of the projects life 
swtDeprecLife =  4;       % The Depreciation period (in yrs) to use. 
                          % Dictated by the IRS and the type of asset used 

% Operating Parameters  
      swtMinP = 6.00;          % minimum Price per unit in the grid 
      swtMaxP = 20.00;         % maximum Price per unit in the grid 
      swtGridP = 4;          % number of grid points (nodes) to for prices. 
                             % Must be > 1 
      swtMinQ = 400;         % minimum Q in the grid 
      swtMaxQ = 1500;        % maximum Q in the grid 
      swtGridQ = 6;          % number of grid points (nodes) to use with Q 
                             % Must be > 1 
      swtPGrowth = 0.1500;      % annualized nominal growth in prices beyond t=1 
      swtQGrowth =  -0.1100;    % annualized growth of quantity sold beyond year 1 
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
     
      
      
%*************************** END OF Gorman's CONTROL PANEL *****************************




% build P and Q grid for the loops 
% These column vectors hold the specific values of P and Q that we'll investigate 
PGrid = seqa(swtMinP, (swtMaxP-swtMinP)/(swtGridP-1), swtGridP);
QGrid = seqa(swtMinQ, (swtMaxQ-swtMinQ)/(swtGridQ-1), swtGridQ);

% Now initialize Matricies for CF from Capital Spending, Operations and changes 
% in Working Capital.  


% CFOP  = zeros(6,swtProjectLife+1);  % CF from Operations % 
% CFCS = zeros(7,swtProjectLife+1);  % CF from Capital Spending - all values entered 
% CFWC  = zeros(10,swtProjectLife+1);  % CF from changes in Working Capital 
% 
% NPVMatx = zeros(swtGridP,swtGridQ) - 9.99; % will hold NPV for each P-Q combo 

i = 1; % loop of rows 
while i <= swtGridP;
    PNow = PGrid(i,1); % Pnow is the price at which the loop is currently at 
    j = 1; % loop of columns 
    while j <= swtGridQ; 
        QNow = QGrid(j,1); % Qnow is the quantity at which the loop is currently at 
        % the i variable will represent the price moving upwards in the vector 
        % the j variable will represent the quantity moving upwards in the vector 
        NPVNow = HW3NPV(PNow,QNow,...
            swtProjectLife,swtWACC,swtTaxRate,swtCostOfEquip,...
            swtSalvValue,swtMktValue,swtDeprecLife,swtMinP,swtMaxP,swtGridP,swtMinQ,...
            swtMaxQ,swtGridQ,swtPGrowth,swtQGrowth,swtFixOpCost,swtFixOpCostGr,swtVarOpCost,...
            swtVarOpCostGr,swtInvent,swtAR,swtAP);
        NPVMatx(i,j) = NPVNow;
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
    save a:\bus444\hw3\FEHW3B.out XAxis YAxis NPVMatx -ascii;
elseif swtWriteTo == 3;
    save c:\bus444\hw3\FEHW3B.out XAxis YAxis NPVMatx -ascii;
elseif swtWriteTo == 4;
    save d:\bus444\hw3\FEHW3B.out XAxis YAxis NPVMatx -ascii;
elseif swtWriteTo == 5;
    save e:\bus444\hw3\FEHW3B.out XAxis YAxis NPVMatx -ascii;
elseif swtWriteTo == 6;
    save f:\bus444\hw3\FEHW3B.out XAxis YAxis NPVMatx -ascii;
elseif swtWriteTo == 7;
    save g:\bus444\FEHW3B.out XAxis YAxis NPVMatx -ascii;
elseif swtWriteTo == 8;
    save h:\bus444\hw3\FEHW3B.out XAxis YAxis NPVMatx -ascii;
elseif swtWriteTo == 9;
    save /users/Daniel/bus444/hw3/FEHW3B.out XAxis YAxis NPVMatx -ascii;
end;



