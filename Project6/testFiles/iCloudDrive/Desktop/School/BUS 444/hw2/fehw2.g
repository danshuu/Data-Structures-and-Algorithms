/* FEHW2.g */
/* 
AKA YldCurv1.g - This program takes data from Treasury zeros (strips) as obtained 
from the WSJ, and computes a yield curve.  The program is set up to input a YTM for 
each Month of each year, in this case November strips are used because they exist in 
each of the next 28 years.  The program converts these YTM's to YTM's for 1,2,3 ... 
year horizons (via linear interpolation) then plots the yield curve.  Note that 
textbooks and theory are based around the type of yield curve we just constructed. i.e.
one based on zero coupon bonds.  However, most of the financial press reports yield curves
based on coupon bearing bonds.  That is not a good idea, but it is a lot easier to do, and 
hence that is why it is done.  Notice that my yield curve drops off after about 21 years, 
whereas the WSJ yield curve (stapled to the assignment) is always upward sloping.  In fact,
the WSJ only plots the 'on the run' (most recently issued) bonds for the 3 and 6 month,
and 1, 2, 5, 10 and 30 year horizons.  Notice from the coupon bearing yields in and around
2021, the very high YTM's (5.88%), but these don't make the plot cuz these bonds are not
'on the run.'  Thus not only is the WSJ yield curve wrong (its using coupon bonds), but
its incomplete too.
*/

new;  @ reset ram @
library pgraph;

/**************** BEGIN CONTROL PANEL ********************/

swtToday = 199904;  @ YYYYMM. Today's date @

swtYCPlot1 = 1;  @ 1= plot current yield curve, 0= dont @

swtForw1 = 3;  @ 0 = all forward curve work is off. @
               @ = any number, N > 0 indicates the N year forward curve to consturct @
               @ e.g. if swtForw1 = 2, then construct the 2 year forward curve @

  swtForwPlot = 1;  @ 1= plot forward curve, 0= dont @
  swtForwWrite = 1; @ 1 = write ascii file, 0= dont @

swtEstYC1 = 5;  @ N= estimate the yield curve at year N @
                @ 0 = do nothing (off) @
    swtEstYCPlot = 1;  @ 1= Plot estimate future yield curve, 0=dont @
    swtEstYCWrite = 1;  @ 1= write to ascii file, 0= dont @

swtReadFrom = 8;  @  1= a, 3=c, 4=d etc @

swtWriteTo  = 8;  @  1= a, 3=c, 4=d etc @

/**************** END CONTROL PANEL ***********************/



if swtReadFrom == 1;

   load InputMatx[29,2] = a:\strips.asc;  @ load an ascii file from a:drive @
                                       @ into a matx InputMatx with dim 29x2 @

elseif swtReadFrom == 3;

  load InputMatx[29,2] = c:\calpoly\teaching\bus444\gauss\homework\hwork2\strips.asc; 
    
elseif swtReadFrom == 5;

  load InputMatx[29,2] = e:\bus444\hw2\strips.asc; 

elseif swtReadFrom == 8;
    
    load InputMatx[29,2] = h:\bus444\hw2\strips.asc;
    
elseif swtReadFrom == 9;
    
    load InputMatx[29,2] = /users/Daniel/bus444/hw2/strips.asc.txt;

endif;



@ The input data must be 2 columns as follows:  Column 1 is the date, with format @
@ YYYYMM e.g. 200611 for Nov 2006. @
@ Column 2 must be quoted price (in 32nds) on Treasury zeros (strips) from WSJ @
@ with format XXX.ZZ, e.g. 87.23 @
@ A price of 87.23 means $87 23/32nds for a zero with $100 face value @
@ I used November maturity bonds since they exist in each year.  The same is true of @
@ August bonds too.  The data in my file is from WSJ 990331 @


@ check  for missing data - we require data spaced 12 months apart @
Differ1 = InputMatx[2:rows(InputMatx),1] - 
          InputMatx[1:rows(InputMatx)-1,1];  
  @ above Difference vector, should be a constant vector of 100's @
if (stdc(Differ1) > 0) or (meanc(Differ1) NE 100);
  print " ";

  print "CRASH.  You do not have bond data (in InputMatx) that is equally spaced ";
  print "        (with 12 month gaps).  Either you are missing a year, or you have ";
  print "        mixed months of coverage.  Fix it.  Program ending. ";

  end;
endif;


@ now compute how far in the future each bond is - in years @
BondYear  = trunc(InputMatx[.,1]/100);
BondMonth = InputMatx[.,1] - (BondYear*100);
TodayYear = trunc(swtToday/100); 
TodayMonth= swtToday - TodayYear*100;

MonthsToGo = (BondYear-TodayYear)*12 + (BondMonth-TodayMonth);
YearsToGo  = MonthsToGo/12;

@ Now compute the YTM (in annualized effective terms) for each bond @

YTMData = zeros(rows(InputMatx), 1) -9.99;  @ initialize @
  @ above will hold annualized effective YTM for each strip @
i=1;
do while i <= rows(InputMatx);
  PriceNowPart1 = trunc(InputMatx[i,2]);  @ the non 32nd part of the price @
  PriceNowPart2 = ((InputMatx[i,2]*100)-(PriceNowPart1*100)) / 32;
     @ above line is the 32nd part of the price, in dollars (per $100 face bond) @
  PriceNow = PriceNowPart1 + PriceNowPart2;
  YTMData[i] = (((100/PriceNow)^(1/YearsToGo[i])) - 1);  @ YTM in decimal form @
       @ above is the Annualized effective YTM, not in pct, i.e. 0.0600 @
i=i+1;
endo;  @ while i <= rows(InputMatx) @



@ we now have annualized YTM's for each of the zero coupon (stripped) bonds @

@ Now we'd like to find the YTM for 1,2,3,... year zeros @
@ The problem is we don't have YTM's for exactly 1,2,... years from today @
@ (probably), So need to estimate them.  That is, if the current month is April @
@ and the bonds were using are all November maturity, then we have bonds which @
@ mature in 7 months, 19 months, 31 months etc.  What we want is the YTM for bonds @
@ that mature at 12, 24, 36 months etc.  As a first pass, in order to avoid @
@ a lot of hairly bond math, we'll just use linear interpolation.  That is, @
@ if we have YTM data (from WSJ) on, say, 7 month and 19 month zeros, then @
@ we'll assume the YTM on a 1 year zero is 5/12's of the way between the YTM @
@ on the 7 and 19 year zeros @

YTM1Yr = zeros(rows(InputMatx)-1,2) - 9.99;  @ initialize matrix @
				@ above will hold the YTM for 1 bonds with maturities at times @
                @ 1,2,3... years @

i=1;
do while i <= rows(InputMatx)-1;

  YTM1Yr[i,1] = i;  @ first column holds the year @

  @ Get ready to call the proc LinInterp @
  Y1 = YTMData[i];   @ YTM 1 @
  Y2 = YTMData[i+1]; @ YTM 2 @
  T1 = YearsToGo[i];   @  Time 1 (in years) @
  T2 = YearsToGo[i+1]; @  Time 2 (in years) @
  T3 = i;  @ the time (in years) we want the YTM for @

  YTM1Yr[i,2] = LinInterp(T1,T2,Y1,Y2,T3);  @ calling the proc @
      @ above line will return the estimated YTM at years 1,2,3, etc... @

i=i+1;
endo;  @ while i < rows(InputMatx) @


@ We now have a yield curve, based on zeros, giving YTM's at 1,2,3,..., 28 year @
@ horizons.  Lets plot it @

if swtYCPlot1 == 1;
  @ The next 3 lines control the range shown on the x and y axis (approximately) @
  xMaxMin = { 0, 30 };
  yMaxMin = { 0.04, 0.07 };  
  scale(xMaxMin,yMaxMin);

  @ the next line controls the thickness of the lines @
  _plwidth = 7;  @ 5-8 is about right - I think - play around a bit @
                 @ Enlarge the graph to see the effect @

  xlabel("Years");
  ylabel("Yield to Maturity");
  title("Yield Curve\L Constructed from Strips");
  xy(YTM1Yr[.,1],YTM1Yr[.,2]);  @ current yield curve @
endif;   												  @ plot with 28 years of data @

@ From this point in the program, we can do several things... @
@ We can determine the N-year forward curve.  For example with N=2, we can use @
@ the yield curve to estimate what the 2 year rate will be in each of the next 26 @
@ years.  For example, we could estimate what the 2 year rate would be in each of @
@ the next 26 years. From my BUS-342, course this would be a plot of 1_r_3, 2_r_4, @
@ 3_r_5, 4_r_6, 5_r_7, ... 26_r_28.  Typically when people talk about the forward @
@ curve they mean the 1-year forward curve, but you can talk about any year forward @
@ curve.  @
@ ANOTHER thing we could do is to estimate what the *entire* yield curve would look like @
@ at some point in the future.  For example, we could estimate what the yield @
@ curve may look like in 4 years.  Since we have only 28 years of data, the estimated @
@ yield curve 4 years in future would only have 24 points of data.  Again, from my @
@ BUS-342 class, these points would consist of the 24 points:  4_r_5, 4_r_6, @
@ 4_r_7, ... 4_r_28. @

@ Your next HW asignment (HW#2) is to do both of these projects.  See the in-class @
@ handout for more on exactly what you need to do. @

forwardRates = zeros(rows(YTM1Yr)-(swtForw1-1),2) - 9.99;  @ creates a matrix for the forward rate graph, ytmrows - swtforw
                                                  rows required @
i = 1;

do while i <= (rows(ytm1Yr) - (swtforw1-1)); @ while i is less than 26 rows @
    forwardRates[i,1] = i - 1; @ 1st column year starts at 0 @
    i = i + 1;
endo;

@ second loop for the 2nd column(forward rate for given switch) @
i = 2;
forwardRates[1,2] = ytm1Yr[swtForw1,2];

do while i <= (rows(ytm1Yr) - (swtforw1-1)); @ while i is less than 26 rows @
    forwardRates[i,2] = (((1 + YTM1Yr[SwtForw1+(i-1), 2])^(SwtForw1+(i-1))/(1+YTM1Yr[(i-1),2])^(i-1)))^(1/swtForw1)-1;
    @ 2nd column is the forward rate  for the given switch @
    i = i+1;
endo;

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@ estimated rates @
estRates = zeros(rows(YTM1Yr)-(swtEstYC1),2) - 9.99;  @ creates a matrix for the forward rate graph, ytmrows - swtforw
                                                        rows required @
i = 1;
do while i <= (rows(ytm1Yr) - (swtEstYC1)); @ while i is less than 26 rows @
    estRates[i,1] = swtEstYC1 + i; @ 1st column year starts at 6 @
    estRates[i,2] = ((1+YTM1Yr[swtEstYC1+i,2])^(swtEstYC1+i)/(1+YTM1Yr[swtEstYC1,2])^swtEstYC1)^(1/i)-1;
    @ 2nd column year is the estimated rates, starting at 1 year rate at the given switch year @
i = i + 1;
endo;


if swtEstYCPlot == 1;
  @ The next 3 lines control the range shown on the x and y axis (approximately) @
  xMaxMin = { 0, 30 };
  yMaxMin = { 0.04, 0.07 };  
  scale(xMaxMin,yMaxMin);

  @ the next line controls the thickness of the lines @
  _plwidth = 7;  @ 5-8 is about right - I think - play around a bit @
                 @ Enlarge the graph to see the effect @

  xlabel("Years");
  ylabel("Yield to Maturity");
  title("Estimated Curve\L Constructed from Strips");
  xy(estRates[.,1],estRates[.,2]);  @ current yield curve @
endif;   							

if swtforwPlot == 1;
  @ The next 3 lines control the range shown on the x and y axis (approximately) @
  xMaxMin = { 0, 30 };
  yMaxMin = { 0.04, 0.07 };  
  scale(xMaxMin,yMaxMin);

  @ the next line controls the thickness of the lines @
  _plwidth = 8;  @ 5-8 is about right - I think - play around a bit @
                 @ Enlarge the graph to see the effect @

  xlabel("Years");
  ylabel("Yield to Maturity");
  title("Forward Curve\L Constructed from Strips");
  xy(forwardRates[.,1],forwardRates[.,2]);  @ current forward curve @
endif;   							
/**********************************************************************/
/************** PUT ALL PROCS BELOW, ALL OTHER CODE ABOVE *************/

proc LinInterp(x1,x2,y1,y2,x3);
  @ Does linear interpolation @
  @ x1 and y1 are paired, as is x2 and y2.  x3 is the value of x @
  @ for which we want to know the corresponding value of y (=y3) @
  @ e.g. for x1=120, y1=10, x2=163, y2=15, x3=12.3, we want to   @
  @ the proc to return a value of (y3=) 139.780 @
    
local ratio1, y3 ;  @ specify variables that are specific to the PROCedure @

  ratio1 = (x3-x1)/(x2-x1);
  y3 = ratio1*(y2-y1)+ y1;

retp(y3);    @ returns the value of y3 to the "call" in the main program @
endp;

if swtWriteTo == 1;
    output file = a:\bus444\hw2\FEHW2.out reset;
elseif swtWriteTo == 3;
    output file = c:\bus444\hw2\FEHW2.out reset;
elseif swtWriteTo == 4;
    output file = d:\bus444\hw2\FEHW2.out reset;
elseif swtWriteTo == 5;
    output file = e:\bus444\hw2\FEHW2.out reset;
elseif swtWriteTo == 6;
    output file = f:\bus444\hw2\FEHW2.out reset;
elseif swtWriteTo == 7;
    output file = g:\bus444\hw2\FEHW2.out reset;
elseif swtWriteTo == 8;
    output file = h:\bus444\hw2\FEHW2.out reset;
elseif swtWriteTo == 9;
    output file = /users/Daniel/bus444/hw2/FEHW2.out reset;

format /rd 15,9;
outwidth 256;
print forwardRates;
print estRates;
output off;
    
endif;

