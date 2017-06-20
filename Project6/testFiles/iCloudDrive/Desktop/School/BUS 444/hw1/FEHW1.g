/* Financial Engineering HW1 */
/* This version 990324 */
/* Author:  Daniel Shu */
/* Does Capital Budgeting I for different values of P and Q */


new;  @ reset ram @
library pgraph;  @ necessary if you want to do graphics later - we do @

format /rd 10,2;  @ set the way numbers are displayed @

/**************************** BEGIN CONTROL PANEL *****************************/

@ Set location to write NPV Matrix to @

swtWriteTo = 4;   @  3 = c:\bus444\hw1\, 4 = c:\bus444\hw1\ etc  9 = Apple etc @
                  @    Make sure C to H drives are available (via =3 to =8 ) @


@ Overall Parameters @
swtProjectLife = 5;    @ Expected life of project, in years @
swtWACC = 0.1220;      @ Weighted average cost of capital for this project @
swtTaxRate = 0.34;     @ Marginal tax rate for the project @ 

@ Capital Spending Parameters @
swtCostOfEquip = 65000;   @ cost of factory at t=0, assume paid in cash @
swtSalvValue = 20000;     @ Est. of Salvage value for deprec purposes @
                          @ at the end of the assumed deprec period @
swtMktValue = 40000;      @ Est. of the actual mkt value of factory at @
                          @ the end of the projects life @
swtDeprecLife =  7;       @ The Depreciation period (in yrs) to use. @
                          @ Dictated by the IRS and the type of asset used @

@ Operating Parameters  @
                        @ Added so that I can create a PNow while incorporating the PGrowth rate @
    swtMinP = 5.00;          @ minimum Price per unit in the grid @
 	swtMaxP = 20.00;         @ maximum Price per unit in the grid @
      swtGridP = 8;          @ number of grid points (nodes) to for prices. @
                             @ Must be > 1 @
                             @ This will only change the plot of the graph @
    @swtQuantThisPer = 1500@  @ Quantity per unit for this period @
                        @ Added so that I can create a QNow while incorporating the QGrowth rate @
      swtMinQ = 500;         @ minimum Q in the grid @
      swtMaxQ = 1500;        @ maximum Q in the grid @
      swtGridQ = 5;          @ number of grid points (nodes) to use with Q @
                             @ Must be > 1 @
                             @ This will only change the plot of the graph @
      swtPGrowth = .0500;      @ annualized nominal growth in prices beyond t=1 @
      swtQGrowth = -0.0100;    @ annualized growth of quantity sold beyond year 1 @
                               @ Enter above as a decimal, i.e. 0.0100 for +1% growth @

      swtFixOpCost = 2700;     @ fixed Op. Costs at t=1 @
      swtFixOpCostGr = 0.0300; @ annualized growth in fixed Op. costs after year 1 @
                               @ Enter above as a decimal, i.e. 0.0100 for +1% growth @
                               @ A value close to inflation is probably appropriate @
      swtVarOpCost =  3.86;    @ variable op. Costs *per unit* at t=1 @
      swtVarOpCostGr = 0.0200; @ Ann. growth in variable Op. Cost per unit after t=1 @
                               @ Enter above as a decimal, i.e. 0.0100 for +1% growth @
                               @ A value close to inflation is probably appropriate @

@ Changes in Working Capital parameters  @
      swtInvent = 0.150;  @ Required Invent level as a proportion of next years sales @
      swtAR     = 0.160;  @ Acct Rec level as a proportion of same year revenue @
      swtAP     = 0.120;  @ Acct Pay level as a proportion of same year revenue @
     

/*************************** END OF CONTROL PANEL *****************************/

/**************************** BEGIN CONTROL PANEL GRADED  ********************/

@ Overall Parameters @
swtProjectLife = 6;    @ Expected life of project, in years @
swtWACC = 0.1220;      @ Weighted average cost of capital for this project @
swtTaxRate = 0.34;     @ Marginal tax rate for the project @ 

@ Capital Spending Parameters @
swtCostOfEquip = 65000;   @ cost of factory at t=0, assume paid in cash @
swtSalvValue = 20000;     @ Est. of Salvage value for deprec purposes @
                          @ at the end of the assumed deprec period @
swtMktValue = 40000;      @ Est. of the actual mkt value of factory at @
                          @ the end of the projects life @
swtDeprecLife =  3;       @ The Depreciation period (in yrs) to use. @
                          @ Dictated by the IRS and the type of asset used @

@ Operating Parameters  @
	swtMinP = 4.00;          @ minimum Price per unit in the grid @
 	swtMaxP = 19.00;         @ maximum Price per unit in the grid @
      swtGridP = 8;          @ number of grid points (nodes) to for prices. @
                             @ Must be > 1 @
      swtMinQ = 600;         @ minimum Q in the grid @
      swtMaxQ = 1400;        @ maximum Q in the grid @
      swtGridQ = 5;          @ number of grid points (nodes) to use with Q @
                             @ Must be > 1 @
      swtPGrowth = 0.0600;      @ annualized nominal growth in prices beyond t=1 @
      swtQGrowth = -0.0200;    @ annualized growth of quantity sold beyond year 1 @
                               @ Enter above as a decimal, i.e. 0.0100 for +1% growth @

      swtFixOpCost = 4700;     @ fixed Op. Costs at t=1 @
      swtFixOpCostGr = 0.0200; @ annualized growth in fixed Op. costs after year 1 @
                               @ Enter above as a decimal, i.e. 0.0100 for +1% growth @
                               @ A value close to inflation is probably appropriate @
      swtVarOpCost =  4.86;    @ variable op. Costs *per unit* at t=1 @
      swtVarOpCostGr = 0.0300; @ Ann. growth in variable Op. Cost per unit after t=1 @
                               @ Enter above as a decimal, i.e. 0.0100 for +1% growth @
                               @ A value close to inflation is probably appropriate @

@ Changes in Working Capital parameters  @
      swtInvent = 0.100;  @ Required Invent level as a proportion of next years sales @
      swtAR     = 0.180;  @ Acct Rec level as a proportion of same year revenue @
      swtAP     = 0.150;  @ Acct Pay level as a proportion of same year revenue @
     

/*************************** END OF CONTROL PANEL GRADED ********************/


@ build P and Q grid for the loops @
@ These column vectors hold the specific values of P and Q that we'll investigate @
PGrid = seqa(swtMinP, (swtMaxP-swtMinP)/(swtGridP-1), swtGridP);
QGrid = seqa(swtMinQ, (swtMaxQ-swtMinQ)/(swtGridQ-1), swtGridQ);

@ Now initialize Matricies for CF from Capital Spending, Operations and changes @
@ in Working Capital.  @


CFOP  = zeros(6,swtProjectLife+1);  @ CF from Operations @ 
CFCS = zeros(7,swtProjectLife+1);  @ CF from Capital Spending - all values entered @
CFWC  = zeros(10,swtProjectLife+1);  @ CF from changes in Working Capital @

NPVMatx = zeros(swtGridP,swtGridQ) - 9.99; @ will hold NPV for each P-Q combo @

i = 1; @ loop of rows @
do while i <= swtGridP;
    Pnow = PGRID[i,1]; @ Pnow is the price at which the loop is currently at @
    j = 1; @ loop of columns @
    do while j <= swtGridQ; 
        Qnow = QGrid[j,1]; @ Qnow is the quantity at which the loop is currently at @
          @ row 1 = accting revenue before tax @
          @ row 2 = accting value of fixed operating expenses - enter as positive values @
          @ row 3 = accting value of total variable operating expenses - positive values @
          @ row 4 = depreciation per year - enter as a positive value @
          @ row 5 = Rev - Exp - Deprec = +row1 - row2 - row3 - row4 @
          @ row 6 = [row 5 * (1 - TaxRate)] + Deprec = CF from Operations @
        
        CFOP[1,2:swtProjectLife+1] = seqm(Pnow*Qnow,(1+swtPGrowth)*(1+swtQGrowth),swtProjectLife)'; @ accounting revenue before tax at t=1 @
        CFOP[2,2:swtProjectLife+1] = seqm(swtFixOpCost,(1+swtFixOpCostGr),swtProjectLife)';
        CFOP[3,2:swtProjectLife+1] = seqm(swtVarOpCost*Qnow,(1+swtVarOpCostGr)*(1+swtQGrowth),swtProjectLife)';
        if swtDeprecLife >= swtProjectLife;
            CFOP[4,2:swtProjectLife+1] = seqm((swtCostOfEquip-swtSalvValue)/swtDeprecLife, 1, swtProjectLife)';
        else;
            CFOP[4,2:swtDeprecLife+1] = seqm((swtCostOfEquip-swtSalvValue)/swtDeprecLife, 1, swtDeprecLife)';
        endif;
        CFOP[5,.] = CFOP[1,.] - CFOP[2,.] - CFOP[3,.] - CFOP[4,.];
        CFOP[6,.] = CFOP[5,.] * (1 - swtTaxRate) + CFOP[4,.];

                                           @ as positive values unless noted otherwise @
          @ row 1 =   Turn-key purchase cost of Capital Equipment - enter as a negative num. @
          @ row 2 =   Depreciation per year of capital Equipment - via straight line to @
          @           to an expected salvage value of swtSalvValue - positive value. @
          @ row 3 =   Accumulated Depreciation @
          @ row 4 =   Book Value of capital equipment at each point in time. @
          @ row 5 =   Expected market selling price of capital equipment when disposed of @
          @           at the end of the project per swtMktValue.  Enter as a positive value @
          @ row 6 =   CF from liqidation of capital equipment at end of project.  This line @
          @           includes the tax effect from selling the equipment at a price other   @
          @           than the current book value = MV + (TaxRate)*(BV-MV), will be pos @   
          @ row 7 =   sum of rows 1 and 6 = CF from Capital Spending - can have pos @
          @           and neg values @
        CFCS[1,1] = -1 * swtCostOfEquip;
        if swtDeprecLife >= swtProjectLife;
            CFCS[2,2:swtProjectLife+1] = seqm((swtCostOfEquip - swtSalvValue)/swtDeprecLife,1,swtProjectLife)';
            CFCS[3,2:swtProjectLife+1] = seqa((swtCostofEquip - swtSalvValue)/swtDeprecLife,(swtCostofEquip - swtSalvValue)/swtDeprecLife,swtProjectLife)';
            CFCS[4,1:swtProjectLife+1] = seqa(swtCostOfEquip,-(swtCostOfEquip-swtSalvValue)/swtDeprecLife,swtProjectLife+1)';

        else;
            CFCS[2,2:swtDeprecLife+1] = seqm((swtCostOfEquip - swtSalvValue)/swtDeprecLife,1,swtDeprecLife)';
            CFCS[3,2:swtDeprecLife+1] = seqa((swtCostofEquip - swtSalvValue)/swtDeprecLife,(swtCostofEquip - swtSalvValue)/swtDeprecLife,swtDeprecLife)';
            CFCS[3,swtDeprecLife+2:swtProjectLife+1] = seqa(CFCS[3,swtDeprecLife+1],0,swtProjectLife-swtDeprecLife)';
            CFCS[4,1:swtDeprecLife+1] = seqa(swtCostOfEquip,-(swtCostOfEquip-swtSalvValue)/swtDeprecLife,swtDeprecLife+1)';
            CFCS[4,swtDeprecLife+2:swtProjectLife+1] = seqa(CFCS[4,swtDeprecLife+1],0,swtProjectLife-swtDeprecLife)';
            @ The rest of the book value after position depreclife will just be left at zeros @
        endif;
        
        CFCS[5,swtProjectLife+1] = swtMktValue;
        CFCS[6,swtProjectLife+1] = CFCS[5,swtProjectLife+1] + swtTaxRate * (CFCS[4,swtProjectLife+1] - CFCS[5,swtProjectLife+1]); @ CF from capital equipment liquidation at the end of the project @
        CFCS[7,1] = (CFCS[1,1] + CFCS[6,1]); @ total CF from Capital Spending @ 
        CFCS[7,swtProjectLife+1] = (CFCS[1,swtProjectLife+1] + CFCS[6,swtProjectLife+1]);

          @ row 1 = inventory levels @
          @ row 2 = A/R levels @
          @ row 3 = A/P levels @
          @ row 4 = Changes in inventory levels @
          @ row 5 = Changes in A/R levels @
          @ row 6 = Changes in A/P levels @
          @ row 7 = CF implication from the change in inventory levels = row 4 * -1 @
          @ row 8 = CF implication from the change in A/R levels = row 5 * -1 @
          @ row 9 = CF implication from the change in A/P levels = row 6 @
          @ row 10 = sum of rows 7,8,9 = CF from changes in Working Capital @
        CFWC[1,1:swtProjectLife] = swtInvent * CFOP[1,2:swtProjectLife+1];
        CFWC[2,2:swtProjectLife+1] = swtAR * CFOP[1,2:swtProjectLife+1];
        CFWC[3,2:swtProjectLife+1] = swtAP * CFOP[1,2:swtProjectLife+1];
        CFWC[4,1] = CFWC[1,1];
        CFWC[4,2:swtProjectLife+1] = CFWC[1,2:swtProjectLife+1] - CFWC[1,1:swtProjectLife];
        CFWC[5,2:swtProjectLife+1] = CFWC[2,2:swtProjectLife+1] - CFWC[2,1:swtProjectLife];
        CFWC[5,swtProjectLife+1] = CFWC[2,swtProjectLife] * -1;
        CFWC[6,2:swtProjectLife+1] = CFWC[3,2:swtProjectLife+1] - CFWC[3,1:swtProjectLife];
        CFWC[6,swtProjectLife+1] = CFWC[3,swtProjectLife] * -1;
        CFWC[7,.] = CFWC[4, .] * -1;
        CFWC[8,.] = CFWC[5, .] * -1;
        CFWC[9,.] = CFWC[6, .] * 1;
        CFWC[10,.] = sumc(CFWC[7:9,.])';

        @ the i variable will represent the price moving upwards in the vector @
        @ the j variable will represent the quantity moving upwards in the vector @
        NPVmatx[i,j] = (CFCS[7,.] + CFOP[6,.] + CFWC[10,.]) * (seqm(1,1/(1+swtWACC),swtProjectLife+1));
        j = j + 1;
    ENDO;
    i = i + 1;
ENDO;
    
@ Done initializing matricies @

@ Now YOU write the program using the above framework @
@
print CFCS;
print CFOP;
print CFWC;
@
@How to plot a 3Dim surface plot in Gauss… type help surface (at the gaussprompt)for more info…@
@Plot the NPV Surface @
xlabel("Price per unit");       
@labels for the axis @
ylabel("Quantity Sold");
zlabel("NPV");
@set the color to be used in the graph.  Per below, all values above 0.01 are @
@ blue and all values below 0.01 values are red.  See Gauss (book) manuals on @
@ graphics for more detail etc. @
_pzclr = { -9e9   12,     /* min bound, MUST be set */
            0.01   1};    /* color division. 1=blue 12=red */
          


surface(PGrid',QGrid,NPVMatx');

if swtWriteTo == 1;
    output file = a:\bus444\hw1\FEHW1.out reset;
    format /rd 15,2;
    outwidth 256;
    print XAxis;
    print YAxis;
    print NPVMatx;
    output off;
elseif swtWriteTo == 3;
    output file = c:\bus444\hw1\FEHW1.out reset;
    format /rd 15,2;
    outwidth 256;
    print XAxis;
    print YAxis;
    print NPVMatx;
    output off;
elseif swtWriteTo == 4;
    output file = d:\bus444\hw1\FEHW1.out reset;
    format /rd 15,2;
    outwidth 256;
    print XAxis;
    print YAxis;
    print NPVMatx;
    output off;
elseif swtWriteTo == 5;
    output file = e:\bus444\hw1\FEHW1.out reset;
    format /rd 15,2;
    outwidth 256;
    print XAxis;
    print YAxis;
    print NPVMatx;
    output off;
elseif swtWriteTo == 6;
    output file = f:\bus444\hw1\FEHW1.out reset;
    format /rd 15,2;
    outwidth 256;
    print XAxis;
    print YAxis;
    print NPVMatx;
    output off;
elseif swtWriteTo == 7;
    output file = g:\bus444\hw1\FEHW1.out reset;
    format /rd 15,2;
    outwidth 256;
    print XAxis;
    print YAxis;
    print NPVMatx;
    output off;
elseif swtWriteTo == 8;
    output file = h:\bus444\hw1\FEHW1.out reset;
    format /rd 15,2;
    outwidth 256;
    print XAxis;
    print YAxis;
    print NPVMatx;
    output off;
elseif swtWriteTo == 9;
    output file = /users/Daniel/bus444/hw1/FEHW1.out reset;
    format /rd 15,2;
    outwidth 256;
    print XAxis;
    print YAxis;
    print NPVMatx;
    output off;

    
endif;



