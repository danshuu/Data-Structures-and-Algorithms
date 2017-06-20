% ConOptEx1.m from page 1-9 of Optimization Manual
% demonstrates non-linear optimization with non-linear inequality constraints

x0 = [-1,1];  % Initial guess at solution
options = optimset('LargeScale','off','Display','iter');  
% turn off default of using a large scale search algorithm
% turn on iteration info to screen.

[x, fval] = fmincon('objfunEx1',x0,[],[],[],[],[],[],'ConFunEx1',options);

[c, ceq] = ConFunEx1(x);  % compute c and ceq as global variables so that
                          % they can be easily checked via simply typing
                          % c or ceq at >> prompt.