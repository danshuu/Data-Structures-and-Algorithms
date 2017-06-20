function NPVNow = HW3NPV(PNow,QNow,...
            swtProjectLife,swtWACC,swtTaxRate,swtCostOfEquip,...
            swtSalvValue,swtMktValue,swtDeprecLife,swtMinP,swtMaxP,swtGridP,swtMinQ,...
            swtMaxQ,swtGridQ,swtPGrowth,swtQGrowth,swtFixOpCost,swtFixOpCostGr,swtVarOpCost,...
            swtVarOpCostGr,swtInvent,swtAR,swtAP);

path(path, 'd:\bus444\hw3\functions');  

CFOP  = zeros(6,swtProjectLife+1);  % CF from Operations % 
CFCS = zeros(7,swtProjectLife+1);  % CF from Capital Spending - all values entered 
CFWC  = zeros(10,swtProjectLife+1);  % CF from changes in Working Capital 

NPVMatx = zeros(swtGridP,swtGridQ) - 9.99; % will hold NPV for each P-Q combo 

% row 1 = accting revenue before tax 
% row 2 = accting value of fixed operating expenses - enter as positive values 
% row 3 = accting value of total variable operating expenses - positive values 
% row 4 = depreciation per year - enter as a positive value 
% row 5 = Rev - Exp - Deprec = +row1 - row2 - row3 - row4 
% row 6 = (row 5 * (1 - TaxRate)) + Deprec = CF from Operations 
CFOP(1,2:swtProjectLife+1) = seqm(PNow*QNow,(1+swtPGrowth)*(1+swtQGrowth),swtProjectLife)'; % accounting revenue before tax at t=1 
CFOP(2,2:swtProjectLife+1) = seqm(swtFixOpCost,(1+swtFixOpCostGr),swtProjectLife)';
CFOP(3,2:swtProjectLife+1) = seqm(swtVarOpCost*QNow,(1+swtVarOpCostGr)*(1+swtQGrowth),swtProjectLife)';
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
	CFCS(3,2:swtDeprecLife+1) = seqa((swtCostofEquip - swtSalvValue)/swtDeprecLife,(swtCostofEquip - swtSalvValue)/swtDeprecLife,swtDeprecLife)';
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
        
NPVNow = (CFCS(7,:) + CFOP(6,:) + CFWC(10,:)) * (seqm(1,1/(1+swtWACC),swtProjectLife+1));
        
DiscFactors = seqm(1,1+swtWACC, swtProjectLife+1);
        
PGrow = seqm(PNow, 1+swtPGrowth,swtProjectLife)'; % row vector
QGrow = seqm(QNow, 1+swtQGrowth,swtProjectLife)'; % row vector
