% ConOptEx2.m from page 1-10 of Optimization Manual
% demonstrates non-linear optimization with non-linear inequality constraints
% and bounds on the x parameter values.

x0 = [-1,1];  % Initial guess at solution
lb = [0,0];   % Lower Bounds set 
ub=[];        % Upper Bounds set

options = optimset('LargeScale','off','Display','iter');  
% turn off default of using a large scale search algorithm
% turn on iteration/search information to screen

[x, fval, exitflat, output, lambda] = fmincon('ObjFunEx1',x0,[],[],[],[],lb,ub,'ConFunEx1',options);
    % the 4 empty matricies in positons 3-6, are for describing linear
    % constraints.  We have none now.  See page 1-2, and 4-30, 4-37.

[c, ceq] = ConFunEx1(x);  % compute c and ceq as global variables so that
                          % they can be easily checked via simply typing
                          % c or ceq at >> prompt.