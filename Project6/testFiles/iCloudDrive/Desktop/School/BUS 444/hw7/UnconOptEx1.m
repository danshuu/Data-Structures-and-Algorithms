% UnconOptEx1.m from page 1-6 of Optimization Manual
% demonstrates non-linear optimization without constraints
%clear all;

x0 = [-1,1];  % Initial guess at solution
options = optimset('LargeScale','off','Display','iter');  
% turn off default of using a large scale search algorithm.
% Also turn on the display to show iteration info as the search progresses.
% See page 4-35 for more info on options you can set.

[x,fval,exitflag,output] = fminunc('ObjFunEx1',x0,options);  
        % the above calls fminunc which requires fewer arguments than fmincon.